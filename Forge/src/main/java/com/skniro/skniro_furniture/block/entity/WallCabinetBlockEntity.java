package com.skniro.skniro_furniture.block.entity;

import com.skniro.skniro_furniture.init.FurnitureStrings;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.DispenserMenu;
import net.minecraft.world.level.block.state.BlockState;

public class WallCabinetBlockEntity extends AbstractFurnitureContainerBlockEntity {


    public WallCabinetBlockEntity(BlockPos pos, BlockState state) {
        super(FurnitureBlockEntityType.Wall_BLOCK_ENTITY.get(), pos, state,9);
    }

    protected Component getDefaultName() {
        return Component.translatable(FurnitureStrings.Wall_Cabinet);
    }

    protected AbstractContainerMenu createMenu(int syncId, Inventory playerInventory) {
        return new DispenserMenu(syncId, playerInventory, this);
    }
}
