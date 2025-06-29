package com.skniro.skniro_furniture.block.entity;

import com.skniro.skniro_furniture.block.init.AbstractWallCabinetBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.LockableContainerBlockEntity;
import net.minecraft.block.entity.ViewerCountManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractFurnitureContainerBlockEntity extends LockableContainerBlockEntity {
    private final ViewerCountManager stateManager;
    private DefaultedList<ItemStack> inventory;

    protected AbstractFurnitureContainerBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, int size) {
        super(blockEntityType, blockPos, blockState);
        this.inventory = DefaultedList.ofSize(size, ItemStack.EMPTY);
        this.stateManager = new ViewerCountManager() {
            protected void onContainerOpen(World world, BlockPos pos, BlockState state) {
                AbstractFurnitureContainerBlockEntity.this.playSound(state, SoundEvents.BLOCK_BARREL_OPEN);
            }

            protected void onContainerClose(World world, BlockPos pos, BlockState state) {
                AbstractFurnitureContainerBlockEntity.this.playSound(state, SoundEvents.BLOCK_BARREL_CLOSE);
            }

            protected void onViewerCountUpdate(World world, BlockPos pos, BlockState state, int oldViewerCount, int newViewerCount) {
            }

            protected boolean isPlayerViewing(PlayerEntity player) {
                if (player.currentScreenHandler instanceof GenericContainerScreenHandler) {
                    Inventory inventory = ((GenericContainerScreenHandler) player.currentScreenHandler).getInventory();
                    return inventory == AbstractFurnitureContainerBlockEntity.this;
                } else {
                    return false;
                }
            }
        };
    }

    void playSound(BlockState state, SoundEvent soundEvent) {
        Vec3i vec3i = ((Direction) state.get(AbstractWallCabinetBlock.FACING)).getVector();
        double d = (double) this.pos.getX() + 0.5 + (double) vec3i.getX() / 2.0;
        double e = (double) this.pos.getY() + 0.5 + (double) vec3i.getY() / 2.0;
        double f = (double) this.pos.getZ() + 0.5 + (double) vec3i.getZ() / 2.0;
        this.world.playSound((PlayerEntity) null, d, e, f, soundEvent, SoundCategory.BLOCKS, 0.5F, this.world.random.nextFloat() * 0.1F + 0.9F);
    }

    protected void writeData(WriteView nbt) {
        super.writeData(nbt);
        Inventories.writeData(nbt, this.inventory);
    }

    protected void readData(ReadView nbt) {
        super.readData(nbt);
        this.inventory = DefaultedList.ofSize(this.size(), ItemStack.EMPTY);
        Inventories.readData(nbt, this.inventory);

    }

    public int size() {
        return inventory.size();
    }

    @Override
    public ItemStack getStack(int slot) {
        return inventory.get(slot);
    }


    protected DefaultedList<ItemStack> getHeldStacks() {
        return this.inventory;
    }

    protected void setHeldStacks(DefaultedList<ItemStack> inventory) {
        this.inventory = inventory;
    }

    @Override
    protected Text getContainerName() {
        return null;
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return null;
    }

    public void onOpen(PlayerEntity player) {
        if (!this.removed && !player.isSpectator()) {
            this.stateManager.openContainer(player, this.getWorld(), this.getPos(), this.getCachedState());
        }

    }

    public void onClose(PlayerEntity player) {
        if (!this.removed && !player.isSpectator()) {
            this.stateManager.closeContainer(player, this.getWorld(), this.getPos(), this.getCachedState());
        }

    }

    public void tick() {
        if (!this.removed) {
            this.stateManager.updateViewerCount(this.getWorld(), this.getPos(), this.getCachedState());
        }

    }

    @Override
    public void markDirty() {
        world.updateListeners(pos, getCachedState(), getCachedState(), 3);
        super.markDirty();
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }


    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }
}
