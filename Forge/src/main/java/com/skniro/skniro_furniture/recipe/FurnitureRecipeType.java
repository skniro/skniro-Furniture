package com.skniro.skniro_furniture.recipe;

import com.skniro.skniro_furniture.Furniture;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public interface FurnitureRecipeType<T extends Recipe<?>> {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Furniture.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, Furniture.MOD_ID);

    public static final Supplier<RecipeSerializer<KitchenSinkRecipe>> Kitchen_Sink_SERIALIZER = SERIALIZERS.register("kitchen_sink", KitchenSinkRecipe.Serializer::new);
    public static final Supplier<RecipeType<KitchenSinkRecipe>> Kitchen_Sink_TYPE = TYPES.register(
            "kitchen_sink", () ->new RecipeType<>() {
                @Override
                public String toString() {
                    return "kitchen_sink";
                }
            });

    public static void registerRecipes(BusGroup eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}

