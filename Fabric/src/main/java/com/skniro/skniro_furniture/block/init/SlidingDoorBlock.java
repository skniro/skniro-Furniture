package com.skniro.skniro_furniture.block.init;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Map;
import java.util.function.BiConsumer;

import net.minecraft.block.*;
import net.minecraft.block.enums.DoorHinge;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.block.WireOrientation;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.world.tick.ScheduledTickView;
import org.jetbrains.annotations.Nullable;

public class SlidingDoorBlock extends Block {
    public static final MapCodec<SlidingDoorBlock> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(BlockSetType.CODEC.fieldOf("block_set_type").forGetter(SlidingDoorBlock::getBlockSetType), createSettingsCodec()).apply(instance, SlidingDoorBlock::new));
    public static final EnumProperty<Direction> FACING;
    public static final EnumProperty<DoubleBlockHalf> HALF;
    public static final EnumProperty<DoorHinge> HINGE;
    public static final BooleanProperty OPEN;
    public static final BooleanProperty POWERED;
    private final BlockSetType blockSetType;

    protected static final VoxelShape CLOSEB_SOUTH = Block.createCuboidShape(0.0D, 0.0D, 8.0D, 16.0D, 16.0D, 9.5D);
    protected static final VoxelShape CLOSEB_WEST =  Block.createCuboidShape(6.5D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D);
    protected static final VoxelShape CLOSEB_NORTH = Block.createCuboidShape(0.0D, 0.0D, 6.5D, 16.0D, 16.0D, 8.0D);
    protected static final VoxelShape CLOSEB_EAST =  Block.createCuboidShape(8.0D, 0.0D, 0.0D, 9.5D, 16.0D, 16.0D);

    protected static final VoxelShape OPENBR_SOUTH = Block.createCuboidShape(14.0D, 0.0D, 8.0D, 30.0D, 16.0D, 9.5D);
    protected static final VoxelShape OPENBR_WEST =  Block.createCuboidShape(6.5D, 0.0D, 14.0D, 8.0D, 16.0D, 30.0D);
    protected static final VoxelShape OPENBR_NORTH = Block.createCuboidShape(-14.0D, 0.0D, 6.5D, 2.0D, 16.0D, 8.0D);
    protected static final VoxelShape OPENBR_EAST =  Block.createCuboidShape(8.0D, 0.0D, -14.0D, 9.5D, 16.0D, 2.0D);

    protected static final VoxelShape OPENBL_SOUTH = Block.createCuboidShape(-14.0D, 0.0D, 8.0D, 2.0D, 16.0D, 9.5D);
    protected static final VoxelShape OPENBL_WEST =  Block.createCuboidShape(6.5D, 0.0D, -14.0D, 8.0D, 16.0D, 2.0D);
    protected static final VoxelShape OPENBL_NORTH = Block.createCuboidShape(14.0D, 0.0D, 6.5D, 30.0D, 16.0D, 8.0D);
    protected static final VoxelShape OPENBL_EAST =  Block.createCuboidShape(8.0D, 0.0D, 14.0D, 9.5D, 16.0D, 30.0D);

    protected static final VoxelShape CLOSE_SOUTH = Block.createCuboidShape(0.0D, 0.0D, 8.0D, 16.0D, 16.0D, 9.5D);
    protected static final VoxelShape CLOSE_WEST =  Block.createCuboidShape(6.5D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D);
    protected static final VoxelShape CLOSE_NORTH = Block.createCuboidShape(0.0D, 0.0D, 6.5D, 16.0D, 16.0D, 8.0D);
    protected static final VoxelShape CLOSE_EAST =  Block.createCuboidShape(8.0D, 0.0D, 0.0D, 9.5D, 16.0D, 16.0D);

    protected static final VoxelShape OPENR_SOUTH = Block.createCuboidShape(14.0D, 0.0D, 8.0D, 30.0D, 16.0D, 9.5D);
    protected static final VoxelShape OPENR_WEST =  Block.createCuboidShape(6.5D, 0.0D, 14.0D, 8.0D, 16.0D, 30.0D);
    protected static final VoxelShape OPENR_NORTH = Block.createCuboidShape(-14.0D, 0.0D, 6.5D, 2.0D, 16.0D, 8.0D);
    protected static final VoxelShape OPENR_EAST =  Block.createCuboidShape(8.0D, 0.0D, -14.0D, 9.5D, 16.0D, 2.0D);

    protected static final VoxelShape OPENL_SOUTH = Block.createCuboidShape(-14.0D, 0.0D, 8.0D, 2.0D, 16.0D, 9.5D);
    protected static final VoxelShape OPENL_WEST = Block.createCuboidShape(6.5D, 0.0D, -14.0D, 8.0D, 16.0D, 2.0D);
    protected static final VoxelShape OPENL_NORTH = Block.createCuboidShape(14.0D, 0.0D, 6.5D, 30.0D, 16.0D, 8.0D);
    protected static final VoxelShape OPENL_EAST = Block.createCuboidShape(8.0D, 0.0D, 14.0D, 9.5D, 16.0D, 30.0D);

    public MapCodec<? extends SlidingDoorBlock> getCodec() {
        return CODEC;
    }

    public SlidingDoorBlock(BlockSetType type, AbstractBlock.Settings settings) {
        super(settings.sounds(type.soundType()));
        this.blockSetType = type;
        this.setDefaultState((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(FACING, Direction.NORTH)).with(OPEN, false)).with(HINGE, DoorHinge.LEFT)).with(POWERED, false)).with(HALF, DoubleBlockHalf.LOWER));
    }

    public BlockSetType getBlockSetType() {
        return this.blockSetType;
    }

    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction direction = state.get(FACING);
        DoubleBlockHalf half = state.get(HALF);
        boolean open = !state.get(OPEN);
        boolean right = (state.get(HINGE) == DoorHinge.RIGHT);

        switch (half) {
            case LOWER:
            default:
                switch (direction) {
                    case NORTH:
                    default:
                        return open? CLOSEB_NORTH : (right? OPENBL_NORTH : OPENBR_NORTH);
                    case SOUTH:
                        return open? CLOSEB_SOUTH : (right? OPENBL_SOUTH : OPENBR_SOUTH);
                    case WEST:
                        return open? CLOSEB_WEST : (right? OPENBL_WEST : OPENBR_WEST);
                    case EAST:
                        return open? CLOSEB_EAST : (right? OPENBL_EAST : OPENBR_EAST);
                }

            case UPPER:
                switch (direction) {
                    case NORTH:
                    default:
                        return open? CLOSE_NORTH : (right? OPENL_NORTH : OPENR_NORTH);
                    case SOUTH:
                        return open? CLOSE_SOUTH : (right? OPENL_SOUTH : OPENR_SOUTH);
                    case WEST:
                        return open? CLOSE_WEST : (right? OPENL_WEST : OPENR_WEST);
                    case EAST:
                        return open? CLOSE_EAST : (right? OPENL_EAST : OPENR_EAST);
                }
        }
    }

    protected BlockState getStateForNeighborUpdate(BlockState state, WorldView world, ScheduledTickView tickView, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, Random random) {
        DoubleBlockHalf doubleBlockHalf = (DoubleBlockHalf)state.get(HALF);
        if (direction.getAxis() == Direction.Axis.Y && doubleBlockHalf == DoubleBlockHalf.LOWER == (direction == Direction.UP)) {
            return neighborState.getBlock() instanceof SlidingDoorBlock && neighborState.get(HALF) != doubleBlockHalf ? (BlockState)neighborState.with(HALF, doubleBlockHalf) : Blocks.AIR.getDefaultState();
        } else {
            return doubleBlockHalf == DoubleBlockHalf.LOWER && direction == Direction.DOWN && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, world, tickView, pos, direction, neighborPos, neighborState, random);
        }
    }

    protected void onExploded(BlockState state, ServerWorld world, BlockPos pos, Explosion explosion, BiConsumer<ItemStack, BlockPos> stackMerger) {
        if (explosion.canTriggerBlocks() && state.get(HALF) == DoubleBlockHalf.LOWER && this.blockSetType.canOpenByWindCharge() && !(Boolean)state.get(POWERED)) {
            this.setOpen((Entity)null, world, state, pos, !this.isOpen(state));
        }

        super.onExploded(state, world, pos, explosion, stackMerger);
    }

    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isClient && (player.shouldSkipBlockDrops() || !player.canHarvest(state))) {
            onBreakInCreative(world, pos, state, player);
        }

        return super.onBreak(world, pos, state, player);
    }

    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        boolean var10000;
        switch (type) {
            case LAND:
            case AIR:
                var10000 = (Boolean)state.get(OPEN);
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
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockPos pos = ctx.getBlockPos();
        World world = ctx.getWorld();
        Direction playerFacing = ctx.getHorizontalPlayerFacing();
        BlockPos upPos = pos.up();
        if (pos.getY() < world.getTopYInclusive() - 1 && world.getBlockState(upPos).canReplace(ctx)) {
            boolean bl = world.isReceivingRedstonePower(pos) || world.isReceivingRedstonePower(upPos);
            return this.getDefaultState()
                    .with(FACING, playerFacing)
                    .with(HINGE, getHinge(ctx))
                    .with(OPEN, false)
                    .with(POWERED, bl)
                    .with(HALF, DoubleBlockHalf.LOWER);
        } else {
            return null;
        }
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        world.setBlockState(pos.up(), state.with(HALF, DoubleBlockHalf.UPPER), 3);
    }

    private DoorHinge getHinge(ItemPlacementContext ctx) {
        BlockView blockView = ctx.getWorld();
        BlockPos blockPos = ctx.getBlockPos();
        Direction direction = ctx.getHorizontalPlayerFacing();
        BlockPos blockPos2 = blockPos.up();
        Direction direction2 = direction.rotateYCounterclockwise();
        BlockPos blockPos3 = blockPos.offset(direction2);
        BlockState blockState = blockView.getBlockState(blockPos3);
        BlockPos blockPos4 = blockPos2.offset(direction2);
        BlockState blockState2 = blockView.getBlockState(blockPos4);
        Direction direction3 = direction.rotateYClockwise();
        BlockPos blockPos5 = blockPos.offset(direction3);
        BlockState blockState3 = blockView.getBlockState(blockPos5);
        BlockPos blockPos6 = blockPos2.offset(direction3);
        BlockState blockState4 = blockView.getBlockState(blockPos6);
        int i = (blockState.isFullCube(blockView, blockPos3) ? -1 : 0) + (blockState2.isFullCube(blockView, blockPos4) ? -1 : 0) + (blockState3.isFullCube(blockView, blockPos5) ? 1 : 0) + (blockState4.isFullCube(blockView, blockPos6) ? 1 : 0);
        boolean bl = blockState.getBlock() instanceof SlidingDoorBlock && blockState.get(HALF) == DoubleBlockHalf.LOWER;
        boolean bl2 = blockState3.getBlock() instanceof SlidingDoorBlock && blockState3.get(HALF) == DoubleBlockHalf.LOWER;
        if ((!bl || bl2) && i <= 0) {
            if ((!bl2 || bl) && i >= 0) {
                int j = direction.getOffsetX();
                int k = direction.getOffsetZ();
                Vec3d vec3d = ctx.getHitPos();
                double d = vec3d.x - (double)blockPos.getX();
                double e = vec3d.z - (double)blockPos.getZ();
                return (j >= 0 || !(e < (double)0.5F)) && (j <= 0 || !(e > (double)0.5F)) && (k >= 0 || !(d > (double)0.5F)) && (k <= 0 || !(d < (double)0.5F)) ? DoorHinge.LEFT : DoorHinge.RIGHT;
            } else {
                return DoorHinge.LEFT;
            }
        } else {
            return DoorHinge.RIGHT;
        }
    }

    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!this.blockSetType.canOpenByHand()) {
            return ActionResult.PASS;
        } else {
            state = (BlockState)state.cycle(OPEN);
            world.setBlockState(pos, state, 10);
            this.playOpenCloseSound(player, world, pos, (Boolean)state.get(OPEN));
            world.emitGameEvent(player, this.isOpen(state) ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
            return ActionResult.SUCCESS;
        }
    }

    public boolean isOpen(BlockState state) {
        return (Boolean)state.get(OPEN);
    }

    public void setOpen(@Nullable Entity entity, World world, BlockState state, BlockPos pos, boolean open) {
        if (state.isOf(this) && (Boolean)state.get(OPEN) != open) {
            world.setBlockState(pos, (BlockState)state.with(OPEN, open), 10);
            this.playOpenCloseSound(entity, world, pos, open);
            world.emitGameEvent(entity, open ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
        }
    }

/*    @Override
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, @Nullable WireOrientation wireOrientation, boolean notify) {
        DoubleBlockHalf half = state.get(HALF);
        if (half == DoubleBlockHalf.UPPER) {
            BlockState below = world.getBlockState(pos.down());
            if (!(below.getBlock() instanceof SlidingDoorBlock) || below.get(HALF) != DoubleBlockHalf.LOWER) {
                world.removeBlock(pos, false); // 上半在，下半丢失 -> 删除
            }
        } else {
            BlockState above = world.getBlockState(pos.up());
            if (!(above.getBlock() instanceof SlidingDoorBlock) || above.get(HALF) != DoubleBlockHalf.UPPER) {
                world.removeBlock(pos, false); // 下半在，上半丢失 -> 删除
            }
        }

        super.neighborUpdate(state, world, pos, block, fromPos, notify);
    }*/


    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, @Nullable WireOrientation wireOrientation, boolean notify) {
        boolean bl = world.isReceivingRedstonePower(pos) || world.isReceivingRedstonePower(pos.offset(state.get(HALF) == DoubleBlockHalf.LOWER ? Direction.UP : Direction.DOWN));
        if (!this.getDefaultState().isOf(sourceBlock) && bl != (Boolean)state.get(POWERED)) {
            if (bl != (Boolean)state.get(OPEN)) {
                this.playOpenCloseSound((Entity)null, world, pos, bl);
                world.emitGameEvent((Entity)null, bl ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
            }

            world.setBlockState(pos, (BlockState)((BlockState)state.with(POWERED, bl)).with(OPEN, bl), 2);
        }

    }

    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.down();
        BlockState blockState = world.getBlockState(blockPos);
        return state.get(HALF) == DoubleBlockHalf.LOWER ? blockState.isSideSolidFullSquare(world, blockPos, Direction.UP) : blockState.isOf(this);
    }

    private void playOpenCloseSound(@Nullable Entity entity, World world, BlockPos pos, boolean open) {
        world.playSound(entity, pos, open ? this.blockSetType.doorOpen() : this.blockSetType.doorClose(), SoundCategory.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.1F + 0.9F);
    }

    protected BlockState rotate(BlockState state, BlockRotation rotation) {
        return (BlockState)state.with(FACING, rotation.rotate((Direction)state.get(FACING)));
    }

    protected BlockState mirror(BlockState state, BlockMirror mirror) {
        return mirror == BlockMirror.NONE ? state : (BlockState)state.rotate(mirror.getRotation((Direction)state.get(FACING))).cycle(HINGE);
    }

    protected long getRenderingSeed(BlockState state, BlockPos pos) {
        return MathHelper.hashCode(pos.getX(), pos.down(state.get(HALF) == DoubleBlockHalf.LOWER ? 0 : 1).getY(), pos.getZ());
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{HALF, FACING, OPEN, HINGE, POWERED});
    }

    public static boolean canOpenByHand(World world, BlockPos pos) {
        return canOpenByHand(world.getBlockState(pos));
    }

    public static boolean canOpenByHand(BlockState state) {
        Block var2 = state.getBlock();
        boolean var10000;
        if (var2 instanceof SlidingDoorBlock doorBlock) {
            if (doorBlock.getBlockSetType().canOpenByHand()) {
                var10000 = true;
                return var10000;
            }
        }

        var10000 = false;
        return var10000;
    }

    static {
        FACING = HorizontalFacingBlock.FACING;
        HALF = Properties.DOUBLE_BLOCK_HALF;
        HINGE = Properties.DOOR_HINGE;
        OPEN = Properties.OPEN;
        POWERED = Properties.POWERED;
    }


    protected static void onBreakInCreative(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        DoubleBlockHalf doubleBlockHalf = (DoubleBlockHalf)state.get(HALF);
        if (doubleBlockHalf == DoubleBlockHalf.UPPER) {
            BlockPos blockPos = pos.down();
            BlockState blockState = world.getBlockState(blockPos);
            if (blockState.isOf(state.getBlock()) && blockState.get(HALF) == DoubleBlockHalf.LOWER) {
                BlockState blockState2 = blockState.getFluidState().isOf(Fluids.WATER) ? Blocks.WATER.getDefaultState() : Blocks.AIR.getDefaultState();
                world.setBlockState(blockPos, blockState2, 35);
                world.syncWorldEvent(player, 2001, blockPos, Block.getRawIdFromState(blockState));
            }
        }

    }
}
