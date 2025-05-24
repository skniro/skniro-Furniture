package com.skniro.skniro_furniture.block.entity;

import com.skniro.skniro_furniture.init.FurnitureStrings;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.Generic3x3ContainerScreenHandler;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class WallCabinetBlockEntity extends AbstractFurnitureContainerBlockEntity {


    public WallCabinetBlockEntity(BlockPos pos, BlockState state) {
        super(FurnitureBlockEntityType.Wall_BLOCK_ENTITY, pos, state,9);
    }

    protected Text getContainerName() {
        return Text.translatable(FurnitureStrings.Wall_Cabinet);
    }

    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new Generic3x3ContainerScreenHandler(syncId, playerInventory, this);
    }
}
