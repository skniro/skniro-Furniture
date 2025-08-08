package com.skniro.skniro_furniture.block.init;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class DeskLampBlock extends AbstractLampBlock{
    private static final VoxelShape SHAPE = Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 12.5, 11.0);

    public DeskLampBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}
