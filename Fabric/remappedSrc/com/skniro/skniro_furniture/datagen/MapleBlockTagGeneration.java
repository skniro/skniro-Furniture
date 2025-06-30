package com.skniro.skniro_furniture.datagen;

import com.skniro.skniro_furniture.block.MapleFurnitureBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import java.util.concurrent.CompletableFuture;

import static com.skniro.skniro_furniture.datagen.MapleBlockTagGeneration.ModBlockTags.*;
import static net.minecraft.tags.BlockTags.*;


public class MapleBlockTagGeneration extends FabricTagProvider.BlockTagProvider {
    public MapleBlockTagGeneration(FabricDataOutput dataGenerator,CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(dataGenerator, completableFuture);
    }


    public static class ModBlockTags {
        public static final TagKey<Block> C_SAPLING = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", "saplings"));
        public static final TagKey<Block> C_MAPLE_LOGS = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", "maple_logs"));
        public static final TagKey<Block> C_CHERRY_LOGS = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", "cherry_logs"));
        public static final TagKey<Block> C_PLASTER = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", "plaster"));

    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        valueLookupBuilder(SAPLINGS);
        valueLookupBuilder(C_SAPLING);
        valueLookupBuilder(C_MAPLE_LOGS);
        valueLookupBuilder(C_CHERRY_LOGS);
        valueLookupBuilder(FENCES);
        valueLookupBuilder(C_PLASTER);
        valueLookupBuilder(CEILING_HANGING_SIGNS);
        valueLookupBuilder(WALL_HANGING_SIGNS);
        valueLookupBuilder(ENCHANTMENT_POWER_PROVIDER)
                .add(MapleFurnitureBlocks.SPRUCE_BOOKSHELF)
                .add(MapleFurnitureBlocks.BIRCH_BOOKSHELF)
                .add(MapleFurnitureBlocks.JUNGLE_BOOKSHELF)
                .add(MapleFurnitureBlocks.ACACIA_BOOKSHELF)
                .add(MapleFurnitureBlocks.DARK_OAK_BOOKSHELF)
                .add(MapleFurnitureBlocks.MANGROVE_BOOKSHELF)
                .add(MapleFurnitureBlocks.CHERRY_BOOKSHELF)
                .add(MapleFurnitureBlocks.BAMBOO_BOOKSHELF)
                .add(MapleFurnitureBlocks.CRIMSON_BOOKSHELF)
                .add(MapleFurnitureBlocks.WARPED_BOOKSHELF)
                .add(MapleFurnitureBlocks.PALE_OAK_BOOKSHELF);
    }
}
