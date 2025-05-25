package com.skniro.skniro_furniture.recipe;

import com.skniro.skniro_furniture.Furniture;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public interface FurnitureRecipeType<T extends Recipe<?>> {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, Furniture.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(BuiltInRegistries.RECIPE_TYPE, Furniture.MOD_ID);

    public static final Supplier<RecipeSerializer<KitchenSinkRecipe>> Kitchen_Sink_SERIALIZER = SERIALIZERS.register("kitchen_sink", KitchenSinkRecipe.Serializer::new);
    public static final Supplier<RecipeType<KitchenSinkRecipe>> Kitchen_Sink_TYPE = TYPES.register(
            "kitchen_sink", () ->new RecipeType<>() {
                @Override
                public String toString() {
                    return "kitchen_sink";
                }
            });

    public static void registerRecipes(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}

