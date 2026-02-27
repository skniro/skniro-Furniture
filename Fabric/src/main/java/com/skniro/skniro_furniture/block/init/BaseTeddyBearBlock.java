package com.skniro.skniro_furniture.block.init;


import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class BaseTeddyBearBlock extends HorizontalFacingBlock {
    public static final MapCodec<BaseTeddyBearBlock> CODEC = createCodec(BaseTeddyBearBlock::new);
    private static final VoxelShape NORTH_SHAPE;
    private static final VoxelShape SOUTH_SHAPE;
    private static final VoxelShape EAST_SHAPE;
    private static final VoxelShape WEST_SHAPE;

    public BaseTeddyBearBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BaseTeddyBearBlock> getCodec() {
        return CODEC;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction direction = state.get(FACING);
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
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    static {
        NORTH_SHAPE = Block.createCuboidShape(5.0, 0.0, 6.0, 11.0, 12.0, 10.6);
        SOUTH_SHAPE = Block.createCuboidShape(5.0, 0.0, 5.4, 11.0, 12.0, 10.0);
        EAST_SHAPE = Block.createCuboidShape(5.4, 0.0, 5.0, 10.0, 12.0, 11.0);
        WEST_SHAPE = Block.createCuboidShape(6.0, 0.0, 5.0, 10.6, 12.0, 11.0);
    }
}
