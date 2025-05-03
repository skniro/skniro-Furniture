package com.skniro.skniro_furniture.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class WallCabinetBlockEntity extends AbstractFurnitureContainerBlockEntity {


    public WallCabinetBlockEntity(BlockPos pos, BlockState state) {
        super(FurnitureBlockEntityType.Wall_BLOCK_ENTITY, pos, state,27);
    }

    protected Text getContainerName() {
        return Text.translatable("container.barrel");
    }

    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return GenericContainerScreenHandler.createGeneric9x3(syncId, playerInventory, this);
    }
}
