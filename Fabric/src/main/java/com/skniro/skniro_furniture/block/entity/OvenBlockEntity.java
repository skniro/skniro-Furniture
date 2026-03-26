package com.skniro.skniro_furniture.block.entity;

import com.skniro.skniro_furniture.init.FurnitureStrings;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.SmokerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.FuelValues;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class OvenBlockEntity extends AbstractFurnaceBlockEntity {
    public OvenBlockEntity(BlockPos pos, BlockState state) {
        super(FurnitureBlockEntityType.OVEN_BLOCK_ENTITY, pos, state, RecipeType.SMOKING);
    }

    protected Component getDefaultName() {
        return Component.translatable(FurnitureStrings.Oven);
    }

    protected int getBurnDuration(FuelValues fuelRegistry, ItemStack stack) {
        return super.getBurnDuration(fuelRegistry, stack) / 2;
    }

    protected AbstractContainerMenu createMenu(int syncId, Inventory playerInventory) {
        return new SmokerMenu(syncId, playerInventory, this, this.dataAccess);
    }

    @Override
    public void setChanged() {
        level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
        super.setChanged();
    }

    public ItemStack getRenderStack() {
        if (this.getItem(SLOT_INPUT).isEmpty()){
            return this.getItem(SLOT_RESULT);
        } else {
            return this.getItem(SLOT_INPUT);
        }
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }


    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registryLookup) {
        return saveWithoutMetadata(registryLookup);
    }

}
