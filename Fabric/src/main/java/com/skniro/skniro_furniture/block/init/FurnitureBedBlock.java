package com.skniro.skniro_furniture.block.init;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.skniro.skniro_furniture.block.entity.FurnitureBedBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.enums.BedPart;
import net.minecraft.entity.Dismounting;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Util;
import net.minecraft.util.math.*;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.CollisionView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class FurnitureBedBlock extends BedBlock implements BlockEntityProvider {
    public static final MapCodec<FurnitureBedBlock> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(DyeColor.CODEC.fieldOf("color").forGetter(FurnitureBedBlock::getColor), createSettingsCodec()).apply(instance, FurnitureBedBlock::new));
    public static final EnumProperty<BedPart> PART;
    public static final BooleanProperty OCCUPIED;
    protected static final VoxelShape TOP_SHAPE;
    protected static final VoxelShape LEG_1_SHAPE;
    protected static final VoxelShape LEG_2_SHAPE;
    protected static final VoxelShape LEG_3_SHAPE;
    protected static final VoxelShape LEG_4_SHAPE;
    protected static final VoxelShape NORTH_SHAPE;
    protected static final VoxelShape SOUTH_SHAPE;
    protected static final VoxelShape WEST_SHAPE;
    protected static final VoxelShape EAST_SHAPE;
    private final DyeColor color;

    public FurnitureBedBlock(DyeColor color, Settings settings) {
        super(color, settings);
        this.color = color;
        this.setDefaultState((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(PART, BedPart.FOOT)).with(OCCUPIED, false));
    }

    @Override
    public boolean canMobSpawnInside(BlockState state) {
        return true;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
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

    @Override
    public DyeColor getColor() {
        return this.color;
    }

    @Nullable
    public static Direction getDirection(BlockView world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos);
        return blockState.getBlock() instanceof FurnitureBedBlock ? (Direction)blockState.get(FACING) : null;
    }

    @Override
    @Nullable
    public boolean isSideInvisible(BlockState state, BlockState neighborState, Direction offset) {
        return neighborState.getBlock() instanceof FurnitureBedBlock;
    }

    public static boolean isBedWorking(World world) {
        return world.getDimension().bedWorks();
    }

    private boolean wakeVillager(World world, BlockPos pos) {
        List<VillagerEntity> list = world.getEntitiesByClass(VillagerEntity.class, new Box(pos), LivingEntity::isSleeping);
        if (list.isEmpty()) {
            return false;
        } else {
            ((VillagerEntity)list.get(0)).wakeUp();
            return true;
        }
    }

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        super.onLandedUpon(world, state, pos, entity, fallDistance * 0.5F);
    }

    @Override
    public void onEntityLand(BlockView world, Entity entity) {
        if (entity.bypassesLandingEffects()) {
            super.onEntityLand(world, entity);
        } else {
            this.bounceEntity(entity);
        }

    }

    private void bounceEntity(Entity entity) {
        Vec3d vec3d = entity.getVelocity();
        if (vec3d.y < (double)0.0F) {
            double d = entity instanceof LivingEntity ? (double)1.0F : 0.8;
            entity.setVelocity(vec3d.x, -vec3d.y * (double)0.66F * d, vec3d.z);
        }

    }

    @Override
    protected BlockState getStateForNeighborUpdate(BlockState state, WorldView world, ScheduledTickView tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, Random random) {
        if (direction == getDirectionTowardsOtherPart((BedPart)state.get(PART), (Direction)state.get(FACING))) {
            return neighborState.isOf(this) && neighborState.get(PART) != state.get(PART) ? (BlockState)state.with(OCCUPIED, (Boolean)neighborState.get(OCCUPIED)) : Blocks.AIR.getDefaultState();
        } else {
            return super.getStateForNeighborUpdate(state, world, tickView, pos, direction, neighborPos, neighborState, random);
        }
    }

    private static Direction getDirectionTowardsOtherPart(BedPart part, Direction direction) {
        return part == BedPart.FOOT ? direction : direction.getOpposite();
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isClient && player.isCreative()) {
            BedPart bedPart = (BedPart)state.get(PART);
            if (bedPart == BedPart.FOOT) {
                BlockPos blockPos = pos.offset(getDirectionTowardsOtherPart(bedPart, (Direction)state.get(FACING)));
                BlockState blockState = world.getBlockState(blockPos);
                if (blockState.isOf(this) && blockState.get(PART) == BedPart.HEAD) {
                    world.setBlockState(blockPos, Blocks.AIR.getDefaultState(), 35);
                    world.syncWorldEvent(player, 2001, blockPos, Block.getRawIdFromState(blockState));
                }
            }
        }

        return super.onBreak(world, pos, state, player);
    }

    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction direction = ctx.getHorizontalPlayerFacing();
        BlockPos blockPos = ctx.getBlockPos();
        BlockPos blockPos2 = blockPos.offset(direction);
        World world = ctx.getWorld();
        return world.getBlockState(blockPos2).canReplace(ctx) && world.getWorldBorder().contains(blockPos2) ? (BlockState)this.getDefaultState().with(FACING, direction) : null;
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction direction = getOppositePartDirection(state).getOpposite();
        switch (direction) {
            case NORTH -> {
                return NORTH_SHAPE;
            }
            case SOUTH -> {
                return SOUTH_SHAPE;
            }
            case WEST -> {
                return WEST_SHAPE;
            }
            default -> {
                return EAST_SHAPE;
            }
        }
    }
    public static Direction getOppositePartDirection(BlockState state) {
        Direction direction = (Direction)state.get(FACING);
        return state.get(PART) == BedPart.HEAD ? direction.getOpposite() : direction;
    }

    public static DoubleBlockProperties.Type getBedPart(BlockState state) {
        BedPart bedPart = (BedPart)state.get(PART);
        return bedPart == BedPart.HEAD ? DoubleBlockProperties.Type.FIRST : DoubleBlockProperties.Type.SECOND;
    }

    private static boolean isBedBelow(BlockView world, BlockPos pos) {
        return world.getBlockState(pos.down()).getBlock() instanceof FurnitureBedBlock;
    }

    public static Optional<Vec3d> findWakeUpPosition(EntityType<?> type, CollisionView world, BlockPos pos, Direction bedDirection, float spawnAngle) {
        Direction direction = bedDirection.rotateYClockwise();
        Direction direction2 = direction.pointsTo(spawnAngle) ? direction.getOpposite() : direction;
        if (isBedBelow(world, pos)) {
            return findWakeUpPosition(type, world, pos, bedDirection, direction2);
        } else {
            int[][] is = getAroundAndOnBedOffsets(bedDirection, direction2);
            Optional<Vec3d> optional = findWakeUpPosition(type, world, pos, is, true);
            return optional.isPresent() ? optional : findWakeUpPosition(type, world, pos, is, false);
        }
    }

    private static Optional<Vec3d> findWakeUpPosition(EntityType<?> type, CollisionView world, BlockPos pos, Direction bedDirection, Direction respawnDirection) {
        int[][] is = getAroundBedOffsets(bedDirection, respawnDirection);
        Optional<Vec3d> optional = findWakeUpPosition(type, world, pos, is, true);
        if (optional.isPresent()) {
            return optional;
        } else {
            BlockPos blockPos = pos.down();
            Optional<Vec3d> optional2 = findWakeUpPosition(type, world, blockPos, is, true);
            if (optional2.isPresent()) {
                return optional2;
            } else {
                int[][] js = getOnBedOffsets(bedDirection);
                Optional<Vec3d> optional3 = findWakeUpPosition(type, world, pos, js, true);
                if (optional3.isPresent()) {
                    return optional3;
                } else {
                    Optional<Vec3d> optional4 = findWakeUpPosition(type, world, pos, is, false);
                    if (optional4.isPresent()) {
                        return optional4;
                    } else {
                        Optional<Vec3d> optional5 = findWakeUpPosition(type, world, blockPos, is, false);
                        return optional5.isPresent() ? optional5 : findWakeUpPosition(type, world, pos, js, false);
                    }
                }
            }
        }
    }

    private static Optional<Vec3d> findWakeUpPosition(EntityType<?> type, CollisionView world, BlockPos pos, int[][] possibleOffsets, boolean ignoreInvalidPos) {
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for(int[] is : possibleOffsets) {
            mutable.set(pos.getX() + is[0], pos.getY(), pos.getZ() + is[1]);
            Vec3d vec3d = Dismounting.findRespawnPos(type, world, mutable, ignoreInvalidPos);
            if (vec3d != null) {
                return Optional.of(vec3d);
            }
        }

        return Optional.empty();
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING, PART, OCCUPIED});
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
        if (!world.isClient) {
            BlockPos blockPos = pos.offset((Direction)state.get(FACING));
            world.setBlockState(blockPos, (BlockState)state.with(PART, BedPart.HEAD), 3);
            world.updateNeighbors(pos, Blocks.AIR);
            state.updateNeighbors(world, pos, 3);
        }

    }

    @Override
    protected long getRenderingSeed(BlockState state, BlockPos pos) {
        BlockPos blockPos = pos.offset((Direction)state.get(FACING), state.get(PART) == BedPart.HEAD ? 0 : 1);
        return MathHelper.hashCode(blockPos.getX(), pos.getY(), blockPos.getZ());
    }

    @Override
    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        return false;
    }

    private static int[][] getAroundAndOnBedOffsets(Direction bedDirection, Direction respawnDirection) {
        return (int[][]) ArrayUtils.addAll(getAroundBedOffsets(bedDirection, respawnDirection), getOnBedOffsets(bedDirection));
    }

    private static int[][] getAroundBedOffsets(Direction bedDirection, Direction respawnDirection) {
        return new int[][]{{respawnDirection.getOffsetX(), respawnDirection.getOffsetZ()}, {respawnDirection.getOffsetX() - bedDirection.getOffsetX(), respawnDirection.getOffsetZ() - bedDirection.getOffsetZ()}, {respawnDirection.getOffsetX() - bedDirection.getOffsetX() * 2, respawnDirection.getOffsetZ() - bedDirection.getOffsetZ() * 2}, {-bedDirection.getOffsetX() * 2, -bedDirection.getOffsetZ() * 2}, {-respawnDirection.getOffsetX() - bedDirection.getOffsetX() * 2, -respawnDirection.getOffsetZ() - bedDirection.getOffsetZ() * 2}, {-respawnDirection.getOffsetX() - bedDirection.getOffsetX(), -respawnDirection.getOffsetZ() - bedDirection.getOffsetZ()}, {-respawnDirection.getOffsetX(), -respawnDirection.getOffsetZ()}, {-respawnDirection.getOffsetX() + bedDirection.getOffsetX(), -respawnDirection.getOffsetZ() + bedDirection.getOffsetZ()}, {bedDirection.getOffsetX(), bedDirection.getOffsetZ()}, {respawnDirection.getOffsetX() + bedDirection.getOffsetX(), respawnDirection.getOffsetZ() + bedDirection.getOffsetZ()}};
    }

    private static int[][] getOnBedOffsets(Direction bedDirection) {
        return new int[][]{{0, 0}, {-bedDirection.getOffsetX(), -bedDirection.getOffsetZ()}};
    }

    static {
        PART = Properties.BED_PART;
        OCCUPIED = Properties.OCCUPIED;
        TOP_SHAPE = Block.createCuboidShape(0.0F, 2.0F, 0.0F, 16.0F, 7.5, 16.0F);
        LEG_1_SHAPE = Block.createCuboidShape(0.0F, 2.0F, 0.0F, 2.0F, 2.0F, 2.0F);
        LEG_2_SHAPE = Block.createCuboidShape(14.0F, 2.0F, 0.0F, 16.0F, 2.0F, 2.0F);
        LEG_3_SHAPE = Block.createCuboidShape(14.0F, 2.0F, 14.0F, 16.0F, 2.0F, 16.0F);
        LEG_4_SHAPE = Block.createCuboidShape(0.0F, 2.0F, 14.0F, 2.0F, 2.0F, 16.0F);
        NORTH_SHAPE = VoxelShapes.union(TOP_SHAPE, LEG_1_SHAPE, LEG_2_SHAPE);
        EAST_SHAPE  = VoxelShapes.union(TOP_SHAPE, LEG_2_SHAPE, LEG_3_SHAPE);
        SOUTH_SHAPE = VoxelShapes.union(TOP_SHAPE, LEG_3_SHAPE, LEG_4_SHAPE);
        WEST_SHAPE  = VoxelShapes.union(TOP_SHAPE, LEG_4_SHAPE, LEG_1_SHAPE);
    }
}
