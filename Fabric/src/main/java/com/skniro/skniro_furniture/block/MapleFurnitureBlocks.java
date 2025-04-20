package com.skniro.skniro_furniture.block;

import com.skniro.skniro_furniture.Furniture;
import com.skniro.skniro_furniture.block.init.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class MapleFurnitureBlocks {

    // OAK Cushion Blocks
    public static final Block CUSHION_OAK_WHITE = registerBlock("oak_white_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    public static final Block CUSHION_OAK_ORANGE = registerBlock("oak_orange_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    public static final Block CUSHION_OAK_MAGENTA = registerBlock("oak_magenta_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    public static final Block CUSHION_OAK_LIGHT_BLUE = registerBlock("oak_light_blue_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    public static final Block CUSHION_OAK_YELLOW = registerBlock("oak_yellow_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    public static final Block CUSHION_OAK_LIME = registerBlock("oak_lime_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    public static final Block CUSHION_OAK_PINK = registerBlock("oak_pink_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    public static final Block CUSHION_OAK_GRAY = registerBlock("oak_gray_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    public static final Block CUSHION_OAK_LIGHT_GRAY = registerBlock("oak_light_gray_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    public static final Block CUSHION_OAK_CYAN = registerBlock("oak_cyan_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    public static final Block CUSHION_OAK_PURPLE = registerBlock("oak_purple_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    public static final Block CUSHION_OAK_BLUE = registerBlock("oak_blue_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    public static final Block CUSHION_OAK_BROWN = registerBlock("oak_brown_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    public static final Block CUSHION_OAK_GREEN = registerBlock("oak_green_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    public static final Block CUSHION_OAK_RED = registerBlock("oak_red_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    public static final Block CUSHION_OAK_BLACK = registerBlock("oak_black_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));


    // SPRUCE Cushion Blocks
    public static final Block CUSHION_SPRUCE_WHITE = registerBlock("spruce_white_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS)));
    public static final Block CUSHION_SPRUCE_ORANGE = registerBlock("spruce_orange_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS)));
    public static final Block CUSHION_SPRUCE_MAGENTA = registerBlock("spruce_magenta_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS)));
    public static final Block CUSHION_SPRUCE_LIGHT_BLUE = registerBlock("spruce_light_blue_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS)));
    public static final Block CUSHION_SPRUCE_YELLOW = registerBlock("spruce_yellow_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS)));
    public static final Block CUSHION_SPRUCE_LIME = registerBlock("spruce_lime_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS)));
    public static final Block CUSHION_SPRUCE_PINK = registerBlock("spruce_pink_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS)));
    public static final Block CUSHION_SPRUCE_GRAY = registerBlock("spruce_gray_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS)));
    public static final Block CUSHION_SPRUCE_LIGHT_GRAY = registerBlock("spruce_light_gray_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS)));
    public static final Block CUSHION_SPRUCE_CYAN = registerBlock("spruce_cyan_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS)));
    public static final Block CUSHION_SPRUCE_PURPLE = registerBlock("spruce_purple_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS)));
    public static final Block CUSHION_SPRUCE_BLUE = registerBlock("spruce_blue_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS)));
    public static final Block CUSHION_SPRUCE_BROWN = registerBlock("spruce_brown_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS)));
    public static final Block CUSHION_SPRUCE_GREEN = registerBlock("spruce_green_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS)));
    public static final Block CUSHION_SPRUCE_RED = registerBlock("spruce_red_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS)));
    public static final Block CUSHION_SPRUCE_BLACK = registerBlock("spruce_black_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS)));

    // BIRCH Cushion Blocks
    public static final Block CUSHION_BIRCH_WHITE = registerBlock("birch_white_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS)));
    public static final Block CUSHION_BIRCH_ORANGE = registerBlock("birch_orange_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS)));
    public static final Block CUSHION_BIRCH_MAGENTA = registerBlock("birch_magenta_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS)));
    public static final Block CUSHION_BIRCH_LIGHT_BLUE = registerBlock("birch_light_blue_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS)));
    public static final Block CUSHION_BIRCH_YELLOW = registerBlock("birch_yellow_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS)));
    public static final Block CUSHION_BIRCH_LIME = registerBlock("birch_lime_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS)));
    public static final Block CUSHION_BIRCH_PINK = registerBlock("birch_pink_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS)));
    public static final Block CUSHION_BIRCH_GRAY = registerBlock("birch_gray_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS)));
    public static final Block CUSHION_BIRCH_LIGHT_GRAY = registerBlock("birch_light_gray_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS)));
    public static final Block CUSHION_BIRCH_CYAN = registerBlock("birch_cyan_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS)));
    public static final Block CUSHION_BIRCH_PURPLE = registerBlock("birch_purple_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS)));
    public static final Block CUSHION_BIRCH_BLUE = registerBlock("birch_blue_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS)));
    public static final Block CUSHION_BIRCH_BROWN = registerBlock("birch_brown_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS)));
    public static final Block CUSHION_BIRCH_GREEN = registerBlock("birch_green_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS)));
    public static final Block CUSHION_BIRCH_RED = registerBlock("birch_red_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS)));
    public static final Block CUSHION_BIRCH_BLACK = registerBlock("birch_black_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS)));

    // JUNGLE Cushion Blocks
    public static final Block CUSHION_JUNGLE_WHITE = registerBlock("jungle_white_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS)));
    public static final Block CUSHION_JUNGLE_ORANGE = registerBlock("jungle_orange_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS)));
    public static final Block CUSHION_JUNGLE_MAGENTA = registerBlock("jungle_magenta_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS)));
    public static final Block CUSHION_JUNGLE_LIGHT_BLUE = registerBlock("jungle_light_blue_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS)));
    public static final Block CUSHION_JUNGLE_YELLOW = registerBlock("jungle_yellow_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS)));
    public static final Block CUSHION_JUNGLE_LIME = registerBlock("jungle_lime_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS)));
    public static final Block CUSHION_JUNGLE_PINK = registerBlock("jungle_pink_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS)));
    public static final Block CUSHION_JUNGLE_GRAY = registerBlock("jungle_gray_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS)));
    public static final Block CUSHION_JUNGLE_LIGHT_GRAY = registerBlock("jungle_light_gray_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS)));
    public static final Block CUSHION_JUNGLE_CYAN = registerBlock("jungle_cyan_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS)));
    public static final Block CUSHION_JUNGLE_PURPLE = registerBlock("jungle_purple_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS)));
    public static final Block CUSHION_JUNGLE_BLUE = registerBlock("jungle_blue_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS)));
    public static final Block CUSHION_JUNGLE_BROWN = registerBlock("jungle_brown_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS)));
    public static final Block CUSHION_JUNGLE_GREEN = registerBlock("jungle_green_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS)));
    public static final Block CUSHION_JUNGLE_RED = registerBlock("jungle_red_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS)));
    public static final Block CUSHION_JUNGLE_BLACK = registerBlock("jungle_black_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS)));

    // ACACIA Cushion Blocks
    public static final Block CUSHION_ACACIA_WHITE = registerBlock("acacia_white_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS)));
    public static final Block CUSHION_ACACIA_ORANGE = registerBlock("acacia_orange_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS)));
    public static final Block CUSHION_ACACIA_MAGENTA = registerBlock("acacia_magenta_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS)));
    public static final Block CUSHION_ACACIA_LIGHT_BLUE = registerBlock("acacia_light_blue_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS)));
    public static final Block CUSHION_ACACIA_YELLOW = registerBlock("acacia_yellow_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS)));
    public static final Block CUSHION_ACACIA_LIME = registerBlock("acacia_lime_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS)));
    public static final Block CUSHION_ACACIA_PINK = registerBlock("acacia_pink_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS)));
    public static final Block CUSHION_ACACIA_GRAY = registerBlock("acacia_gray_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS)));
    public static final Block CUSHION_ACACIA_LIGHT_GRAY = registerBlock("acacia_light_gray_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS)));
    public static final Block CUSHION_ACACIA_CYAN = registerBlock("acacia_cyan_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS)));
    public static final Block CUSHION_ACACIA_PURPLE = registerBlock("acacia_purple_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS)));
    public static final Block CUSHION_ACACIA_BLUE = registerBlock("acacia_blue_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS)));
    public static final Block CUSHION_ACACIA_BROWN = registerBlock("acacia_brown_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS)));
    public static final Block CUSHION_ACACIA_GREEN = registerBlock("acacia_green_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS)));
    public static final Block CUSHION_ACACIA_RED = registerBlock("acacia_red_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS)));
    public static final Block CUSHION_ACACIA_BLACK = registerBlock("acacia_black_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS)));

    // DARK OAK Cushion Blocks
    public static final Block CUSHION_DARK_OAK_WHITE = registerBlock("dark_oak_white_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Block CUSHION_DARK_OAK_ORANGE = registerBlock("dark_oak_orange_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Block CUSHION_DARK_OAK_MAGENTA = registerBlock("dark_oak_magenta_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Block CUSHION_DARK_OAK_LIGHT_BLUE = registerBlock("dark_oak_light_blue_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Block CUSHION_DARK_OAK_YELLOW = registerBlock("dark_oak_yellow_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Block CUSHION_DARK_OAK_LIME = registerBlock("dark_oak_lime_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Block CUSHION_DARK_OAK_PINK = registerBlock("dark_oak_pink_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Block CUSHION_DARK_OAK_GRAY = registerBlock("dark_oak_gray_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Block CUSHION_DARK_OAK_LIGHT_GRAY = registerBlock("dark_oak_light_gray_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Block CUSHION_DARK_OAK_CYAN = registerBlock("dark_oak_cyan_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Block CUSHION_DARK_OAK_PURPLE = registerBlock("dark_oak_purple_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Block CUSHION_DARK_OAK_BLUE = registerBlock("dark_oak_blue_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Block CUSHION_DARK_OAK_BROWN = registerBlock("dark_oak_brown_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Block CUSHION_DARK_OAK_GREEN = registerBlock("dark_oak_green_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Block CUSHION_DARK_OAK_RED = registerBlock("dark_oak_red_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS)));
    public static final Block CUSHION_DARK_OAK_BLACK = registerBlock("dark_oak_black_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS)));


    // CRIMSON Cushion Blocks
    public static final Block CUSHION_CRIMSON_WHITE = registerBlock("crimson_white_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS)));
    public static final Block CUSHION_CRIMSON_ORANGE = registerBlock("crimson_orange_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS)));
    public static final Block CUSHION_CRIMSON_MAGENTA = registerBlock("crimson_magenta_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS)));
    public static final Block CUSHION_CRIMSON_LIGHT_BLUE = registerBlock("crimson_light_blue_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS)));
    public static final Block CUSHION_CRIMSON_YELLOW = registerBlock("crimson_yellow_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS)));
    public static final Block CUSHION_CRIMSON_LIME = registerBlock("crimson_lime_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS)));
    public static final Block CUSHION_CRIMSON_PINK = registerBlock("crimson_pink_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS)));
    public static final Block CUSHION_CRIMSON_GRAY = registerBlock("crimson_gray_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS)));
    public static final Block CUSHION_CRIMSON_LIGHT_GRAY = registerBlock("crimson_light_gray_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS)));
    public static final Block CUSHION_CRIMSON_CYAN = registerBlock("crimson_cyan_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS)));
    public static final Block CUSHION_CRIMSON_PURPLE = registerBlock("crimson_purple_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS)));
    public static final Block CUSHION_CRIMSON_BLUE = registerBlock("crimson_blue_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS)));
    public static final Block CUSHION_CRIMSON_BROWN = registerBlock("crimson_brown_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS)));
    public static final Block CUSHION_CRIMSON_GREEN = registerBlock("crimson_green_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS)));
    public static final Block CUSHION_CRIMSON_RED = registerBlock("crimson_red_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS)));
    public static final Block CUSHION_CRIMSON_BLACK = registerBlock("crimson_black_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS)));

    // WARPED Cushion Blocks
    public static final Block CUSHION_WARPED_WHITE = registerBlock("warped_white_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS)));
    public static final Block CUSHION_WARPED_ORANGE = registerBlock("warped_orange_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS)));
    public static final Block CUSHION_WARPED_MAGENTA = registerBlock("warped_magenta_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS)));
    public static final Block CUSHION_WARPED_LIGHT_BLUE = registerBlock("warped_light_blue_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS)));
    public static final Block CUSHION_WARPED_YELLOW = registerBlock("warped_yellow_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS)));
    public static final Block CUSHION_WARPED_LIME = registerBlock("warped_lime_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS)));
    public static final Block CUSHION_WARPED_PINK = registerBlock("warped_pink_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS)));
    public static final Block CUSHION_WARPED_GRAY = registerBlock("warped_gray_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS)));
    public static final Block CUSHION_WARPED_LIGHT_GRAY = registerBlock("warped_light_gray_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS)));
    public static final Block CUSHION_WARPED_CYAN = registerBlock("warped_cyan_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS)));
    public static final Block CUSHION_WARPED_PURPLE = registerBlock("warped_purple_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS)));
    public static final Block CUSHION_WARPED_BLUE = registerBlock("warped_blue_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS)));
    public static final Block CUSHION_WARPED_BROWN = registerBlock("warped_brown_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS)));
    public static final Block CUSHION_WARPED_GREEN = registerBlock("warped_green_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS)));
    public static final Block CUSHION_WARPED_RED = registerBlock("warped_red_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS)));
    public static final Block CUSHION_WARPED_BLACK = registerBlock("warped_black_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS)));

    // MANGROVE Cushion Blocks
    public static final Block CUSHION_MANGROVE_WHITE = registerBlock("mangrove_white_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS)));
    public static final Block CUSHION_MANGROVE_ORANGE = registerBlock("mangrove_orange_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS)));
    public static final Block CUSHION_MANGROVE_MAGENTA = registerBlock("mangrove_magenta_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS)));
    public static final Block CUSHION_MANGROVE_LIGHT_BLUE = registerBlock("mangrove_light_blue_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS)));
    public static final Block CUSHION_MANGROVE_YELLOW = registerBlock("mangrove_yellow_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS)));
    public static final Block CUSHION_MANGROVE_LIME = registerBlock("mangrove_lime_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS)));
    public static final Block CUSHION_MANGROVE_PINK = registerBlock("mangrove_pink_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS)));
    public static final Block CUSHION_MANGROVE_GRAY = registerBlock("mangrove_gray_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS)));
    public static final Block CUSHION_MANGROVE_LIGHT_GRAY = registerBlock("mangrove_light_gray_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS)));
    public static final Block CUSHION_MANGROVE_CYAN = registerBlock("mangrove_cyan_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS)));
    public static final Block CUSHION_MANGROVE_PURPLE = registerBlock("mangrove_purple_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS)));
    public static final Block CUSHION_MANGROVE_BLUE = registerBlock("mangrove_blue_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS)));
    public static final Block CUSHION_MANGROVE_BROWN = registerBlock("mangrove_brown_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS)));
    public static final Block CUSHION_MANGROVE_GREEN = registerBlock("mangrove_green_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS)));
    public static final Block CUSHION_MANGROVE_RED = registerBlock("mangrove_red_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS)));
    public static final Block CUSHION_MANGROVE_BLACK = registerBlock("mangrove_black_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS)));

    // CHERRY Cushion Blocks
    public static final Block CUSHION_CHERRY_WHITE = registerBlock("cherry_white_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS)));
    public static final Block CUSHION_CHERRY_ORANGE = registerBlock("cherry_orange_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS)));
    public static final Block CUSHION_CHERRY_MAGENTA = registerBlock("cherry_magenta_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS)));
    public static final Block CUSHION_CHERRY_LIGHT_BLUE = registerBlock("cherry_light_blue_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS)));
    public static final Block CUSHION_CHERRY_YELLOW = registerBlock("cherry_yellow_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS)));
    public static final Block CUSHION_CHERRY_LIME = registerBlock("cherry_lime_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS)));
    public static final Block CUSHION_CHERRY_PINK = registerBlock("cherry_pink_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS)));
    public static final Block CUSHION_CHERRY_GRAY = registerBlock("cherry_gray_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS)));
    public static final Block CUSHION_CHERRY_LIGHT_GRAY = registerBlock("cherry_light_gray_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS)));
    public static final Block CUSHION_CHERRY_CYAN = registerBlock("cherry_cyan_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS)));
    public static final Block CUSHION_CHERRY_PURPLE = registerBlock("cherry_purple_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS)));
    public static final Block CUSHION_CHERRY_BLUE = registerBlock("cherry_blue_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS)));
    public static final Block CUSHION_CHERRY_BROWN = registerBlock("cherry_brown_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS)));
    public static final Block CUSHION_CHERRY_GREEN = registerBlock("cherry_green_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS)));
    public static final Block CUSHION_CHERRY_RED = registerBlock("cherry_red_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS)));
    public static final Block CUSHION_CHERRY_BLACK = registerBlock("cherry_black_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS)));

    // BAMBOO Cushion Blocks
    public static final Block CUSHION_BAMBOO_WHITE = registerBlock("bamboo_white_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS)));
    public static final Block CUSHION_BAMBOO_ORANGE = registerBlock("bamboo_orange_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS)));
    public static final Block CUSHION_BAMBOO_MAGENTA = registerBlock("bamboo_magenta_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS)));
    public static final Block CUSHION_BAMBOO_LIGHT_BLUE = registerBlock("bamboo_light_blue_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS)));
    public static final Block CUSHION_BAMBOO_YELLOW = registerBlock("bamboo_yellow_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS)));
    public static final Block CUSHION_BAMBOO_LIME = registerBlock("bamboo_lime_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS)));
    public static final Block CUSHION_BAMBOO_PINK = registerBlock("bamboo_pink_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS)));
    public static final Block CUSHION_BAMBOO_GRAY = registerBlock("bamboo_gray_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS)));
    public static final Block CUSHION_BAMBOO_LIGHT_GRAY = registerBlock("bamboo_light_gray_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS)));
    public static final Block CUSHION_BAMBOO_CYAN = registerBlock("bamboo_cyan_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS)));
    public static final Block CUSHION_BAMBOO_PURPLE = registerBlock("bamboo_purple_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS)));
    public static final Block CUSHION_BAMBOO_BLUE = registerBlock("bamboo_blue_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS)));
    public static final Block CUSHION_BAMBOO_BROWN = registerBlock("bamboo_brown_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS)));
    public static final Block CUSHION_BAMBOO_GREEN = registerBlock("bamboo_green_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS)));
    public static final Block CUSHION_BAMBOO_RED = registerBlock("bamboo_red_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS)));
    public static final Block CUSHION_BAMBOO_BLACK = registerBlock("bamboo_black_cushion", CushionBlock::new, (AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS)));


    // Table Blocks
    public static final Block TABLE_OAK = registerBlock("oak_table", TableBlock::new, (AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()));
    public static final Block TABLE_SPRUCE = registerBlock("spruce_table", TableBlock::new, (AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque()));
    public static final Block TABLE_BIRCH = registerBlock("birch_table", TableBlock::new, (AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque()));
    public static final Block TABLE_JUNGLE = registerBlock("jungle_table", TableBlock::new, (AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque()));
    public static final Block TABLE_ACACIA = registerBlock("acacia_table", TableBlock::new, (AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque()));
    public static final Block TABLE_DARK_OAK = registerBlock("dark_oak_table", TableBlock::new, (AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque()));
    public static final Block TABLE_CRIMSON = registerBlock("crimson_table", TableBlock::new, (AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque()));
    public static final Block TABLE_WARPED = registerBlock("warped_table", TableBlock::new, (AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque()));
    public static final Block TABLE_MANGROVE = registerBlock("mangrove_table", TableBlock::new, (AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque()));
    public static final Block TABLE_BAMBOO = registerBlock("bamboo_table", TableBlock::new, (AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque()));
    public static final Block TABLE_CHERRY = registerBlock("cherry_table", TableBlock::new, (AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque()));

    //Window
    public static final Block Window_WOOD_OAK = registerBlock("oak_wood_window", (settings)-> new WindowBlock(settings, BlockSetType.OAK),AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    public static final Block Window_WOOD_BIRCH = registerBlock("birch_wood_window", (settings)-> new WindowBlock(settings,BlockSetType.BIRCH),AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque());
    public static final Block Window_WOOD_SPRUCE = registerBlock("spruce_wood_window", (settings)-> new WindowBlock(settings,BlockSetType.SPRUCE),AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque());
    public static final Block Window_WOOD_JUNGLE = registerBlock("jungle_wood_window", (settings)-> new WindowBlock(settings, BlockSetType.JUNGLE),AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque());
    public static final Block Window_WOOD_DARK_OAK = registerBlock("dark_oak_wood_window", (settings)-> new WindowBlock(settings, BlockSetType.DARK_OAK),AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque());
    public static final Block Window_WOOD_ACACIA = registerBlock("acacia_wood_window", (settings)-> new WindowBlock(settings,BlockSetType.ACACIA),AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque());
    public static final Block Window_WOOD_MANGROVE = registerBlock("mangrove_wood_window", (settings)-> new WindowBlock(settings, BlockSetType.MANGROVE),AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque());
    public static final Block Window_WOOD_CHERRY = registerBlock("cherry_wood_window", (settings)-> new WindowBlock(settings, BlockSetType.CHERRY),AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque());
    public static final Block Window_WOOD_CRIMSON = registerBlock("crimson_wood_window", (settings)-> new WindowBlock(settings, BlockSetType.CRIMSON),AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque());
    public static final Block Window_WOOD_WARPED = registerBlock("warped_wood_window", (settings)-> new WindowBlock(settings,BlockSetType.WARPED),AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque());
    public static final Block Window_PLANK_OAK = registerBlock("oak_plank_window", (settings)-> new WindowBlock(settings,BlockSetType.OAK),AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    public static final Block Window_PLANK_BIRCH = registerBlock("birch_plank_window", (settings)-> new WindowBlock(settings, BlockSetType.BIRCH),AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque());
    public static final Block Window_PLANK_SPRUCE = registerBlock("spruce_plank_window", (settings)-> new WindowBlock(settings, BlockSetType.SPRUCE),AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque());
    public static final Block Window_PLANK_JUNGLE = registerBlock("jungle_plank_window", (settings)-> new WindowBlock(settings, BlockSetType.JUNGLE),AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque());
    public static final Block Window_PLANK_DARK_OAK = registerBlock("dark_oak_plank_window", (settings)-> new WindowBlock(settings, BlockSetType.DARK_OAK),AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque());
    public static final Block Window_PLANK_ACACIA = registerBlock("acacia_plank_window", (settings)-> new WindowBlock(settings,BlockSetType.ACACIA),AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque());
    public static final Block Window_PLANK_MANGROVE = registerBlock("mangrove_plank_window", (settings)-> new WindowBlock(settings, BlockSetType.MANGROVE),AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque());
    public static final Block Window_PLANK_CHERRY = registerBlock("cherry_plank_window", (settings)-> new WindowBlock(settings, BlockSetType.CHERRY),AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque());
    public static final Block Window_PLANK_CRIMSON = registerBlock("crimson_plank_window", (settings)-> new WindowBlock(settings, BlockSetType.CRIMSON),AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque());
    public static final Block Window_PLANK_WARPED = registerBlock("warped_plank_window", (settings)-> new WindowBlock(settings, BlockSetType.WARPED),AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque());

    // Coffee Table Blocks
    public static final Block Coffee_Table_WOOD_OAK = registerBlock("oak_wood_coffee_table", TableBlock::new, (AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()));
    public static final Block Coffee_Table_WOOD_BIRCH = registerBlock("birch_wood_coffee_table", TableBlock::new, (AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque()));
    public static final Block Coffee_Table_WOOD_SPRUCE = registerBlock("spruce_wood_coffee_table", TableBlock::new, (AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque()));
    public static final Block Coffee_Table_WOOD_JUNGLE = registerBlock("jungle_wood_coffee_table", TableBlock::new, (AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque()));
    public static final Block Coffee_Table_WOOD_DARK_OAK = registerBlock("dark_oak_wood_coffee_table", TableBlock::new, (AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque()));
    public static final Block Coffee_Table_WOOD_ACACIA = registerBlock("acacia_wood_coffee_table", TableBlock::new, (AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque()));
    public static final Block Coffee_Table_WOOD_MANGROVE = registerBlock("mangrove_wood_coffee_table", TableBlock::new, (AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque()));
    public static final Block Coffee_Table_WOOD_BAMBOO = registerBlock("bamboo_wood_coffee_table", TableBlock::new, (AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque()));
    public static final Block Coffee_Table_WOOD_CHERRY = registerBlock("cherry_wood_coffee_table", TableBlock::new, (AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque()));
    public static final Block Coffee_Table_WOOD_CRIMSON = registerBlock("crimson_wood_coffee_table", TableBlock::new, (AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque()));
    public static final Block Coffee_Table_WOOD_WARPED = registerBlock("warped_wood_coffee_table", TableBlock::new, (AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque()));
    public static final Block Coffee_Table_PLANK_OAK = registerBlock("oak_plank_coffee_table", TableBlock::new, (AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()));
    public static final Block Coffee_Table_PLANK_BIRCH = registerBlock("birch_plank_coffee_table", TableBlock::new, (AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque()));
    public static final Block Coffee_Table_PLANK_SPRUCE = registerBlock("spruce_plank_coffee_table", TableBlock::new, (AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque()));
    public static final Block Coffee_Table_PLANK_JUNGLE = registerBlock("jungle_plank_coffee_table", TableBlock::new, (AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque()));
    public static final Block Coffee_Table_PLANK_DARK_OAK = registerBlock("dark_oak_plank_coffee_table", TableBlock::new, (AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque()));
    public static final Block Coffee_Table_PLANK_ACACIA = registerBlock("acacia_plank_coffee_table", TableBlock::new, (AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque()));
    public static final Block Coffee_Table_PLANK_MANGROVE = registerBlock("mangrove_plank_coffee_table", TableBlock::new, (AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque()));
    public static final Block Coffee_Table_PLANK_BAMBOO = registerBlock("bamboo_plank_coffee_table", TableBlock::new, (AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque()));
    public static final Block Coffee_Table_PLANK_CHERRY = registerBlock("cherry_plank_coffee_table", TableBlock::new, (AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque()));
    public static final Block Coffee_Table_PLANK_CRIMSON = registerBlock("crimson_plank_coffee_table", TableBlock::new, (AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque()));
    public static final Block Coffee_Table_PLANK_WARPED = registerBlock("warped_plank_coffee_table", TableBlock::new, (AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque()));

    //Chair
    public static final Block Chair_WOOD_OAK = registerBlock("oak_wood_chair", ChairBlock::new, (AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()));
    public static final Block Chair_WOOD_BIRCH = registerBlock("birch_wood_chair", ChairBlock::new, (AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque()));
    public static final Block Chair_WOOD_SPRUCE = registerBlock("spruce_wood_chair", ChairBlock::new, (AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque()));
    public static final Block Chair_WOOD_JUNGLE = registerBlock("jungle_wood_chair", ChairBlock::new, (AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque()));
    public static final Block Chair_WOOD_DARK_OAK = registerBlock("dark_oak_wood_chair", ChairBlock::new, (AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque()));
    public static final Block Chair_WOOD_ACACIA = registerBlock("acacia_wood_chair", ChairBlock::new, (AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque()));
    public static final Block Chair_WOOD_MANGROVE = registerBlock("mangrove_wood_chair", ChairBlock::new, (AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque()));
    public static final Block Chair_WOOD_BAMBOO = registerBlock("bamboo_wood_chair", ChairBlock::new, (AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque()));
    public static final Block Chair_WOOD_CHERRY = registerBlock("cherry_wood_chair", ChairBlock::new, (AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque()));
    public static final Block Chair_WOOD_CRIMSON = registerBlock("crimson_wood_chair", ChairBlock::new, (AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque()));
    public static final Block Chair_WOOD_WARPED = registerBlock("warped_wood_chair", ChairBlock::new, (AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque()));
    public static final Block Chair_PLANK_OAK = registerBlock("oak_plank_chair", ChairBlock::new, (AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()));
    public static final Block Chair_PLANK_BIRCH = registerBlock("birch_plank_chair", ChairBlock::new, (AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque()));
    public static final Block Chair_PLANK_SPRUCE = registerBlock("spruce_plank_chair", ChairBlock::new, (AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque()));
    public static final Block Chair_PLANK_JUNGLE = registerBlock("jungle_plank_chair", ChairBlock::new, (AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque()));
    public static final Block Chair_PLANK_DARK_OAK = registerBlock("dark_oak_plank_chair", ChairBlock::new, (AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque()));
    public static final Block Chair_PLANK_ACACIA = registerBlock("acacia_plank_chair", ChairBlock::new, (AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque()));
    public static final Block Chair_PLANK_MANGROVE = registerBlock("mangrove_plank_chair", ChairBlock::new, (AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque()));
    public static final Block Chair_PLANK_BAMBOO = registerBlock("bamboo_plank_chair", ChairBlock::new, (AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque()));
    public static final Block Chair_PLANK_CHERRY = registerBlock("cherry_plank_chair", ChairBlock::new, (AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque()));
    public static final Block Chair_PLANK_CRIMSON = registerBlock("crimson_plank_chair", ChairBlock::new, (AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque()));
    public static final Block Chair_PLANK_WARPED = registerBlock("warped_plank_chair", ChairBlock::new, (AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque()));

    //End Table
    public static final Block END_TABLE_OAK = registerBlock("oak_end_table", EndTableBlock::new, (AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()));
    public static final Block END_TABLE_SPRUCE = registerBlock("spruce_end_table", EndTableBlock::new, (AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque()));
    public static final Block END_TABLE_BIRCH = registerBlock("birch_end_table", EndTableBlock::new, (AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque()));
    public static final Block END_TABLE_JUNGLE = registerBlock("jungle_end_table", EndTableBlock::new, (AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque()));
    public static final Block END_TABLE_ACACIA = registerBlock("acacia_end_table", EndTableBlock::new, (AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque()));
    public static final Block END_TABLE_DARK_OAK = registerBlock("dark_oak_end_table", EndTableBlock::new, (AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque()));
    public static final Block END_TABLE_CRIMSON = registerBlock("crimson_end_table", EndTableBlock::new, (AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque()));
    public static final Block END_TABLE_WARPED = registerBlock("warped_end_table", EndTableBlock::new, (AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque()));
    public static final Block END_TABLE_MANGROVE = registerBlock("mangrove_end_table", EndTableBlock::new, (AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque()));
    public static final Block END_TABLE_BAMBOO = registerBlock("bamboo_end_table", EndTableBlock::new, (AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque()));
    public static final Block END_TABLE_CHERRY = registerBlock("cherry_end_table", EndTableBlock::new, (AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque()));



    public static final Block OAK_PLANK_COFFEE_CHAIR_WHITE = registerBlock("oak_plank_coffee_chair_white", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    public static final Block OAK_PLANK_COFFEE_CHAIR_ORANGE = registerBlock("oak_plank_coffee_chair_orange", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    public static final Block OAK_PLANK_COFFEE_CHAIR_MAGENTA = registerBlock("oak_plank_coffee_chair_magenta", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    public static final Block OAK_PLANK_COFFEE_CHAIR_LIGHT_BLUE = registerBlock("oak_plank_coffee_chair_light_blue", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    public static final Block OAK_PLANK_COFFEE_CHAIR_YELLOW = registerBlock("oak_plank_coffee_chair_yellow", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    public static final Block OAK_PLANK_COFFEE_CHAIR_LIME = registerBlock("oak_plank_coffee_chair_lime", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    public static final Block OAK_PLANK_COFFEE_CHAIR_PINK = registerBlock("oak_plank_coffee_chair_pink", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    public static final Block OAK_PLANK_COFFEE_CHAIR_GRAY = registerBlock("oak_plank_coffee_chair_gray", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    public static final Block OAK_PLANK_COFFEE_CHAIR_LIGHT_GRAY = registerBlock("oak_plank_coffee_chair_light_gray", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    public static final Block OAK_PLANK_COFFEE_CHAIR_CYAN = registerBlock("oak_plank_coffee_chair_cyan", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    public static final Block OAK_PLANK_COFFEE_CHAIR_PURPLE = registerBlock("oak_plank_coffee_chair_purple", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    public static final Block OAK_PLANK_COFFEE_CHAIR_BLUE = registerBlock("oak_plank_coffee_chair_blue", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    public static final Block OAK_PLANK_COFFEE_CHAIR_BROWN = registerBlock("oak_plank_coffee_chair_brown", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    public static final Block OAK_PLANK_COFFEE_CHAIR_GREEN = registerBlock("oak_plank_coffee_chair_green", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    public static final Block OAK_PLANK_COFFEE_CHAIR_RED = registerBlock("oak_plank_coffee_chair_red", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    public static final Block OAK_PLANK_COFFEE_CHAIR_BLACK = registerBlock("oak_plank_coffee_chair_black", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    public static final Block SPRUCE_PLANK_COFFEE_CHAIR_WHITE = registerBlock("spruce_plank_coffee_chair_white", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque());
    public static final Block SPRUCE_PLANK_COFFEE_CHAIR_ORANGE = registerBlock("spruce_plank_coffee_chair_orange", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque());
    public static final Block SPRUCE_PLANK_COFFEE_CHAIR_MAGENTA = registerBlock("spruce_plank_coffee_chair_magenta", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque());
    public static final Block SPRUCE_PLANK_COFFEE_CHAIR_LIGHT_BLUE = registerBlock("spruce_plank_coffee_chair_light_blue", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque());
    public static final Block SPRUCE_PLANK_COFFEE_CHAIR_YELLOW = registerBlock("spruce_plank_coffee_chair_yellow", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque());
    public static final Block SPRUCE_PLANK_COFFEE_CHAIR_LIME = registerBlock("spruce_plank_coffee_chair_lime", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque());
    public static final Block SPRUCE_PLANK_COFFEE_CHAIR_PINK = registerBlock("spruce_plank_coffee_chair_pink", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque());
    public static final Block SPRUCE_PLANK_COFFEE_CHAIR_GRAY = registerBlock("spruce_plank_coffee_chair_gray", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque());
    public static final Block SPRUCE_PLANK_COFFEE_CHAIR_LIGHT_GRAY = registerBlock("spruce_plank_coffee_chair_light_gray", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque());
    public static final Block SPRUCE_PLANK_COFFEE_CHAIR_CYAN = registerBlock("spruce_plank_coffee_chair_cyan", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque());
    public static final Block SPRUCE_PLANK_COFFEE_CHAIR_PURPLE = registerBlock("spruce_plank_coffee_chair_purple", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque());
    public static final Block SPRUCE_PLANK_COFFEE_CHAIR_BLUE = registerBlock("spruce_plank_coffee_chair_blue", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque());
    public static final Block SPRUCE_PLANK_COFFEE_CHAIR_BROWN = registerBlock("spruce_plank_coffee_chair_brown", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque());
    public static final Block SPRUCE_PLANK_COFFEE_CHAIR_GREEN = registerBlock("spruce_plank_coffee_chair_green", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque());
    public static final Block SPRUCE_PLANK_COFFEE_CHAIR_RED = registerBlock("spruce_plank_coffee_chair_red", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque());
    public static final Block SPRUCE_PLANK_COFFEE_CHAIR_BLACK = registerBlock("spruce_plank_coffee_chair_black", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque());
    public static final Block BIRCH_PLANK_COFFEE_CHAIR_WHITE = registerBlock("birch_plank_coffee_chair_white", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque());
    public static final Block BIRCH_PLANK_COFFEE_CHAIR_ORANGE = registerBlock("birch_plank_coffee_chair_orange", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque());
    public static final Block BIRCH_PLANK_COFFEE_CHAIR_MAGENTA = registerBlock("birch_plank_coffee_chair_magenta", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque());
    public static final Block BIRCH_PLANK_COFFEE_CHAIR_LIGHT_BLUE = registerBlock("birch_plank_coffee_chair_light_blue", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque());
    public static final Block BIRCH_PLANK_COFFEE_CHAIR_YELLOW = registerBlock("birch_plank_coffee_chair_yellow", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque());
    public static final Block BIRCH_PLANK_COFFEE_CHAIR_LIME = registerBlock("birch_plank_coffee_chair_lime", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque());
    public static final Block BIRCH_PLANK_COFFEE_CHAIR_PINK = registerBlock("birch_plank_coffee_chair_pink", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque());
    public static final Block BIRCH_PLANK_COFFEE_CHAIR_GRAY = registerBlock("birch_plank_coffee_chair_gray", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque());
    public static final Block BIRCH_PLANK_COFFEE_CHAIR_LIGHT_GRAY = registerBlock("birch_plank_coffee_chair_light_gray", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque());
    public static final Block BIRCH_PLANK_COFFEE_CHAIR_CYAN = registerBlock("birch_plank_coffee_chair_cyan", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque());
    public static final Block BIRCH_PLANK_COFFEE_CHAIR_PURPLE = registerBlock("birch_plank_coffee_chair_purple", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque());
    public static final Block BIRCH_PLANK_COFFEE_CHAIR_BLUE = registerBlock("birch_plank_coffee_chair_blue", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque());
    public static final Block BIRCH_PLANK_COFFEE_CHAIR_BROWN = registerBlock("birch_plank_coffee_chair_brown", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque());
    public static final Block BIRCH_PLANK_COFFEE_CHAIR_GREEN = registerBlock("birch_plank_coffee_chair_green", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque());
    public static final Block BIRCH_PLANK_COFFEE_CHAIR_RED = registerBlock("birch_plank_coffee_chair_red", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque());
    public static final Block BIRCH_PLANK_COFFEE_CHAIR_BLACK = registerBlock("birch_plank_coffee_chair_black", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque());
    public static final Block JUNGLE_PLANK_COFFEE_CHAIR_WHITE = registerBlock("jungle_plank_coffee_chair_white", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque());
    public static final Block JUNGLE_PLANK_COFFEE_CHAIR_ORANGE = registerBlock("jungle_plank_coffee_chair_orange", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque());
    public static final Block JUNGLE_PLANK_COFFEE_CHAIR_MAGENTA = registerBlock("jungle_plank_coffee_chair_magenta", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque());
    public static final Block JUNGLE_PLANK_COFFEE_CHAIR_LIGHT_BLUE = registerBlock("jungle_plank_coffee_chair_light_blue", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque());
    public static final Block JUNGLE_PLANK_COFFEE_CHAIR_YELLOW = registerBlock("jungle_plank_coffee_chair_yellow", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque());
    public static final Block JUNGLE_PLANK_COFFEE_CHAIR_LIME = registerBlock("jungle_plank_coffee_chair_lime", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque());
    public static final Block JUNGLE_PLANK_COFFEE_CHAIR_PINK = registerBlock("jungle_plank_coffee_chair_pink", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque());
    public static final Block JUNGLE_PLANK_COFFEE_CHAIR_GRAY = registerBlock("jungle_plank_coffee_chair_gray", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque());
    public static final Block JUNGLE_PLANK_COFFEE_CHAIR_LIGHT_GRAY = registerBlock("jungle_plank_coffee_chair_light_gray", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque());
    public static final Block JUNGLE_PLANK_COFFEE_CHAIR_CYAN = registerBlock("jungle_plank_coffee_chair_cyan", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque());
    public static final Block JUNGLE_PLANK_COFFEE_CHAIR_PURPLE = registerBlock("jungle_plank_coffee_chair_purple", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque());
    public static final Block JUNGLE_PLANK_COFFEE_CHAIR_BLUE = registerBlock("jungle_plank_coffee_chair_blue", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque());
    public static final Block JUNGLE_PLANK_COFFEE_CHAIR_BROWN = registerBlock("jungle_plank_coffee_chair_brown", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque());
    public static final Block JUNGLE_PLANK_COFFEE_CHAIR_GREEN = registerBlock("jungle_plank_coffee_chair_green", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque());
    public static final Block JUNGLE_PLANK_COFFEE_CHAIR_RED = registerBlock("jungle_plank_coffee_chair_red", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque());
    public static final Block JUNGLE_PLANK_COFFEE_CHAIR_BLACK = registerBlock("jungle_plank_coffee_chair_black", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque());
    public static final Block ACACIA_PLANK_COFFEE_CHAIR_WHITE = registerBlock("acacia_plank_coffee_chair_white", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque());
    public static final Block ACACIA_PLANK_COFFEE_CHAIR_ORANGE = registerBlock("acacia_plank_coffee_chair_orange", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque());
    public static final Block ACACIA_PLANK_COFFEE_CHAIR_MAGENTA = registerBlock("acacia_plank_coffee_chair_magenta", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque());
    public static final Block ACACIA_PLANK_COFFEE_CHAIR_LIGHT_BLUE = registerBlock("acacia_plank_coffee_chair_light_blue", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque());
    public static final Block ACACIA_PLANK_COFFEE_CHAIR_YELLOW = registerBlock("acacia_plank_coffee_chair_yellow", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque());
    public static final Block ACACIA_PLANK_COFFEE_CHAIR_LIME = registerBlock("acacia_plank_coffee_chair_lime", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque());
    public static final Block ACACIA_PLANK_COFFEE_CHAIR_PINK = registerBlock("acacia_plank_coffee_chair_pink", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque());
    public static final Block ACACIA_PLANK_COFFEE_CHAIR_GRAY = registerBlock("acacia_plank_coffee_chair_gray", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque());
    public static final Block ACACIA_PLANK_COFFEE_CHAIR_LIGHT_GRAY = registerBlock("acacia_plank_coffee_chair_light_gray", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque());
    public static final Block ACACIA_PLANK_COFFEE_CHAIR_CYAN = registerBlock("acacia_plank_coffee_chair_cyan", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque());
    public static final Block ACACIA_PLANK_COFFEE_CHAIR_PURPLE = registerBlock("acacia_plank_coffee_chair_purple", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque());
    public static final Block ACACIA_PLANK_COFFEE_CHAIR_BLUE = registerBlock("acacia_plank_coffee_chair_blue", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque());
    public static final Block ACACIA_PLANK_COFFEE_CHAIR_BROWN = registerBlock("acacia_plank_coffee_chair_brown", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque());
    public static final Block ACACIA_PLANK_COFFEE_CHAIR_GREEN = registerBlock("acacia_plank_coffee_chair_green", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque());
    public static final Block ACACIA_PLANK_COFFEE_CHAIR_RED = registerBlock("acacia_plank_coffee_chair_red", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque());
    public static final Block ACACIA_PLANK_COFFEE_CHAIR_BLACK = registerBlock("acacia_plank_coffee_chair_black", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque());
    public static final Block DARK_OAK_PLANK_COFFEE_CHAIR_WHITE = registerBlock("dark_oak_plank_coffee_chair_white", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque());
    public static final Block DARK_OAK_PLANK_COFFEE_CHAIR_ORANGE = registerBlock("dark_oak_plank_coffee_chair_orange", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque());
    public static final Block DARK_OAK_PLANK_COFFEE_CHAIR_MAGENTA = registerBlock("dark_oak_plank_coffee_chair_magenta", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque());
    public static final Block DARK_OAK_PLANK_COFFEE_CHAIR_LIGHT_BLUE = registerBlock("dark_oak_plank_coffee_chair_light_blue", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque());
    public static final Block DARK_OAK_PLANK_COFFEE_CHAIR_YELLOW = registerBlock("dark_oak_plank_coffee_chair_yellow", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque());
    public static final Block DARK_OAK_PLANK_COFFEE_CHAIR_LIME = registerBlock("dark_oak_plank_coffee_chair_lime", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque());
    public static final Block DARK_OAK_PLANK_COFFEE_CHAIR_PINK = registerBlock("dark_oak_plank_coffee_chair_pink", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque());
    public static final Block DARK_OAK_PLANK_COFFEE_CHAIR_GRAY = registerBlock("dark_oak_plank_coffee_chair_gray", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque());
    public static final Block DARK_OAK_PLANK_COFFEE_CHAIR_LIGHT_GRAY = registerBlock("dark_oak_plank_coffee_chair_light_gray", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque());
    public static final Block DARK_OAK_PLANK_COFFEE_CHAIR_CYAN = registerBlock("dark_oak_plank_coffee_chair_cyan", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque());
    public static final Block DARK_OAK_PLANK_COFFEE_CHAIR_PURPLE = registerBlock("dark_oak_plank_coffee_chair_purple", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque());
    public static final Block DARK_OAK_PLANK_COFFEE_CHAIR_BLUE = registerBlock("dark_oak_plank_coffee_chair_blue", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque());
    public static final Block DARK_OAK_PLANK_COFFEE_CHAIR_BROWN = registerBlock("dark_oak_plank_coffee_chair_brown", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque());
    public static final Block DARK_OAK_PLANK_COFFEE_CHAIR_GREEN = registerBlock("dark_oak_plank_coffee_chair_green", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque());
    public static final Block DARK_OAK_PLANK_COFFEE_CHAIR_RED = registerBlock("dark_oak_plank_coffee_chair_red", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque());
    public static final Block DARK_OAK_PLANK_COFFEE_CHAIR_BLACK = registerBlock("dark_oak_plank_coffee_chair_black", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque());
    public static final Block MANGROVE_PLANK_COFFEE_CHAIR_WHITE = registerBlock("mangrove_plank_coffee_chair_white", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque());
    public static final Block MANGROVE_PLANK_COFFEE_CHAIR_ORANGE = registerBlock("mangrove_plank_coffee_chair_orange", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque());
    public static final Block MANGROVE_PLANK_COFFEE_CHAIR_MAGENTA = registerBlock("mangrove_plank_coffee_chair_magenta", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque());
    public static final Block MANGROVE_PLANK_COFFEE_CHAIR_LIGHT_BLUE = registerBlock("mangrove_plank_coffee_chair_light_blue", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque());
    public static final Block MANGROVE_PLANK_COFFEE_CHAIR_YELLOW = registerBlock("mangrove_plank_coffee_chair_yellow", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque());
    public static final Block MANGROVE_PLANK_COFFEE_CHAIR_LIME = registerBlock("mangrove_plank_coffee_chair_lime", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque());
    public static final Block MANGROVE_PLANK_COFFEE_CHAIR_PINK = registerBlock("mangrove_plank_coffee_chair_pink", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque());
    public static final Block MANGROVE_PLANK_COFFEE_CHAIR_GRAY = registerBlock("mangrove_plank_coffee_chair_gray", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque());
    public static final Block MANGROVE_PLANK_COFFEE_CHAIR_LIGHT_GRAY = registerBlock("mangrove_plank_coffee_chair_light_gray", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque());
    public static final Block MANGROVE_PLANK_COFFEE_CHAIR_CYAN = registerBlock("mangrove_plank_coffee_chair_cyan", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque());
    public static final Block MANGROVE_PLANK_COFFEE_CHAIR_PURPLE = registerBlock("mangrove_plank_coffee_chair_purple", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque());
    public static final Block MANGROVE_PLANK_COFFEE_CHAIR_BLUE = registerBlock("mangrove_plank_coffee_chair_blue", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque());
    public static final Block MANGROVE_PLANK_COFFEE_CHAIR_BROWN = registerBlock("mangrove_plank_coffee_chair_brown", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque());
    public static final Block MANGROVE_PLANK_COFFEE_CHAIR_GREEN = registerBlock("mangrove_plank_coffee_chair_green", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque());
    public static final Block MANGROVE_PLANK_COFFEE_CHAIR_RED = registerBlock("mangrove_plank_coffee_chair_red", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque());
    public static final Block MANGROVE_PLANK_COFFEE_CHAIR_BLACK = registerBlock("mangrove_plank_coffee_chair_black", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque());
    public static final Block CHERRY_PLANK_COFFEE_CHAIR_WHITE = registerBlock("cherry_plank_coffee_chair_white", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque());
    public static final Block CHERRY_PLANK_COFFEE_CHAIR_ORANGE = registerBlock("cherry_plank_coffee_chair_orange", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque());
    public static final Block CHERRY_PLANK_COFFEE_CHAIR_MAGENTA = registerBlock("cherry_plank_coffee_chair_magenta", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque());
    public static final Block CHERRY_PLANK_COFFEE_CHAIR_LIGHT_BLUE = registerBlock("cherry_plank_coffee_chair_light_blue", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque());
    public static final Block CHERRY_PLANK_COFFEE_CHAIR_YELLOW = registerBlock("cherry_plank_coffee_chair_yellow", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque());
    public static final Block CHERRY_PLANK_COFFEE_CHAIR_LIME = registerBlock("cherry_plank_coffee_chair_lime", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque());
    public static final Block CHERRY_PLANK_COFFEE_CHAIR_PINK = registerBlock("cherry_plank_coffee_chair_pink", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque());
    public static final Block CHERRY_PLANK_COFFEE_CHAIR_GRAY = registerBlock("cherry_plank_coffee_chair_gray", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque());
    public static final Block CHERRY_PLANK_COFFEE_CHAIR_LIGHT_GRAY = registerBlock("cherry_plank_coffee_chair_light_gray", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque());
    public static final Block CHERRY_PLANK_COFFEE_CHAIR_CYAN = registerBlock("cherry_plank_coffee_chair_cyan", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque());
    public static final Block CHERRY_PLANK_COFFEE_CHAIR_PURPLE = registerBlock("cherry_plank_coffee_chair_purple", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque());
    public static final Block CHERRY_PLANK_COFFEE_CHAIR_BLUE = registerBlock("cherry_plank_coffee_chair_blue", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque());
    public static final Block CHERRY_PLANK_COFFEE_CHAIR_BROWN = registerBlock("cherry_plank_coffee_chair_brown", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque());
    public static final Block CHERRY_PLANK_COFFEE_CHAIR_GREEN = registerBlock("cherry_plank_coffee_chair_green", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque());
    public static final Block CHERRY_PLANK_COFFEE_CHAIR_RED = registerBlock("cherry_plank_coffee_chair_red", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque());
    public static final Block CHERRY_PLANK_COFFEE_CHAIR_BLACK = registerBlock("cherry_plank_coffee_chair_black", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque());
    public static final Block BAMBOO_PLANK_COFFEE_CHAIR_WHITE = registerBlock("bamboo_plank_coffee_chair_white", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque());
    public static final Block BAMBOO_PLANK_COFFEE_CHAIR_ORANGE = registerBlock("bamboo_plank_coffee_chair_orange", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque());
    public static final Block BAMBOO_PLANK_COFFEE_CHAIR_MAGENTA = registerBlock("bamboo_plank_coffee_chair_magenta", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque());
    public static final Block BAMBOO_PLANK_COFFEE_CHAIR_LIGHT_BLUE = registerBlock("bamboo_plank_coffee_chair_light_blue", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque());
    public static final Block BAMBOO_PLANK_COFFEE_CHAIR_YELLOW = registerBlock("bamboo_plank_coffee_chair_yellow", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque());
    public static final Block BAMBOO_PLANK_COFFEE_CHAIR_LIME = registerBlock("bamboo_plank_coffee_chair_lime", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque());
    public static final Block BAMBOO_PLANK_COFFEE_CHAIR_PINK = registerBlock("bamboo_plank_coffee_chair_pink", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque());
    public static final Block BAMBOO_PLANK_COFFEE_CHAIR_GRAY = registerBlock("bamboo_plank_coffee_chair_gray", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque());
    public static final Block BAMBOO_PLANK_COFFEE_CHAIR_LIGHT_GRAY = registerBlock("bamboo_plank_coffee_chair_light_gray", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque());
    public static final Block BAMBOO_PLANK_COFFEE_CHAIR_CYAN = registerBlock("bamboo_plank_coffee_chair_cyan", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque());
    public static final Block BAMBOO_PLANK_COFFEE_CHAIR_PURPLE = registerBlock("bamboo_plank_coffee_chair_purple", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque());
    public static final Block BAMBOO_PLANK_COFFEE_CHAIR_BLUE = registerBlock("bamboo_plank_coffee_chair_blue", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque());
    public static final Block BAMBOO_PLANK_COFFEE_CHAIR_BROWN = registerBlock("bamboo_plank_coffee_chair_brown", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque());
    public static final Block BAMBOO_PLANK_COFFEE_CHAIR_GREEN = registerBlock("bamboo_plank_coffee_chair_green", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque());
    public static final Block BAMBOO_PLANK_COFFEE_CHAIR_RED = registerBlock("bamboo_plank_coffee_chair_red", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque());
    public static final Block BAMBOO_PLANK_COFFEE_CHAIR_BLACK = registerBlock("bamboo_plank_coffee_chair_black", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque());
    public static final Block CRIMSON_PLANK_COFFEE_CHAIR_WHITE = registerBlock("crimson_plank_coffee_chair_white", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque());
    public static final Block CRIMSON_PLANK_COFFEE_CHAIR_ORANGE = registerBlock("crimson_plank_coffee_chair_orange", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque());
    public static final Block CRIMSON_PLANK_COFFEE_CHAIR_MAGENTA = registerBlock("crimson_plank_coffee_chair_magenta", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque());
    public static final Block CRIMSON_PLANK_COFFEE_CHAIR_LIGHT_BLUE = registerBlock("crimson_plank_coffee_chair_light_blue", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque());
    public static final Block CRIMSON_PLANK_COFFEE_CHAIR_YELLOW = registerBlock("crimson_plank_coffee_chair_yellow", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque());
    public static final Block CRIMSON_PLANK_COFFEE_CHAIR_LIME = registerBlock("crimson_plank_coffee_chair_lime", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque());
    public static final Block CRIMSON_PLANK_COFFEE_CHAIR_PINK = registerBlock("crimson_plank_coffee_chair_pink", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque());
    public static final Block CRIMSON_PLANK_COFFEE_CHAIR_GRAY = registerBlock("crimson_plank_coffee_chair_gray", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque());
    public static final Block CRIMSON_PLANK_COFFEE_CHAIR_LIGHT_GRAY = registerBlock("crimson_plank_coffee_chair_light_gray", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque());
    public static final Block CRIMSON_PLANK_COFFEE_CHAIR_CYAN = registerBlock("crimson_plank_coffee_chair_cyan", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque());
    public static final Block CRIMSON_PLANK_COFFEE_CHAIR_PURPLE = registerBlock("crimson_plank_coffee_chair_purple", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque());
    public static final Block CRIMSON_PLANK_COFFEE_CHAIR_BLUE = registerBlock("crimson_plank_coffee_chair_blue", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque());
    public static final Block CRIMSON_PLANK_COFFEE_CHAIR_BROWN = registerBlock("crimson_plank_coffee_chair_brown", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque());
    public static final Block CRIMSON_PLANK_COFFEE_CHAIR_GREEN = registerBlock("crimson_plank_coffee_chair_green", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque());
    public static final Block CRIMSON_PLANK_COFFEE_CHAIR_RED = registerBlock("crimson_plank_coffee_chair_red", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque());
    public static final Block CRIMSON_PLANK_COFFEE_CHAIR_BLACK = registerBlock("crimson_plank_coffee_chair_black", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque());
    public static final Block WARPED_PLANK_COFFEE_CHAIR_WHITE = registerBlock("warped_plank_coffee_chair_white", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque());
    public static final Block WARPED_PLANK_COFFEE_CHAIR_ORANGE = registerBlock("warped_plank_coffee_chair_orange", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque());
    public static final Block WARPED_PLANK_COFFEE_CHAIR_MAGENTA = registerBlock("warped_plank_coffee_chair_magenta", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque());
    public static final Block WARPED_PLANK_COFFEE_CHAIR_LIGHT_BLUE = registerBlock("warped_plank_coffee_chair_light_blue", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque());
    public static final Block WARPED_PLANK_COFFEE_CHAIR_YELLOW = registerBlock("warped_plank_coffee_chair_yellow", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque());
    public static final Block WARPED_PLANK_COFFEE_CHAIR_LIME = registerBlock("warped_plank_coffee_chair_lime", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque());
    public static final Block WARPED_PLANK_COFFEE_CHAIR_PINK = registerBlock("warped_plank_coffee_chair_pink", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque());
    public static final Block WARPED_PLANK_COFFEE_CHAIR_GRAY = registerBlock("warped_plank_coffee_chair_gray", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque());
    public static final Block WARPED_PLANK_COFFEE_CHAIR_LIGHT_GRAY = registerBlock("warped_plank_coffee_chair_light_gray", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque());
    public static final Block WARPED_PLANK_COFFEE_CHAIR_CYAN = registerBlock("warped_plank_coffee_chair_cyan", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque());
    public static final Block WARPED_PLANK_COFFEE_CHAIR_PURPLE = registerBlock("warped_plank_coffee_chair_purple", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque());
    public static final Block WARPED_PLANK_COFFEE_CHAIR_BLUE = registerBlock("warped_plank_coffee_chair_blue", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque());
    public static final Block WARPED_PLANK_COFFEE_CHAIR_BROWN = registerBlock("warped_plank_coffee_chair_brown", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque());
    public static final Block WARPED_PLANK_COFFEE_CHAIR_GREEN = registerBlock("warped_plank_coffee_chair_green", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque());
    public static final Block WARPED_PLANK_COFFEE_CHAIR_RED = registerBlock("warped_plank_coffee_chair_red", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque());
    public static final Block WARPED_PLANK_COFFEE_CHAIR_BLACK = registerBlock("warped_plank_coffee_chair_black", CoffeeChairBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque());


    //triple cabinet
    public static final Block OAK_PLANK_TRIPLE_CABINET = registerBlock("oak_plank_triple_cabinet", TripleCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    public static final Block OAK_WOOD_TRIPLE_CABINET = registerBlock("oak_wood_triple_cabinet", TripleCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    public static final Block SPRUCE_PLANK_TRIPLE_CABINET = registerBlock("spruce_plank_triple_cabinet", TripleCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque());
    public static final Block SPRUCE_WOOD_TRIPLE_CABINET = registerBlock("spruce_wood_triple_cabinet", TripleCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque());
    public static final Block BIRCH_PLANK_TRIPLE_CABINET = registerBlock("birch_plank_triple_cabinet", TripleCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque());
    public static final Block BIRCH_WOOD_TRIPLE_CABINET = registerBlock("birch_wood_triple_cabinet", TripleCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque());
    public static final Block JUNGLE_PLANK_TRIPLE_CABINET = registerBlock("jungle_plank_triple_cabinet", TripleCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque());
    public static final Block JUNGLE_WOOD_TRIPLE_CABINET = registerBlock("jungle_wood_triple_cabinet", TripleCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque());
    public static final Block ACACIA_PLANK_TRIPLE_CABINET = registerBlock("acacia_plank_triple_cabinet", TripleCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque());
    public static final Block ACACIA_WOOD_TRIPLE_CABINET = registerBlock("acacia_wood_triple_cabinet", TripleCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque());
    public static final Block DARK_OAK_PLANK_TRIPLE_CABINET = registerBlock("dark_oak_plank_triple_cabinet", TripleCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque());
    public static final Block DARK_OAK_WOOD_TRIPLE_CABINET = registerBlock("dark_oak_wood_triple_cabinet", TripleCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque());
    public static final Block MANGROVE_PLANK_TRIPLE_CABINET = registerBlock("mangrove_plank_triple_cabinet", TripleCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque());
    public static final Block MANGROVE_WOOD_TRIPLE_CABINET = registerBlock("mangrove_wood_triple_cabinet", TripleCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque());
    public static final Block CHERRY_PLANK_TRIPLE_CABINET = registerBlock("cherry_plank_triple_cabinet", TripleCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque());
    public static final Block CHERRY_WOOD_TRIPLE_CABINET = registerBlock("cherry_wood_triple_cabinet", TripleCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque());
    public static final Block BAMBOO_PLANK_TRIPLE_CABINET = registerBlock("bamboo_plank_triple_cabinet", TripleCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque());
    public static final Block BAMBOO_WOOD_TRIPLE_CABINET = registerBlock("bamboo_wood_triple_cabinet", TripleCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque());
    public static final Block CRIMSON_PLANK_TRIPLE_CABINET = registerBlock("crimson_plank_triple_cabinet", TripleCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque());
    public static final Block CRIMSON_WOOD_TRIPLE_CABINET = registerBlock("crimson_wood_triple_cabinet", TripleCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque());
    public static final Block WARPED_PLANK_TRIPLE_CABINET = registerBlock("warped_plank_triple_cabinet", TripleCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque());
    public static final Block WARPED_WOOD_TRIPLE_CABINET = registerBlock("warped_wood_triple_cabinet", TripleCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque());

    public static final Block OAK_WOOD_Four_Grid_Cabinet = registerBlock("oak_wood_four_grid_cabinet", FourGridCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    public static final Block OAK_PLANKS_Four_Grid_Cabinet = registerBlock("oak_plank_four_grid_cabinet", FourGridCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    public static final Block SPRUCE_WOOD_Four_Grid_Cabinet = registerBlock("spruce_wood_four_grid_cabinet", FourGridCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque());
    public static final Block SPRUCE_PLANKS_Four_Grid_Cabinet = registerBlock("spruce_plank_four_grid_cabinet", FourGridCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque());
    public static final Block BIRCH_WOOD_Four_Grid_Cabinet = registerBlock("birch_wood_four_grid_cabinet", FourGridCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque());
    public static final Block BIRCH_PLANKS_Four_Grid_Cabinet = registerBlock("birch_plank_four_grid_cabinet", FourGridCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque());
    public static final Block JUNGLE_WOOD_Four_Grid_Cabinet = registerBlock("jungle_wood_four_grid_cabinet", FourGridCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque());
    public static final Block JUNGLE_PLANKS_Four_Grid_Cabinet = registerBlock("jungle_plank_four_grid_cabinet", FourGridCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque());
    public static final Block ACACIA_WOOD_Four_Grid_Cabinet = registerBlock("acacia_wood_four_grid_cabinet", FourGridCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque());
    public static final Block ACACIA_PLANKS_Four_Grid_Cabinet = registerBlock("acacia_plank_four_grid_cabinet", FourGridCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque());
    public static final Block DARK_OAK_WOOD_Four_Grid_Cabinet = registerBlock("dark_oak_wood_four_grid_cabinet", FourGridCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque());
    public static final Block DARK_OAK_PLANKS_Four_Grid_Cabinet = registerBlock("dark_oak_plank_four_grid_cabinet", FourGridCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque());
    public static final Block MANGROVE_WOOD_Four_Grid_Cabinet = registerBlock("mangrove_wood_four_grid_cabinet", FourGridCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque());
    public static final Block MANGROVE_PLANKS_Four_Grid_Cabinet = registerBlock("mangrove_plank_four_grid_cabinet", FourGridCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque());
    public static final Block CHERRY_WOOD_Four_Grid_Cabinet = registerBlock("cherry_wood_four_grid_cabinet", FourGridCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque());
    public static final Block CHERRY_PLANKS_Four_Grid_Cabinet = registerBlock("cherry_plank_four_grid_cabinet", FourGridCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque());
    public static final Block CRIMSON_HYPHAE_Four_Grid_Cabinet = registerBlock("crimson_wood_four_grid_cabinet", FourGridCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque());
    public static final Block CRIMSON_PLANKS_Four_Grid_Cabinet = registerBlock("crimson_plank_four_grid_cabinet", FourGridCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque());
    public static final Block WARPED_HYPHAE_Four_Grid_Cabinet = registerBlock("warped_wood_four_grid_cabinet", FourGridCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque());
    public static final Block WARPED_PLANKS_Four_Grid_Cabinet = registerBlock("warped_plank_four_grid_cabinet", FourGridCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque());
    public static final Block BAMBOO_BLOCK_Four_Grid_Cabinet = registerBlock("bamboo_wood_four_grid_cabinet", FourGridCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque());
    public static final Block BAMBOO_PLANKS_Four_Grid_Cabinet = registerBlock("bamboo_plank_four_grid_cabinet", FourGridCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque());

    public static final Block WHITE_KITCHEN_COUNTER = registerBlock("white_kitchen_counter", KitchenCounterBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block ORANGE_KITCHEN_COUNTER = registerBlock("orange_kitchen_counter", KitchenCounterBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block MAGENTA_KITCHEN_COUNTER = registerBlock("magenta_kitchen_counter", KitchenCounterBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block LIGHT_BLUE_KITCHEN_COUNTER = registerBlock("light_blue_kitchen_counter", KitchenCounterBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block YELLOW_KITCHEN_COUNTER = registerBlock("yellow_kitchen_counter", KitchenCounterBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block LIME_KITCHEN_COUNTER = registerBlock("lime_kitchen_counter", KitchenCounterBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block PINK_KITCHEN_COUNTER = registerBlock("pink_kitchen_counter", KitchenCounterBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block GRAY_KITCHEN_COUNTER = registerBlock("gray_kitchen_counter", KitchenCounterBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block LIGHT_GRAY_KITCHEN_COUNTER = registerBlock("light_gray_kitchen_counter", KitchenCounterBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block CYAN_KITCHEN_COUNTER = registerBlock("cyan_kitchen_counter", KitchenCounterBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block PURPLE_KITCHEN_COUNTER = registerBlock("purple_kitchen_counter", KitchenCounterBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block BLUE_KITCHEN_COUNTER = registerBlock("blue_kitchen_counter", KitchenCounterBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block BROWN_KITCHEN_COUNTER = registerBlock("brown_kitchen_counter", KitchenCounterBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block GREEN_KITCHEN_COUNTER = registerBlock("green_kitchen_counter", KitchenCounterBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block RED_KITCHEN_COUNTER = registerBlock("red_kitchen_counter", KitchenCounterBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block BLACK_KITCHEN_COUNTER = registerBlock("black_kitchen_counter", KitchenCounterBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());

    public static final Block OAK_PLANKS_KITCHEN_COUNTER = registerBlock("oak_planks_kitchen_counter", KitchenCounterBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    public static final Block OAK_WOOD_KITCHEN_COUNTER = registerBlock("oak_wood_kitchen_counter", KitchenCounterBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    public static final Block SPRUCE_PLANKS_KITCHEN_COUNTER = registerBlock("spruce_planks_kitchen_counter", KitchenCounterBlock::new, AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque());
    public static final Block SPRUCE_WOOD_KITCHEN_COUNTER = registerBlock("spruce_wood_kitchen_counter", KitchenCounterBlock::new, AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque());
    public static final Block BIRCH_PLANKS_KITCHEN_COUNTER = registerBlock("birch_planks_kitchen_counter", KitchenCounterBlock::new, AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque());
    public static final Block BIRCH_WOOD_KITCHEN_COUNTER = registerBlock("birch_wood_kitchen_counter", KitchenCounterBlock::new, AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque());
    public static final Block JUNGLE_PLANKS_KITCHEN_COUNTER = registerBlock("jungle_planks_kitchen_counter", KitchenCounterBlock::new, AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque());
    public static final Block JUNGLE_WOOD_KITCHEN_COUNTER = registerBlock("jungle_wood_kitchen_counter", KitchenCounterBlock::new, AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque());
    public static final Block ACACIA_PLANKS_KITCHEN_COUNTER = registerBlock("acacia_planks_kitchen_counter", KitchenCounterBlock::new, AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque());
    public static final Block ACACIA_WOOD_KITCHEN_COUNTER = registerBlock("acacia_wood_kitchen_counter", KitchenCounterBlock::new, AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque());
    public static final Block DARK_OAK_PLANKS_KITCHEN_COUNTER = registerBlock("dark_oak_planks_kitchen_counter", KitchenCounterBlock::new, AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque());
    public static final Block DARK_OAK_WOOD_KITCHEN_COUNTER = registerBlock("dark_oak_wood_kitchen_counter", KitchenCounterBlock::new, AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque());
    public static final Block MANGROVE_PLANKS_KITCHEN_COUNTER = registerBlock("mangrove_planks_kitchen_counter", KitchenCounterBlock::new, AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque());
    public static final Block MANGROVE_WOOD_KITCHEN_COUNTER = registerBlock("mangrove_wood_kitchen_counter", KitchenCounterBlock::new, AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque());
    public static final Block CHERRY_PLANKS_KITCHEN_COUNTER = registerBlock("cherry_planks_kitchen_counter", KitchenCounterBlock::new, AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque());
    public static final Block CHERRY_WOOD_KITCHEN_COUNTER = registerBlock("cherry_wood_kitchen_counter", KitchenCounterBlock::new, AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque());
    public static final Block CRIMSON_PLANKS_KITCHEN_COUNTER = registerBlock("crimson_planks_kitchen_counter", KitchenCounterBlock::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque());
    public static final Block CRIMSON_HYPHAE_KITCHEN_COUNTER = registerBlock("crimson_wood_kitchen_counter", KitchenCounterBlock::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque());
    public static final Block WARPED_PLANKS_KITCHEN_COUNTER = registerBlock("warped_planks_kitchen_counter", KitchenCounterBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque());
    public static final Block WARPED_HYPHAE_KITCHEN_COUNTER = registerBlock("warped_wood_kitchen_counter", KitchenCounterBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque());
    public static final Block BAMBOO_PLANKS_KITCHEN_COUNTER = registerBlock("bamboo_planks_kitchen_counter", KitchenCounterBlock::new, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque());
    public static final Block BAMBOO_BLOCK_KITCHEN_COUNTER = registerBlock("bamboo_wood_kitchen_counter", KitchenCounterBlock::new, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque());


    //Counter Drawer
    public static final Block WHITE_KITCHEN_COUNTER_DRAWER = registerBlock("white_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block ORANGE_KITCHEN_COUNTER_DRAWER = registerBlock("orange_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block MAGENTA_KITCHEN_COUNTER_DRAWER = registerBlock("magenta_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block LIGHT_BLUE_KITCHEN_COUNTER_DRAWER = registerBlock("light_blue_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block YELLOW_KITCHEN_COUNTER_DRAWER = registerBlock("yellow_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block LIME_KITCHEN_COUNTER_DRAWER = registerBlock("lime_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block PINK_KITCHEN_COUNTER_DRAWER = registerBlock("pink_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block GRAY_KITCHEN_COUNTER_DRAWER = registerBlock("gray_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block LIGHT_GRAY_KITCHEN_COUNTER_DRAWER = registerBlock("light_gray_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block CYAN_KITCHEN_COUNTER_DRAWER = registerBlock("cyan_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block PURPLE_KITCHEN_COUNTER_DRAWER = registerBlock("purple_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block BLUE_KITCHEN_COUNTER_DRAWER = registerBlock("blue_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block BROWN_KITCHEN_COUNTER_DRAWER = registerBlock("brown_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block GREEN_KITCHEN_COUNTER_DRAWER = registerBlock("green_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block RED_KITCHEN_COUNTER_DRAWER = registerBlock("red_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block BLACK_KITCHEN_COUNTER_DRAWER = registerBlock("black_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());

    public static final Block OAK_PLANKS_KITCHEN_COUNTER_DRAWER = registerBlock("oak_planks_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    public static final Block OAK_WOOD_KITCHEN_COUNTER_DRAWER = registerBlock("oak_wood_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    public static final Block SPRUCE_PLANKS_KITCHEN_COUNTER_DRAWER = registerBlock("spruce_planks_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque());
    public static final Block SPRUCE_WOOD_KITCHEN_COUNTER_DRAWER = registerBlock("spruce_wood_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque());
    public static final Block BIRCH_PLANKS_KITCHEN_COUNTER_DRAWER = registerBlock("birch_planks_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque());
    public static final Block BIRCH_WOOD_KITCHEN_COUNTER_DRAWER = registerBlock("birch_wood_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque());
    public static final Block JUNGLE_PLANKS_KITCHEN_COUNTER_DRAWER = registerBlock("jungle_planks_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque());
    public static final Block JUNGLE_WOOD_KITCHEN_COUNTER_DRAWER = registerBlock("jungle_wood_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque());
    public static final Block ACACIA_PLANKS_KITCHEN_COUNTER_DRAWER = registerBlock("acacia_planks_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque());
    public static final Block ACACIA_WOOD_KITCHEN_COUNTER_DRAWER = registerBlock("acacia_wood_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque());
    public static final Block DARK_OAK_PLANKS_KITCHEN_COUNTER_DRAWER = registerBlock("dark_oak_planks_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque());
    public static final Block DARK_OAK_WOOD_KITCHEN_COUNTER_DRAWER = registerBlock("dark_oak_wood_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque());
    public static final Block MANGROVE_PLANKS_KITCHEN_COUNTER_DRAWER = registerBlock("mangrove_planks_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque());
    public static final Block MANGROVE_WOOD_KITCHEN_COUNTER_DRAWER = registerBlock("mangrove_wood_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque());
    public static final Block CHERRY_PLANKS_KITCHEN_COUNTER_DRAWER = registerBlock("cherry_planks_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque());
    public static final Block CHERRY_WOOD_KITCHEN_COUNTER_DRAWER = registerBlock("cherry_wood_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque());
    public static final Block CRIMSON_PLANKS_KITCHEN_COUNTER_DRAWER = registerBlock("crimson_planks_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque());
    public static final Block CRIMSON_HYPHAE_KITCHEN_COUNTER_DRAWER = registerBlock("crimson_wood_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque());
    public static final Block WARPED_PLANKS_KITCHEN_COUNTER_DRAWER = registerBlock("warped_planks_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque());
    public static final Block WARPED_HYPHAE_KITCHEN_COUNTER_DRAWER = registerBlock("warped_wood_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque());
    public static final Block BAMBOO_PLANKS_KITCHEN_COUNTER_DRAWER = registerBlock("bamboo_planks_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque());
    public static final Block BAMBOO_BLOCK_KITCHEN_COUNTER_DRAWER = registerBlock("bamboo_wood_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque());

    public static final Block WHITE_KITCHEN_CABINET = registerBlock("white_kitchen_cabinet", KitchenCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block ORANGE_KITCHEN_CABINET = registerBlock("orange_kitchen_cabinet", KitchenCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block MAGENTA_KITCHEN_CABINET = registerBlock("magenta_kitchen_cabinet", KitchenCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block LIGHT_BLUE_KITCHEN_CABINET = registerBlock("light_blue_kitchen_cabinet", KitchenCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block YELLOW_KITCHEN_CABINET = registerBlock("yellow_kitchen_cabinet", KitchenCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block LIME_KITCHEN_CABINET = registerBlock("lime_kitchen_cabinet", KitchenCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block PINK_KITCHEN_CABINET = registerBlock("pink_kitchen_cabinet", KitchenCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block GRAY_KITCHEN_CABINET = registerBlock("gray_kitchen_cabinet", KitchenCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block LIGHT_GRAY_KITCHEN_CABINET = registerBlock("light_gray_kitchen_cabinet", KitchenCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block CYAN_KITCHEN_CABINET = registerBlock("cyan_kitchen_cabinet", KitchenCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block PURPLE_KITCHEN_CABINET = registerBlock("purple_kitchen_cabinet", KitchenCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block BLUE_KITCHEN_CABINET = registerBlock("blue_kitchen_cabinet", KitchenCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block BROWN_KITCHEN_CABINET = registerBlock("brown_kitchen_cabinet", KitchenCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block GREEN_KITCHEN_CABINET = registerBlock("green_kitchen_cabinet", KitchenCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block RED_KITCHEN_CABINET = registerBlock("red_kitchen_cabinet", KitchenCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());
    public static final Block BLACK_KITCHEN_CABINET = registerBlock("black_kitchen_cabinet", KitchenCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).nonOpaque());

    public static final Block OAK_PLANKS_KITCHEN_CABINET = registerBlock("oak_planks_kitchen_cabinet", KitchenCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    public static final Block OAK_WOOD_KITCHEN_CABINET = registerBlock("oak_wood_kitchen_cabinet", KitchenCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    public static final Block SPRUCE_PLANKS_KITCHEN_CABINET = registerBlock("spruce_planks_kitchen_cabinet", KitchenCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque());
    public static final Block SPRUCE_WOOD_KITCHEN_CABINET = registerBlock("spruce_wood_kitchen_cabinet", KitchenCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque());
    public static final Block BIRCH_PLANKS_KITCHEN_CABINET = registerBlock("birch_planks_kitchen_cabinet", KitchenCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque());
    public static final Block BIRCH_WOOD_KITCHEN_CABINET = registerBlock("birch_wood_kitchen_cabinet", KitchenCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque());
    public static final Block JUNGLE_PLANKS_KITCHEN_CABINET = registerBlock("jungle_planks_kitchen_cabinet", KitchenCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque());
    public static final Block JUNGLE_WOOD_KITCHEN_CABINET = registerBlock("jungle_wood_kitchen_cabinet", KitchenCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque());
    public static final Block ACACIA_PLANKS_KITCHEN_CABINET = registerBlock("acacia_planks_kitchen_cabinet", KitchenCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque());
    public static final Block ACACIA_WOOD_KITCHEN_CABINET = registerBlock("acacia_wood_kitchen_cabinet", KitchenCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque());
    public static final Block DARK_OAK_PLANKS_KITCHEN_CABINET = registerBlock("dark_oak_planks_kitchen_cabinet", KitchenCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque());
    public static final Block DARK_OAK_WOOD_KITCHEN_CABINET = registerBlock("dark_oak_wood_kitchen_cabinet", KitchenCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque());
    public static final Block MANGROVE_PLANKS_KITCHEN_CABINET = registerBlock("mangrove_planks_kitchen_cabinet", KitchenCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque());
    public static final Block MANGROVE_WOOD_KITCHEN_CABINET = registerBlock("mangrove_wood_kitchen_cabinet", KitchenCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque());
    public static final Block CHERRY_PLANKS_KITCHEN_CABINET = registerBlock("cherry_planks_kitchen_cabinet", KitchenCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque());
    public static final Block CHERRY_WOOD_KITCHEN_CABINET = registerBlock("cherry_wood_kitchen_cabinet", KitchenCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque());
    public static final Block CRIMSON_PLANKS_KITCHEN_CABINET = registerBlock("crimson_planks_kitchen_cabinet", KitchenCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque());
    public static final Block CRIMSON_HYPHAE_KITCHEN_CABINET = registerBlock("crimson_wood_kitchen_cabinet", KitchenCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque());
    public static final Block WARPED_PLANKS_KITCHEN_CABINET = registerBlock("warped_planks_kitchen_cabinet", KitchenCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque());
    public static final Block WARPED_HYPHAE_KITCHEN_CABINET = registerBlock("warped_wood_kitchen_cabinet", KitchenCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque());
    public static final Block BAMBOO_PLANKS_KITCHEN_CABINET = registerBlock("bamboo_planks_kitchen_cabinet", KitchenCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque());
    public static final Block BAMBOO_BLOCK_KITCHEN_CABINET = registerBlock("bamboo_wood_kitchen_cabinet", KitchenCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque());


    public static final Block OAK_PLANKS_BEDSIDE_CABINET = registerBlock("oak_planks_bedside_cabinet", BedsideCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    public static final Block OAK_WOOD_BEDSIDE_CABINET = registerBlock("oak_wood_bedside_cabinet", BedsideCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    public static final Block SPRUCE_PLANKS_BEDSIDE_CABINET = registerBlock("spruce_planks_bedside_cabinet", BedsideCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque());
    public static final Block SPRUCE_WOOD_BEDSIDE_CABINET = registerBlock("spruce_wood_bedside_cabinet", BedsideCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque());
    public static final Block BIRCH_PLANKS_BEDSIDE_CABINET = registerBlock("birch_planks_bedside_cabinet", BedsideCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque());
    public static final Block BIRCH_WOOD_BEDSIDE_CABINET = registerBlock("birch_wood_bedside_cabinet", BedsideCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque());
    public static final Block JUNGLE_PLANKS_BEDSIDE_CABINET = registerBlock("jungle_planks_bedside_cabinet", BedsideCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque());
    public static final Block JUNGLE_WOOD_BEDSIDE_CABINET = registerBlock("jungle_wood_bedside_cabinet", BedsideCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque());
    public static final Block ACACIA_PLANKS_BEDSIDE_CABINET = registerBlock("acacia_planks_bedside_cabinet", BedsideCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque());
    public static final Block ACACIA_WOOD_BEDSIDE_CABINET = registerBlock("acacia_wood_bedside_cabinet", BedsideCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque());
    public static final Block DARK_OAK_PLANKS_BEDSIDE_CABINET = registerBlock("dark_oak_planks_bedside_cabinet", BedsideCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque());
    public static final Block DARK_OAK_WOOD_BEDSIDE_CABINET = registerBlock("dark_oak_wood_bedside_cabinet", BedsideCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque());
    public static final Block MANGROVE_PLANKS_BEDSIDE_CABINET = registerBlock("mangrove_planks_bedside_cabinet", BedsideCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque());
    public static final Block MANGROVE_WOOD_BEDSIDE_CABINET = registerBlock("mangrove_wood_bedside_cabinet", BedsideCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque());
    public static final Block CHERRY_PLANKS_BEDSIDE_CABINET = registerBlock("cherry_planks_bedside_cabinet", BedsideCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque());
    public static final Block CHERRY_WOOD_BEDSIDE_CABINET = registerBlock("cherry_wood_bedside_cabinet", BedsideCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque());
    public static final Block CRIMSON_PLANKS_BEDSIDE_CABINET = registerBlock("crimson_planks_bedside_cabinet", BedsideCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque());
    public static final Block CRIMSON_HYPHAE_BEDSIDE_CABINET = registerBlock("crimson_wood_bedside_cabinet", BedsideCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque());
    public static final Block WARPED_PLANKS_BEDSIDE_CABINET = registerBlock("warped_planks_bedside_cabinet", BedsideCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque());
    public static final Block WARPED_HYPHAE_BEDSIDE_CABINET = registerBlock("warped_wood_bedside_cabinet", BedsideCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque());
    public static final Block BAMBOO_PLANKS_BEDSIDE_CABINET = registerBlock("bamboo_planks_bedside_cabinet", BedsideCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque());
    public static final Block BAMBOO_BLOCK_BEDSIDE_CABINET = registerBlock("bamboo_wood_bedside_cabinet", BedsideCabinetBlock::new, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque());

    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Block block = (Block)factory.apply(settings.registryKey(keyOf(name)));
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, keyOf(name), block);
    }


    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Furniture.MOD_ID, name)),
                new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Furniture.MOD_ID, name)))));
    }

    private static Block registerBlockWithoutItem(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Block block = (Block)factory.apply(settings.registryKey(keyOf(name)));
        return Registry.register(Registries.BLOCK, keyOf(name), block);
    }

    private static RegistryKey<Block> keyOf(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Furniture.MOD_ID, name));
    }

    public static void registerCushionBlocks() {
        Furniture.LOGGER.debug("Registering Cushion Blocks for " + Furniture.MOD_ID);
    }
}
