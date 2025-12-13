package com.skniro.skniro_furniture.block.entity;

import com.skniro.skniro_furniture.block.api.world.inventory.FurnitureChestMenu;
import com.skniro.skniro_furniture.block.init.FridgeBlock;
import com.skniro.skniro_furniture.init.FurnitureStrings;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

public class DeskCabinetBlockEntity extends AbstractFurnitureContainerBlockEntity {

    public DeskCabinetBlockEntity(BlockPos pos, BlockState state) {
        super(FurnitureBlockEntityType.Desk_Cabinet_BLOCK_ENTITY.get(), pos, state,18);
    }

    @Override
    protected Component getDefaultName() {
        if(getBlockState().getValue(FridgeBlock.HALF) == DoubleBlockHalf.UPPER) {
            return Component.translatable(FurnitureStrings.Fridge_UPPER);
        }
        return Component.translatable(FurnitureStrings.Fridge_LOWER);
    }
    protected AbstractContainerMenu createMenu(int syncId, Inventory playerInventory) {
        return FurnitureChestMenu.twoRows(syncId, playerInventory, this);
    }
}
