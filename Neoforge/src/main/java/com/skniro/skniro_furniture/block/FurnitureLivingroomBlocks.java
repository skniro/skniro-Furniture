package com.skniro.skniro_furniture.block;

import com.skniro.skniro_furniture.Furniture;
import com.skniro.skniro_furniture.block.init.SofaBlock;
import com.skniro.skniro_furniture.block.init.TvStandBlock;
import com.skniro.skniro_furniture.item.FurnitureItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class FurnitureLivingroomBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(BuiltInRegistries.BLOCK, Furniture.MOD_ID);

    //Sofa Blocks
    public static final Supplier<Block> Sofa_WHITE = registerBlock("white_sofa",
            ()-> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).noOcclusion()));
    public static final Supplier<Block> Sofa_ORANGE = registerBlock("orange_sofa",
            ()-> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_WOOL).noOcclusion()));
    public static final Supplier<Block> Sofa_MAGENTA = registerBlock("magenta_sofa",
            ()-> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_WOOL).noOcclusion()));
    public static final Supplier<Block> Sofa_LIGHT_BLUE = registerBlock("light_blue_sofa",
            ()-> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_WOOL).noOcclusion()));
    public static final Supplier<Block> Sofa_YELLOW = registerBlock("yellow_sofa",
            ()-> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_WOOL).noOcclusion()));
    public static final Supplier<Block> Sofa_LIME = registerBlock("lime_sofa",
            ()-> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_WOOL).noOcclusion()));
    public static final Supplier<Block> Sofa_PINK = registerBlock("pink_sofa",
            ()-> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_WOOL).noOcclusion()));
    public static final Supplier<Block> Sofa_GRAY = registerBlock("gray_sofa",
            ()-> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_WOOL).noOcclusion()));
    public static final Supplier<Block> Sofa_LIGHT_GRAY = registerBlock("light_gray_sofa",
            ()-> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_WOOL).noOcclusion()));
    public static final Supplier<Block> Sofa_CYAN = registerBlock("cyan_sofa",
            ()-> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_WOOL).noOcclusion()));
    public static final Supplier<Block> Sofa_PURPLE = registerBlock("purple_sofa",
            ()-> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_WOOL).noOcclusion()));
    public static final Supplier<Block> Sofa_BLUE = registerBlock("blue_sofa",
            ()-> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_WOOL).noOcclusion()));
    public static final Supplier<Block> Sofa_BROWN = registerBlock("brown_sofa",
            ()-> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_WOOL).noOcclusion()));
    public static final Supplier<Block> Sofa_GREEN = registerBlock("green_sofa",
            ()-> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_WOOL).noOcclusion()));
    public static final Supplier<Block> Sofa_RED = registerBlock("red_sofa",
            ()-> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_WOOL).noOcclusion()));
    public static final Supplier<Block> Sofa_BLACK = registerBlock("black_sofa",
            ()-> new SofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_WOOL).noOcclusion()));

    public static final Supplier<Block> OAK_PLANKS_TV_STAND = registerBlock("oak_planks_tv_stand",
            ()-> new TvStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> OAK_WOOD_TV_STAND = registerBlock("oak_wood_tv_stand",
            ()-> new TvStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> SPRUCE_PLANKS_TV_STAND = registerBlock("spruce_planks_tv_stand",
            ()-> new TvStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final Supplier<Block> SPRUCE_WOOD_TV_STAND = registerBlock("spruce_wood_tv_stand",
            ()-> new TvStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final Supplier<Block> BIRCH_PLANKS_TV_STAND = registerBlock("birch_planks_tv_stand",
            ()-> new TvStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final Supplier<Block> BIRCH_WOOD_TV_STAND = registerBlock("birch_wood_tv_stand",
            ()-> new TvStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final Supplier<Block> JUNGLE_PLANKS_TV_STAND = registerBlock("jungle_planks_tv_stand",
            ()-> new TvStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final Supplier<Block> JUNGLE_WOOD_TV_STAND = registerBlock("jungle_wood_tv_stand",
            ()-> new TvStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final Supplier<Block> ACACIA_PLANKS_TV_STAND = registerBlock("acacia_planks_tv_stand",
            ()-> new TvStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final Supplier<Block> ACACIA_WOOD_TV_STAND = registerBlock("acacia_wood_tv_stand",
            ()-> new TvStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final Supplier<Block> DARK_OAK_PLANKS_TV_STAND = registerBlock("dark_oak_planks_tv_stand",
            ()-> new TvStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> DARK_OAK_WOOD_TV_STAND = registerBlock("dark_oak_wood_tv_stand",
            ()-> new TvStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> MANGROVE_PLANKS_TV_STAND = registerBlock("mangrove_planks_tv_stand",
            ()-> new TvStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final Supplier<Block> MANGROVE_WOOD_TV_STAND = registerBlock("mangrove_wood_tv_stand",
            ()-> new TvStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final Supplier<Block> CHERRY_PLANKS_TV_STAND = registerBlock("cherry_planks_tv_stand",
            ()-> new TvStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final Supplier<Block> CHERRY_WOOD_TV_STAND = registerBlock("cherry_wood_tv_stand",
            ()-> new TvStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final Supplier<Block> CRIMSON_PLANKS_TV_STAND = registerBlock("crimson_planks_tv_stand",
            ()-> new TvStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final Supplier<Block> CRIMSON_HYPHAE_TV_STAND = registerBlock("crimson_wood_tv_stand",
            ()-> new TvStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final Supplier<Block> WARPED_PLANKS_TV_STAND = registerBlock("warped_planks_tv_stand",
            ()-> new TvStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final Supplier<Block> WARPED_HYPHAE_TV_STAND = registerBlock("warped_wood_tv_stand",
            ()-> new TvStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final Supplier<Block> BAMBOO_PLANKS_TV_STAND = registerBlock("bamboo_planks_tv_stand",
            ()-> new TvStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion()));
    public static final Supplier<Block> BAMBOO_BLOCK_TV_STAND = registerBlock("bamboo_wood_tv_stand",
            ()-> new TvStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion()));

    private static <T extends Block> Supplier<T> registerBlockWithoutItem(String name, Supplier<T> block) {
        Supplier<T> toReturn = BLOCKS.register(name, block);
        return toReturn;
    }

    private static <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block) {
        Supplier<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> Supplier<Item> registerBlockItem(String name, Supplier<T> block
    ) {
        return FurnitureItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void registerLivingroomBlocks(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
