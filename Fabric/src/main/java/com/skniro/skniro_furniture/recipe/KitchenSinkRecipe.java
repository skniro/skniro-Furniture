package com.skniro.skniro_furniture.recipe;


import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.world.World;

import java.util.List;


public class KitchenSinkRecipe implements Recipe<SimpleInventory> {
    final ItemStack output;
    final List<Ingredient> recipeItems;

    public KitchenSinkRecipe(List<Ingredient> recipeItems, ItemStack output) {
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        if (world.isClient()) {
            return false;
        }
        return recipeItems.get(0).test(inventory.getStack(0));
    }

    @Override
    public ItemStack craft(SimpleInventory inventory, DynamicRegistryManager registryManager) {
        return output;
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(DynamicRegistryManager registryManager) {
        return output;
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.ofSize(this.recipeItems.size());
        list.addAll(recipeItems);
        return list;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return FurnitureRecipeType.Kitchen_Sink_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return FurnitureRecipeType.Kitchen_Sink_TYPE;
    }

    public static class Serializer implements RecipeSerializer<KitchenSinkRecipe> {
        public static final Codec<KitchenSinkRecipe> CODEC = RecordCodecBuilder.create(in -> in.group(
                validateAmount(Ingredient.DISALLOW_EMPTY_CODEC, 9).fieldOf("ingredient").forGetter(KitchenSinkRecipe::getIngredients),
                ItemStack.RECIPE_RESULT_CODEC.fieldOf("result").forGetter(r -> r.output)
        ).apply(in, KitchenSinkRecipe::new));

        private static Codec<List<Ingredient>> validateAmount(Codec<Ingredient> delegate, int max) {
            return Codecs.validate(Codecs.validate(
                    delegate.listOf(), list -> list.size() > max ? DataResult.error(() -> "Recipe has too many ingredients!") : DataResult.success(list)
            ), list -> list.isEmpty() ? DataResult.error(() -> "Recipe has no ingredients!") : DataResult.success(list));
        }

        @Override
        public Codec<KitchenSinkRecipe> codec() {
            return CODEC;
        }

        @Override
        public KitchenSinkRecipe read(PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);

            for(int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromPacket(buf));
            }

            ItemStack output = buf.readItemStack();
            return new KitchenSinkRecipe(inputs, output);
        }

        @Override
        public void write(PacketByteBuf buf, KitchenSinkRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());

            for (Ingredient ingredient : recipe.getIngredients()) {
                ingredient.write(buf);
            }

            buf.writeItemStack(recipe.getResult(null));
        }
    }
}








