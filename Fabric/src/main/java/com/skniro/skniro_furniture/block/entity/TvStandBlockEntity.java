package com.skniro.skniro_furniture.block.entity;

import com.skniro.skniro_furniture.init.FurnitureStrings;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.level.block.state.BlockState;

public class TvStandBlockEntity extends AbstractFurnitureContainerBlockEntity {


    public TvStandBlockEntity(BlockPos pos, BlockState state) {
        super(FurnitureBlockEntityType.TV_Stand_BLOCK_ENTITY, pos, state,27);
    }

    protected Component getDefaultName() {
        return Component.translatable(FurnitureStrings.TV_Stand);
    }

    protected AbstractContainerMenu createMenu(int syncId, Inventory playerInventory) {
        return ChestMenu.threeRows(syncId, playerInventory, this);
    }
}
