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

    public FurnitureChestMenu(MenuType<?> type_, int syncId, Inventory inventory, Container container, int rows) {
        super(type_, syncId);
        checkContainerSize(container, rows * 9);
        this.container = container;
        this.containerRows = rows;
        container.startOpen(inventory.player);
        int i = (this.containerRows - 4) * 18;

        for(int j = 0; j < this.containerRows; ++j) {
            for(int k = 0; k < 9; ++k) {
                this.addSlot(new Slot(container, k + j * 9, 8 + k * 18, 18 + j * 18));
            }
        }

        for(int l = 0; l < 3; ++l) {
            for(int j1 = 0; j1 < 9; ++j1) {
                this.addSlot(new Slot(inventory, j1 + l * 9 + 9, 8 + j1 * 18, 103 + l * 18 + i));
            }
        }

        for(int i1 = 0; i1 < 9; ++i1) {
            this.addSlot(new Slot(inventory, i1, 8 + i1 * 18, 161 + i));
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