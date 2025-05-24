package com.skniro.skniro_furniture.block.entity;

import com.skniro.skniro_furniture.init.FurnitureStrings;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class BedsideCabinetBlockEntity extends AbstractFurnitureContainerBlockEntity {


    public BedsideCabinetBlockEntity(BlockPos pos, BlockState state) {
        super(FurnitureBlockEntityType.Bedside_Cabinet_BLOCK_ENTITY, pos, state,27);
    }

    protected Text getContainerName() {
        return Text.translatable(FurnitureStrings.Bedside_Cabinet);
    }

    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return GenericContainerScreenHandler.createGeneric9x3(syncId, playerInventory, this);
    }
}
