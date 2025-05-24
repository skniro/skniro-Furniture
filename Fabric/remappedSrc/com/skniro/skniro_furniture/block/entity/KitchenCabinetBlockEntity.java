package com.skniro.skniro_furniture.block.entity;

import com.skniro.skniro_furniture.init.FurnitureStrings;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.level.block.state.BlockState;

public class KitchenCabinetBlockEntity extends AbstractFurnitureContainerBlockEntity {

    public KitchenCabinetBlockEntity(BlockPos pos, BlockState state) {
        super(FurnitureBlockEntityType.Kitchen_Cabinet_BLOCK_ENTITY, pos, state,27);
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable(FurnitureStrings.Kitchen_Cabinet);
    }

    @Override
    protected AbstractContainerMenu createMenu(int syncId, Inventory playerInventory) {
        return ChestMenu.threeRows(syncId, playerInventory, this);
    }
}
