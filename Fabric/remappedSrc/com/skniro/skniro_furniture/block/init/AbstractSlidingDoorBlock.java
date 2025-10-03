package com.skniro.skniro_furniture.block.init;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.function.BiConsumer;

public abstract class AbstractSlidingDoorBlock extends Block {
    public static final EnumProperty<Direction> FACING;
    public static final EnumProperty<DoubleBlockHalf> HALF;
    public static final EnumProperty<DoorHingeSide> HINGE;
    public static final BooleanProperty OPEN;
    public static final BooleanProperty POWERED;
    private final BlockSetType blockSetType;

    public AbstractSlidingDoorBlock(BlockSetType type, Properties settings) {
        super(settings.sound(type.soundType()));
        this.blockSetType = type;
        this.registerDefaultState((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH)).setValue(OPEN, false)).setValue(HINGE, DoorHingeSide.LEFT)).setValue(POWERED, false)).setValue(HALF, DoubleBlockHalf.LOWER));
    }

    public BlockSetType getBlockSetType() {
        return this.blockSetType;
    }

    protected BlockState updateShape(BlockState state, LevelReader world, ScheduledTickAccess tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource random) {
        DoubleBlockHalf doubleBlockHalf = (DoubleBlockHalf)state.getValue(HALF);
        if (direction.getAxis() == Direction.Axis.Y && doubleBlockHalf == DoubleBlockHalf.LOWER == (direction == Direction.UP)) {
            return neighborState.getBlock() instanceof AbstractSlidingDoorBlock && neighborState.getValue(HALF) != doubleBlockHalf ? (BlockState)neighborState.setValue(HALF, doubleBlockHalf) : Blocks.AIR.defaultBlockState();
        } else {
            return doubleBlockHalf == DoubleBlockHalf.LOWER && direction == Direction.DOWN && !state.canSurvive(world, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, world, tickView, pos, direction, neighborPos, neighborState, random);
        }
    }

    protected void onExplosionHit(BlockState state, ServerLevel world, BlockPos pos, Explosion explosion, BiConsumer<ItemStack, BlockPos> stackMerger) {
        if (explosion.canTriggerBlocks() && state.getValue(HALF) == DoubleBlockHalf.LOWER && this.blockSetType.canOpenByWindCharge() && !(Boolean)state.getValue(POWERED)) {
            this.setOpen((Entity)null, world, state, pos, !this.isOpen(state));
        }

        super.onExplosionHit(state, world, pos, explosion, stackMerger);
    }

    public BlockState playerWillDestroy(Level world, BlockPos pos, BlockState state, Player player) {
        if (!world.isClientSide() && (player.preventsBlockDrops() || !player.hasCorrectToolForDrops(state))) {
            onBreakInCreative(world, pos, state, player);
        }

        return super.playerWillDestroy(world, pos, state, player);
    }

    protected boolean isPathfindable(BlockState state, PathComputationType type) {
        boolean var10000;
        switch (type) {
            case LAND:
            case AIR:
                var10000 = (Boolean)state.getValue(OPEN);
                break;
            case WATER:
                var10000 = false;
                break;
            default:
                throw new MatchException((String)null, (Throwable)null);
        }

        return var10000;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        BlockPos pos = ctx.getClickedPos();
        Level world = ctx.getLevel();
        Direction playerFacing = ctx.getHorizontalDirection();
        BlockPos upPos = pos.above();
        if (pos.getY() < world.getMaxY() - 1 && world.getBlockState(upPos).canBeReplaced(ctx)) {
            boolean bl = world.hasNeighborSignal(pos) || world.hasNeighborSignal(upPos);
            return this.defaultBlockState()
                    .setValue(FACING, playerFacing)
                    .setValue(HINGE, getHinge(ctx))
                    .setValue(OPEN, false)
                    .setValue(POWERED, bl)
                    .setValue(HALF, DoubleBlockHalf.LOWER);
        } else {
            return null;
        }
    }

    @Override
    public void setPlacedBy(Level world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        world.setBlock(pos.above(), state.setValue(HALF, DoubleBlockHalf.UPPER), 3);
    }

    private DoorHingeSide getHinge(BlockPlaceContext ctx) {
        BlockGetter blockView = ctx.getLevel();
        BlockPos blockPos = ctx.getClickedPos();
        Direction direction = ctx.getHorizontalDirection();
        BlockPos blockPos2 = blockPos.above();
        Direction direction2 = direction.getCounterClockWise();
        BlockPos blockPos3 = blockPos.relative(direction2);
        BlockState blockState = blockView.getBlockState(blockPos3);
        BlockPos blockPos4 = blockPos2.relative(direction2);
        BlockState blockState2 = blockView.getBlockState(blockPos4);
        Direction direction3 = direction.getClockWise();
        BlockPos blockPos5 = blockPos.relative(direction3);
        BlockState blockState3 = blockView.getBlockState(blockPos5);
        BlockPos blockPos6 = blockPos2.relative(direction3);
        BlockState blockState4 = blockView.getBlockState(blockPos6);
        int i = (blockState.isCollisionShapeFullBlock(blockView, blockPos3) ? -1 : 0) + (blockState2.isCollisionShapeFullBlock(blockView, blockPos4) ? -1 : 0) + (blockState3.isCollisionShapeFullBlock(blockView, blockPos5) ? 1 : 0) + (blockState4.isCollisionShapeFullBlock(blockView, blockPos6) ? 1 : 0);
        boolean bl = blockState.getBlock() instanceof AbstractSlidingDoorBlock && blockState.getValue(HALF) == DoubleBlockHalf.LOWER;
        boolean bl2 = blockState3.getBlock() instanceof AbstractSlidingDoorBlock && blockState3.getValue(HALF) == DoubleBlockHalf.LOWER;
        if ((!bl || bl2) && i <= 0) {
            if ((!bl2 || bl) && i >= 0) {
                int j = direction.getStepX();
                int k = direction.getStepZ();
                Vec3 vec3d = ctx.getClickLocation();
                double d = vec3d.x - (double)blockPos.getX();
                double e = vec3d.z - (double)blockPos.getZ();
                return (j >= 0 || !(e < (double)0.5F)) && (j <= 0 || !(e > (double)0.5F)) && (k >= 0 || !(d > (double)0.5F)) && (k <= 0 || !(d < (double)0.5F)) ? DoorHingeSide.LEFT : DoorHingeSide.RIGHT;
            } else {
                return DoorHingeSide.LEFT;
            }
        } else {
            return DoorHingeSide.RIGHT;
        }
    }

    protected InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
        if (!this.blockSetType.canOpenByHand()) {
            return InteractionResult.PASS;
        } else {
            state = (BlockState)state.cycle(OPEN);
            world.setBlock(pos, state, 10);
            this.playOpenCloseSound(player, world, pos, (Boolean)state.getValue(OPEN));
            world.gameEvent(player, this.isOpen(state) ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
            return InteractionResult.SUCCESS;
        }
    }

    public boolean isOpen(BlockState state) {
        return (Boolean)state.getValue(OPEN);
    }

    public void setOpen(@Nullable Entity entity, Level world, BlockState state, BlockPos pos, boolean open) {
        if (state.is(this) && (Boolean)state.getValue(OPEN) != open) {
            world.setBlock(pos, (BlockState)state.setValue(OPEN, open), 10);
            this.playOpenCloseSound(entity, world, pos, open);
            world.gameEvent(entity, open ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
        }
    }


    protected void neighborChanged(BlockState state, Level world, BlockPos pos, Block sourceBlock, @Nullable Orientation wireOrientation, boolean notify) {
        boolean bl = world.hasNeighborSignal(pos) || world.hasNeighborSignal(pos.relative(state.getValue(HALF) == DoubleBlockHalf.LOWER ? Direction.UP : Direction.DOWN));
        if (!this.defaultBlockState().is(sourceBlock) && bl != (Boolean)state.getValue(POWERED)) {
            if (bl != (Boolean)state.getValue(OPEN)) {
                this.playOpenCloseSound((Entity)null, world, pos, bl);
                world.gameEvent((Entity)null, bl ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
            }

            world.setBlock(pos, (BlockState)((BlockState)state.setValue(POWERED, bl)).setValue(OPEN, bl), 2);
        }

    }

    protected boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        BlockPos blockPos = pos.below();
        BlockState blockState = world.getBlockState(blockPos);
        return state.getValue(HALF) == DoubleBlockHalf.LOWER ? blockState.isFaceSturdy(world, blockPos, Direction.UP) : blockState.is(this);
    }

    private void playOpenCloseSound(@Nullable Entity entity, Level world, BlockPos pos, boolean open) {
        world.playSound(entity, pos, open ? this.blockSetType.doorOpen() : this.blockSetType.doorClose(), SoundSource.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.1F + 0.9F);
    }

    protected BlockState rotate(BlockState state, Rotation rotation) {
        return (BlockState)state.setValue(FACING, rotation.rotate((Direction)state.getValue(FACING)));
    }

    protected BlockState mirror(BlockState state, Mirror mirror) {
        return mirror == Mirror.NONE ? state : (BlockState)state.rotate(mirror.getRotation((Direction)state.getValue(FACING))).cycle(HINGE);
    }

    protected long getSeed(BlockState state, BlockPos pos) {
        return Mth.getSeed(pos.getX(), pos.below(state.getValue(HALF) == DoubleBlockHalf.LOWER ? 0 : 1).getY(), pos.getZ());
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{HALF, FACING, OPEN, HINGE, POWERED});
    }

    public static boolean canOpenByHand(Level world, BlockPos pos) {
        return canOpenByHand(world.getBlockState(pos));
    }

    public static boolean canOpenByHand(BlockState state) {
        Block var2 = state.getBlock();
        boolean var10000;
        if (var2 instanceof AbstractSlidingDoorBlock doorBlock) {
            if (doorBlock.getBlockSetType().canOpenByHand()) {
                var10000 = true;
                return var10000;
            }
        }

        var10000 = false;
        return var10000;
    }

    static {
        FACING = HorizontalDirectionalBlock.FACING;
        HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
        HINGE = BlockStateProperties.DOOR_HINGE;
        OPEN = BlockStateProperties.OPEN;
        POWERED = BlockStateProperties.POWERED;
    }


    protected static void onBreakInCreative(Level world, BlockPos pos, BlockState state, Player player) {
        DoubleBlockHalf doubleBlockHalf = (DoubleBlockHalf)state.getValue(HALF);
        if (doubleBlockHalf == DoubleBlockHalf.UPPER) {
            BlockPos blockPos = pos.below();
            BlockState blockState = world.getBlockState(blockPos);
            if (blockState.is(state.getBlock()) && blockState.getValue(HALF) == DoubleBlockHalf.LOWER) {
                BlockState blockState2 = blockState.getFluidState().is(Fluids.WATER) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
                world.setBlock(blockPos, blockState2, 35);
                world.levelEvent(player, 2001, blockPos, Block.getId(blockState));
            }
        }

    }
}
