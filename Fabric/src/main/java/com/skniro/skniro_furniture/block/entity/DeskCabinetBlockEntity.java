package com.skniro.skniro_furniture.block.entity;

import com.skniro.skniro_furniture.init.FurnitureStrings;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class DeskCabinetBlockEntity extends AbstractFurnitureContainerBlockEntity {

    public DeskCabinetBlockEntity(BlockPos pos, BlockState state) {
        super(FurnitureBlockEntityType.Desk_Cabinet_BLOCK_ENTITY, pos, state,18);
    }


    protected Text getContainerName() {
        return Text.translatable(FurnitureStrings.Desk_Cabinet);
    }

    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return GenericContainerScreenHandler.createGeneric9x2(syncId, playerInventory);
    }
}
