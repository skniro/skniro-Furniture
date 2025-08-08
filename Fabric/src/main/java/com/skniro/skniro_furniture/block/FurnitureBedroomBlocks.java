package com.skniro.skniro_furniture.block;

import com.skniro.skniro_furniture.Furniture;
import com.skniro.skniro_furniture.block.init.BedsideCabinetBlock;
import com.skniro.skniro_furniture.block.init.DeskBlock;
import com.skniro.skniro_furniture.block.init.DeskCabinetBlock;
import com.skniro.skniro_furniture.block.init.DeskLampBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.minecraft.block.Blocks.createLightLevelFromLitBlockState;

public class FurnitureBedroomBlocks {
    public static final Block OAK_PLANKS_BEDSIDE_CABINET = registerBlock("oak_planks_bedside_cabinet", new BedsideCabinetBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()));
    public static final Block OAK_WOOD_BEDSIDE_CABINET = registerBlock("oak_wood_bedside_cabinet", new BedsideCabinetBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()));
    public static final Block SPRUCE_PLANKS_BEDSIDE_CABINET = registerBlock("spruce_planks_bedside_cabinet", new BedsideCabinetBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque()));
    public static final Block SPRUCE_WOOD_BEDSIDE_CABINET = registerBlock("spruce_wood_bedside_cabinet", new BedsideCabinetBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque()));
    public static final Block BIRCH_PLANKS_BEDSIDE_CABINET = registerBlock("birch_planks_bedside_cabinet", new BedsideCabinetBlock(AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque()));
    public static final Block BIRCH_WOOD_BEDSIDE_CABINET = registerBlock("birch_wood_bedside_cabinet", new BedsideCabinetBlock(AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque()));
    public static final Block JUNGLE_PLANKS_BEDSIDE_CABINET = registerBlock("jungle_planks_bedside_cabinet", new BedsideCabinetBlock(AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque()));
    public static final Block JUNGLE_WOOD_BEDSIDE_CABINET = registerBlock("jungle_wood_bedside_cabinet", new BedsideCabinetBlock(AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque()));
    public static final Block ACACIA_PLANKS_BEDSIDE_CABINET = registerBlock("acacia_planks_bedside_cabinet", new BedsideCabinetBlock(AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque()));
    public static final Block ACACIA_WOOD_BEDSIDE_CABINET = registerBlock("acacia_wood_bedside_cabinet", new BedsideCabinetBlock(AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque()));
    public static final Block DARK_OAK_PLANKS_BEDSIDE_CABINET = registerBlock("dark_oak_planks_bedside_cabinet", new BedsideCabinetBlock(AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque()));
    public static final Block DARK_OAK_WOOD_BEDSIDE_CABINET = registerBlock("dark_oak_wood_bedside_cabinet", new BedsideCabinetBlock(AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque()));
    public static final Block MANGROVE_PLANKS_BEDSIDE_CABINET = registerBlock("mangrove_planks_bedside_cabinet", new BedsideCabinetBlock(AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque()));
    public static final Block MANGROVE_WOOD_BEDSIDE_CABINET = registerBlock("mangrove_wood_bedside_cabinet", new BedsideCabinetBlock(AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque()));
    public static final Block CHERRY_PLANKS_BEDSIDE_CABINET = registerBlock("cherry_planks_bedside_cabinet", new BedsideCabinetBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque()));
    public static final Block CHERRY_WOOD_BEDSIDE_CABINET = registerBlock("cherry_wood_bedside_cabinet", new BedsideCabinetBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque()));
    public static final Block CRIMSON_PLANKS_BEDSIDE_CABINET = registerBlock("crimson_planks_bedside_cabinet", new BedsideCabinetBlock(AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque()));
    public static final Block CRIMSON_HYPHAE_BEDSIDE_CABINET = registerBlock("crimson_wood_bedside_cabinet", new BedsideCabinetBlock(AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque()));
    public static final Block WARPED_PLANKS_BEDSIDE_CABINET = registerBlock("warped_planks_bedside_cabinet", new BedsideCabinetBlock(AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque()));
    public static final Block WARPED_HYPHAE_BEDSIDE_CABINET = registerBlock("warped_wood_bedside_cabinet", new BedsideCabinetBlock(AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque()));
    public static final Block BAMBOO_PLANKS_BEDSIDE_CABINET = registerBlock("bamboo_planks_bedside_cabinet", new BedsideCabinetBlock(AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque()));
    public static final Block BAMBOO_BLOCK_BEDSIDE_CABINET = registerBlock("bamboo_wood_bedside_cabinet", new BedsideCabinetBlock(AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque()));

    public static final Block OAK_PLANKS_Desk_CABINET = registerBlock("oak_planks_desk_cabinet", new DeskCabinetBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()));
    public static final Block OAK_WOOD_Desk_CABINET = registerBlock("oak_wood_desk_cabinet", new DeskCabinetBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()));
    public static final Block SPRUCE_PLANKS_Desk_CABINET = registerBlock("spruce_planks_desk_cabinet", new DeskCabinetBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque()));
    public static final Block SPRUCE_WOOD_Desk_CABINET = registerBlock("spruce_wood_desk_cabinet", new DeskCabinetBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque()));
    public static final Block BIRCH_PLANKS_Desk_CABINET = registerBlock("birch_planks_desk_cabinet", new DeskCabinetBlock(AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque()));
    public static final Block BIRCH_WOOD_Desk_CABINET = registerBlock("birch_wood_desk_cabinet", new DeskCabinetBlock(AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque()));
    public static final Block JUNGLE_PLANKS_Desk_CABINET = registerBlock("jungle_planks_desk_cabinet", new DeskCabinetBlock(AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque()));
    public static final Block JUNGLE_WOOD_Desk_CABINET = registerBlock("jungle_wood_desk_cabinet", new DeskCabinetBlock(AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque()));
    public static final Block ACACIA_PLANKS_Desk_CABINET = registerBlock("acacia_planks_desk_cabinet", new DeskCabinetBlock(AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque()));
    public static final Block ACACIA_WOOD_Desk_CABINET = registerBlock("acacia_wood_desk_cabinet", new DeskCabinetBlock(AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque()));
    public static final Block DARK_OAK_PLANKS_Desk_CABINET = registerBlock("dark_oak_planks_desk_cabinet", new DeskCabinetBlock(AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque()));
    public static final Block DARK_OAK_WOOD_Desk_CABINET = registerBlock("dark_oak_wood_desk_cabinet", new DeskCabinetBlock(AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque()));
    public static final Block MANGROVE_PLANKS_Desk_CABINET = registerBlock("mangrove_planks_desk_cabinet", new DeskCabinetBlock(AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque()));
    public static final Block MANGROVE_WOOD_Desk_CABINET = registerBlock("mangrove_wood_desk_cabinet", new DeskCabinetBlock(AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque()));
    public static final Block CHERRY_PLANKS_Desk_CABINET = registerBlock("cherry_planks_desk_cabinet", new DeskCabinetBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque()));
    public static final Block CHERRY_WOOD_Desk_CABINET = registerBlock("cherry_wood_desk_cabinet", new DeskCabinetBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque()));
    public static final Block CRIMSON_PLANKS_Desk_CABINET = registerBlock("crimson_planks_desk_cabinet", new DeskCabinetBlock(AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque()));
    public static final Block CRIMSON_HYPHAE_Desk_CABINET = registerBlock("crimson_wood_desk_cabinet", new DeskCabinetBlock(AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque()));
    public static final Block WARPED_PLANKS_Desk_CABINET = registerBlock("warped_planks_desk_cabinet", new DeskCabinetBlock(AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque()));
    public static final Block WARPED_HYPHAE_Desk_CABINET = registerBlock("warped_wood_desk_cabinet", new DeskCabinetBlock(AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque()));
    public static final Block BAMBOO_PLANKS_Desk_CABINET = registerBlock("bamboo_planks_desk_cabinet", new DeskCabinetBlock(AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque()));
    public static final Block BAMBOO_BLOCK_Desk_CABINET = registerBlock("bamboo_wood_desk_cabinet", new DeskCabinetBlock(AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque()));

    public static final Block OAK_PLANKS_BOOK_Desk = registerBlock("oak_planks_book_desk", new DeskBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()));
    public static final Block OAK_WOOD_BOOK_Desk = registerBlock("oak_wood_book_desk", new DeskBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()));
    public static final Block SPRUCE_PLANKS_BOOK_Desk = registerBlock("spruce_planks_book_desk", new DeskBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque()));
    public static final Block SPRUCE_WOOD_BOOK_Desk = registerBlock("spruce_wood_book_desk", new DeskBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque()));
    public static final Block BIRCH_PLANKS_BOOK_Desk = registerBlock("birch_planks_book_desk", new DeskBlock(AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque()));
    public static final Block BIRCH_WOOD_BOOK_Desk = registerBlock("birch_wood_book_desk", new DeskBlock(AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque()));
    public static final Block JUNGLE_PLANKS_BOOK_Desk = registerBlock("jungle_planks_book_desk", new DeskBlock(AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque()));
    public static final Block JUNGLE_WOOD_BOOK_Desk = registerBlock("jungle_wood_book_desk", new DeskBlock(AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque()));
    public static final Block ACACIA_PLANKS_BOOK_Desk = registerBlock("acacia_planks_book_desk", new DeskBlock(AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque()));
    public static final Block ACACIA_WOOD_BOOK_Desk = registerBlock("acacia_wood_book_desk", new DeskBlock(AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque()));
    public static final Block DARK_OAK_PLANKS_BOOK_Desk = registerBlock("dark_oak_planks_book_desk", new DeskBlock(AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque()));
    public static final Block DARK_OAK_WOOD_BOOK_Desk = registerBlock("dark_oak_wood_book_desk", new DeskBlock(AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque()));
    public static final Block MANGROVE_PLANKS_BOOK_Desk = registerBlock("mangrove_planks_book_desk", new DeskBlock(AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque()));
    public static final Block MANGROVE_WOOD_BOOK_Desk = registerBlock("mangrove_wood_book_desk", new DeskBlock(AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque()));
    public static final Block CHERRY_PLANKS_BOOK_Desk = registerBlock("cherry_planks_book_desk", new DeskBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque()));
    public static final Block CHERRY_WOOD_BOOK_Desk = registerBlock("cherry_wood_book_desk", new DeskBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque()));
    public static final Block CRIMSON_PLANKS_BOOK_Desk = registerBlock("crimson_planks_book_desk", new DeskBlock(AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque()));
    public static final Block CRIMSON_HYPHAE_BOOK_Desk = registerBlock("crimson_wood_book_desk", new DeskBlock(AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque()));
    public static final Block WARPED_PLANKS_BOOK_Desk = registerBlock("warped_planks_book_desk", new DeskBlock(AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque()));
    public static final Block WARPED_HYPHAE_BOOK_Desk = registerBlock("warped_wood_book_desk", new DeskBlock(AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque()));
    public static final Block BAMBOO_PLANKS_BOOK_Desk = registerBlock("bamboo_planks_book_desk", new DeskBlock(AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque()));
    public static final Block BAMBOO_BLOCK_BOOK_Desk = registerBlock("bamboo_wood_book_desk", new DeskBlock(AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque()));

    public static final Block White_Desk_Lamp = registerBlock("white_desk_lamp", new DeskLampBlock(AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).luminance(createLightLevelFromLitBlockState(15)).strength(0.3F).nonOpaque()));
    public static final Block Orange_Desk_Lamp = registerBlock("orange_desk_lamp", new DeskLampBlock(AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).luminance(createLightLevelFromLitBlockState(15)).strength(0.3F).nonOpaque()));
    public static final Block Magenta_Desk_Lamp = registerBlock("magenta_desk_lamp", new DeskLampBlock(AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).luminance(createLightLevelFromLitBlockState(15)).strength(0.3F).nonOpaque()));
    public static final Block LightBlue_Desk_Lamp = registerBlock("light_blue_desk_lamp", new DeskLampBlock(AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).luminance(createLightLevelFromLitBlockState(15)).strength(0.3F).nonOpaque()));
    public static final Block Yellow_Desk_Lamp = registerBlock("yellow_desk_lamp", new DeskLampBlock(AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).luminance(createLightLevelFromLitBlockState(15)).strength(0.3F).nonOpaque()));
    public static final Block Lime_Desk_Lamp = registerBlock("lime_desk_lamp", new DeskLampBlock(AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).luminance(createLightLevelFromLitBlockState(15)).strength(0.3F).nonOpaque()));
    public static final Block Pink_Desk_Lamp = registerBlock("pink_desk_lamp", new DeskLampBlock(AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).luminance(createLightLevelFromLitBlockState(15)).strength(0.3F).nonOpaque()));
    public static final Block Gray_Desk_Lamp = registerBlock("gray_desk_lamp", new DeskLampBlock(AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).luminance(createLightLevelFromLitBlockState(15)).strength(0.3F).nonOpaque()));
    public static final Block LightGray_Desk_Lamp = registerBlock("light_gray_desk_lamp", new DeskLampBlock(AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).luminance(createLightLevelFromLitBlockState(15)).strength(0.3F).nonOpaque()));
    public static final Block Cyan_Desk_Lamp = registerBlock("cyan_desk_lamp", new DeskLampBlock(AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).luminance(createLightLevelFromLitBlockState(15)).strength(0.3F).nonOpaque()));
    public static final Block Purple_Desk_Lamp = registerBlock("purple_desk_lamp", new DeskLampBlock(AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).luminance(createLightLevelFromLitBlockState(15)).strength(0.3F).nonOpaque()));
    public static final Block Blue_Desk_Lamp = registerBlock("blue_desk_lamp", new DeskLampBlock(AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).luminance(createLightLevelFromLitBlockState(15)).strength(0.3F).nonOpaque()));
    public static final Block Brown_Desk_Lamp = registerBlock("brown_desk_lamp", new DeskLampBlock(AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).luminance(createLightLevelFromLitBlockState(15)).strength(0.3F).nonOpaque()));
    public static final Block Green_Desk_Lamp = registerBlock("green_desk_lamp", new DeskLampBlock(AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).luminance(createLightLevelFromLitBlockState(15)).strength(0.3F).nonOpaque()));
    public static final Block Red_Desk_Lamp = registerBlock("red_desk_lamp", new DeskLampBlock(AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).luminance(createLightLevelFromLitBlockState(15)).strength(0.3F).nonOpaque()));
    public static final Block Black_Desk_Lamp = registerBlock("black_desk_lamp", new DeskLampBlock(AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).luminance(createLightLevelFromLitBlockState(15)).strength(0.3F).nonOpaque()));


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

    public static void registerBedroomBlocks() {
        Furniture.LOGGER.debug("Registering Bedroom Blocks for " + Furniture.MOD_ID);
    }
}
