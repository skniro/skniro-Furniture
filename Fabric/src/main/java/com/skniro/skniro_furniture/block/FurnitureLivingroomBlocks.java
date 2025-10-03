package com.skniro.skniro_furniture.block;

import com.skniro.skniro_furniture.Furniture;
import com.skniro.skniro_furniture.block.init.TVBlock;
import com.skniro.skniro_furniture.block.init.TvStandBlock;
import com.skniro.skniro_furniture.block.init.SofaBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

import static net.minecraft.block.Blocks.createLightLevelFromLitBlockState;

public class FurnitureLivingroomBlocks {
    //Sofa Blocks
    public static final Block Sofa_WHITE = registerBlock("white_sofa", new SofaBlock(AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).nonOpaque()));
    public static final Block Sofa_ORANGE = registerBlock("orange_sofa", new SofaBlock(AbstractBlock.Settings.copy(Blocks.ORANGE_WOOL).nonOpaque()));
    public static final Block Sofa_MAGENTA = registerBlock("magenta_sofa", new SofaBlock(AbstractBlock.Settings.copy(Blocks.MAGENTA_WOOL).nonOpaque()));
    public static final Block Sofa_LIGHT_BLUE = registerBlock("light_blue_sofa", new SofaBlock(AbstractBlock.Settings.copy(Blocks.LIGHT_BLUE_WOOL).nonOpaque()));
    public static final Block Sofa_YELLOW = registerBlock("yellow_sofa", new SofaBlock(AbstractBlock.Settings.copy(Blocks.YELLOW_WOOL).nonOpaque()));
    public static final Block Sofa_LIME = registerBlock("lime_sofa", new SofaBlock(AbstractBlock.Settings.copy(Blocks.LIME_WOOL).nonOpaque()));
    public static final Block Sofa_PINK = registerBlock("pink_sofa", new SofaBlock(AbstractBlock.Settings.copy(Blocks.PINK_WOOL).nonOpaque()));
    public static final Block Sofa_GRAY = registerBlock("gray_sofa", new SofaBlock(AbstractBlock.Settings.copy(Blocks.GRAY_WOOL).nonOpaque()));
    public static final Block Sofa_LIGHT_GRAY = registerBlock("light_gray_sofa", new SofaBlock(AbstractBlock.Settings.copy(Blocks.LIGHT_GRAY_WOOL).nonOpaque()));
    public static final Block Sofa_CYAN = registerBlock("cyan_sofa", new SofaBlock(AbstractBlock.Settings.copy(Blocks.CYAN_WOOL).nonOpaque()));
    public static final Block Sofa_PURPLE = registerBlock("purple_sofa", new SofaBlock(AbstractBlock.Settings.copy(Blocks.PURPLE_WOOL).nonOpaque()));
    public static final Block Sofa_BLUE = registerBlock("blue_sofa", new SofaBlock(AbstractBlock.Settings.copy(Blocks.BLUE_WOOL).nonOpaque()));
    public static final Block Sofa_BROWN = registerBlock("brown_sofa", new SofaBlock(AbstractBlock.Settings.copy(Blocks.BROWN_WOOL).nonOpaque()));
    public static final Block Sofa_GREEN = registerBlock("green_sofa", new SofaBlock(AbstractBlock.Settings.copy(Blocks.GREEN_WOOL).nonOpaque()));
    public static final Block Sofa_RED = registerBlock("red_sofa", new SofaBlock(AbstractBlock.Settings.copy(Blocks.RED_WOOL).nonOpaque()));
    public static final Block Sofa_BLACK = registerBlock("black_sofa", new SofaBlock(AbstractBlock.Settings.copy(Blocks.BLACK_WOOL).nonOpaque()));

    public static final Block OAK_PLANKS_TV_STAND = registerBlock("oak_planks_tv_stand", new TvStandBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()));
    public static final Block OAK_WOOD_TV_STAND = registerBlock("oak_wood_tv_stand", new TvStandBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()));
    public static final Block SPRUCE_PLANKS_TV_STAND = registerBlock("spruce_planks_tv_stand", new TvStandBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque()));
    public static final Block SPRUCE_WOOD_TV_STAND = registerBlock("spruce_wood_tv_stand", new TvStandBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque()));
    public static final Block BIRCH_PLANKS_TV_STAND = registerBlock("birch_planks_tv_stand", new TvStandBlock(AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque()));
    public static final Block BIRCH_WOOD_TV_STAND = registerBlock("birch_wood_tv_stand", new TvStandBlock(AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque()));
    public static final Block JUNGLE_PLANKS_TV_STAND = registerBlock("jungle_planks_tv_stand", new TvStandBlock(AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque()));
    public static final Block JUNGLE_WOOD_TV_STAND = registerBlock("jungle_wood_tv_stand", new TvStandBlock(AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque()));
    public static final Block ACACIA_PLANKS_TV_STAND = registerBlock("acacia_planks_tv_stand", new TvStandBlock(AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque()));
    public static final Block ACACIA_WOOD_TV_STAND = registerBlock("acacia_wood_tv_stand", new TvStandBlock(AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque()));
    public static final Block DARK_OAK_PLANKS_TV_STAND = registerBlock("dark_oak_planks_tv_stand", new TvStandBlock(AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque()));
    public static final Block DARK_OAK_WOOD_TV_STAND = registerBlock("dark_oak_wood_tv_stand", new TvStandBlock(AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque()));
    public static final Block MANGROVE_PLANKS_TV_STAND = registerBlock("mangrove_planks_tv_stand", new TvStandBlock(AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque()));
    public static final Block MANGROVE_WOOD_TV_STAND = registerBlock("mangrove_wood_tv_stand", new TvStandBlock(AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque()));
    public static final Block CHERRY_PLANKS_TV_STAND = registerBlock("cherry_planks_tv_stand", new TvStandBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque()));
    public static final Block CHERRY_WOOD_TV_STAND = registerBlock("cherry_wood_tv_stand", new TvStandBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque()));
    public static final Block CRIMSON_PLANKS_TV_STAND = registerBlock("crimson_planks_tv_stand", new TvStandBlock(AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque()));
    public static final Block CRIMSON_HYPHAE_TV_STAND = registerBlock("crimson_wood_tv_stand", new TvStandBlock(AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque()));
    public static final Block WARPED_PLANKS_TV_STAND = registerBlock("warped_planks_tv_stand", new TvStandBlock(AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque()));
    public static final Block WARPED_HYPHAE_TV_STAND = registerBlock("warped_wood_tv_stand", new TvStandBlock(AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque()));
    public static final Block BAMBOO_PLANKS_TV_STAND = registerBlock("bamboo_planks_tv_stand", new TvStandBlock(AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque()));
    public static final Block BAMBOO_BLOCK_TV_STAND = registerBlock("bamboo_wood_tv_stand", new TvStandBlock(AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque()));

    public static final Block OAK_PLANKS_TV = registerBlock("oak_planks_tv", new TVBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()));
    public static final Block OAK_WOOD_TV = registerBlock("oak_wood_tv", new TVBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()));
    public static final Block SPRUCE_PLANKS_TV = registerBlock("spruce_planks_tv", new TVBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()));
    public static final Block SPRUCE_WOOD_TV = registerBlock("spruce_wood_tv", new TVBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()));
    public static final Block BIRCH_PLANKS_TV = registerBlock("birch_planks_tv", new TVBlock(AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()));
    public static final Block BIRCH_WOOD_TV = registerBlock("birch_wood_tv", new TVBlock(AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()));
    public static final Block JUNGLE_PLANKS_TV = registerBlock("jungle_planks_tv", new TVBlock(AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()));
    public static final Block JUNGLE_WOOD_TV = registerBlock("jungle_wood_tv", new TVBlock(AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()));
    public static final Block ACACIA_PLANKS_TV = registerBlock("acacia_planks_tv", new TVBlock(AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()));
    public static final Block ACACIA_WOOD_TV = registerBlock("acacia_wood_tv", new TVBlock(AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()));
    public static final Block DARK_OAK_PLANKS_TV = registerBlock("dark_oak_planks_tv", new TVBlock(AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()));
    public static final Block DARK_OAK_WOOD_TV = registerBlock("dark_oak_wood_tv", new TVBlock(AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()));
    public static final Block MANGROVE_PLANKS_TV = registerBlock("mangrove_planks_tv", new TVBlock(AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()));
    public static final Block MANGROVE_WOOD_TV = registerBlock("mangrove_wood_tv", new TVBlock(AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()));
    public static final Block CHERRY_PLANKS_TV = registerBlock("cherry_planks_tv", new TVBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()));
    public static final Block CHERRY_WOOD_TV = registerBlock("cherry_wood_tv", new TVBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()));
    public static final Block CRIMSON_PLANKS_TV = registerBlock("crimson_planks_tv", new TVBlock(AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()));
    public static final Block CRIMSON_HYPHAE_TV = registerBlock("crimson_wood_tv", new TVBlock(AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()));
    public static final Block WARPED_PLANKS_TV = registerBlock("warped_planks_tv", new TVBlock(AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()));
    public static final Block WARPED_HYPHAE_TV = registerBlock("warped_wood_tv", new TVBlock(AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()));
    public static final Block BAMBOO_PLANKS_TV = registerBlock("bamboo_planks_tv", new TVBlock(AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()));
    public static final Block BAMBOO_BLOCK_TV = registerBlock("bamboo_wood_tv", new TVBlock(AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()));

    public static final Block TV_WHITE = registerBlock("white_tv", new TVBlock(AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()));
    public static final Block TV_ORANGE = registerBlock("orange_tv", new TVBlock(AbstractBlock.Settings.copy(Blocks.ORANGE_WOOL).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()));
    public static final Block TV_MAGENTA = registerBlock("magenta_tv", new TVBlock(AbstractBlock.Settings.copy(Blocks.MAGENTA_WOOL).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()));
    public static final Block TV_LIGHT_BLUE = registerBlock("light_blue_tv", new TVBlock(AbstractBlock.Settings.copy(Blocks.LIGHT_BLUE_WOOL).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()));
    public static final Block TV_YELLOW = registerBlock("yellow_tv", new TVBlock(AbstractBlock.Settings.copy(Blocks.YELLOW_WOOL).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()));
    public static final Block TV_LIME = registerBlock("lime_tv", new TVBlock(AbstractBlock.Settings.copy(Blocks.LIME_WOOL).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()));
    public static final Block TV_PINK = registerBlock("pink_tv", new TVBlock(AbstractBlock.Settings.copy(Blocks.PINK_WOOL).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()));
    public static final Block TV_GRAY = registerBlock("gray_tv", new TVBlock(AbstractBlock.Settings.copy(Blocks.GRAY_WOOL).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()));
    public static final Block TV_LIGHT_GRAY = registerBlock("light_gray_tv", new TVBlock(AbstractBlock.Settings.copy(Blocks.LIGHT_GRAY_WOOL).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()));
    public static final Block TV_CYAN = registerBlock("cyan_tv", new TVBlock(AbstractBlock.Settings.copy(Blocks.CYAN_WOOL).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()));
    public static final Block TV_PURPLE = registerBlock("purple_tv", new TVBlock(AbstractBlock.Settings.copy(Blocks.PURPLE_WOOL).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()));
    public static final Block TV_BLUE = registerBlock("blue_tv", new TVBlock(AbstractBlock.Settings.copy(Blocks.BLUE_WOOL).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()));
    public static final Block TV_BROWN = registerBlock("brown_tv", new TVBlock(AbstractBlock.Settings.copy(Blocks.BROWN_WOOL).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()));
    public static final Block TV_GREEN = registerBlock("green_tv", new TVBlock(AbstractBlock.Settings.copy(Blocks.GREEN_WOOL).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()));
    public static final Block TV_RED = registerBlock("red_tv", new TVBlock(AbstractBlock.Settings.copy(Blocks.RED_WOOL).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()));
    public static final Block TV_BLACK = registerBlock("black_tv", new TVBlock(AbstractBlock.Settings.copy(Blocks.BLACK_WOOL).luminance(createLightLevelFromLitBlockState(15)).nonOpaque()));


    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(Furniture.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Furniture.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(Furniture.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerLivingroomBlocks() {
        Furniture.LOGGER.debug("Registering Livingroom Blocks for " + Furniture.MOD_ID);
    }
}
