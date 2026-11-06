package com.skniro.skniro_furniture.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class MirrorBlockEntity extends BlockEntity {
    public MirrorBlockEntity(BlockPos pos, BlockState state) {
        super(FurnitureBlockEntityType.Mirror_BLOCK_ENTITY, pos, state);
    }
}
