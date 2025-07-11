package com.skniro.skniro_furniture.recipe;


import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
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
    public boolean matches(KitchenSinkRecipeInput inventory, Level world) {
        for (int i = 0; i < recipeItems.size(); i++) {
            if (!recipeItems.get(i).test(inventory.getItem(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack assemble(KitchenSinkRecipeInput inventory, HolderLookup.Provider lookup) {
        return output;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider lookup) {
        return output;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.createWithCapacity(1);
        list.addAll(recipeItems);
        return list;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return FurnitureRecipeType.Kitchen_Sink_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return FurnitureRecipeType.Kitchen_Sink_TYPE.get();
    }

    public static class Serializer implements RecipeSerializer<KitchenSinkRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final MapCodec<KitchenSinkRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC_NONEMPTY.listOf().fieldOf("ingredient").forGetter((recipe) -> {
                    return recipe.recipeItems;
                }),
                ItemStack.CODEC.fieldOf("result").forGetter((recipe) -> {
                    return recipe.output;
                })
        ).apply(inst, KitchenSinkRecipe::new));


        public static final StreamCodec<RegistryFriendlyByteBuf, KitchenSinkRecipe> PACKET_CODEC = StreamCodec.of(Serializer::write, Serializer::read);

        public Serializer() {
        }

        public MapCodec<KitchenSinkRecipe> codec() {
            return CODEC;
        }

        public StreamCodec<RegistryFriendlyByteBuf, KitchenSinkRecipe> streamCodec() {
            return PACKET_CODEC;
        }

        private static KitchenSinkRecipe read(RegistryFriendlyByteBuf buf) {
            int i = buf.readVarInt();
            NonNullList<Ingredient> defaultedList = NonNullList.withSize(i, Ingredient.EMPTY);
            defaultedList.replaceAll((empty) -> {
                return (Ingredient)Ingredient.CONTENTS_STREAM_CODEC.decode(buf);
            });
            ItemStack itemStack = (ItemStack)ItemStack.STREAM_CODEC.decode(buf);
            return new KitchenSinkRecipe(defaultedList, itemStack);
        }

        private static void write(RegistryFriendlyByteBuf buf, KitchenSinkRecipe recipe) {
            buf.writeVarInt(recipe.recipeItems.size());
            Iterator var2 = recipe.recipeItems.iterator();

            while(var2.hasNext()) {
                Ingredient ingredient = (Ingredient)var2.next();
                Ingredient.CONTENTS_STREAM_CODEC.encode(buf, ingredient);
            }

            ItemStack.STREAM_CODEC.encode(buf, recipe.output);
        }
    }
}








