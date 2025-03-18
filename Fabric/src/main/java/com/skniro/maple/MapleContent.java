package com.skniro.maple;


import com.skniro.maple.block.*;
import com.skniro.maple.client.renderer.ChairRenderer;
import com.skniro.maple.client.renderer.CushinoRenderer;
import com.skniro.maple.entity.MapleEntityType;
import com.skniro.maple.item.MapleItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;


public class MapleContent {


    public static void registerItem(){
        MapleItems.registerModItems();
    }
    public static void registerBlock(){
        MapleFurnitureBlocks.registerCushionBlocks();
    }

    public static void registerFluid(){
    }

    public static void CreativeTab() {
        ItemGroupEvents.modifyEntriesEvent(Maple.Maple_Group_Furniture).register(content -> {
            //Cushion
            content.add(MapleFurnitureBlocks.CUSHION_OAK_WHITE);
            content.add(MapleFurnitureBlocks.CUSHION_OAK_ORANGE);
            content.add(MapleFurnitureBlocks.CUSHION_OAK_MAGENTA);
            content.add(MapleFurnitureBlocks.CUSHION_OAK_LIGHT_BLUE);
            content.add(MapleFurnitureBlocks.CUSHION_OAK_YELLOW);
            content.add(MapleFurnitureBlocks.CUSHION_OAK_LIME);
            content.add(MapleFurnitureBlocks.CUSHION_OAK_PINK);
            content.add(MapleFurnitureBlocks.CUSHION_OAK_GRAY);
            content.add(MapleFurnitureBlocks.CUSHION_OAK_LIGHT_GRAY);
            content.add(MapleFurnitureBlocks.CUSHION_OAK_CYAN);
            content.add(MapleFurnitureBlocks.CUSHION_OAK_PURPLE);
            content.add(MapleFurnitureBlocks.CUSHION_OAK_BLUE);
            content.add(MapleFurnitureBlocks.CUSHION_OAK_BROWN);
            content.add(MapleFurnitureBlocks.CUSHION_OAK_GREEN);
            content.add(MapleFurnitureBlocks.CUSHION_OAK_RED);
            content.add(MapleFurnitureBlocks.CUSHION_OAK_BLACK);
            content.add(MapleFurnitureBlocks.CUSHION_SPRUCE_WHITE);
            content.add(MapleFurnitureBlocks.CUSHION_SPRUCE_ORANGE);
            content.add(MapleFurnitureBlocks.CUSHION_SPRUCE_MAGENTA);
            content.add(MapleFurnitureBlocks.CUSHION_SPRUCE_LIGHT_BLUE);
            content.add(MapleFurnitureBlocks.CUSHION_SPRUCE_YELLOW);
            content.add(MapleFurnitureBlocks.CUSHION_SPRUCE_LIME);
            content.add(MapleFurnitureBlocks.CUSHION_SPRUCE_PINK);
            content.add(MapleFurnitureBlocks.CUSHION_SPRUCE_GRAY);
            content.add(MapleFurnitureBlocks.CUSHION_SPRUCE_LIGHT_GRAY);
            content.add(MapleFurnitureBlocks.CUSHION_SPRUCE_CYAN);
            content.add(MapleFurnitureBlocks.CUSHION_SPRUCE_PURPLE);
            content.add(MapleFurnitureBlocks.CUSHION_SPRUCE_BLUE);
            content.add(MapleFurnitureBlocks.CUSHION_SPRUCE_BROWN);
            content.add(MapleFurnitureBlocks.CUSHION_SPRUCE_GREEN);
            content.add(MapleFurnitureBlocks.CUSHION_SPRUCE_RED);
            content.add(MapleFurnitureBlocks.CUSHION_SPRUCE_BLACK);
            content.add(MapleFurnitureBlocks.CUSHION_BIRCH_WHITE);
            content.add(MapleFurnitureBlocks.CUSHION_BIRCH_ORANGE);
            content.add(MapleFurnitureBlocks.CUSHION_BIRCH_MAGENTA);
            content.add(MapleFurnitureBlocks.CUSHION_BIRCH_LIGHT_BLUE);
            content.add(MapleFurnitureBlocks.CUSHION_BIRCH_YELLOW);
            content.add(MapleFurnitureBlocks.CUSHION_BIRCH_LIME);
            content.add(MapleFurnitureBlocks.CUSHION_BIRCH_PINK);
            content.add(MapleFurnitureBlocks.CUSHION_BIRCH_GRAY);
            content.add(MapleFurnitureBlocks.CUSHION_BIRCH_LIGHT_GRAY);
            content.add(MapleFurnitureBlocks.CUSHION_BIRCH_CYAN);
            content.add(MapleFurnitureBlocks.CUSHION_BIRCH_PURPLE);
            content.add(MapleFurnitureBlocks.CUSHION_BIRCH_BLUE);
            content.add(MapleFurnitureBlocks.CUSHION_BIRCH_BROWN);
            content.add(MapleFurnitureBlocks.CUSHION_BIRCH_GREEN);
            content.add(MapleFurnitureBlocks.CUSHION_BIRCH_RED);
            content.add(MapleFurnitureBlocks.CUSHION_BIRCH_BLACK);
            content.add(MapleFurnitureBlocks.CUSHION_JUNGLE_WHITE);
            content.add(MapleFurnitureBlocks.CUSHION_JUNGLE_ORANGE);
            content.add(MapleFurnitureBlocks.CUSHION_JUNGLE_MAGENTA);
            content.add(MapleFurnitureBlocks.CUSHION_JUNGLE_LIGHT_BLUE);
            content.add(MapleFurnitureBlocks.CUSHION_JUNGLE_YELLOW);
            content.add(MapleFurnitureBlocks.CUSHION_JUNGLE_LIME);
            content.add(MapleFurnitureBlocks.CUSHION_JUNGLE_PINK);
            content.add(MapleFurnitureBlocks.CUSHION_JUNGLE_GRAY);
            content.add(MapleFurnitureBlocks.CUSHION_JUNGLE_LIGHT_GRAY);
            content.add(MapleFurnitureBlocks.CUSHION_JUNGLE_CYAN);
            content.add(MapleFurnitureBlocks.CUSHION_JUNGLE_PURPLE);
            content.add(MapleFurnitureBlocks.CUSHION_JUNGLE_BLUE);
            content.add(MapleFurnitureBlocks.CUSHION_JUNGLE_BROWN);
            content.add(MapleFurnitureBlocks.CUSHION_JUNGLE_GREEN);
            content.add(MapleFurnitureBlocks.CUSHION_JUNGLE_RED);
            content.add(MapleFurnitureBlocks.CUSHION_JUNGLE_BLACK);
            content.add(MapleFurnitureBlocks.CUSHION_ACACIA_WHITE);
            content.add(MapleFurnitureBlocks.CUSHION_ACACIA_ORANGE);
            content.add(MapleFurnitureBlocks.CUSHION_ACACIA_MAGENTA);
            content.add(MapleFurnitureBlocks.CUSHION_ACACIA_LIGHT_BLUE);
            content.add(MapleFurnitureBlocks.CUSHION_ACACIA_YELLOW);
            content.add(MapleFurnitureBlocks.CUSHION_ACACIA_LIME);
            content.add(MapleFurnitureBlocks.CUSHION_ACACIA_PINK);
            content.add(MapleFurnitureBlocks.CUSHION_ACACIA_GRAY);
            content.add(MapleFurnitureBlocks.CUSHION_ACACIA_LIGHT_GRAY);
            content.add(MapleFurnitureBlocks.CUSHION_ACACIA_CYAN);
            content.add(MapleFurnitureBlocks.CUSHION_ACACIA_PURPLE);
            content.add(MapleFurnitureBlocks.CUSHION_ACACIA_BLUE);
            content.add(MapleFurnitureBlocks.CUSHION_ACACIA_BROWN);
            content.add(MapleFurnitureBlocks.CUSHION_ACACIA_GREEN);
            content.add(MapleFurnitureBlocks.CUSHION_ACACIA_RED);
            content.add(MapleFurnitureBlocks.CUSHION_ACACIA_BLACK);
            content.add(MapleFurnitureBlocks.CUSHION_DARK_OAK_WHITE);
            content.add(MapleFurnitureBlocks.CUSHION_DARK_OAK_ORANGE);
            content.add(MapleFurnitureBlocks.CUSHION_DARK_OAK_MAGENTA);
            content.add(MapleFurnitureBlocks.CUSHION_DARK_OAK_LIGHT_BLUE);
            content.add(MapleFurnitureBlocks.CUSHION_DARK_OAK_YELLOW);
            content.add(MapleFurnitureBlocks.CUSHION_DARK_OAK_LIME);
            content.add(MapleFurnitureBlocks.CUSHION_DARK_OAK_PINK);
            content.add(MapleFurnitureBlocks.CUSHION_DARK_OAK_GRAY);
            content.add(MapleFurnitureBlocks.CUSHION_DARK_OAK_LIGHT_GRAY);
            content.add(MapleFurnitureBlocks.CUSHION_DARK_OAK_CYAN);
            content.add(MapleFurnitureBlocks.CUSHION_DARK_OAK_PURPLE);
            content.add(MapleFurnitureBlocks.CUSHION_DARK_OAK_BLUE);
            content.add(MapleFurnitureBlocks.CUSHION_DARK_OAK_BROWN);
            content.add(MapleFurnitureBlocks.CUSHION_DARK_OAK_GREEN);
            content.add(MapleFurnitureBlocks.CUSHION_DARK_OAK_RED);
            content.add(MapleFurnitureBlocks.CUSHION_DARK_OAK_BLACK);
            content.add(MapleFurnitureBlocks.CUSHION_CRIMSON_WHITE);
            content.add(MapleFurnitureBlocks.CUSHION_CRIMSON_ORANGE);
            content.add(MapleFurnitureBlocks.CUSHION_CRIMSON_MAGENTA);
            content.add(MapleFurnitureBlocks.CUSHION_CRIMSON_LIGHT_BLUE);
            content.add(MapleFurnitureBlocks.CUSHION_CRIMSON_YELLOW);
            content.add(MapleFurnitureBlocks.CUSHION_CRIMSON_LIME);
            content.add(MapleFurnitureBlocks.CUSHION_CRIMSON_PINK);
            content.add(MapleFurnitureBlocks.CUSHION_CRIMSON_GRAY);
            content.add(MapleFurnitureBlocks.CUSHION_CRIMSON_LIGHT_GRAY);
            content.add(MapleFurnitureBlocks.CUSHION_CRIMSON_CYAN);
            content.add(MapleFurnitureBlocks.CUSHION_CRIMSON_PURPLE);
            content.add(MapleFurnitureBlocks.CUSHION_CRIMSON_BLUE);
            content.add(MapleFurnitureBlocks.CUSHION_CRIMSON_BROWN);
            content.add(MapleFurnitureBlocks.CUSHION_CRIMSON_GREEN);
            content.add(MapleFurnitureBlocks.CUSHION_CRIMSON_RED);
            content.add(MapleFurnitureBlocks.CUSHION_CRIMSON_BLACK);
            content.add(MapleFurnitureBlocks.CUSHION_WARPED_WHITE);
            content.add(MapleFurnitureBlocks.CUSHION_WARPED_ORANGE);
            content.add(MapleFurnitureBlocks.CUSHION_WARPED_MAGENTA);
            content.add(MapleFurnitureBlocks.CUSHION_WARPED_LIGHT_BLUE);
            content.add(MapleFurnitureBlocks.CUSHION_WARPED_YELLOW);
            content.add(MapleFurnitureBlocks.CUSHION_WARPED_LIME);
            content.add(MapleFurnitureBlocks.CUSHION_WARPED_PINK);
            content.add(MapleFurnitureBlocks.CUSHION_WARPED_GRAY);
            content.add(MapleFurnitureBlocks.CUSHION_WARPED_LIGHT_GRAY);
            content.add(MapleFurnitureBlocks.CUSHION_WARPED_CYAN);
            content.add(MapleFurnitureBlocks.CUSHION_WARPED_PURPLE);
            content.add(MapleFurnitureBlocks.CUSHION_WARPED_BLUE);
            content.add(MapleFurnitureBlocks.CUSHION_WARPED_BROWN);
            content.add(MapleFurnitureBlocks.CUSHION_WARPED_GREEN);
            content.add(MapleFurnitureBlocks.CUSHION_WARPED_RED);
            content.add(MapleFurnitureBlocks.CUSHION_WARPED_BLACK);
            content.add(MapleFurnitureBlocks.CUSHION_MANGROVE_WHITE);
            content.add(MapleFurnitureBlocks.CUSHION_MANGROVE_ORANGE);
            content.add(MapleFurnitureBlocks.CUSHION_MANGROVE_MAGENTA);
            content.add(MapleFurnitureBlocks.CUSHION_MANGROVE_LIGHT_BLUE);
            content.add(MapleFurnitureBlocks.CUSHION_MANGROVE_YELLOW);
            content.add(MapleFurnitureBlocks.CUSHION_MANGROVE_LIME);
            content.add(MapleFurnitureBlocks.CUSHION_MANGROVE_PINK);
            content.add(MapleFurnitureBlocks.CUSHION_MANGROVE_GRAY);
            content.add(MapleFurnitureBlocks.CUSHION_MANGROVE_LIGHT_GRAY);
            content.add(MapleFurnitureBlocks.CUSHION_MANGROVE_CYAN);
            content.add(MapleFurnitureBlocks.CUSHION_MANGROVE_PURPLE);
            content.add(MapleFurnitureBlocks.CUSHION_MANGROVE_BLUE);
            content.add(MapleFurnitureBlocks.CUSHION_MANGROVE_BROWN);
            content.add(MapleFurnitureBlocks.CUSHION_MANGROVE_GREEN);
            content.add(MapleFurnitureBlocks.CUSHION_MANGROVE_RED);
            content.add(MapleFurnitureBlocks.CUSHION_MANGROVE_BLACK);
            content.add(MapleFurnitureBlocks.CUSHION_MAPLE_WHITE);
            content.add(MapleFurnitureBlocks.CUSHION_MAPLE_ORANGE);
            content.add(MapleFurnitureBlocks.CUSHION_MAPLE_MAGENTA);
            content.add(MapleFurnitureBlocks.CUSHION_MAPLE_LIGHT_BLUE);
            content.add(MapleFurnitureBlocks.CUSHION_MAPLE_YELLOW);
            content.add(MapleFurnitureBlocks.CUSHION_MAPLE_LIME);
            content.add(MapleFurnitureBlocks.CUSHION_MAPLE_PINK);
            content.add(MapleFurnitureBlocks.CUSHION_MAPLE_GRAY);
            content.add(MapleFurnitureBlocks.CUSHION_MAPLE_LIGHT_GRAY);
            content.add(MapleFurnitureBlocks.CUSHION_MAPLE_CYAN);
            content.add(MapleFurnitureBlocks.CUSHION_MAPLE_PURPLE);
            content.add(MapleFurnitureBlocks.CUSHION_MAPLE_BLUE);
            content.add(MapleFurnitureBlocks.CUSHION_MAPLE_BROWN);
            content.add(MapleFurnitureBlocks.CUSHION_MAPLE_GREEN);
            content.add(MapleFurnitureBlocks.CUSHION_MAPLE_RED);
            content.add(MapleFurnitureBlocks.CUSHION_MAPLE_BLACK);
            content.add(MapleFurnitureBlocks.CUSHION_CHERRY_WHITE);
            content.add(MapleFurnitureBlocks.CUSHION_CHERRY_ORANGE);
            content.add(MapleFurnitureBlocks.CUSHION_CHERRY_MAGENTA);
            content.add(MapleFurnitureBlocks.CUSHION_CHERRY_LIGHT_BLUE);
            content.add(MapleFurnitureBlocks.CUSHION_CHERRY_YELLOW);
            content.add(MapleFurnitureBlocks.CUSHION_CHERRY_LIME);
            content.add(MapleFurnitureBlocks.CUSHION_CHERRY_PINK);
            content.add(MapleFurnitureBlocks.CUSHION_CHERRY_GRAY);
            content.add(MapleFurnitureBlocks.CUSHION_CHERRY_LIGHT_GRAY);
            content.add(MapleFurnitureBlocks.CUSHION_CHERRY_CYAN);
            content.add(MapleFurnitureBlocks.CUSHION_CHERRY_PURPLE);
            content.add(MapleFurnitureBlocks.CUSHION_CHERRY_BLUE);
            content.add(MapleFurnitureBlocks.CUSHION_CHERRY_BROWN);
            content.add(MapleFurnitureBlocks.CUSHION_CHERRY_GREEN);
            content.add(MapleFurnitureBlocks.CUSHION_CHERRY_RED);
            content.add(MapleFurnitureBlocks.CUSHION_CHERRY_BLACK);
            content.add(MapleFurnitureBlocks.CUSHION_GINKGO_WHITE);
            content.add(MapleFurnitureBlocks.CUSHION_GINKGO_ORANGE);
            content.add(MapleFurnitureBlocks.CUSHION_GINKGO_MAGENTA);
            content.add(MapleFurnitureBlocks.CUSHION_GINKGO_LIGHT_BLUE);
            content.add(MapleFurnitureBlocks.CUSHION_GINKGO_YELLOW);
            content.add(MapleFurnitureBlocks.CUSHION_GINKGO_LIME);
            content.add(MapleFurnitureBlocks.CUSHION_GINKGO_PINK);
            content.add(MapleFurnitureBlocks.CUSHION_GINKGO_GRAY);
            content.add(MapleFurnitureBlocks.CUSHION_GINKGO_LIGHT_GRAY);
            content.add(MapleFurnitureBlocks.CUSHION_GINKGO_CYAN);
            content.add(MapleFurnitureBlocks.CUSHION_GINKGO_PURPLE);
            content.add(MapleFurnitureBlocks.CUSHION_GINKGO_BLUE);
            content.add(MapleFurnitureBlocks.CUSHION_GINKGO_BROWN);
            content.add(MapleFurnitureBlocks.CUSHION_GINKGO_GREEN);
            content.add(MapleFurnitureBlocks.CUSHION_GINKGO_RED);
            content.add(MapleFurnitureBlocks.CUSHION_GINKGO_BLACK);
            content.add(MapleFurnitureBlocks.CUSHION_BAMBOO_WHITE);
            content.add(MapleFurnitureBlocks.CUSHION_BAMBOO_ORANGE);
            content.add(MapleFurnitureBlocks.CUSHION_BAMBOO_MAGENTA);
            content.add(MapleFurnitureBlocks.CUSHION_BAMBOO_LIGHT_BLUE);
            content.add(MapleFurnitureBlocks.CUSHION_BAMBOO_YELLOW);
            content.add(MapleFurnitureBlocks.CUSHION_BAMBOO_LIME);
            content.add(MapleFurnitureBlocks.CUSHION_BAMBOO_PINK);
            content.add(MapleFurnitureBlocks.CUSHION_BAMBOO_GRAY);
            content.add(MapleFurnitureBlocks.CUSHION_BAMBOO_LIGHT_GRAY);
            content.add(MapleFurnitureBlocks.CUSHION_BAMBOO_CYAN);
            content.add(MapleFurnitureBlocks.CUSHION_BAMBOO_PURPLE);
            content.add(MapleFurnitureBlocks.CUSHION_BAMBOO_BLUE);
            content.add(MapleFurnitureBlocks.CUSHION_BAMBOO_BROWN);
            content.add(MapleFurnitureBlocks.CUSHION_BAMBOO_GREEN);
            content.add(MapleFurnitureBlocks.CUSHION_BAMBOO_RED);
            content.add(MapleFurnitureBlocks.CUSHION_BAMBOO_BLACK);

            content.add(MapleFurnitureBlocks.TABLE_OAK);
            content.add(MapleFurnitureBlocks.TABLE_SPRUCE);
            content.add(MapleFurnitureBlocks.TABLE_BIRCH);
            content.add(MapleFurnitureBlocks.TABLE_JUNGLE);
            content.add(MapleFurnitureBlocks.TABLE_ACACIA);
            content.add(MapleFurnitureBlocks.TABLE_DARK_OAK);
            content.add(MapleFurnitureBlocks.TABLE_CRIMSON);
            content.add(MapleFurnitureBlocks.TABLE_WARPED);
            content.add(MapleFurnitureBlocks.TABLE_MANGROVE);
            content.add(MapleFurnitureBlocks.TABLE_BAMBOO);
            content.add(MapleFurnitureBlocks.TABLE_CHERRY);
            content.add(MapleFurnitureBlocks.TABLE_MAPLE);
            content.add(MapleFurnitureBlocks.TABLE_GINKGO);
            content.add(MapleFurnitureBlocks.Window_Wood_GINKGO);
            content.add(MapleFurnitureBlocks.Window_Wood_MAPLE);
            content.add(MapleFurnitureBlocks.Window_WOOD_OAK);
            content.add(MapleFurnitureBlocks.Window_WOOD_BIRCH);
            content.add(MapleFurnitureBlocks.Window_WOOD_SPRUCE);
            content.add(MapleFurnitureBlocks.Window_WOOD_JUNGLE);
            content.add(MapleFurnitureBlocks.Window_WOOD_DARK_OAK);
            content.add(MapleFurnitureBlocks.Window_WOOD_ACACIA);
            content.add(MapleFurnitureBlocks.Window_WOOD_MANGROVE);
            content.add(MapleFurnitureBlocks.Window_WOOD_CHERRY);
            content.add(MapleFurnitureBlocks.Window_WOOD_CRIMSON);
            content.add(MapleFurnitureBlocks.Window_WOOD_WARPED);
            content.add(MapleFurnitureBlocks.Window_PLANK_OAK);
            content.add(MapleFurnitureBlocks.Window_PLANK_BIRCH);
            content.add(MapleFurnitureBlocks.Window_PLANK_SPRUCE);
            content.add(MapleFurnitureBlocks.Window_PLANK_JUNGLE);
            content.add(MapleFurnitureBlocks.Window_PLANK_DARK_OAK);
            content.add(MapleFurnitureBlocks.Window_PLANK_ACACIA);
            content.add(MapleFurnitureBlocks.Window_PLANK_MANGROVE);
            content.add(MapleFurnitureBlocks.Window_PLANK_CHERRY);
            content.add(MapleFurnitureBlocks.Window_PLANK_CRIMSON);
            content.add(MapleFurnitureBlocks.Window_PLANK_WARPED);
            content.add(MapleFurnitureBlocks.Window_PLANK_GINKGO);
            content.add(MapleFurnitureBlocks.Window_PLANK_MAPLE);
            content.add(MapleFurnitureBlocks.Coffee_Table_WOOD_OAK);
            content.add(MapleFurnitureBlocks.Coffee_Table_WOOD_SPRUCE);
            content.add(MapleFurnitureBlocks.Coffee_Table_WOOD_BIRCH);
            content.add(MapleFurnitureBlocks.Coffee_Table_WOOD_JUNGLE);
            content.add(MapleFurnitureBlocks.Coffee_Table_WOOD_ACACIA);
            content.add(MapleFurnitureBlocks.Coffee_Table_WOOD_DARK_OAK);
            content.add(MapleFurnitureBlocks.Coffee_Table_WOOD_CRIMSON);
            content.add(MapleFurnitureBlocks.Coffee_Table_WOOD_WARPED);
            content.add(MapleFurnitureBlocks.Coffee_Table_WOOD_MANGROVE);
            content.add(MapleFurnitureBlocks.Coffee_Table_WOOD_BAMBOO);
            content.add(MapleFurnitureBlocks.Coffee_Table_WOOD_CHERRY);
            content.add(MapleFurnitureBlocks.Coffee_Table_Wood_MAPLE);
            content.add(MapleFurnitureBlocks.Coffee_Table_Wood_GINKGO);
            content.add(MapleFurnitureBlocks.Coffee_Table_PLANK_OAK);
            content.add(MapleFurnitureBlocks.Coffee_Table_PLANK_SPRUCE);
            content.add(MapleFurnitureBlocks.Coffee_Table_PLANK_BIRCH);
            content.add(MapleFurnitureBlocks.Coffee_Table_PLANK_JUNGLE);
            content.add(MapleFurnitureBlocks.Coffee_Table_PLANK_ACACIA);
            content.add(MapleFurnitureBlocks.Coffee_Table_PLANK_DARK_OAK);
            content.add(MapleFurnitureBlocks.Coffee_Table_PLANK_CRIMSON);
            content.add(MapleFurnitureBlocks.Coffee_Table_PLANK_WARPED);
            content.add(MapleFurnitureBlocks.Coffee_Table_PLANK_MANGROVE);
            content.add(MapleFurnitureBlocks.Coffee_Table_PLANK_BAMBOO);
            content.add(MapleFurnitureBlocks.Coffee_Table_PLANK_CHERRY);
            content.add(MapleFurnitureBlocks.Coffee_Table_PLANK_MAPLE);
            content.add(MapleFurnitureBlocks.Coffee_Table_PLANK_GINKGO);

            content.add(MapleFurnitureBlocks.Chair_WOOD_OAK);
            content.add(MapleFurnitureBlocks.Chair_WOOD_SPRUCE);
            content.add(MapleFurnitureBlocks.Chair_WOOD_BIRCH);
            content.add(MapleFurnitureBlocks.Chair_WOOD_JUNGLE);
            content.add(MapleFurnitureBlocks.Chair_WOOD_ACACIA);
            content.add(MapleFurnitureBlocks.Chair_WOOD_DARK_OAK);
            content.add(MapleFurnitureBlocks.Chair_WOOD_CRIMSON);
            content.add(MapleFurnitureBlocks.Chair_WOOD_WARPED);
            content.add(MapleFurnitureBlocks.Chair_WOOD_MANGROVE);
            content.add(MapleFurnitureBlocks.Chair_WOOD_BAMBOO);
            content.add(MapleFurnitureBlocks.Chair_WOOD_CHERRY);
            content.add(MapleFurnitureBlocks.Chair_Wood_MAPLE);
            content.add(MapleFurnitureBlocks.Chair_Wood_GINKGO);
            content.add(MapleFurnitureBlocks.Chair_PLANK_OAK);
            content.add(MapleFurnitureBlocks.Chair_PLANK_SPRUCE);
            content.add(MapleFurnitureBlocks.Chair_PLANK_BIRCH);
            content.add(MapleFurnitureBlocks.Chair_PLANK_JUNGLE);
            content.add(MapleFurnitureBlocks.Chair_PLANK_ACACIA);
            content.add(MapleFurnitureBlocks.Chair_PLANK_DARK_OAK);
            content.add(MapleFurnitureBlocks.Chair_PLANK_CRIMSON);
            content.add(MapleFurnitureBlocks.Chair_PLANK_WARPED);
            content.add(MapleFurnitureBlocks.Chair_PLANK_MANGROVE);
            content.add(MapleFurnitureBlocks.Chair_PLANK_BAMBOO);
            content.add(MapleFurnitureBlocks.Chair_PLANK_CHERRY);
            content.add(MapleFurnitureBlocks.Chair_PLANK_MAPLE);
            content.add(MapleFurnitureBlocks.Chair_PLANK_GINKGO);
            content.add(MapleFurnitureBlocks.END_TABLE_OAK);
            content.add(MapleFurnitureBlocks.END_TABLE_SPRUCE);
            content.add(MapleFurnitureBlocks.END_TABLE_BIRCH);
            content.add(MapleFurnitureBlocks.END_TABLE_JUNGLE);
            content.add(MapleFurnitureBlocks.END_TABLE_ACACIA);
            content.add(MapleFurnitureBlocks.END_TABLE_DARK_OAK);
            content.add(MapleFurnitureBlocks.END_TABLE_CRIMSON);
            content.add(MapleFurnitureBlocks.END_TABLE_WARPED);
            content.add(MapleFurnitureBlocks.END_TABLE_MANGROVE);
            content.add(MapleFurnitureBlocks.END_TABLE_BAMBOO);
            content.add(MapleFurnitureBlocks.END_TABLE_CHERRY);
            content.add(MapleFurnitureBlocks.END_TABLE_MAPLE);
            content.add(MapleFurnitureBlocks.END_TABLE_GINKGO);
        });


    }

    public static void generateWorldGen() {
    }

    public static void registerRecipeType() {
    }

    public static void registerScreenType() {
    }

    public static void registerOthers() {
        MapleEntityType.registerMapleEntityType();
    }

    public static void registerCommand() {
    }

    public static void registerMapleLootTable() {

    }

    public static void registerMapleCompostableItems() {
    }

    @Environment(EnvType.CLIENT)
    public static void registerClientEntityRenderer() {
        EntityRendererRegistry.register(MapleEntityType.CHAIR_ENTITY, ChairRenderer::new);
        EntityRendererRegistry.register(MapleEntityType.Cushion_ENTITY, CushinoRenderer::new);


    }

    @Environment(EnvType.CLIENT)
    public static void registerClientParticle() {

    }
}

