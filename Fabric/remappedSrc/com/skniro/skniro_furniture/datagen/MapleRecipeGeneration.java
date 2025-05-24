package com.skniro.skniro_furniture.datagen;

import com.google.common.collect.Lists;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.Util;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MapleRecipeGeneration extends FabricRecipeProvider {
    public MapleRecipeGeneration(FabricDataOutput generator, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(generator, registryLookup);
    }


    public static final List<ItemLike> STRIPPED_MAPLE = Util.make(Lists.newArrayList(), list -> {
    });
    public static final List<ItemLike> Green_Tea = Util.make(Lists.newArrayList(), list -> {
    });

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider wrapperLookup, RecipeOutput exporter) {
        return new RecipeProvider(wrapperLookup, exporter) {
            @Override
            public void buildRecipes() {

                shapeless(RecipeCategory.FOOD,Items.SWEET_BERRIES).requires(Items.SWEET_BERRIES,3).requires(Items.POTION).unlockedBy("has_base_item", has(Items.SWEET_BERRIES)).save(output);

            }
        };
    }

    @Override
    public String getName() {
        return "";
    }
}