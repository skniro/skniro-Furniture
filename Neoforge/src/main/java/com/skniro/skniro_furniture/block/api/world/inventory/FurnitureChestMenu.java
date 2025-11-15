package com.skniro.skniro_furniture.block.api.world.inventory;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class FurnitureChestMenu extends AbstractContainerMenu {
    private final Container container;
    private final int containerRows;

    private FurnitureChestMenu(MenuType<?> type, int syncId, Inventory inventory, int rows) {
        this(type, syncId, inventory, new SimpleContainer(9 * rows), rows);
    }

    public static FurnitureChestMenu oneRow(int syncId, Inventory inventory) {
        return new FurnitureChestMenu(MenuType.GENERIC_9x1, syncId, inventory, 1);
    }

    public static FurnitureChestMenu twoRows(int syncId, Inventory inventory) {
        return new FurnitureChestMenu(MenuType.GENERIC_9x2, syncId, inventory, 2);
    }

    public static FurnitureChestMenu threeRows(int syncId, Inventory inventory) {
        return new FurnitureChestMenu(MenuType.GENERIC_9x3, syncId, inventory, 3);
    }

    public static FurnitureChestMenu fourRows(int syncId, Inventory inventory) {
        return new FurnitureChestMenu(MenuType.GENERIC_9x4, syncId, inventory, 4);
    }

    public static FurnitureChestMenu fiveRows(int syncId, Inventory inventory) {
        return new FurnitureChestMenu(MenuType.GENERIC_9x5, syncId, inventory, 5);
    }

    public static FurnitureChestMenu sixRows(int syncId, Inventory inventory) {
        return new FurnitureChestMenu(MenuType.GENERIC_9x6, syncId, inventory, 6);
    }
    public static FurnitureChestMenu oneRow(int syncId, Inventory inventory, Container container) {
        return new FurnitureChestMenu(MenuType.GENERIC_9x1, syncId, inventory, container, 1);
    }

    public static FurnitureChestMenu twoRows(int syncId, Inventory inventory, Container container) {
        return new FurnitureChestMenu(MenuType.GENERIC_9x2, syncId, inventory, container, 2);
    }

    public static FurnitureChestMenu threeRows(int syncId, Inventory inventory, Container container) {
        return new FurnitureChestMenu(MenuType.GENERIC_9x3, syncId, inventory, container, 3);
    }

    public static FurnitureChestMenu fourRows(int p_39259_, Inventory inventory, Container container) {
        return new FurnitureChestMenu(MenuType.GENERIC_9x4, p_39259_, inventory, container, 4);
    }

    public static FurnitureChestMenu fiveRows(int syncId, Inventory inventory, Container container) {
        return new FurnitureChestMenu(MenuType.GENERIC_9x5, syncId, inventory, container, 5);
    }

    public static FurnitureChestMenu sixRows(int syncId, Inventory inventory, Container container) {
        return new FurnitureChestMenu(MenuType.GENERIC_9x6, syncId, inventory, container, 6);
    }

    public FurnitureChestMenu(MenuType<?> type, int syncId, Inventory inventory, Container container, int rows) {
        super(type, syncId);
        checkContainerSize(container, rows * 9);
        this.container = container;
        this.containerRows = rows;
        container.startOpen(inventory.player);
        int $$5 = 18;
        this.addChestGrid(container, 8, 18);
        int $$6 = 18 + this.containerRows * 18 + 13;
        this.addStandardInventorySlots(inventory, 8, $$6);
    }

    private void addChestGrid(Container container, int left, int top) {
        for (int $$3 = 0; $$3 < this.containerRows; ++$$3) {
            for (int $$4 = 0; $$4 < 9; ++$$4) {
                this.addSlot(new Slot(container, $$4 + $$3 * 9, left + $$4 * 18, top + $$3 * 18));
            }
        }

    }

    public boolean stillValid(Player player) {
        return this.container.stillValid(player);
    }

    public ItemStack quickMoveStack(Player player, int slot) {
        ItemStack $$2 = ItemStack.EMPTY;
        Slot $$3 = (Slot) this.slots.get(slot);
        if ($$3 != null && $$3.hasItem()) {
            ItemStack $$4 = $$3.getItem();
            $$2 = $$4.copy();
            if (slot < this.containerRows * 9) {
                if (!this.moveItemStackTo($$4, this.containerRows * 9, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo($$4, 0, this.containerRows * 9, false)) {
                return ItemStack.EMPTY;
            }

            if ($$4.isEmpty()) {
                $$3.setByPlayer(ItemStack.EMPTY);
            } else {
                $$3.setChanged();
            }
        }

        return $$2;
    }

    public void removed(Player player) {
        super.removed(player);
        this.container.stopOpen(player);
    }

    public Container getContainer() {
        return this.container;
    }

    public int getRowCount() {
        return this.containerRows;
    }
}