package com.skniro.skniro_furniture.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class PaperSlidingDoorBlockEntity extends BlockEntity {
    public PaperSlidingDoorBlockEntity(BlockPos pos, BlockState state) {
        super(FurnitureBlockEntityType.PaperSlidingDoor_BLOCK_ENTITY.get(), pos, state);
    }
}
