package com.skniro.maple.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

import static com.skniro.maple.datagen.MapleBlockTagGeneration.ModBlockTags.*;
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
        getOrCreateTagBuilder(SAPLINGS);
        getOrCreateTagBuilder(C_SAPLING);
        getOrCreateTagBuilder(C_MAPLE_LOGS);
        getOrCreateTagBuilder(C_CHERRY_LOGS);
        getOrCreateTagBuilder(FENCES);
        getOrCreateTagBuilder(C_PLASTER);
        getOrCreateTagBuilder(CEILING_HANGING_SIGNS);
        getOrCreateTagBuilder(WALL_HANGING_SIGNS);
    }
}
