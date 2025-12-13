package com.skniro.skniro_furniture.block.entity;

import com.skniro.skniro_furniture.block.init.FridgeBlock;
import com.skniro.skniro_furniture.init.FurnitureStrings;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class FridgeBlockEntity extends AbstractFurnitureContainerBlockEntity {

    public FridgeBlockEntity(BlockPos pos, BlockState state) {
        super(FurnitureBlockEntityType.Fridge_BLOCK_ENTITY, pos, state,54);
    }

    @Override
    protected Text getContainerName() {

        if(getCachedState().get(FridgeBlock.HALF) == DoubleBlockHalf.UPPER) {
            return Text.translatable(FurnitureStrings.Fridge_UPPER);
        }
        return Text.translatable(FurnitureStrings.Fridge_LOWER);
    }
    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return GenericContainerScreenHandler.createGeneric9x6(syncId, playerInventory, this);
    }
}
