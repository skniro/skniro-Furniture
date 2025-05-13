package com.skniro.skniro_furniture.recipe;


import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public class KitchenSinkRecipe implements Recipe<KitchenSinkRecipeInput> {
    final ItemStack output;
    final Ingredient ingredient;
    @Nullable
    private IngredientPlacement ingredientPlacement;


    public KitchenSinkRecipe(Ingredient ingredients, ItemStack output) {
        this.output = output;
        this.ingredient = ingredients;
    }

    public Ingredient ingredient() {
        return this.ingredient;
    }

    public ItemStack output() {
        return this.output;
    }

    @Override
    public boolean matches(KitchenSinkRecipeInput input, World world) {
        if (world.isClient()) {
            return false;
        }
        return this.ingredient.test(input.getStackInSlot(1));
    }

    @Override
    public ItemStack craft(KitchenSinkRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output.copy();
    }

    @Override
    public RecipeSerializer<? extends Recipe<KitchenSinkRecipeInput>> getSerializer() {
        return FurnitureRecipeType.Kitchen_Sink_SERIALIZER;
    }

    @Override
    public RecipeType<? extends Recipe<KitchenSinkRecipeInput>> getType() {
        return FurnitureRecipeType.Kitchen_Sink_TYPE;
    }

    @Override
    public IngredientPlacement getIngredientPlacement() {
        if (this.ingredientPlacement == null) {
            this.ingredientPlacement = IngredientPlacement.forSingleSlot(this.ingredient);
        }

        return this.ingredientPlacement;
    }

    @Override
    public RecipeBookCategory getRecipeBookCategory() {
        return null;
    }

    public static class Serializer implements RecipeSerializer<KitchenSinkRecipe> {
        public static final MapCodec<KitchenSinkRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC.fieldOf("ingredient").forGetter((recipe) -> {
                    return recipe.ingredient;
                }),
                ItemStack.CODEC.fieldOf("result").forGetter((recipe) -> {
                    return recipe.output;
                })
        ).apply(inst, KitchenSinkRecipe::new));

        public static final PacketCodec<RegistryByteBuf, KitchenSinkRecipe> STREAM_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, KitchenSinkRecipe::ingredient,
                        ItemStack.PACKET_CODEC, KitchenSinkRecipe::output,
                        KitchenSinkRecipe::new);

        public Serializer() {
        }

        public MapCodec<KitchenSinkRecipe> codec() {
            return CODEC;
        }

        public PacketCodec<RegistryByteBuf, KitchenSinkRecipe> packetCodec() {
            return STREAM_CODEC;
        }
    }
}









