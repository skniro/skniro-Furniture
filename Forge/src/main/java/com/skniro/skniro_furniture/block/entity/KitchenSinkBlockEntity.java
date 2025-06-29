package com.skniro.skniro_furniture.block.entity;

import com.skniro.skniro_furniture.block.api.entity.ImplementedInventory;
import com.skniro.skniro_furniture.init.FurnitureStrings;
import com.skniro.skniro_furniture.recipe.FurnitureRecipeType;
import com.skniro.skniro_furniture.recipe.KitchenSinkRecipe;
import com.skniro.skniro_furniture.recipe.KitchenSinkRecipeInput;
import com.skniro.skniro_furniture.screen.KitchenSinkBlockScreenHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class KitchenSinkBlockEntity extends BlockEntity implements MenuProvider, ImplementedInventory {
    private final NonNullList<ItemStack> inventory = NonNullList.withSize(4, ItemStack.EMPTY);
    private float rotation = 0;
    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;

    protected final ContainerData propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;
    private final int DEFAULT_MAX_PROGRESS = 72;

    public KitchenSinkBlockEntity(BlockPos pos, BlockState state) {
        super(FurnitureBlockEntityType.Kitchen_Sink_BLOCK_ENTITY.get(), pos, state);
        this.propertyDelegate = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> KitchenSinkBlockEntity.this.progress;
                    case 1 -> KitchenSinkBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0: KitchenSinkBlockEntity.this.progress = value;
                    case 1: KitchenSinkBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    public ItemStack getRenderStack() {
        if (this.getItem(INPUT_SLOT).isEmpty()){
            return this.getItem(OUTPUT_SLOT);
        } else {
            return this.getItem(INPUT_SLOT);
        }
    }

    @Override
    public void setChanged() {
        level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
        super.setChanged();
    }

    @Override
    public NonNullList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable(FurnitureStrings.Kitchen_Sink);
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int syncId, Inventory playerInventory, Player player) {
        return new KitchenSinkBlockScreenHandler(syncId, playerInventory, this, propertyDelegate);
    }

    @Override
    protected void saveAdditional(ValueOutput nbt) {
        super.saveAdditional(nbt);
        ContainerHelper.saveAllItems(nbt, inventory);
        nbt.putInt("kitchen_sink.progress", progress);
        nbt.putInt("kitchen_sink.max_progress", maxProgress);
    }

    @Override
    protected void loadAdditional(ValueInput nbt) {
        ContainerHelper.loadAllItems(nbt, inventory);
        progress = nbt.getInt("kitchen_sink.progress").orElse(0);
        maxProgress = nbt.getInt("kitchen_sink.max_progress").orElse(72);
        super.loadAdditional(nbt);
    }

    public void tick(Level world, BlockPos pos, BlockState state) {
        if(world.isClientSide()) {
            return;
        }
        if(hasRecipe() && canInsertIntoOutputSlot()) {
            increaseCraftingProgress();
            setChanged(world, pos, state);

            if(hasCraftingFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }


    private void resetProgress() {
        this.progress = 0;
        this.maxProgress = DEFAULT_MAX_PROGRESS;
    }

    private void craftItem() {
        Optional<RecipeHolder<KitchenSinkRecipe>> recipe = getCurrentRecipe();
        this.removeItem(INPUT_SLOT, 1);
        this.setItem(OUTPUT_SLOT, new ItemStack(recipe.get().value().output().getItem(),
                this.getItem(OUTPUT_SLOT).getCount() + recipe.get().value().output().getCount()));
    }

    @Override
    public int[] getSlotsForFace(Direction direction) {
        if (direction != Direction.DOWN) {
            return new int[]{INPUT_SLOT};
        } else {
            return new int[]{OUTPUT_SLOT};
        }
    }
    @Override
    public boolean canPlaceItem(int slot, ItemStack stack) {
        return slot != OUTPUT_SLOT;
    }

    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftingProgress() {
        this.progress++;
    }

    private boolean canInsertIntoOutputSlot() {
        return this.getItem(OUTPUT_SLOT).isEmpty() ||
                this.getItem(OUTPUT_SLOT).getCount() < this.getItem(OUTPUT_SLOT).getMaxStackSize();
    }

    private boolean hasRecipe() {
        Optional<RecipeHolder<KitchenSinkRecipe>> recipe = getCurrentRecipe();
        if(recipe.isEmpty()) {
            return false;
        }

        ItemStack output = recipe.get().value().output();
        return canInsertAmountIntoOutputSlot(output.getCount()) && canInsertItemIntoOutputSlot(output);
    }
    private Optional<RecipeHolder<KitchenSinkRecipe>> getCurrentRecipe() {
        return this.getLevel().getServer().getRecipeManager()
                .getRecipeFor(FurnitureRecipeType.Kitchen_Sink_TYPE.get(), new KitchenSinkRecipeInput(inventory.get(INPUT_SLOT)), this.getLevel());
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return this.getItem(OUTPUT_SLOT).isEmpty() || this.getItem(OUTPUT_SLOT).getItem() == output.getItem();
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
    int maxCount = this.getItem(OUTPUT_SLOT).isEmpty() ? 64 : this.getItem(OUTPUT_SLOT).getMaxStackSize();
    int currentCount = this.getItem(OUTPUT_SLOT).getCount();

        return maxCount >= currentCount + count;
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
