package com.skniro.skniro_furniture.block;

import com.skniro.skniro_furniture.Furniture;
import com.skniro.skniro_furniture.block.init.TvStandBlock;
import com.skniro.skniro_furniture.block.init.SofaBlock;
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

public class FurnitureLivingroomBlocks {
    //Sofa Blocks
    public static final Block Sofa_WHITE = registerBlock("white_sofa", SofaBlock::new, (BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).noOcclusion()));
    public static final Block Sofa_ORANGE = registerBlock("orange_sofa", SofaBlock::new, (BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_WOOL).noOcclusion()));
    public static final Block Sofa_MAGENTA = registerBlock("magenta_sofa", SofaBlock::new, (BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_WOOL).noOcclusion()));
    public static final Block Sofa_LIGHT_BLUE = registerBlock("light_blue_sofa", SofaBlock::new, (BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_WOOL).noOcclusion()));
    public static final Block Sofa_YELLOW = registerBlock("yellow_sofa", SofaBlock::new, (BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_WOOL).noOcclusion()));
    public static final Block Sofa_LIME = registerBlock("lime_sofa", SofaBlock::new, (BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_WOOL).noOcclusion()));
    public static final Block Sofa_PINK = registerBlock("pink_sofa", SofaBlock::new, (BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_WOOL).noOcclusion()));
    public static final Block Sofa_GRAY = registerBlock("gray_sofa", SofaBlock::new, (BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_WOOL).noOcclusion()));
    public static final Block Sofa_LIGHT_GRAY = registerBlock("light_gray_sofa", SofaBlock::new, (BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_WOOL).noOcclusion()));
    public static final Block Sofa_CYAN = registerBlock("cyan_sofa", SofaBlock::new, (BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_WOOL).noOcclusion()));
    public static final Block Sofa_PURPLE = registerBlock("purple_sofa", SofaBlock::new, (BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_WOOL).noOcclusion()));
    public static final Block Sofa_BLUE = registerBlock("blue_sofa", SofaBlock::new, (BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_WOOL).noOcclusion()));
    public static final Block Sofa_BROWN = registerBlock("brown_sofa", SofaBlock::new, (BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_WOOL).noOcclusion()));
    public static final Block Sofa_GREEN = registerBlock("green_sofa", SofaBlock::new, (BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_WOOL).noOcclusion()));
    public static final Block Sofa_RED = registerBlock("red_sofa", SofaBlock::new, (BlockBehaviour.Properties.ofFullCopy(Blocks.RED_WOOL).noOcclusion()));
    public static final Block Sofa_BLACK = registerBlock("black_sofa", SofaBlock::new, (BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_WOOL).noOcclusion()));

    public static final Block OAK_PLANKS_TV_STAND = registerBlock("oak_planks_tv_stand", TvStandBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final Block OAK_WOOD_TV_STAND = registerBlock("oak_wood_tv_stand", TvStandBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final Block PALE_OAK_PLANKS_TV_STAND = registerBlock("pale_oak_planks_tv_stand", TvStandBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_PLANKS).noOcclusion());
    public static final Block PALE_OAK_WOOD_TV_STAND = registerBlock("pale_oak_wood_tv_stand", TvStandBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_PLANKS).noOcclusion());
    public static final Block SPRUCE_PLANKS_TV_STAND = registerBlock("spruce_planks_tv_stand", TvStandBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion());
    public static final Block SPRUCE_WOOD_TV_STAND = registerBlock("spruce_wood_tv_stand", TvStandBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion());
    public static final Block BIRCH_PLANKS_TV_STAND = registerBlock("birch_planks_tv_stand", TvStandBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion());
    public static final Block BIRCH_WOOD_TV_STAND = registerBlock("birch_wood_tv_stand", TvStandBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion());
    public static final Block JUNGLE_PLANKS_TV_STAND = registerBlock("jungle_planks_tv_stand", TvStandBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion());
    public static final Block JUNGLE_WOOD_TV_STAND = registerBlock("jungle_wood_tv_stand", TvStandBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion());
    public static final Block ACACIA_PLANKS_TV_STAND = registerBlock("acacia_planks_tv_stand", TvStandBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion());
    public static final Block ACACIA_WOOD_TV_STAND = registerBlock("acacia_wood_tv_stand", TvStandBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion());
    public static final Block DARK_OAK_PLANKS_TV_STAND = registerBlock("dark_oak_planks_tv_stand", TvStandBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion());
    public static final Block DARK_OAK_WOOD_TV_STAND = registerBlock("dark_oak_wood_tv_stand", TvStandBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion());
    public static final Block MANGROVE_PLANKS_TV_STAND = registerBlock("mangrove_planks_tv_stand", TvStandBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion());
    public static final Block MANGROVE_WOOD_TV_STAND = registerBlock("mangrove_wood_tv_stand", TvStandBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion());
    public static final Block CHERRY_PLANKS_TV_STAND = registerBlock("cherry_planks_tv_stand", TvStandBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion());
    public static final Block CHERRY_WOOD_TV_STAND = registerBlock("cherry_wood_tv_stand", TvStandBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion());
    public static final Block CRIMSON_PLANKS_TV_STAND = registerBlock("crimson_planks_tv_stand", TvStandBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion());
    public static final Block CRIMSON_HYPHAE_TV_STAND = registerBlock("crimson_wood_tv_stand", TvStandBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion());
    public static final Block WARPED_PLANKS_TV_STAND = registerBlock("warped_planks_tv_stand", TvStandBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion());
    public static final Block WARPED_HYPHAE_TV_STAND = registerBlock("warped_wood_tv_stand", TvStandBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion());
    public static final Block BAMBOO_PLANKS_TV_STAND = registerBlock("bamboo_planks_tv_stand", TvStandBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion());
    public static final Block BAMBOO_BLOCK_TV_STAND = registerBlock("bamboo_wood_tv_stand", TvStandBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion());



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

    public static void registerLivingroomBlocks() {
        Furniture.LOGGER.debug("Registering Livingroom Blocks for " + Furniture.MOD_ID);
    }
}
