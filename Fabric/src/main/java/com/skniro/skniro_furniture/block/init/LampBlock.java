package com.skniro.skniro_furniture.block.init;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class LampBlock extends AbstractLampBlock{
    public static final MapCodec<LampBlock> CODEC = createCodec(LampBlock::new);
    private static final VoxelShape SHAPE = Block.createCuboidShape(0.0, 14.5, 0.0, 16.0, 16.0, 16.0);

    public LampBlock(Settings settings) {
        super(settings);
    }

    public MapCodec<LampBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}
