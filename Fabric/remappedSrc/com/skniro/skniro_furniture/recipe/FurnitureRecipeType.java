package com.skniro.skniro_furniture.recipe;

import com.skniro.skniro_furniture.Furniture;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

public interface FurnitureRecipeType<T extends Recipe<?>> {
    public static final RecipeSerializer<KitchenSinkRecipe> Kitchen_Sink_SERIALIZER = Registry.register(
            BuiltInRegistries.RECIPE_SERIALIZER, ResourceLocation.fromNamespaceAndPath(Furniture.MOD_ID, "kitchen_sink"), new KitchenSinkRecipe.Serializer());
    public static final RecipeType<KitchenSinkRecipe> Kitchen_Sink_TYPE = Registry.register(
            BuiltInRegistries.RECIPE_TYPE, ResourceLocation.fromNamespaceAndPath(Furniture.MOD_ID, "kitchen_sink"), new RecipeType<>() {
                @Override
                public String toString() {
                    return "kitchen_sink";
                }
            });

    public static void registerRecipes() {
        Furniture.LOGGER.info("Registering Custom Recipes for " + Furniture.MOD_ID);
    }
}

