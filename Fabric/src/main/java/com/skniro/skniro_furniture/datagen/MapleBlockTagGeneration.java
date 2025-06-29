package com.skniro.skniro_furniture.datagen;

import com.skniro.skniro_furniture.block.MapleFurnitureBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

import static com.skniro.skniro_furniture.datagen.MapleBlockTagGeneration.ModBlockTags.*;
import static net.minecraft.registry.tag.BlockTags.*;


public class MapleBlockTagGeneration extends FabricTagProvider.BlockTagProvider {
    public MapleBlockTagGeneration(FabricDataOutput dataGenerator,CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(dataGenerator, completableFuture);
    }


    public static class ModBlockTags {
        public static final TagKey<Block> C_SAPLING = TagKey.of(RegistryKeys.BLOCK, Identifier.of("c", "saplings"));
        public static final TagKey<Block> C_MAPLE_LOGS = TagKey.of(RegistryKeys.BLOCK, Identifier.of("c", "maple_logs"));
        public static final TagKey<Block> C_CHERRY_LOGS = TagKey.of(RegistryKeys.BLOCK, Identifier.of("c", "cherry_logs"));
        public static final TagKey<Block> C_PLASTER = TagKey.of(RegistryKeys.BLOCK, Identifier.of("c", "plaster"));

    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        /*getOrCreateTagBuilder(SAPLINGS);
        getOrCreateTagBuilder(C_SAPLING);
        getOrCreateTagBuilder(C_MAPLE_LOGS);
        getOrCreateTagBuilder(C_CHERRY_LOGS);
        getOrCreateTagBuilder(FENCES);
        getOrCreateTagBuilder(C_PLASTER);
        getOrCreateTagBuilder(CEILING_HANGING_SIGNS);
        getOrCreateTagBuilder(WALL_HANGING_SIGNS);
        getOrCreateTagBuilder(ENCHANTMENT_POWER_PROVIDER)
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
                .add(MapleFurnitureBlocks.PALE_OAK_BOOKSHELF);*/
    }
}
