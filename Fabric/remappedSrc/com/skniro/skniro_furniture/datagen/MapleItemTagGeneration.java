package com.skniro.skniro_furniture.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.registry.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import java.util.concurrent.CompletableFuture;


public class MapleItemTagGeneration extends FabricTagProvider<Item> {
    public MapleItemTagGeneration(FabricDataOutput dataGenerator, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(dataGenerator, Registries.ITEM, completableFuture);
    }

    public static class ModItemTags {
        public static final TagKey<Item> C_SAPLING = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "saplings"));
        public static final TagKey<Item> C_MAPLE_LOGS = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "maple_logs"));
        public static final TagKey<Item> C_CHERRY_LOGS = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "cherry_logs"));
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {

    }


}
