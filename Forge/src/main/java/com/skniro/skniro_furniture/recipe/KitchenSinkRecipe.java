package com.skniro.skniro_furniture.recipe;


import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.PlacementInfo;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;


public class KitchenSinkRecipe implements Recipe<KitchenSinkRecipeInput> {
    final ItemStack output;
    final Ingredient ingredient;
    @Nullable
    private PlacementInfo ingredientPlacement;


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
    public boolean matches(KitchenSinkRecipeInput input, Level world) {
        if (world.isClientSide()) {
            return false;
        }
        return this.ingredient.test(input.getItem(1));
    }

    @Override
    public ItemStack assemble(KitchenSinkRecipeInput input, HolderLookup.Provider lookup) {
        return output.copy();
    }

    @Override
    public RecipeSerializer<? extends Recipe<KitchenSinkRecipeInput>> getSerializer() {
        return FurnitureRecipeType.Kitchen_Sink_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends Recipe<KitchenSinkRecipeInput>> getType() {
        return FurnitureRecipeType.Kitchen_Sink_TYPE.get();
    }

    @Override
    public PlacementInfo placementInfo() {
        if (this.ingredientPlacement == null) {
            this.ingredientPlacement = PlacementInfo.create(this.ingredient);
        }

        return this.ingredientPlacement;
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
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

        public static final StreamCodec<RegistryFriendlyByteBuf, KitchenSinkRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, KitchenSinkRecipe::ingredient,
                        ItemStack.STREAM_CODEC, KitchenSinkRecipe::output,
                        KitchenSinkRecipe::new);

        public Serializer() {
        }

        public MapCodec<KitchenSinkRecipe> codec() {
            return CODEC;
        }

        public StreamCodec<RegistryFriendlyByteBuf, KitchenSinkRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}









