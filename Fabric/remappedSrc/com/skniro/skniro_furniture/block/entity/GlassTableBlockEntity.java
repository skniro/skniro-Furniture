package com.skniro.skniro_furniture.block.entity;

import com.skniro.skniro_furniture.init.FurnitureStrings;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.DispenserMenu;
import net.minecraft.world.level.block.state.BlockState;

public class GlassTableBlockEntity extends AbstractFurnitureContainerBlockEntity {

    public GlassTableBlockEntity(BlockPos pos, BlockState state) {
        super(FurnitureBlockEntityType.GLASS_TABLE_BLOCK_ENTITY, pos, state, 9);
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable(FurnitureStrings.Glass_Table);
    }

    @Override
    protected AbstractContainerMenu createMenu(int syncId, Inventory playerInventory) {
        return new DispenserMenu(syncId, playerInventory, this);
    }
}