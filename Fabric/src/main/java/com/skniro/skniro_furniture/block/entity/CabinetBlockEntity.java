package com.skniro.skniro_furniture.block.entity;

import com.skniro.skniro_furniture.init.FurnitureStrings;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.Generic3x3ContainerScreenHandler;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class CabinetBlockEntity extends AbstractFurnitureContainerBlockEntity {

    public CabinetBlockEntity(BlockPos pos, BlockState state) {
        super(FurnitureBlockEntityType.Cabinet_BLOCK_ENTITY, pos, state, 9);
    }

    @Override
    protected Text getContainerName() {
        return Text.translatable(FurnitureStrings.Cabinet);
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new Generic3x3ContainerScreenHandler(syncId, playerInventory, this);
    }
}