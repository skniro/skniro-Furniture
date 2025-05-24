package com.skniro.skniro_furniture.block.entity;

import com.skniro.skniro_furniture.init.FurnitureStrings;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.level.block.state.BlockState;

public class DrawerBlockEntity extends AbstractFurnitureContainerBlockEntity {

    public DrawerBlockEntity(BlockPos pos, BlockState state) {
        super(FurnitureBlockEntityType.Drawer_BLOCK_ENTITY, pos, state,27);
    }

    protected Component getDefaultName() {
        return Component.translatable(FurnitureStrings.Drawer);
    }

    protected AbstractContainerMenu createMenu(int syncId, Inventory playerInventory) {
        return ChestMenu.threeRows(syncId, playerInventory, this);
    }
}