package com.skniro.skniro_furniture.block;

import com.skniro.skniro_furniture.Furniture;
import com.skniro.skniro_furniture.block.init.*;
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

public class FurnitureKitchenBlocks {
    public static final Block WHITE_OVEN = registerBlock("white_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block ORANGE_OVEN = registerBlock("orange_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block MAGENTA_OVEN = registerBlock("magenta_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block LIGHT_BLUE_OVEN = registerBlock("light_blue_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block YELLOW_OVEN = registerBlock("yellow_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block LIME_OVEN = registerBlock("lime_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block PINK_OVEN = registerBlock("pink_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block GRAY_OVEN = registerBlock("gray_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block LIGHT_GRAY_OVEN = registerBlock("light_gray_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block CYAN_OVEN = registerBlock("cyan_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block PURPLE_OVEN = registerBlock("purple_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block BLUE_OVEN = registerBlock("blue_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block BROWN_OVEN = registerBlock("brown_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block GREEN_OVEN = registerBlock("green_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block RED_OVEN = registerBlock("red_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block BLACK_OVEN = registerBlock("black_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());

    public static final Block OAK_PLANKS_OVEN = registerBlock("oak_planks_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final Block OAK_WOOD_OVEN = registerBlock("oak_wood_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final Block PALE_OAK_PLANKS_OVEN = registerBlock("pale_oak_planks_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_PLANKS).noOcclusion());
    public static final Block PALE_OAK_WOOD_OVEN = registerBlock("pale_oak_wood_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_PLANKS).noOcclusion());
    public static final Block SPRUCE_PLANKS_OVEN = registerBlock("spruce_planks_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion());
    public static final Block SPRUCE_WOOD_OVEN = registerBlock("spruce_wood_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion());
    public static final Block BIRCH_PLANKS_OVEN = registerBlock("birch_planks_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion());
    public static final Block BIRCH_WOOD_OVEN = registerBlock("birch_wood_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion());
    public static final Block JUNGLE_PLANKS_OVEN = registerBlock("jungle_planks_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion());
    public static final Block JUNGLE_WOOD_OVEN = registerBlock("jungle_wood_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion());
    public static final Block ACACIA_PLANKS_OVEN = registerBlock("acacia_planks_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion());
    public static final Block ACACIA_WOOD_OVEN = registerBlock("acacia_wood_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion());
    public static final Block DARK_OAK_PLANKS_OVEN = registerBlock("dark_oak_planks_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion());
    public static final Block DARK_OAK_WOOD_OVEN = registerBlock("dark_oak_wood_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion());
    public static final Block MANGROVE_PLANKS_OVEN = registerBlock("mangrove_planks_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion());
    public static final Block MANGROVE_WOOD_OVEN = registerBlock("mangrove_wood_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion());
    public static final Block CHERRY_PLANKS_OVEN = registerBlock("cherry_planks_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion());
    public static final Block CHERRY_WOOD_OVEN = registerBlock("cherry_wood_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion());
    public static final Block CRIMSON_PLANKS_OVEN = registerBlock("crimson_planks_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion());
    public static final Block CRIMSON_HYPHAE_OVEN = registerBlock("crimson_wood_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion());
    public static final Block WARPED_PLANKS_OVEN = registerBlock("warped_planks_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion());
    public static final Block WARPED_HYPHAE_OVEN = registerBlock("warped_wood_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion());
    public static final Block BAMBOO_PLANKS_OVEN = registerBlock("bamboo_planks_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion());
    public static final Block BAMBOO_BLOCK_OVEN = registerBlock("bamboo_wood_oven", OvenBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion());

    public static final Block WHITE_KITCHEN_COUNTER = registerBlock("white_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block ORANGE_KITCHEN_COUNTER = registerBlock("orange_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block MAGENTA_KITCHEN_COUNTER = registerBlock("magenta_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block LIGHT_BLUE_KITCHEN_COUNTER = registerBlock("light_blue_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block YELLOW_KITCHEN_COUNTER = registerBlock("yellow_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block LIME_KITCHEN_COUNTER = registerBlock("lime_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block PINK_KITCHEN_COUNTER = registerBlock("pink_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block GRAY_KITCHEN_COUNTER = registerBlock("gray_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block LIGHT_GRAY_KITCHEN_COUNTER = registerBlock("light_gray_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block CYAN_KITCHEN_COUNTER = registerBlock("cyan_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block PURPLE_KITCHEN_COUNTER = registerBlock("purple_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block BLUE_KITCHEN_COUNTER = registerBlock("blue_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block BROWN_KITCHEN_COUNTER = registerBlock("brown_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block GREEN_KITCHEN_COUNTER = registerBlock("green_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block RED_KITCHEN_COUNTER = registerBlock("red_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block BLACK_KITCHEN_COUNTER = registerBlock("black_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());

    public static final Block OAK_PLANKS_KITCHEN_COUNTER = registerBlock("oak_planks_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final Block OAK_WOOD_KITCHEN_COUNTER = registerBlock("oak_wood_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final Block PALE_OAK_PLANKS_KITCHEN_COUNTER = registerBlock("pale_oak_planks_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_PLANKS).noOcclusion());
    public static final Block PALE_OAK_WOOD_KITCHEN_COUNTER = registerBlock("pale_oak_wood_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_PLANKS).noOcclusion());
    public static final Block SPRUCE_PLANKS_KITCHEN_COUNTER = registerBlock("spruce_planks_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion());
    public static final Block SPRUCE_WOOD_KITCHEN_COUNTER = registerBlock("spruce_wood_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion());
    public static final Block BIRCH_PLANKS_KITCHEN_COUNTER = registerBlock("birch_planks_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion());
    public static final Block BIRCH_WOOD_KITCHEN_COUNTER = registerBlock("birch_wood_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion());
    public static final Block JUNGLE_PLANKS_KITCHEN_COUNTER = registerBlock("jungle_planks_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion());
    public static final Block JUNGLE_WOOD_KITCHEN_COUNTER = registerBlock("jungle_wood_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion());
    public static final Block ACACIA_PLANKS_KITCHEN_COUNTER = registerBlock("acacia_planks_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion());
    public static final Block ACACIA_WOOD_KITCHEN_COUNTER = registerBlock("acacia_wood_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion());
    public static final Block DARK_OAK_PLANKS_KITCHEN_COUNTER = registerBlock("dark_oak_planks_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion());
    public static final Block DARK_OAK_WOOD_KITCHEN_COUNTER = registerBlock("dark_oak_wood_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion());
    public static final Block MANGROVE_PLANKS_KITCHEN_COUNTER = registerBlock("mangrove_planks_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion());
    public static final Block MANGROVE_WOOD_KITCHEN_COUNTER = registerBlock("mangrove_wood_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion());
    public static final Block CHERRY_PLANKS_KITCHEN_COUNTER = registerBlock("cherry_planks_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion());
    public static final Block CHERRY_WOOD_KITCHEN_COUNTER = registerBlock("cherry_wood_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion());
    public static final Block CRIMSON_PLANKS_KITCHEN_COUNTER = registerBlock("crimson_planks_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion());
    public static final Block CRIMSON_HYPHAE_KITCHEN_COUNTER = registerBlock("crimson_wood_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion());
    public static final Block WARPED_PLANKS_KITCHEN_COUNTER = registerBlock("warped_planks_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion());
    public static final Block WARPED_HYPHAE_KITCHEN_COUNTER = registerBlock("warped_wood_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion());
    public static final Block BAMBOO_PLANKS_KITCHEN_COUNTER = registerBlock("bamboo_planks_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion());
    public static final Block BAMBOO_BLOCK_KITCHEN_COUNTER = registerBlock("bamboo_wood_kitchen_counter", KitchenCounterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion());


    //Counter Drawer
    public static final Block WHITE_KITCHEN_COUNTER_DRAWER = registerBlock("white_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block ORANGE_KITCHEN_COUNTER_DRAWER = registerBlock("orange_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block MAGENTA_KITCHEN_COUNTER_DRAWER = registerBlock("magenta_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block LIGHT_BLUE_KITCHEN_COUNTER_DRAWER = registerBlock("light_blue_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block YELLOW_KITCHEN_COUNTER_DRAWER = registerBlock("yellow_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block LIME_KITCHEN_COUNTER_DRAWER = registerBlock("lime_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block PINK_KITCHEN_COUNTER_DRAWER = registerBlock("pink_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block GRAY_KITCHEN_COUNTER_DRAWER = registerBlock("gray_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block LIGHT_GRAY_KITCHEN_COUNTER_DRAWER = registerBlock("light_gray_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block CYAN_KITCHEN_COUNTER_DRAWER = registerBlock("cyan_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block PURPLE_KITCHEN_COUNTER_DRAWER = registerBlock("purple_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block BLUE_KITCHEN_COUNTER_DRAWER = registerBlock("blue_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block BROWN_KITCHEN_COUNTER_DRAWER = registerBlock("brown_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block GREEN_KITCHEN_COUNTER_DRAWER = registerBlock("green_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block RED_KITCHEN_COUNTER_DRAWER = registerBlock("red_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block BLACK_KITCHEN_COUNTER_DRAWER = registerBlock("black_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());

    public static final Block OAK_PLANKS_KITCHEN_COUNTER_DRAWER = registerBlock("oak_planks_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final Block OAK_WOOD_KITCHEN_COUNTER_DRAWER = registerBlock("oak_wood_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final Block PALE_OAK_PLANKS_KITCHEN_COUNTER_DRAWER = registerBlock("pale_oak_planks_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_PLANKS).noOcclusion());
    public static final Block PALE_OAK_WOOD_KITCHEN_COUNTER_DRAWER = registerBlock("pale_oak_wood_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_PLANKS).noOcclusion());
    public static final Block SPRUCE_PLANKS_KITCHEN_COUNTER_DRAWER = registerBlock("spruce_planks_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion());
    public static final Block SPRUCE_WOOD_KITCHEN_COUNTER_DRAWER = registerBlock("spruce_wood_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion());
    public static final Block BIRCH_PLANKS_KITCHEN_COUNTER_DRAWER = registerBlock("birch_planks_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion());
    public static final Block BIRCH_WOOD_KITCHEN_COUNTER_DRAWER = registerBlock("birch_wood_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion());
    public static final Block JUNGLE_PLANKS_KITCHEN_COUNTER_DRAWER = registerBlock("jungle_planks_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion());
    public static final Block JUNGLE_WOOD_KITCHEN_COUNTER_DRAWER = registerBlock("jungle_wood_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion());
    public static final Block ACACIA_PLANKS_KITCHEN_COUNTER_DRAWER = registerBlock("acacia_planks_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion());
    public static final Block ACACIA_WOOD_KITCHEN_COUNTER_DRAWER = registerBlock("acacia_wood_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion());
    public static final Block DARK_OAK_PLANKS_KITCHEN_COUNTER_DRAWER = registerBlock("dark_oak_planks_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion());
    public static final Block DARK_OAK_WOOD_KITCHEN_COUNTER_DRAWER = registerBlock("dark_oak_wood_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion());
    public static final Block MANGROVE_PLANKS_KITCHEN_COUNTER_DRAWER = registerBlock("mangrove_planks_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion());
    public static final Block MANGROVE_WOOD_KITCHEN_COUNTER_DRAWER = registerBlock("mangrove_wood_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion());
    public static final Block CHERRY_PLANKS_KITCHEN_COUNTER_DRAWER = registerBlock("cherry_planks_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion());
    public static final Block CHERRY_WOOD_KITCHEN_COUNTER_DRAWER = registerBlock("cherry_wood_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion());
    public static final Block CRIMSON_PLANKS_KITCHEN_COUNTER_DRAWER = registerBlock("crimson_planks_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion());
    public static final Block CRIMSON_HYPHAE_KITCHEN_COUNTER_DRAWER = registerBlock("crimson_wood_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion());
    public static final Block WARPED_PLANKS_KITCHEN_COUNTER_DRAWER = registerBlock("warped_planks_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion());
    public static final Block WARPED_HYPHAE_KITCHEN_COUNTER_DRAWER = registerBlock("warped_wood_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion());
    public static final Block BAMBOO_PLANKS_KITCHEN_COUNTER_DRAWER = registerBlock("bamboo_planks_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion());
    public static final Block BAMBOO_BLOCK_KITCHEN_COUNTER_DRAWER = registerBlock("bamboo_wood_kitchen_counter_drawer", KitchenCounterDrawerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion());

    public static final Block WHITE_KITCHEN_CABINET = registerBlock("white_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block ORANGE_KITCHEN_CABINET = registerBlock("orange_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block MAGENTA_KITCHEN_CABINET = registerBlock("magenta_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block LIGHT_BLUE_KITCHEN_CABINET = registerBlock("light_blue_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block YELLOW_KITCHEN_CABINET = registerBlock("yellow_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block LIME_KITCHEN_CABINET = registerBlock("lime_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block PINK_KITCHEN_CABINET = registerBlock("pink_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block GRAY_KITCHEN_CABINET = registerBlock("gray_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block LIGHT_GRAY_KITCHEN_CABINET = registerBlock("light_gray_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block CYAN_KITCHEN_CABINET = registerBlock("cyan_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block PURPLE_KITCHEN_CABINET = registerBlock("purple_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block BLUE_KITCHEN_CABINET = registerBlock("blue_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block BROWN_KITCHEN_CABINET = registerBlock("brown_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block GREEN_KITCHEN_CABINET = registerBlock("green_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block RED_KITCHEN_CABINET = registerBlock("red_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block BLACK_KITCHEN_CABINET = registerBlock("black_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());

    public static final Block OAK_PLANKS_KITCHEN_CABINET = registerBlock("oak_planks_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final Block OAK_WOOD_KITCHEN_CABINET = registerBlock("oak_wood_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final Block PALE_OAK_PLANKS_KITCHEN_CABINET = registerBlock("pale_oak_planks_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_PLANKS).noOcclusion());
    public static final Block PALE_OAK_WOOD_KITCHEN_CABINET = registerBlock("pale_oak_wood_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_PLANKS).noOcclusion());
    public static final Block SPRUCE_PLANKS_KITCHEN_CABINET = registerBlock("spruce_planks_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion());
    public static final Block SPRUCE_WOOD_KITCHEN_CABINET = registerBlock("spruce_wood_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion());
    public static final Block BIRCH_PLANKS_KITCHEN_CABINET = registerBlock("birch_planks_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion());
    public static final Block BIRCH_WOOD_KITCHEN_CABINET = registerBlock("birch_wood_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion());
    public static final Block JUNGLE_PLANKS_KITCHEN_CABINET = registerBlock("jungle_planks_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion());
    public static final Block JUNGLE_WOOD_KITCHEN_CABINET = registerBlock("jungle_wood_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion());
    public static final Block ACACIA_PLANKS_KITCHEN_CABINET = registerBlock("acacia_planks_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion());
    public static final Block ACACIA_WOOD_KITCHEN_CABINET = registerBlock("acacia_wood_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion());
    public static final Block DARK_OAK_PLANKS_KITCHEN_CABINET = registerBlock("dark_oak_planks_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion());
    public static final Block DARK_OAK_WOOD_KITCHEN_CABINET = registerBlock("dark_oak_wood_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion());
    public static final Block MANGROVE_PLANKS_KITCHEN_CABINET = registerBlock("mangrove_planks_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion());
    public static final Block MANGROVE_WOOD_KITCHEN_CABINET = registerBlock("mangrove_wood_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion());
    public static final Block CHERRY_PLANKS_KITCHEN_CABINET = registerBlock("cherry_planks_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion());
    public static final Block CHERRY_WOOD_KITCHEN_CABINET = registerBlock("cherry_wood_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion());
    public static final Block CRIMSON_PLANKS_KITCHEN_CABINET = registerBlock("crimson_planks_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion());
    public static final Block CRIMSON_HYPHAE_KITCHEN_CABINET = registerBlock("crimson_wood_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion());
    public static final Block WARPED_PLANKS_KITCHEN_CABINET = registerBlock("warped_planks_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion());
    public static final Block WARPED_HYPHAE_KITCHEN_CABINET = registerBlock("warped_wood_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion());
    public static final Block BAMBOO_PLANKS_KITCHEN_CABINET = registerBlock("bamboo_planks_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion());
    public static final Block BAMBOO_BLOCK_KITCHEN_CABINET = registerBlock("bamboo_wood_kitchen_cabinet", KitchenCabinetBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion());

    public static final Block WHITE_Fridge = registerBlock("white_fridge", FridgeBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block ORANGE_Fridge = registerBlock("orange_fridge", FridgeBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block MAGENTA_Fridge = registerBlock("magenta_fridge", FridgeBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block LIGHT_BLUE_Fridge = registerBlock("light_blue_fridge", FridgeBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block YELLOW_Fridge = registerBlock("yellow_fridge", FridgeBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block LIME_Fridge = registerBlock("lime_fridge", FridgeBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block PINK_Fridge = registerBlock("pink_fridge", FridgeBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block GRAY_Fridge = registerBlock("gray_fridge", FridgeBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block LIGHT_GRAY_Fridge = registerBlock("light_gray_fridge", FridgeBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block CYAN_Fridge = registerBlock("cyan_fridge", FridgeBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block PURPLE_Fridge = registerBlock("purple_fridge", FridgeBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block BLUE_Fridge = registerBlock("blue_fridge", FridgeBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block BROWN_Fridge = registerBlock("brown_fridge", FridgeBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block GREEN_Fridge = registerBlock("green_fridge", FridgeBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block RED_Fridge = registerBlock("red_fridge", FridgeBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block BLACK_Fridge = registerBlock("black_fridge", FridgeBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());

    public static final Block WHITE_KITCHEN_SINK = registerBlock("white_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block ORANGE_KITCHEN_SINK = registerBlock("orange_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block MAGENTA_KITCHEN_SINK = registerBlock("magenta_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block LIGHT_BLUE_KITCHEN_SINK = registerBlock("light_blue_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block YELLOW_KITCHEN_SINK = registerBlock("yellow_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block LIME_KITCHEN_SINK = registerBlock("lime_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block PINK_KITCHEN_SINK = registerBlock("pink_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block GRAY_KITCHEN_SINK = registerBlock("gray_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block LIGHT_GRAY_KITCHEN_SINK = registerBlock("light_gray_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block CYAN_KITCHEN_SINK = registerBlock("cyan_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block PURPLE_KITCHEN_SINK = registerBlock("purple_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block BLUE_KITCHEN_SINK = registerBlock("blue_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block BROWN_KITCHEN_SINK = registerBlock("brown_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block GREEN_KITCHEN_SINK = registerBlock("green_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block RED_KITCHEN_SINK = registerBlock("red_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block BLACK_KITCHEN_SINK = registerBlock("black_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());

    public static final Block OAK_PLANKS_KITCHEN_SINK = registerBlock("oak_planks_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final Block OAK_WOOD_KITCHEN_SINK = registerBlock("oak_wood_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final Block PALE_OAK_PLANKS_KITCHEN_SINK = registerBlock("pale_oak_planks_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_PLANKS).noOcclusion());
    public static final Block PALE_OAK_WOOD_KITCHEN_SINK = registerBlock("pale_oak_wood_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_PLANKS).noOcclusion());
    public static final Block SPRUCE_PLANKS_KITCHEN_SINK = registerBlock("spruce_planks_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion());
    public static final Block SPRUCE_WOOD_KITCHEN_SINK = registerBlock("spruce_wood_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion());
    public static final Block BIRCH_PLANKS_KITCHEN_SINK = registerBlock("birch_planks_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion());
    public static final Block BIRCH_WOOD_KITCHEN_SINK = registerBlock("birch_wood_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion());
    public static final Block JUNGLE_PLANKS_KITCHEN_SINK = registerBlock("jungle_planks_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion());
    public static final Block JUNGLE_WOOD_KITCHEN_SINK = registerBlock("jungle_wood_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion());
    public static final Block ACACIA_PLANKS_KITCHEN_SINK = registerBlock("acacia_planks_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion());
    public static final Block ACACIA_WOOD_KITCHEN_SINK = registerBlock("acacia_wood_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion());
    public static final Block DARK_OAK_PLANKS_KITCHEN_SINK = registerBlock("dark_oak_planks_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion());
    public static final Block DARK_OAK_WOOD_KITCHEN_SINK = registerBlock("dark_oak_wood_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion());
    public static final Block MANGROVE_PLANKS_KITCHEN_SINK = registerBlock("mangrove_planks_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion());
    public static final Block MANGROVE_WOOD_KITCHEN_SINK = registerBlock("mangrove_wood_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion());
    public static final Block CHERRY_PLANKS_KITCHEN_SINK = registerBlock("cherry_planks_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion());
    public static final Block CHERRY_WOOD_KITCHEN_SINK = registerBlock("cherry_wood_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion());
    public static final Block CRIMSON_PLANKS_KITCHEN_SINK = registerBlock("crimson_planks_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion());
    public static final Block CRIMSON_HYPHAE_KITCHEN_SINK = registerBlock("crimson_wood_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion());
    public static final Block WARPED_PLANKS_KITCHEN_SINK = registerBlock("warped_planks_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion());
    public static final Block WARPED_HYPHAE_KITCHEN_SINK = registerBlock("warped_wood_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion());
    public static final Block BAMBOO_PLANKS_KITCHEN_SINK = registerBlock("bamboo_planks_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion());
    public static final Block BAMBOO_BLOCK_KITCHEN_SINK = registerBlock("bamboo_wood_kitchen_sink", KitchenSinkBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion());

    //Plate
    public static final Block OAK_WOOD_Plate = registerBlock("oak_wood_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final Block OAK_PLANKS_Plate = registerBlock("oak_plank_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final Block PALE_OAK_WOOD_Plate = registerBlock("pale_oak_wood_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_PLANKS).noOcclusion());
    public static final Block PALE_OAK_PLANKS_Plate = registerBlock("pale_oak_plank_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_PLANKS).noOcclusion());
    public static final Block SPRUCE_WOOD_Plate = registerBlock("spruce_wood_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion());
    public static final Block SPRUCE_PLANKS_Plate = registerBlock("spruce_plank_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion());
    public static final Block BIRCH_WOOD_Plate = registerBlock("birch_wood_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion());
    public static final Block BIRCH_PLANKS_Plate = registerBlock("birch_plank_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion());
    public static final Block JUNGLE_WOOD_Plate = registerBlock("jungle_wood_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion());
    public static final Block JUNGLE_PLANKS_Plate = registerBlock("jungle_plank_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion());
    public static final Block ACACIA_WOOD_Plate = registerBlock("acacia_wood_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion());
    public static final Block ACACIA_PLANKS_Plate = registerBlock("acacia_plank_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion());
    public static final Block DARK_OAK_WOOD_Plate = registerBlock("dark_oak_wood_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion());
    public static final Block DARK_OAK_PLANKS_Plate = registerBlock("dark_oak_plank_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion());
    public static final Block MANGROVE_WOOD_Plate = registerBlock("mangrove_wood_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion());
    public static final Block MANGROVE_PLANKS_Plate = registerBlock("mangrove_plank_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion());
    public static final Block CHERRY_WOOD_Plate = registerBlock("cherry_wood_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion());
    public static final Block CHERRY_PLANKS_Plate = registerBlock("cherry_plank_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion());
    public static final Block CRIMSON_HYPHAE_Plate = registerBlock("crimson_wood_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion());
    public static final Block CRIMSON_PLANKS_Plate = registerBlock("crimson_plank_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion());
    public static final Block WARPED_HYPHAE_Plate = registerBlock("warped_wood_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion());
    public static final Block WARPED_PLANKS_Plate = registerBlock("warped_plank_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion());
    public static final Block BAMBOO_BLOCK_Plate = registerBlock("bamboo_wood_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion());
    public static final Block BAMBOO_PLANKS_Plate = registerBlock("bamboo_plank_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).noOcclusion());

    public static final Block WHITE_Plate = registerBlock("white_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block ORANGE_Plate = registerBlock("orange_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block MAGENTA_Plate = registerBlock("magenta_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block LIGHT_BLUE_Plate = registerBlock("light_blue_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block YELLOW_Plate = registerBlock("yellow_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block LIME_Plate = registerBlock("lime_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block PINK_Plate = registerBlock("pink_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block GRAY_Plate = registerBlock("gray_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block LIGHT_GRAY_Plate = registerBlock("light_gray_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block CYAN_Plate = registerBlock("cyan_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block PURPLE_Plate = registerBlock("purple_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block BLUE_Plate = registerBlock("blue_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block BROWN_Plate = registerBlock("brown_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block GREEN_Plate = registerBlock("green_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block RED_Plate = registerBlock("red_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());
    public static final Block BLACK_Plate = registerBlock("black_plate", PlateBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).noOcclusion());





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

    public static void registerKitchenBlocks() {
        Furniture.LOGGER.debug("Registering Kitchen Blocks for " + Furniture.MOD_ID);
    }
}
