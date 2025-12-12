package com.skniro.skniro_furniture.block.entity;

import com.skniro.skniro_furniture.block.init.FridgeBlock;
import com.skniro.skniro_furniture.init.FurnitureStrings;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.Half;

public class FridgeBlockEntity extends AbstractFurnitureContainerBlockEntity {

    public FridgeBlockEntity(BlockPos pos, BlockState state) {
        super(FurnitureBlockEntityType.Fridge_BLOCK_ENTITY.get(), pos, state,54);
    }

    @Override
    protected Component getDefaultName() {
        if(getBlockState().getValue(FridgeBlock.HALF) == DoubleBlockHalf.UPPER) {
            return Component.translatable(FurnitureStrings.Fridge_UPPER);
        }
        return Component.translatable(FurnitureStrings.Fridge_LOWER);
    }

    @Override
    protected AbstractContainerMenu createMenu(int syncId, Inventory playerInventory) {
        return ChestMenu.sixRows(syncId, playerInventory, this);
    }
}
