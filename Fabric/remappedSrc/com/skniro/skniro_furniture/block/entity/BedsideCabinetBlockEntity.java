package com.skniro.skniro_furniture.block.entity;

import com.skniro.skniro_furniture.init.FurnitureStrings;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.level.block.state.BlockState;

public class BedsideCabinetBlockEntity extends AbstractFurnitureContainerBlockEntity {


    public BedsideCabinetBlockEntity(BlockPos pos, BlockState state) {
        super(FurnitureBlockEntityType.Bedside_Cabinet_BLOCK_ENTITY, pos, state,27);
    }

    protected Component getDefaultName() {
        return Component.translatable(FurnitureStrings.Bedside_Cabinet);
    }

    protected AbstractContainerMenu createMenu(int syncId, Inventory playerInventory) {
        return ChestMenu.threeRows(syncId, playerInventory, this);
    }
}
