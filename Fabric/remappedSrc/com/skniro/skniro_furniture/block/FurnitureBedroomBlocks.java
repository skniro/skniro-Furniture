package com.skniro.skniro_furniture.block;

import com.skniro.skniro_furniture.Furniture;
import com.skniro.skniro_furniture.block.init.BedsideCabinetBlock;
import com.skniro.skniro_furniture.block.init.DeskBlock;
import com.skniro.skniro_furniture.block.init.DeskCabinetBlock;
import java.util.function.Function;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class FurnitureBedroomBlocks {
    public static final Block OAK_PLANKS_BEDSIDE_CABINET = registerBlock("oak_planks_bedside_cabinet", BedsideCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final Block OAK_WOOD_BEDSIDE_CABINET = registerBlock("oak_wood_bedside_cabinet", BedsideCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final Block PALE_OAK_PLANKS_BEDSIDE_CABINET = registerBlock("pale_oak_planks_bedside_cabinet", BedsideCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_PLANKS).noOcclusion());
    public static final Block PALE_OAK_WOOD_BEDSIDE_CABINET = registerBlock("pale_oak_wood_bedside_cabinet", BedsideCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_PLANKS).noOcclusion());
    public static final Block SPRUCE_PLANKS_BEDSIDE_CABINET = registerBlock("spruce_planks_bedside_cabinet", BedsideCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion());
    public static final Block SPRUCE_WOOD_BEDSIDE_CABINET = registerBlock("spruce_wood_bedside_cabinet", BedsideCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion());
    public static final Block BIRCH_PLANKS_BEDSIDE_CABINET = registerBlock("birch_planks_bedside_cabinet", BedsideCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion());
    public static final Block BIRCH_WOOD_BEDSIDE_CABINET = registerBlock("birch_wood_bedside_cabinet", BedsideCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion());
    public static final Block JUNGLE_PLANKS_BEDSIDE_CABINET = registerBlock("jungle_planks_bedside_cabinet", BedsideCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion());
    public static final Block JUNGLE_WOOD_BEDSIDE_CABINET = registerBlock("jungle_wood_bedside_cabinet", BedsideCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion());
    public static final Block ACACIA_PLANKS_BEDSIDE_CABINET = registerBlock("acacia_planks_bedside_cabinet", BedsideCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion());
    public static final Block ACACIA_WOOD_BEDSIDE_CABINET = registerBlock("acacia_wood_bedside_cabinet", BedsideCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion());
    public static final Block DARK_OAK_PLANKS_BEDSIDE_CABINET = registerBlock("dark_oak_planks_bedside_cabinet", BedsideCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion());
    public static final Block DARK_OAK_WOOD_BEDSIDE_CABINET = registerBlock("dark_oak_wood_bedside_cabinet", BedsideCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion());
    public static final Block MANGROVE_PLANKS_BEDSIDE_CABINET = registerBlock("mangrove_planks_bedside_cabinet", BedsideCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion());
    public static final Block MANGROVE_WOOD_BEDSIDE_CABINET = registerBlock("mangrove_wood_bedside_cabinet", BedsideCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion());
    public static final Block CHERRY_PLANKS_BEDSIDE_CABINET = registerBlock("cherry_planks_bedside_cabinet", BedsideCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion());
    public static final Block CHERRY_WOOD_BEDSIDE_CABINET = registerBlock("cherry_wood_bedside_cabinet", BedsideCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion());
    public static final Block CRIMSON_PLANKS_BEDSIDE_CABINET = registerBlock("crimson_planks_bedside_cabinet", BedsideCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion());
    public static final Block CRIMSON_HYPHAE_BEDSIDE_CABINET = registerBlock("crimson_wood_bedside_cabinet", BedsideCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion());
    public static final Block WARPED_PLANKS_BEDSIDE_CABINET = registerBlock("warped_planks_bedside_cabinet", BedsideCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion());
    public static final Block WARPED_HYPHAE_BEDSIDE_CABINET = registerBlock("warped_wood_bedside_cabinet", BedsideCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion());
    public static final Block BAMBOO_PLANKS_BEDSIDE_CABINET = registerBlock("bamboo_planks_bedside_cabinet", BedsideCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion());
    public static final Block BAMBOO_BLOCK_BEDSIDE_CABINET = registerBlock("bamboo_wood_bedside_cabinet", BedsideCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion());

    public static final Block OAK_PLANKS_Desk_CABINET = registerBlock("oak_planks_desk_cabinet", DeskCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final Block OAK_WOOD_Desk_CABINET = registerBlock("oak_wood_desk_cabinet", DeskCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final Block PALE_OAK_PLANKS_Desk_CABINET = registerBlock("pale_oak_planks_desk_cabinet", DeskCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_PLANKS).noOcclusion());
    public static final Block PALE_OAK_WOOD_Desk_CABINET = registerBlock("pale_oak_wood_desk_cabinet", DeskCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_PLANKS).noOcclusion());
    public static final Block SPRUCE_PLANKS_Desk_CABINET = registerBlock("spruce_planks_desk_cabinet", DeskCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion());
    public static final Block SPRUCE_WOOD_Desk_CABINET = registerBlock("spruce_wood_desk_cabinet", DeskCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion());
    public static final Block BIRCH_PLANKS_Desk_CABINET = registerBlock("birch_planks_desk_cabinet", DeskCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion());
    public static final Block BIRCH_WOOD_Desk_CABINET = registerBlock("birch_wood_desk_cabinet", DeskCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion());
    public static final Block JUNGLE_PLANKS_Desk_CABINET = registerBlock("jungle_planks_desk_cabinet", DeskCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion());
    public static final Block JUNGLE_WOOD_Desk_CABINET = registerBlock("jungle_wood_desk_cabinet", DeskCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion());
    public static final Block ACACIA_PLANKS_Desk_CABINET = registerBlock("acacia_planks_desk_cabinet", DeskCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion());
    public static final Block ACACIA_WOOD_Desk_CABINET = registerBlock("acacia_wood_desk_cabinet", DeskCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion());
    public static final Block DARK_OAK_PLANKS_Desk_CABINET = registerBlock("dark_oak_planks_desk_cabinet", DeskCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion());
    public static final Block DARK_OAK_WOOD_Desk_CABINET = registerBlock("dark_oak_wood_desk_cabinet", DeskCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion());
    public static final Block MANGROVE_PLANKS_Desk_CABINET = registerBlock("mangrove_planks_desk_cabinet", DeskCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion());
    public static final Block MANGROVE_WOOD_Desk_CABINET = registerBlock("mangrove_wood_desk_cabinet", DeskCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion());
    public static final Block CHERRY_PLANKS_Desk_CABINET = registerBlock("cherry_planks_desk_cabinet", DeskCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion());
    public static final Block CHERRY_WOOD_Desk_CABINET = registerBlock("cherry_wood_desk_cabinet", DeskCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion());
    public static final Block CRIMSON_PLANKS_Desk_CABINET = registerBlock("crimson_planks_desk_cabinet", DeskCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion());
    public static final Block CRIMSON_HYPHAE_Desk_CABINET = registerBlock("crimson_wood_desk_cabinet", DeskCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion());
    public static final Block WARPED_PLANKS_Desk_CABINET = registerBlock("warped_planks_desk_cabinet", DeskCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion());
    public static final Block WARPED_HYPHAE_Desk_CABINET = registerBlock("warped_wood_desk_cabinet", DeskCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion());
    public static final Block BAMBOO_PLANKS_Desk_CABINET = registerBlock("bamboo_planks_desk_cabinet", DeskCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion());
    public static final Block BAMBOO_BLOCK_Desk_CABINET = registerBlock("bamboo_wood_desk_cabinet", DeskCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion());

    public static final Block OAK_PLANKS_BOOK_Desk = registerBlock("oak_planks_book_desk", DeskBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final Block OAK_WOOD_BOOK_Desk = registerBlock("oak_wood_book_desk", DeskBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final Block PALE_OAK_PLANKS_BOOK_Desk = registerBlock("pale_oak_planks_book_desk", DeskBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_PLANKS).noOcclusion());
    public static final Block PALE_OAK_WOOD_BOOK_Desk = registerBlock("pale_oak_wood_book_desk", DeskBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_PLANKS).noOcclusion());
    public static final Block SPRUCE_PLANKS_BOOK_Desk = registerBlock("spruce_planks_book_desk", DeskBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion());
    public static final Block SPRUCE_WOOD_BOOK_Desk = registerBlock("spruce_wood_book_desk", DeskBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion());
    public static final Block BIRCH_PLANKS_BOOK_Desk = registerBlock("birch_planks_book_desk", DeskBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion());
    public static final Block BIRCH_WOOD_BOOK_Desk = registerBlock("birch_wood_book_desk", DeskBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion());
    public static final Block JUNGLE_PLANKS_BOOK_Desk = registerBlock("jungle_planks_book_desk", DeskBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion());
    public static final Block JUNGLE_WOOD_BOOK_Desk = registerBlock("jungle_wood_book_desk", DeskBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion());
    public static final Block ACACIA_PLANKS_BOOK_Desk = registerBlock("acacia_planks_book_desk", DeskBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion());
    public static final Block ACACIA_WOOD_BOOK_Desk = registerBlock("acacia_wood_book_desk", DeskBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion());
    public static final Block DARK_OAK_PLANKS_BOOK_Desk = registerBlock("dark_oak_planks_book_desk", DeskBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion());
    public static final Block DARK_OAK_WOOD_BOOK_Desk = registerBlock("dark_oak_wood_book_desk", DeskBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion());
    public static final Block MANGROVE_PLANKS_BOOK_Desk = registerBlock("mangrove_planks_book_desk", DeskBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion());
    public static final Block MANGROVE_WOOD_BOOK_Desk = registerBlock("mangrove_wood_book_desk", DeskBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion());
    public static final Block CHERRY_PLANKS_BOOK_Desk = registerBlock("cherry_planks_book_desk", DeskBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion());
    public static final Block CHERRY_WOOD_BOOK_Desk = registerBlock("cherry_wood_book_desk", DeskBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion());
    public static final Block CRIMSON_PLANKS_BOOK_Desk = registerBlock("crimson_planks_book_desk", DeskBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion());
    public static final Block CRIMSON_HYPHAE_BOOK_Desk = registerBlock("crimson_wood_book_desk", DeskBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion());
    public static final Block WARPED_PLANKS_BOOK_Desk = registerBlock("warped_planks_book_desk", DeskBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion());
    public static final Block WARPED_HYPHAE_BOOK_Desk = registerBlock("warped_wood_book_desk", DeskBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion());
    public static final Block BAMBOO_PLANKS_BOOK_Desk = registerBlock("bamboo_planks_book_desk", DeskBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion());
    public static final Block BAMBOO_BLOCK_BOOK_Desk = registerBlock("bamboo_wood_book_desk", DeskBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion());








    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties settings) {
        Block block = (Block)factory.apply(settings.setId(keyOf(name)));
        registerBlockItem(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, keyOf(name), block);
    }


    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(BuiltInRegistries.ITEM, ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Furniture.MOD_ID, name)),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Furniture.MOD_ID, name)))));
    }

    private static Block registerBlockWithoutItem(String name, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties settings) {
        Block block = (Block)factory.apply(settings.setId(keyOf(name)));
        return Registry.register(BuiltInRegistries.BLOCK, keyOf(name), block);
    }

    private static ResourceKey<Block> keyOf(String name) {
        return ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Furniture.MOD_ID, name));
    }

    public static void registerBedroomBlocks() {
        Furniture.LOGGER.debug("Registering Bedroom Blocks for " + Furniture.MOD_ID);
    }
}
