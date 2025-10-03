package com.skniro.skniro_furniture.block.init;

import com.mojang.datafixers.util.Either;
import com.mojang.math.OctahedralGroup;
import com.mojang.math.Quadrant;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.skniro.skniro_furniture.block.entity.FurnitureBedBlockEntity;
import net.minecraft.Util;
import net.minecraft.block.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Unit;
import net.minecraft.util.math.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.CollisionGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class FurnitureBedBlock extends BedBlock implements EntityBlock {
    public static final MapCodec<FurnitureBedBlock> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(DyeColor.CODEC.fieldOf("color").forGetter(FurnitureBedBlock::getColor), propertiesCodec()).apply(instance, FurnitureBedBlock::new));
    public static final EnumProperty<BedPart> PART;
    public static final BooleanProperty OCCUPIED;
    private static final Map SHAPES_BY_DIRECTION;
    private final DyeColor color;

    public FurnitureBedBlock(DyeColor color, BlockBehaviour.Properties settings) {
        super(color, settings);
        this.color = color;
        this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(PART, BedPart.FOOT)).setValue(OCCUPIED, false));
    }

    public boolean isPossibleToRespawnInThis(BlockState state) {
        return true;
    }

    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new FurnitureBedBlockEntity(pos, state, this.color);
    }

