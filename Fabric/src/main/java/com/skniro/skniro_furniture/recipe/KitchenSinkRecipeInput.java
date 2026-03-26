package com.skniro.skniro_furniture.recipe;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public class KitchenSinkRecipeInput implements RecipeInput {
    private final ItemStack input;

    public KitchenSinkRecipeInput(ItemStack input) {
        this.input = input;
    }

    @Override
    public ItemStack getItem(int slot) {
        return input;
    }

    @Override
    public int size() {
        return 1;
    }
}