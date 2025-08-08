package com.skniro.skniro_furniture.block;

import com.skniro.skniro_furniture.Furniture;
import com.skniro.skniro_furniture.block.init.BedsideCabinetBlock;
import com.skniro.skniro_furniture.block.init.DeskBlock;
import com.skniro.skniro_furniture.block.init.DeskCabinetBlock;
import com.skniro.skniro_furniture.block.init.DeskLampBlock;
import com.skniro.skniro_furniture.item.FurnitureItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class FurnitureBedroomBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Furniture.MOD_ID);

    public static final Supplier<Block> OAK_PLANKS_BEDSIDE_CABINET = registerBlock("oak_planks_bedside_cabinet",
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> OAK_WOOD_BEDSIDE_CABINET = registerBlock("oak_wood_bedside_cabinet",
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> SPRUCE_PLANKS_BEDSIDE_CABINET = registerBlock("spruce_planks_bedside_cabinet",
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final Supplier<Block> SPRUCE_WOOD_BEDSIDE_CABINET = registerBlock("spruce_wood_bedside_cabinet",
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final Supplier<Block> BIRCH_PLANKS_BEDSIDE_CABINET = registerBlock("birch_planks_bedside_cabinet",
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final Supplier<Block> BIRCH_WOOD_BEDSIDE_CABINET = registerBlock("birch_wood_bedside_cabinet",
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final Supplier<Block> JUNGLE_PLANKS_BEDSIDE_CABINET = registerBlock("jungle_planks_bedside_cabinet",
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final Supplier<Block> JUNGLE_WOOD_BEDSIDE_CABINET = registerBlock("jungle_wood_bedside_cabinet",
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final Supplier<Block> ACACIA_PLANKS_BEDSIDE_CABINET = registerBlock("acacia_planks_bedside_cabinet",
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final Supplier<Block> ACACIA_WOOD_BEDSIDE_CABINET = registerBlock("acacia_wood_bedside_cabinet",
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final Supplier<Block> DARK_OAK_PLANKS_BEDSIDE_CABINET = registerBlock("dark_oak_planks_bedside_cabinet",
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> DARK_OAK_WOOD_BEDSIDE_CABINET = registerBlock("dark_oak_wood_bedside_cabinet",
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> MANGROVE_PLANKS_BEDSIDE_CABINET = registerBlock("mangrove_planks_bedside_cabinet",
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final Supplier<Block> MANGROVE_WOOD_BEDSIDE_CABINET = registerBlock("mangrove_wood_bedside_cabinet",
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final Supplier<Block> CHERRY_PLANKS_BEDSIDE_CABINET = registerBlock("cherry_planks_bedside_cabinet",
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final Supplier<Block> CHERRY_WOOD_BEDSIDE_CABINET = registerBlock("cherry_wood_bedside_cabinet",
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final Supplier<Block> CRIMSON_PLANKS_BEDSIDE_CABINET = registerBlock("crimson_planks_bedside_cabinet",
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final Supplier<Block> CRIMSON_HYPHAE_BEDSIDE_CABINET = registerBlock("crimson_wood_bedside_cabinet",
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final Supplier<Block> WARPED_PLANKS_BEDSIDE_CABINET = registerBlock("warped_planks_bedside_cabinet",
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final Supplier<Block> WARPED_HYPHAE_BEDSIDE_CABINET = registerBlock("warped_wood_bedside_cabinet",
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final Supplier<Block> BAMBOO_PLANKS_BEDSIDE_CABINET = registerBlock("bamboo_planks_bedside_cabinet",
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS).noOcclusion()));
    public static final Supplier<Block> BAMBOO_BLOCK_BEDSIDE_CABINET = registerBlock("bamboo_wood_bedside_cabinet",
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS).noOcclusion()));

    public static final Supplier<Block> OAK_PLANKS_Desk_CABINET = registerBlock("oak_planks_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> OAK_WOOD_Desk_CABINET = registerBlock("oak_wood_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> SPRUCE_PLANKS_Desk_CABINET = registerBlock("spruce_planks_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final Supplier<Block> SPRUCE_WOOD_Desk_CABINET = registerBlock("spruce_wood_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final Supplier<Block> BIRCH_PLANKS_Desk_CABINET = registerBlock("birch_planks_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final Supplier<Block> BIRCH_WOOD_Desk_CABINET = registerBlock("birch_wood_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final Supplier<Block> JUNGLE_PLANKS_Desk_CABINET = registerBlock("jungle_planks_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final Supplier<Block> JUNGLE_WOOD_Desk_CABINET = registerBlock("jungle_wood_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final Supplier<Block> ACACIA_PLANKS_Desk_CABINET = registerBlock("acacia_planks_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final Supplier<Block> ACACIA_WOOD_Desk_CABINET = registerBlock("acacia_wood_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final Supplier<Block> DARK_OAK_PLANKS_Desk_CABINET = registerBlock("dark_oak_planks_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> DARK_OAK_WOOD_Desk_CABINET = registerBlock("dark_oak_wood_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> MANGROVE_PLANKS_Desk_CABINET = registerBlock("mangrove_planks_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final Supplier<Block> MANGROVE_WOOD_Desk_CABINET = registerBlock("mangrove_wood_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final Supplier<Block> CHERRY_PLANKS_Desk_CABINET = registerBlock("cherry_planks_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final Supplier<Block> CHERRY_WOOD_Desk_CABINET = registerBlock("cherry_wood_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final Supplier<Block> CRIMSON_PLANKS_Desk_CABINET = registerBlock("crimson_planks_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final Supplier<Block> CRIMSON_HYPHAE_Desk_CABINET = registerBlock("crimson_wood_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final Supplier<Block> WARPED_PLANKS_Desk_CABINET = registerBlock("warped_planks_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final Supplier<Block> WARPED_HYPHAE_Desk_CABINET = registerBlock("warped_wood_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final Supplier<Block> BAMBOO_PLANKS_Desk_CABINET = registerBlock("bamboo_planks_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS).noOcclusion()));
    public static final Supplier<Block> BAMBOO_BLOCK_Desk_CABINET = registerBlock("bamboo_wood_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS).noOcclusion()));

    public static final Supplier<Block> OAK_PLANKS_BOOK_Desk = registerBlock("oak_planks_book_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> OAK_WOOD_BOOK_Desk = registerBlock("oak_wood_book_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> SPRUCE_PLANKS_BOOK_Desk = registerBlock("spruce_planks_book_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final Supplier<Block> SPRUCE_WOOD_BOOK_Desk = registerBlock("spruce_wood_book_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final Supplier<Block> BIRCH_PLANKS_BOOK_Desk = registerBlock("birch_planks_book_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final Supplier<Block> BIRCH_WOOD_BOOK_Desk = registerBlock("birch_wood_book_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final Supplier<Block> JUNGLE_PLANKS_BOOK_Desk = registerBlock("jungle_planks_book_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final Supplier<Block> JUNGLE_WOOD_BOOK_Desk = registerBlock("jungle_wood_book_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final Supplier<Block> ACACIA_PLANKS_BOOK_Desk = registerBlock("acacia_planks_book_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final Supplier<Block> ACACIA_WOOD_BOOK_Desk = registerBlock("acacia_wood_book_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final Supplier<Block> DARK_OAK_PLANKS_BOOK_Desk = registerBlock("dark_oak_planks_book_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> DARK_OAK_WOOD_BOOK_Desk = registerBlock("dark_oak_wood_book_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> MANGROVE_PLANKS_BOOK_Desk = registerBlock("mangrove_planks_book_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final Supplier<Block> MANGROVE_WOOD_BOOK_Desk = registerBlock("mangrove_wood_book_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final Supplier<Block> CHERRY_PLANKS_BOOK_Desk = registerBlock("cherry_planks_book_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final Supplier<Block> CHERRY_WOOD_BOOK_Desk = registerBlock("cherry_wood_book_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final Supplier<Block> CRIMSON_PLANKS_BOOK_Desk = registerBlock("crimson_planks_book_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final Supplier<Block> CRIMSON_HYPHAE_BOOK_Desk = registerBlock("crimson_wood_book_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final Supplier<Block> WARPED_PLANKS_BOOK_Desk = registerBlock("warped_planks_book_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final Supplier<Block> WARPED_HYPHAE_BOOK_Desk = registerBlock("warped_wood_book_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final Supplier<Block> BAMBOO_PLANKS_BOOK_Desk = registerBlock("bamboo_planks_book_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS).noOcclusion()));
    public static final Supplier<Block> BAMBOO_BLOCK_BOOK_Desk = registerBlock("bamboo_wood_book_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS).noOcclusion()));

    public static final Supplier<Block> White_Desk_Lamp = registerBlock("white_desk_lamp",
            ()-> new DeskLampBlock(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK).lightLevel(litBlockEmission(15)).strength(0.3F).noOcclusion()));
    public static final Supplier<Block> Orange_Desk_Lamp = registerBlock("orange_desk_lamp",
            ()-> new DeskLampBlock(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK).lightLevel(litBlockEmission(15)).strength(0.3F).noOcclusion()));
    public static final Supplier<Block> Magenta_Desk_Lamp = registerBlock("magenta_desk_lamp",
            ()-> new DeskLampBlock(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK).lightLevel(litBlockEmission(15)).strength(0.3F).noOcclusion()));
    public static final Supplier<Block> LightBlue_Desk_Lamp = registerBlock("light_blue_desk_lamp",
            ()-> new DeskLampBlock(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK).lightLevel(litBlockEmission(15)).strength(0.3F).noOcclusion()));
    public static final Supplier<Block> Yellow_Desk_Lamp = registerBlock("yellow_desk_lamp",
            ()-> new DeskLampBlock(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK).lightLevel(litBlockEmission(15)).strength(0.3F).noOcclusion()));
    public static final Supplier<Block> Lime_Desk_Lamp = registerBlock("lime_desk_lamp",
            ()-> new DeskLampBlock(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK).lightLevel(litBlockEmission(15)).strength(0.3F).noOcclusion()));
    public static final Supplier<Block> Pink_Desk_Lamp = registerBlock("pink_desk_lamp",
            ()-> new DeskLampBlock(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK).lightLevel(litBlockEmission(15)).strength(0.3F).noOcclusion()));
    public static final Supplier<Block> Gray_Desk_Lamp = registerBlock("gray_desk_lamp",
            ()-> new DeskLampBlock(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK).lightLevel(litBlockEmission(15)).strength(0.3F).noOcclusion()));
    public static final Supplier<Block> LightGray_Desk_Lamp = registerBlock("light_gray_desk_lamp",
            ()-> new DeskLampBlock(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK).lightLevel(litBlockEmission(15)).strength(0.3F).noOcclusion()));
    public static final Supplier<Block> Cyan_Desk_Lamp = registerBlock("cyan_desk_lamp",
            ()-> new DeskLampBlock(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK).lightLevel(litBlockEmission(15)).strength(0.3F).noOcclusion()));
    public static final Supplier<Block> Purple_Desk_Lamp = registerBlock("purple_desk_lamp",
            ()-> new DeskLampBlock(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK).lightLevel(litBlockEmission(15)).strength(0.3F).noOcclusion()));
    public static final Supplier<Block> Blue_Desk_Lamp = registerBlock("blue_desk_lamp",
            ()-> new DeskLampBlock(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK).lightLevel(litBlockEmission(15)).strength(0.3F).noOcclusion()));
    public static final Supplier<Block> Brown_Desk_Lamp = registerBlock("brown_desk_lamp",
            ()-> new DeskLampBlock(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK).lightLevel(litBlockEmission(15)).strength(0.3F).noOcclusion()));
    public static final Supplier<Block> Green_Desk_Lamp = registerBlock("green_desk_lamp",
            ()-> new DeskLampBlock(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK).lightLevel(litBlockEmission(15)).strength(0.3F).noOcclusion()));
    public static final Supplier<Block> Red_Desk_Lamp = registerBlock("red_desk_lamp",
            ()-> new DeskLampBlock(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK).lightLevel(litBlockEmission(15)).strength(0.3F).noOcclusion()));
    public static final Supplier<Block> Black_Desk_Lamp = registerBlock("black_desk_lamp",
            ()-> new DeskLampBlock(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK).lightLevel(litBlockEmission(15)).strength(0.3F).noOcclusion()));

    private static ToIntFunction<BlockState> litBlockEmission(int p_50760_) {
        return (p_50763_) -> {
            return (Boolean)p_50763_.getValue(BlockStateProperties.LIT) ? p_50760_ : 0;
        };
    }

    private static <T extends Block> RegistryObject<T> registerBlockWithoutItem(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return FurnitureItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void registerBedroomBlocks(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
