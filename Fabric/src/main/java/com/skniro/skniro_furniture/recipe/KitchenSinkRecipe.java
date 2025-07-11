package com.skniro.skniro_furniture.recipe;


import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.*;
import net.minecraft.recipe.input.RecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.List;


public class KitchenSinkRecipe implements Recipe<KitchenSinkRecipeInput> {
    final ItemStack output;
    final List<Ingredient> recipeItems;

    public KitchenSinkRecipe(List<Ingredient> recipeItems, ItemStack output) {
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(KitchenSinkRecipeInput inventory, World world) {
        for (int i = 0; i < recipeItems.size(); i++) {
            if (!recipeItems.get(i).test(inventory.getStackInSlot(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack craft(KitchenSinkRecipeInput inventory, RegistryWrapper.WrapperLookup lookup) {
        return output;
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup lookup) {
        return output;
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.ofSize(1);
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
        public static final Serializer INSTANCE = new Serializer();
        public static final MapCodec<KitchenSinkRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.DISALLOW_EMPTY_CODEC.listOf().fieldOf("ingredient").forGetter((recipe) -> {
                    return recipe.recipeItems;
                }),
                ItemStack.CODEC.fieldOf("result").forGetter((recipe) -> {
                    return recipe.output;
                })
        ).apply(inst, KitchenSinkRecipe::new));


        public static final PacketCodec<RegistryByteBuf, KitchenSinkRecipe> PACKET_CODEC = PacketCodec.ofStatic(KitchenSinkRecipe.Serializer::write, KitchenSinkRecipe.Serializer::read);

        public Serializer() {
        }

        public MapCodec<KitchenSinkRecipe> codec() {
            return CODEC;
        }

        public PacketCodec<RegistryByteBuf, KitchenSinkRecipe> packetCodec() {
            return PACKET_CODEC;
        }

        private static KitchenSinkRecipe read(RegistryByteBuf buf) {
            int i = buf.readVarInt();
            DefaultedList<Ingredient> defaultedList = DefaultedList.ofSize(i, Ingredient.EMPTY);
            defaultedList.replaceAll((empty) -> {
                return (Ingredient)Ingredient.PACKET_CODEC.decode(buf);
            });
            ItemStack itemStack = (ItemStack)ItemStack.PACKET_CODEC.decode(buf);
            return new KitchenSinkRecipe(defaultedList, itemStack);
        }

        private static void write(RegistryByteBuf buf, KitchenSinkRecipe recipe) {
            buf.writeVarInt(recipe.recipeItems.size());
            Iterator var2 = recipe.recipeItems.iterator();

            while(var2.hasNext()) {
                Ingredient ingredient = (Ingredient)var2.next();
                Ingredient.PACKET_CODEC.encode(buf, ingredient);
            }

            ItemStack.PACKET_CODEC.encode(buf, recipe.output);
        }
    }
}








