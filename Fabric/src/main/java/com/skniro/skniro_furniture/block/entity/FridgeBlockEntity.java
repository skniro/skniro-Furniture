package com.skniro.skniro_furniture.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class FridgeBlockEntity extends AbstractFurnitureContainerBlockEntity {

    public FridgeBlockEntity(BlockPos pos, BlockState state) {
        super(FurnitureBlockEntityType.Fridge_BLOCK_ENTITY, pos, state,27);
    }

    @Override
    protected Text getContainerName() {
        return Text.translatable("container.barrel");
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return GenericContainerScreenHandler.createGeneric9x3(syncId, playerInventory, this);
    }
}