/*    protected ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state, boolean includeData) {
        BlockEntity var6 = world.getBlockEntity(pos);
        if (var6 instanceof FurnitureBedBlockEntity CustomBedBlockEntity) {
            return CustomBedBlockEntity.getPickStack();
        } else {
            return super.getPickStack(world, pos, state, includeData);
        }
    }*/

    public DyeColor getColor() {
        return this.color;
    }

    @Nullable
    public static Direction getBedOrientation(BlockGetter world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos);
        return blockState.getBlock() instanceof FurnitureBedBlock ? (Direction)blockState.getValue(FACING) : null;
    }

    @Nullable
    public boolean skipRendering(BlockState state, BlockState neighborState, Direction offset) {
        return neighborState.getBlock() instanceof FurnitureBedBlock;
    }

    public static boolean canSetSpawn(Level world) {
        return world.dimensionType().bedWorks();
    }

    private boolean kickVillagerOutOfBed(Level world, BlockPos pos) {
        List<Villager> list = world.getEntitiesOfClass(Villager.class, new AABB(pos), LivingEntity::isSleeping);
        if (list.isEmpty()) {
            return false;
        } else {
            ((Villager)list.get(0)).stopSleeping();
            return true;
        }
    }

    public void fallOn(Level world, BlockState state, BlockPos pos, Entity entity, double fallDistance) {
        super.fallOn(world, state, pos, entity, fallDistance * (double)0.5F);
    }

    public void updateEntityMovementAfterFallOn(BlockGetter world, Entity entity) {
        if (entity.isSuppressingBounce()) {
            super.updateEntityMovementAfterFallOn(world, entity);
        } else {
            this.bounceUp(entity);
        }

    }

    private void bounceUp(Entity entity) {
        Vec3 vec3d = entity.getDeltaMovement();
        if (vec3d.y < (double)0.0F) {
            double d = entity instanceof LivingEntity ? (double)1.0F : 0.8;
            entity.setDeltaMovement(vec3d.x, -vec3d.y * (double)0.66F * d, vec3d.z);
        }

    }

    protected BlockState updateShape(BlockState state, LevelReader world, ScheduledTickAccess tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource random) {
        if (direction == getNeighbourDirection((BedPart)state.getValue(PART), (Direction)state.getValue(FACING))) {
            return neighborState.is(this) && neighborState.getValue(PART) != state.getValue(PART) ? (BlockState)state.setValue(OCCUPIED, (Boolean)neighborState.getValue(OCCUPIED)) : Blocks.AIR.defaultBlockState();
        } else {
            return super.updateShape(state, world, tickView, pos, direction, neighborPos, neighborState, random);
        }
    }

    private static Direction getNeighbourDirection(BedPart part, Direction direction) {
        return part == BedPart.FOOT ? direction : direction.getOpposite();
    }

    public BlockState playerWillDestroy(Level world, BlockPos pos, BlockState state, Player player) {
        if (!world.isClientSide() && player.preventsBlockDrops()) {
            BedPart bedPart = (BedPart)state.getValue(PART);
            if (bedPart == BedPart.FOOT) {
                BlockPos blockPos = pos.relative(getNeighbourDirection(bedPart, (Direction)state.getValue(FACING)));
                BlockState blockState = world.getBlockState(blockPos);
                if (blockState.is(this) && blockState.getValue(PART) == BedPart.HEAD) {
                    world.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 35);
                    world.levelEvent(player, 2001, blockPos, Block.getId(blockState));
                }
            }
        }

        return super.playerWillDestroy(world, pos, state, player);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        Direction direction = ctx.getHorizontalDirection();
        BlockPos blockPos = ctx.getClickedPos();
        BlockPos blockPos2 = blockPos.relative(direction);
        Level world = ctx.getLevel();
        return world.getBlockState(blockPos2).canBeReplaced(ctx) && world.getWorldBorder().isWithinBounds(blockPos2) ? (BlockState)this.defaultBlockState().setValue(FACING, direction) : null;
    }

    protected VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return (VoxelShape)SHAPES_BY_DIRECTION.get(getConnectedDirection(state).getOpposite());
    }

    public static Direction getConnectedDirection(BlockState state) {
        Direction direction = (Direction)state.getValue(FACING);
        return state.getValue(PART) == BedPart.HEAD ? direction.getOpposite() : direction;
    }

    public static DoubleBlockCombiner.BlockType getBlockType(BlockState state) {
        BedPart bedPart = (BedPart)state.getValue(PART);
        return bedPart == BedPart.HEAD ? DoubleBlockCombiner.BlockType.FIRST : DoubleBlockCombiner.BlockType.SECOND;
    }

    private static boolean isBunkBed(BlockGetter world, BlockPos pos) {
        return world.getBlockState(pos.below()).getBlock() instanceof FurnitureBedBlock;
    }

    public static Optional<Vec3> findStandUpPosition(EntityType<?> type, CollisionGetter world, BlockPos pos, Direction bedDirection, float spawnAngle) {
        Direction direction = bedDirection.getClockWise();
        Direction direction2 = direction.isFacingAngle(spawnAngle) ? direction.getOpposite() : direction;
        if (isBunkBed(world, pos)) {
            return findBunkBedStandUpPosition(type, world, pos, bedDirection, direction2);
        } else {
            int[][] is = bedStandUpOffsets(bedDirection, direction2);
            Optional<Vec3> optional = findStandUpPositionAtOffset(type, world, pos, is, true);
            return optional.isPresent() ? optional : findStandUpPositionAtOffset(type, world, pos, is, false);
        }
    }

    private static Optional<Vec3> findBunkBedStandUpPosition(EntityType<?> type, CollisionGetter world, BlockPos pos, Direction bedDirection, Direction respawnDirection) {
        int[][] is = bedSurroundStandUpOffsets(bedDirection, respawnDirection);
        Optional<Vec3> optional = findStandUpPositionAtOffset(type, world, pos, is, true);
        if (optional.isPresent()) {
            return optional;
        } else {
            BlockPos blockPos = pos.below();
            Optional<Vec3> optional2 = findStandUpPositionAtOffset(type, world, blockPos, is, true);
            if (optional2.isPresent()) {
                return optional2;
            } else {
                int[][] js = bedAboveStandUpOffsets(bedDirection);
                Optional<Vec3> optional3 = findStandUpPositionAtOffset(type, world, pos, js, true);
                if (optional3.isPresent()) {
                    return optional3;
                } else {
                    Optional<Vec3> optional4 = findStandUpPositionAtOffset(type, world, pos, is, false);
                    if (optional4.isPresent()) {
                        return optional4;
                    } else {
                        Optional<Vec3> optional5 = findStandUpPositionAtOffset(type, world, blockPos, is, false);
                        return optional5.isPresent() ? optional5 : findStandUpPositionAtOffset(type, world, pos, js, false);
                    }
                }
            }
        }
    }

    private static Optional<Vec3> findStandUpPositionAtOffset(EntityType<?> type, CollisionGetter world, BlockPos pos, int[][] possibleOffsets, boolean ignoreInvalidPos) {
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();

        for(int[] is : possibleOffsets) {
            mutable.set(pos.getX() + is[0], pos.getY(), pos.getZ() + is[1]);
            Vec3 vec3d = DismountHelper.findSafeDismountLocation(type, world, mutable, ignoreInvalidPos);
            if (vec3d != null) {
                return Optional.of(vec3d);
            }
        }

        return Optional.empty();
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING, PART, OCCUPIED});
    }

    public void setPlacedBy(Level world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.setPlacedBy(world, pos, state, placer, itemStack);
        if (!world.isClientSide()) {
            BlockPos blockPos = pos.relative((Direction)state.getValue(FACING));
            world.setBlock(blockPos, (BlockState)state.setValue(PART, BedPart.HEAD), 3);
            world.updateNeighborsAt(pos, Blocks.AIR);
            state.updateNeighbourShapes(world, pos, 3);
        }

    }

    protected long getSeed(BlockState state, BlockPos pos) {
        BlockPos blockPos = pos.relative((Direction)state.getValue(FACING), state.getValue(PART) == BedPart.HEAD ? 0 : 1);
        return Mth.getSeed(blockPos.getX(), pos.getY(), blockPos.getZ());
    }

    protected boolean isPathfindable(BlockState state, PathComputationType type) {
        return false;
    }

    private static int[][] bedStandUpOffsets(Direction bedDirection, Direction respawnDirection) {
        return (int[][]) ArrayUtils.addAll(bedSurroundStandUpOffsets(bedDirection, respawnDirection), bedAboveStandUpOffsets(bedDirection));
    }

    private static int[][] bedSurroundStandUpOffsets(Direction bedDirection, Direction respawnDirection) {
        return new int[][]{{respawnDirection.getStepX(), respawnDirection.getStepZ()}, {respawnDirection.getStepX() - bedDirection.getStepX(), respawnDirection.getStepZ() - bedDirection.getStepZ()}, {respawnDirection.getStepX() - bedDirection.getStepX() * 2, respawnDirection.getStepZ() - bedDirection.getStepZ() * 2}, {-bedDirection.getStepX() * 2, -bedDirection.getStepZ() * 2}, {-respawnDirection.getStepX() - bedDirection.getStepX() * 2, -respawnDirection.getStepZ() - bedDirection.getStepZ() * 2}, {-respawnDirection.getStepX() - bedDirection.getStepX(), -respawnDirection.getStepZ() - bedDirection.getStepZ()}, {-respawnDirection.getStepX(), -respawnDirection.getStepZ()}, {-respawnDirection.getStepX() + bedDirection.getStepX(), -respawnDirection.getStepZ() + bedDirection.getStepZ()}, {bedDirection.getStepX(), bedDirection.getStepZ()}, {respawnDirection.getStepX() + bedDirection.getStepX(), respawnDirection.getStepZ() + bedDirection.getStepZ()}};
    }

    private static int[][] bedAboveStandUpOffsets(Direction bedDirection) {
        return new int[][]{{0, 0}, {-bedDirection.getStepX(), -bedDirection.getStepZ()}};
    }

    static {
        PART = BlockStateProperties.BED_PART;
        OCCUPIED = BlockStateProperties.OCCUPIED;
        SHAPES_BY_DIRECTION = (Map)Util.make(() -> {
            VoxelShape voxelShape = Block.box((double)0.0F, (double)0.0F, (double)0.0F, (double)2.0F, (double)2.0F, (double)2.0F);
            VoxelShape voxelShape2 = Shapes.rotate(voxelShape, OctahedralGroup.fromXYAngles(Quadrant.R0, Quadrant.R90));
            return Shapes.rotateHorizontal(Shapes.or(Block.column((double)16.0F, (double)2.0F, (double)7.5F), new VoxelShape[]{voxelShape, voxelShape2}));
        });
    }
}
