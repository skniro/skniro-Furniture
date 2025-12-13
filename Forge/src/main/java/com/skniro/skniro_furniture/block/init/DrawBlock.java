package com.skniro.skniro_furniture.block.init;

import com.mojang.serialization.MapCodec;
import com.skniro.skniro_furniture.entity.MapleEntityType;
import com.skniro.skniro_furniture.entity.furniture.ChairEntity;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DrawBlock extends HorizontalDirectionalBlock {
    private static final VoxelShape NORTH_SHAPE;
    private static final VoxelShape SOUTH_SHAPE;
    private static final VoxelShape EAST_SHAPE;
    private static final VoxelShape WEST_SHAPE;
    public static final MapCodec<DrawBlock> CODEC = simpleCodec(DrawBlock::new);
    public DrawBlock(Properties settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        switch (direction){
            case EAST:
                return EAST_SHAPE;
            case SOUTH:
                return SOUTH_SHAPE;
            case WEST:
                return WEST_SHAPE;
            case NORTH:
            default:
                return NORTH_SHAPE;
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite());
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    static {
        NORTH_SHAPE = Block.box(2.0, 2.0, 15.0, 14.0, 14.0, 16.0);
        SOUTH_SHAPE = Block.box(2.0, 2.0, 0.0, 14.0, 14.0, 1.0);
        EAST_SHAPE = Block.box(0.0, 2.0, 2.0, 1.0, 14.0, 14.0);
        WEST_SHAPE = Block.box(15.0, 2.0, 2.0, 16.0, 14.0, 14.0);
    }
}