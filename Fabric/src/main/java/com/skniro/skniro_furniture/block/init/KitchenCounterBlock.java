package com.skniro.skniro_furniture.block.init;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class KitchenCounterBlock extends HorizontalFacingBlock {
    public static final BooleanProperty LEFT = BooleanProperty.of("left");
    public static final BooleanProperty RIGHT = BooleanProperty.of("right");

    public static final MapCodec<KitchenCounterBlock> CODEC = createCodec(KitchenCounterBlock::new);

    private static final VoxelShape SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 16.0);

    public KitchenCounterBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(LEFT,false).with(RIGHT,false));
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return CODEC;
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        super.neighborUpdate(state, world, pos, sourceBlock, sourcePos, notify);

        if (world.isClient()) return;

        Direction direction = (Direction) state.get(FACING);
        BlockState blockState = world.getBlockState(pos.offset(direction));
        if (isCounter(blockState)) {
            Direction direction2 = (Direction) blockState.get(FACING);
            if (direction2.getAxis() != ((Direction) state.get(FACING)).getAxis() && isDifferentOrientation(state, world, pos, direction2.getOpposite())) {
                boolean leftConnected = isLeftConnected(world, pos, direction);
                boolean rightConnected = isRightConnected(world, pos, direction);

                BlockState newState = state.with(LEFT, leftConnected).with(RIGHT, rightConnected);
                if (!newState.equals(state)) {
                    world.setBlockState(pos, newState, Block.NOTIFY_LISTENERS);
                }
            }
        }
    }

    public static boolean isCounter(BlockState state) {
        return state.getBlock() instanceof KitchenCounterBlock;
    }

    private static boolean isDifferentOrientation(BlockState state, BlockView world, BlockPos pos, Direction dir) {
        BlockState blockState = world.getBlockState(pos.offset(dir));
        return !isCounter(blockState) || blockState.get(FACING) != state.get(FACING);
    }

    private boolean isLeftConnected(World world, BlockPos pos, Direction facing) {
        BlockState neighborState = world.getBlockState(pos.offset(facing.rotateYCounterclockwise()));
        return neighborState.getBlock() == this && neighborState.get(FACING) == facing;
    }

    private boolean isRightConnected(World world, BlockPos pos, Direction facing) {
        BlockState neighborState = world.getBlockState(pos.offset(facing.rotateYClockwise()));
        return neighborState.getBlock() == this && neighborState.get(FACING) == facing;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        Direction facing = context.getHorizontalPlayerFacing().getOpposite();

        return this.getDefaultState().with(FACING, facing);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, LEFT, RIGHT);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}
