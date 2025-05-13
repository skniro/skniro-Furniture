package com.skniro.skniro_furniture.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.input.RecipeInput;

public class KitchenSinkRecipeInput implements RecipeInput {
    private final ItemStack input;

    public KitchenSinkRecipeInput(ItemStack input) {
        this.input = input;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return input;
    }

    @Override
    public int size() {
        return 1;
    }
}