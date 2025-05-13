package com.skniro.skniro_furniture.recipe;

import com.skniro.skniro_furniture.Furniture;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public interface FurnitureRecipeType<T extends Recipe<?>> {
    public static final RecipeSerializer<KitchenSinkRecipe> Kitchen_Sink_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER, Identifier.of(Furniture.MOD_ID, "kitchen_sink"), new KitchenSinkRecipe.Serializer());
    public static final RecipeType<KitchenSinkRecipe> Kitchen_Sink_TYPE = Registry.register(
            Registries.RECIPE_TYPE, Identifier.of(Furniture.MOD_ID, "kitchen_sink"), new RecipeType<>() {
                @Override
                public String toString() {
                    return "kitchen_sink";
                }
            });

    public static void registerRecipes() {
        Furniture.LOGGER.info("Registering Custom Recipes for " + Furniture.MOD_ID);
    }
}

