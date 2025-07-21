package com.skniro.skniro_furniture.block.entity;

import com.skniro.skniro_furniture.block.api.entity.ImplementedInventory;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class PlateBlockEntity extends BlockEntity implements ImplementedInventory {
    private final NonNullList<ItemStack> inventory = NonNullList.withSize(1, ItemStack.EMPTY);

    public PlateBlockEntity(BlockPos pos, BlockState state) {
        super(FurnitureBlockEntityType.Plate_BLOCK_ENTITY, pos, state);
    }

    @Override
    public NonNullList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        super.saveAdditional(nbt);
        ContainerHelper.saveAllItems(nbt, inventory);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        ContainerHelper.loadAllItems(nbt, inventory);
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }
}