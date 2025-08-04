package com.skniro.skniro_furniture.block.init;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class LampBlock extends AbstractLampBlock{
    public static final MapCodec<LampBlock> CODEC = simpleCodec(LampBlock::new);
    private static final VoxelShape SHAPE = Block.box(0.0, 14.5, 0.0, 16.0, 16.0, 16.0);

    public LampBlock(Properties settings) {
        super(settings);
    }

    public MapCodec<LampBlock> codec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}
