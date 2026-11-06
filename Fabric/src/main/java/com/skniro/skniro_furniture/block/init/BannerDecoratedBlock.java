package com.skniro.skniro_furniture.block.init;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

/** Implemented by multi-part furniture blocks whose banner decorations are shared between parts. */
public interface BannerDecoratedBlock {
    List<BlockPos> getDecorationPositions(Level world, BlockPos pos, BlockState state);
}
