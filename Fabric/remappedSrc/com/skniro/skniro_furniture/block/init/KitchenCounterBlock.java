package com.skniro.skniro_furniture.block.init;

import com.mojang.serialization.MapCodec;
import com.skniro.skniro_furniture.entity.MapleEntityType;
import com.skniro.skniro_furniture.entity.furniture.ChairEntity;
import net.minecraft.block.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class KitchenCounterBlock extends HorizontalDirectionalBlock {
    public static final BooleanProperty LEFT = BooleanProperty.create("left");
    public static final BooleanProperty RIGHT = BooleanProperty.create("right");

    public static final MapCodec<KitchenCounterBlock> CODEC = simpleCodec(KitchenCounterBlock::new);

    private static final VoxelShape SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0);

    public KitchenCounterBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.stateDefinition.any().setValue(LEFT,false).setValue(RIGHT,false));
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    public void neighborChanged(BlockState state, Level world, BlockPos pos, Block sourceBlock, @Nullable Orientation wireOrientation, boolean notify) {
        super.neighborChanged(state, world, pos, sourceBlock, wireOrientation, notify);

        if (world.isClientSide()) return;

        Direction direction = (Direction) state.getValue(FACING);
        BlockState blockState = world.getBlockState(pos.relative(direction));
        if (isCounter(blockState)) {
            Direction direction2 = (Direction) blockState.getValue(FACING);
            if (direction2.getAxis() != ((Direction) state.getValue(FACING)).getAxis() && isDifferentOrientation(state, world, pos, direction2.getOpposite())) {
                boolean leftConnected = isLeftConnected(world, pos, direction);
                boolean rightConnected = isRightConnected(world, pos, direction);

                BlockState newState = state.setValue(LEFT, leftConnected).setValue(RIGHT, rightConnected);
                if (!newState.equals(state)) {
                    world.setBlock(pos, newState, Block.UPDATE_CLIENTS);
                }
            }
        }
    }

    public static boolean isCounter(BlockState state) {
        return state.getBlock() instanceof KitchenCounterBlock;
    }

    private static boolean isDifferentOrientation(BlockState state, BlockGetter world, BlockPos pos, Direction dir) {
        BlockState blockState = world.getBlockState(pos.relative(dir));
        return !isCounter(blockState) || blockState.getValue(FACING) != state.getValue(FACING);
    }

    private boolean isLeftConnected(Level world, BlockPos pos, Direction facing) {
        BlockState neighborState = world.getBlockState(pos.relative(facing.getCounterClockWise()));
        return neighborState.getBlock() == this && neighborState.getValue(FACING) == facing;
    }

    private boolean isRightConnected(Level world, BlockPos pos, Direction facing) {
        BlockState neighborState = world.getBlockState(pos.relative(facing.getClockWise()));
        return neighborState.getBlock() == this && neighborState.getValue(FACING) == facing;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction facing = context.getHorizontalDirection().getOpposite();

        return this.defaultBlockState().setValue(FACING, facing);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, LEFT, RIGHT);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}
