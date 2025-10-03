package com.skniro.skniro_furniture.block.entity;

import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

public class FurnitureBedBlockEntity extends BlockEntity {
    private static final Logger LOGGER = LogUtils.getLogger();
    @Nullable
    private Component customName;
    private final DyeColor baseColor;

    public FurnitureBedBlockEntity(BlockPos pos, BlockState state) {
        this(pos, state, DyeColor.WHITE);
    }


    public FurnitureBedBlockEntity(BlockPos pos, BlockState state, DyeColor baseColor) {
        super(FurnitureBlockEntityType.Bed_BLOCK_ENTITY.get(), pos, state);
        this.baseColor = baseColor;
    }
}

