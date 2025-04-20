package com.skniro.skniro_furniture;


import com.skniro.skniro_furniture.block.entity.FurnitureBlockEntityType;
import com.skniro.skniro_furniture.block.renderer.CabinetBlockEntityRenderer;
import com.skniro.skniro_furniture.client.renderer.ChairRenderer;
import com.skniro.skniro_furniture.client.renderer.CushinoRenderer;
import com.skniro.skniro_furniture.entity.MapleEntityType;
import com.skniro.skniro_furniture.item.MapleItems;
import com.skniro.skniro_furniture.block.MapleFurnitureBlocks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;


public class FurnitureContent {


    public static void registerItem(){
        MapleItems.registerModItems();
    }
    public static void registerBlock(){
        MapleFurnitureBlocks.registerCushionBlocks();
        FurnitureBlockEntityType.registerMapleBlockEntityType();
    }

    public static void registerFluid(){
    }

    public static void CreativeTab() {
        ItemGroupEvents.modifyEntriesEvent(Furniture.Maple_Group_Furniture).register(content -> {
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

            content.add(MapleFurnitureBlocks.OAK_PLANK_COFFEE_CHAIR_WHITE);
            content.add(MapleFurnitureBlocks.OAK_PLANK_COFFEE_CHAIR_ORANGE);
            content.add(MapleFurnitureBlocks.OAK_PLANK_COFFEE_CHAIR_MAGENTA);
            content.add(MapleFurnitureBlocks.OAK_PLANK_COFFEE_CHAIR_LIGHT_BLUE);
            content.add(MapleFurnitureBlocks.OAK_PLANK_COFFEE_CHAIR_YELLOW);
            content.add(MapleFurnitureBlocks.OAK_PLANK_COFFEE_CHAIR_LIME);
            content.add(MapleFurnitureBlocks.OAK_PLANK_COFFEE_CHAIR_PINK);
            content.add(MapleFurnitureBlocks.OAK_PLANK_COFFEE_CHAIR_GRAY);
            content.add(MapleFurnitureBlocks.OAK_PLANK_COFFEE_CHAIR_LIGHT_GRAY);
            content.add(MapleFurnitureBlocks.OAK_PLANK_COFFEE_CHAIR_CYAN);
            content.add(MapleFurnitureBlocks.OAK_PLANK_COFFEE_CHAIR_PURPLE);
            content.add(MapleFurnitureBlocks.OAK_PLANK_COFFEE_CHAIR_BLUE);
            content.add(MapleFurnitureBlocks.OAK_PLANK_COFFEE_CHAIR_BROWN);
            content.add(MapleFurnitureBlocks.OAK_PLANK_COFFEE_CHAIR_GREEN);
            content.add(MapleFurnitureBlocks.OAK_PLANK_COFFEE_CHAIR_RED);
            content.add(MapleFurnitureBlocks.OAK_PLANK_COFFEE_CHAIR_BLACK);
            content.add(MapleFurnitureBlocks.SPRUCE_PLANK_COFFEE_CHAIR_WHITE);
            content.add(MapleFurnitureBlocks.SPRUCE_PLANK_COFFEE_CHAIR_ORANGE);
            content.add(MapleFurnitureBlocks.SPRUCE_PLANK_COFFEE_CHAIR_MAGENTA);
            content.add(MapleFurnitureBlocks.SPRUCE_PLANK_COFFEE_CHAIR_LIGHT_BLUE);
            content.add(MapleFurnitureBlocks.SPRUCE_PLANK_COFFEE_CHAIR_YELLOW);
            content.add(MapleFurnitureBlocks.SPRUCE_PLANK_COFFEE_CHAIR_LIME);
            content.add(MapleFurnitureBlocks.SPRUCE_PLANK_COFFEE_CHAIR_PINK);
            content.add(MapleFurnitureBlocks.SPRUCE_PLANK_COFFEE_CHAIR_GRAY);
            content.add(MapleFurnitureBlocks.SPRUCE_PLANK_COFFEE_CHAIR_LIGHT_GRAY);
            content.add(MapleFurnitureBlocks.SPRUCE_PLANK_COFFEE_CHAIR_CYAN);
            content.add(MapleFurnitureBlocks.SPRUCE_PLANK_COFFEE_CHAIR_PURPLE);
            content.add(MapleFurnitureBlocks.SPRUCE_PLANK_COFFEE_CHAIR_BLUE);
            content.add(MapleFurnitureBlocks.SPRUCE_PLANK_COFFEE_CHAIR_BROWN);
            content.add(MapleFurnitureBlocks.SPRUCE_PLANK_COFFEE_CHAIR_GREEN);
            content.add(MapleFurnitureBlocks.SPRUCE_PLANK_COFFEE_CHAIR_RED);
            content.add(MapleFurnitureBlocks.SPRUCE_PLANK_COFFEE_CHAIR_BLACK);
            content.add(MapleFurnitureBlocks.BIRCH_PLANK_COFFEE_CHAIR_WHITE);
            content.add(MapleFurnitureBlocks.BIRCH_PLANK_COFFEE_CHAIR_ORANGE);
            content.add(MapleFurnitureBlocks.BIRCH_PLANK_COFFEE_CHAIR_MAGENTA);
            content.add(MapleFurnitureBlocks.BIRCH_PLANK_COFFEE_CHAIR_LIGHT_BLUE);
            content.add(MapleFurnitureBlocks.BIRCH_PLANK_COFFEE_CHAIR_YELLOW);
            content.add(MapleFurnitureBlocks.BIRCH_PLANK_COFFEE_CHAIR_LIME);
            content.add(MapleFurnitureBlocks.BIRCH_PLANK_COFFEE_CHAIR_PINK);
            content.add(MapleFurnitureBlocks.BIRCH_PLANK_COFFEE_CHAIR_GRAY);
            content.add(MapleFurnitureBlocks.BIRCH_PLANK_COFFEE_CHAIR_LIGHT_GRAY);
            content.add(MapleFurnitureBlocks.BIRCH_PLANK_COFFEE_CHAIR_CYAN);
            content.add(MapleFurnitureBlocks.BIRCH_PLANK_COFFEE_CHAIR_PURPLE);
            content.add(MapleFurnitureBlocks.BIRCH_PLANK_COFFEE_CHAIR_BLUE);
            content.add(MapleFurnitureBlocks.BIRCH_PLANK_COFFEE_CHAIR_BROWN);
            content.add(MapleFurnitureBlocks.BIRCH_PLANK_COFFEE_CHAIR_GREEN);
            content.add(MapleFurnitureBlocks.BIRCH_PLANK_COFFEE_CHAIR_RED);
            content.add(MapleFurnitureBlocks.BIRCH_PLANK_COFFEE_CHAIR_BLACK);
            content.add(MapleFurnitureBlocks.JUNGLE_PLANK_COFFEE_CHAIR_WHITE);
            content.add(MapleFurnitureBlocks.JUNGLE_PLANK_COFFEE_CHAIR_ORANGE);
            content.add(MapleFurnitureBlocks.JUNGLE_PLANK_COFFEE_CHAIR_MAGENTA);
            content.add(MapleFurnitureBlocks.JUNGLE_PLANK_COFFEE_CHAIR_LIGHT_BLUE);
            content.add(MapleFurnitureBlocks.JUNGLE_PLANK_COFFEE_CHAIR_YELLOW);
            content.add(MapleFurnitureBlocks.JUNGLE_PLANK_COFFEE_CHAIR_LIME);
            content.add(MapleFurnitureBlocks.JUNGLE_PLANK_COFFEE_CHAIR_PINK);
            content.add(MapleFurnitureBlocks.JUNGLE_PLANK_COFFEE_CHAIR_GRAY);
            content.add(MapleFurnitureBlocks.JUNGLE_PLANK_COFFEE_CHAIR_LIGHT_GRAY);
            content.add(MapleFurnitureBlocks.JUNGLE_PLANK_COFFEE_CHAIR_CYAN);
            content.add(MapleFurnitureBlocks.JUNGLE_PLANK_COFFEE_CHAIR_PURPLE);
            content.add(MapleFurnitureBlocks.JUNGLE_PLANK_COFFEE_CHAIR_BLUE);
            content.add(MapleFurnitureBlocks.JUNGLE_PLANK_COFFEE_CHAIR_BROWN);
            content.add(MapleFurnitureBlocks.JUNGLE_PLANK_COFFEE_CHAIR_GREEN);
            content.add(MapleFurnitureBlocks.JUNGLE_PLANK_COFFEE_CHAIR_RED);
            content.add(MapleFurnitureBlocks.JUNGLE_PLANK_COFFEE_CHAIR_BLACK);
            content.add(MapleFurnitureBlocks.ACACIA_PLANK_COFFEE_CHAIR_WHITE);
            content.add(MapleFurnitureBlocks.ACACIA_PLANK_COFFEE_CHAIR_ORANGE);
            content.add(MapleFurnitureBlocks.ACACIA_PLANK_COFFEE_CHAIR_MAGENTA);
            content.add(MapleFurnitureBlocks.ACACIA_PLANK_COFFEE_CHAIR_LIGHT_BLUE);
            content.add(MapleFurnitureBlocks.ACACIA_PLANK_COFFEE_CHAIR_YELLOW);
            content.add(MapleFurnitureBlocks.ACACIA_PLANK_COFFEE_CHAIR_LIME);
            content.add(MapleFurnitureBlocks.ACACIA_PLANK_COFFEE_CHAIR_PINK);
            content.add(MapleFurnitureBlocks.ACACIA_PLANK_COFFEE_CHAIR_GRAY);
            content.add(MapleFurnitureBlocks.ACACIA_PLANK_COFFEE_CHAIR_LIGHT_GRAY);
            content.add(MapleFurnitureBlocks.ACACIA_PLANK_COFFEE_CHAIR_CYAN);
            content.add(MapleFurnitureBlocks.ACACIA_PLANK_COFFEE_CHAIR_PURPLE);
            content.add(MapleFurnitureBlocks.ACACIA_PLANK_COFFEE_CHAIR_BLUE);
            content.add(MapleFurnitureBlocks.ACACIA_PLANK_COFFEE_CHAIR_BROWN);
            content.add(MapleFurnitureBlocks.ACACIA_PLANK_COFFEE_CHAIR_GREEN);
            content.add(MapleFurnitureBlocks.ACACIA_PLANK_COFFEE_CHAIR_RED);
            content.add(MapleFurnitureBlocks.ACACIA_PLANK_COFFEE_CHAIR_BLACK);
            content.add(MapleFurnitureBlocks.DARK_OAK_PLANK_COFFEE_CHAIR_WHITE);
            content.add(MapleFurnitureBlocks.DARK_OAK_PLANK_COFFEE_CHAIR_ORANGE);
            content.add(MapleFurnitureBlocks.DARK_OAK_PLANK_COFFEE_CHAIR_MAGENTA);
            content.add(MapleFurnitureBlocks.DARK_OAK_PLANK_COFFEE_CHAIR_LIGHT_BLUE);
            content.add(MapleFurnitureBlocks.DARK_OAK_PLANK_COFFEE_CHAIR_YELLOW);
            content.add(MapleFurnitureBlocks.DARK_OAK_PLANK_COFFEE_CHAIR_LIME);
            content.add(MapleFurnitureBlocks.DARK_OAK_PLANK_COFFEE_CHAIR_PINK);
            content.add(MapleFurnitureBlocks.DARK_OAK_PLANK_COFFEE_CHAIR_GRAY);
            content.add(MapleFurnitureBlocks.DARK_OAK_PLANK_COFFEE_CHAIR_LIGHT_GRAY);
            content.add(MapleFurnitureBlocks.DARK_OAK_PLANK_COFFEE_CHAIR_CYAN);
            content.add(MapleFurnitureBlocks.DARK_OAK_PLANK_COFFEE_CHAIR_PURPLE);
            content.add(MapleFurnitureBlocks.DARK_OAK_PLANK_COFFEE_CHAIR_BLUE);
            content.add(MapleFurnitureBlocks.DARK_OAK_PLANK_COFFEE_CHAIR_BROWN);
            content.add(MapleFurnitureBlocks.DARK_OAK_PLANK_COFFEE_CHAIR_GREEN);
            content.add(MapleFurnitureBlocks.DARK_OAK_PLANK_COFFEE_CHAIR_RED);
            content.add(MapleFurnitureBlocks.DARK_OAK_PLANK_COFFEE_CHAIR_BLACK);
            content.add(MapleFurnitureBlocks.MANGROVE_PLANK_COFFEE_CHAIR_WHITE);
            content.add(MapleFurnitureBlocks.MANGROVE_PLANK_COFFEE_CHAIR_ORANGE);
            content.add(MapleFurnitureBlocks.MANGROVE_PLANK_COFFEE_CHAIR_MAGENTA);
            content.add(MapleFurnitureBlocks.MANGROVE_PLANK_COFFEE_CHAIR_LIGHT_BLUE);
            content.add(MapleFurnitureBlocks.MANGROVE_PLANK_COFFEE_CHAIR_YELLOW);
            content.add(MapleFurnitureBlocks.MANGROVE_PLANK_COFFEE_CHAIR_LIME);
            content.add(MapleFurnitureBlocks.MANGROVE_PLANK_COFFEE_CHAIR_PINK);
            content.add(MapleFurnitureBlocks.MANGROVE_PLANK_COFFEE_CHAIR_GRAY);
            content.add(MapleFurnitureBlocks.MANGROVE_PLANK_COFFEE_CHAIR_LIGHT_GRAY);
            content.add(MapleFurnitureBlocks.MANGROVE_PLANK_COFFEE_CHAIR_CYAN);
            content.add(MapleFurnitureBlocks.MANGROVE_PLANK_COFFEE_CHAIR_PURPLE);
            content.add(MapleFurnitureBlocks.MANGROVE_PLANK_COFFEE_CHAIR_BLUE);
            content.add(MapleFurnitureBlocks.MANGROVE_PLANK_COFFEE_CHAIR_BROWN);
            content.add(MapleFurnitureBlocks.MANGROVE_PLANK_COFFEE_CHAIR_GREEN);
            content.add(MapleFurnitureBlocks.MANGROVE_PLANK_COFFEE_CHAIR_RED);
            content.add(MapleFurnitureBlocks.MANGROVE_PLANK_COFFEE_CHAIR_BLACK);
            content.add(MapleFurnitureBlocks.CHERRY_PLANK_COFFEE_CHAIR_WHITE);
            content.add(MapleFurnitureBlocks.CHERRY_PLANK_COFFEE_CHAIR_ORANGE);
            content.add(MapleFurnitureBlocks.CHERRY_PLANK_COFFEE_CHAIR_MAGENTA);
            content.add(MapleFurnitureBlocks.CHERRY_PLANK_COFFEE_CHAIR_LIGHT_BLUE);
            content.add(MapleFurnitureBlocks.CHERRY_PLANK_COFFEE_CHAIR_YELLOW);
            content.add(MapleFurnitureBlocks.CHERRY_PLANK_COFFEE_CHAIR_LIME);
            content.add(MapleFurnitureBlocks.CHERRY_PLANK_COFFEE_CHAIR_PINK);
            content.add(MapleFurnitureBlocks.CHERRY_PLANK_COFFEE_CHAIR_GRAY);
            content.add(MapleFurnitureBlocks.CHERRY_PLANK_COFFEE_CHAIR_LIGHT_GRAY);
            content.add(MapleFurnitureBlocks.CHERRY_PLANK_COFFEE_CHAIR_CYAN);
            content.add(MapleFurnitureBlocks.CHERRY_PLANK_COFFEE_CHAIR_PURPLE);
            content.add(MapleFurnitureBlocks.CHERRY_PLANK_COFFEE_CHAIR_BLUE);
            content.add(MapleFurnitureBlocks.CHERRY_PLANK_COFFEE_CHAIR_BROWN);
            content.add(MapleFurnitureBlocks.CHERRY_PLANK_COFFEE_CHAIR_GREEN);
            content.add(MapleFurnitureBlocks.CHERRY_PLANK_COFFEE_CHAIR_RED);
            content.add(MapleFurnitureBlocks.CHERRY_PLANK_COFFEE_CHAIR_BLACK);
            content.add(MapleFurnitureBlocks.BAMBOO_PLANK_COFFEE_CHAIR_WHITE);
            content.add(MapleFurnitureBlocks.BAMBOO_PLANK_COFFEE_CHAIR_ORANGE);
            content.add(MapleFurnitureBlocks.BAMBOO_PLANK_COFFEE_CHAIR_MAGENTA);
            content.add(MapleFurnitureBlocks.BAMBOO_PLANK_COFFEE_CHAIR_LIGHT_BLUE);
            content.add(MapleFurnitureBlocks.BAMBOO_PLANK_COFFEE_CHAIR_YELLOW);
            content.add(MapleFurnitureBlocks.BAMBOO_PLANK_COFFEE_CHAIR_LIME);
            content.add(MapleFurnitureBlocks.BAMBOO_PLANK_COFFEE_CHAIR_PINK);
            content.add(MapleFurnitureBlocks.BAMBOO_PLANK_COFFEE_CHAIR_GRAY);
            content.add(MapleFurnitureBlocks.BAMBOO_PLANK_COFFEE_CHAIR_LIGHT_GRAY);
            content.add(MapleFurnitureBlocks.BAMBOO_PLANK_COFFEE_CHAIR_CYAN);
            content.add(MapleFurnitureBlocks.BAMBOO_PLANK_COFFEE_CHAIR_PURPLE);
            content.add(MapleFurnitureBlocks.BAMBOO_PLANK_COFFEE_CHAIR_BLUE);
            content.add(MapleFurnitureBlocks.BAMBOO_PLANK_COFFEE_CHAIR_BROWN);
            content.add(MapleFurnitureBlocks.BAMBOO_PLANK_COFFEE_CHAIR_GREEN);
            content.add(MapleFurnitureBlocks.BAMBOO_PLANK_COFFEE_CHAIR_RED);
            content.add(MapleFurnitureBlocks.BAMBOO_PLANK_COFFEE_CHAIR_BLACK);
            content.add(MapleFurnitureBlocks.CRIMSON_PLANK_COFFEE_CHAIR_WHITE);
            content.add(MapleFurnitureBlocks.CRIMSON_PLANK_COFFEE_CHAIR_ORANGE);
            content.add(MapleFurnitureBlocks.CRIMSON_PLANK_COFFEE_CHAIR_MAGENTA);
            content.add(MapleFurnitureBlocks.CRIMSON_PLANK_COFFEE_CHAIR_LIGHT_BLUE);
            content.add(MapleFurnitureBlocks.CRIMSON_PLANK_COFFEE_CHAIR_YELLOW);
            content.add(MapleFurnitureBlocks.CRIMSON_PLANK_COFFEE_CHAIR_LIME);
            content.add(MapleFurnitureBlocks.CRIMSON_PLANK_COFFEE_CHAIR_PINK);
            content.add(MapleFurnitureBlocks.CRIMSON_PLANK_COFFEE_CHAIR_GRAY);
            content.add(MapleFurnitureBlocks.CRIMSON_PLANK_COFFEE_CHAIR_LIGHT_GRAY);
            content.add(MapleFurnitureBlocks.CRIMSON_PLANK_COFFEE_CHAIR_CYAN);
            content.add(MapleFurnitureBlocks.CRIMSON_PLANK_COFFEE_CHAIR_PURPLE);
            content.add(MapleFurnitureBlocks.CRIMSON_PLANK_COFFEE_CHAIR_BLUE);
            content.add(MapleFurnitureBlocks.CRIMSON_PLANK_COFFEE_CHAIR_BROWN);
            content.add(MapleFurnitureBlocks.CRIMSON_PLANK_COFFEE_CHAIR_GREEN);
            content.add(MapleFurnitureBlocks.CRIMSON_PLANK_COFFEE_CHAIR_RED);
            content.add(MapleFurnitureBlocks.CRIMSON_PLANK_COFFEE_CHAIR_BLACK);
            content.add(MapleFurnitureBlocks.WARPED_PLANK_COFFEE_CHAIR_WHITE);
            content.add(MapleFurnitureBlocks.WARPED_PLANK_COFFEE_CHAIR_ORANGE);
            content.add(MapleFurnitureBlocks.WARPED_PLANK_COFFEE_CHAIR_MAGENTA);
            content.add(MapleFurnitureBlocks.WARPED_PLANK_COFFEE_CHAIR_LIGHT_BLUE);
            content.add(MapleFurnitureBlocks.WARPED_PLANK_COFFEE_CHAIR_YELLOW);
            content.add(MapleFurnitureBlocks.WARPED_PLANK_COFFEE_CHAIR_LIME);
            content.add(MapleFurnitureBlocks.WARPED_PLANK_COFFEE_CHAIR_PINK);
            content.add(MapleFurnitureBlocks.WARPED_PLANK_COFFEE_CHAIR_GRAY);
            content.add(MapleFurnitureBlocks.WARPED_PLANK_COFFEE_CHAIR_LIGHT_GRAY);
            content.add(MapleFurnitureBlocks.WARPED_PLANK_COFFEE_CHAIR_CYAN);
            content.add(MapleFurnitureBlocks.WARPED_PLANK_COFFEE_CHAIR_PURPLE);
            content.add(MapleFurnitureBlocks.WARPED_PLANK_COFFEE_CHAIR_BLUE);
            content.add(MapleFurnitureBlocks.WARPED_PLANK_COFFEE_CHAIR_BROWN);
            content.add(MapleFurnitureBlocks.WARPED_PLANK_COFFEE_CHAIR_GREEN);
            content.add(MapleFurnitureBlocks.WARPED_PLANK_COFFEE_CHAIR_RED);
            content.add(MapleFurnitureBlocks.WARPED_PLANK_COFFEE_CHAIR_BLACK);

            content.add(MapleFurnitureBlocks.OAK_PLANK_TRIPLE_CABINET);
            content.add(MapleFurnitureBlocks.OAK_WOOD_TRIPLE_CABINET);
            content.add(MapleFurnitureBlocks.SPRUCE_PLANK_TRIPLE_CABINET);
            content.add(MapleFurnitureBlocks.SPRUCE_WOOD_TRIPLE_CABINET);
            content.add(MapleFurnitureBlocks.BIRCH_PLANK_TRIPLE_CABINET);
            content.add(MapleFurnitureBlocks.BIRCH_WOOD_TRIPLE_CABINET);
            content.add(MapleFurnitureBlocks.JUNGLE_PLANK_TRIPLE_CABINET);
            content.add(MapleFurnitureBlocks.JUNGLE_WOOD_TRIPLE_CABINET);
            content.add(MapleFurnitureBlocks.ACACIA_PLANK_TRIPLE_CABINET);
            content.add(MapleFurnitureBlocks.ACACIA_WOOD_TRIPLE_CABINET);
            content.add(MapleFurnitureBlocks.DARK_OAK_PLANK_TRIPLE_CABINET);
            content.add(MapleFurnitureBlocks.DARK_OAK_WOOD_TRIPLE_CABINET);
            content.add(MapleFurnitureBlocks.MANGROVE_PLANK_TRIPLE_CABINET);
            content.add(MapleFurnitureBlocks.MANGROVE_WOOD_TRIPLE_CABINET);
            content.add(MapleFurnitureBlocks.CHERRY_PLANK_TRIPLE_CABINET);
            content.add(MapleFurnitureBlocks.CHERRY_WOOD_TRIPLE_CABINET);
            content.add(MapleFurnitureBlocks.BAMBOO_PLANK_TRIPLE_CABINET);
            content.add(MapleFurnitureBlocks.BAMBOO_WOOD_TRIPLE_CABINET);
            content.add(MapleFurnitureBlocks.CRIMSON_PLANK_TRIPLE_CABINET);
            content.add(MapleFurnitureBlocks.CRIMSON_WOOD_TRIPLE_CABINET);
            content.add(MapleFurnitureBlocks.WARPED_PLANK_TRIPLE_CABINET);
            content.add(MapleFurnitureBlocks.WARPED_WOOD_TRIPLE_CABINET);

            content.add(MapleFurnitureBlocks.OAK_WOOD_Four_Grid_Cabinet);
            content.add(MapleFurnitureBlocks.OAK_PLANKS_Four_Grid_Cabinet);
            content.add(MapleFurnitureBlocks.SPRUCE_WOOD_Four_Grid_Cabinet);
            content.add(MapleFurnitureBlocks.SPRUCE_PLANKS_Four_Grid_Cabinet);
            content.add(MapleFurnitureBlocks.BIRCH_WOOD_Four_Grid_Cabinet);
            content.add(MapleFurnitureBlocks.BIRCH_PLANKS_Four_Grid_Cabinet);
            content.add(MapleFurnitureBlocks.JUNGLE_WOOD_Four_Grid_Cabinet);
            content.add(MapleFurnitureBlocks.JUNGLE_PLANKS_Four_Grid_Cabinet);
            content.add(MapleFurnitureBlocks.ACACIA_WOOD_Four_Grid_Cabinet);
            content.add(MapleFurnitureBlocks.ACACIA_PLANKS_Four_Grid_Cabinet);
            content.add(MapleFurnitureBlocks.DARK_OAK_WOOD_Four_Grid_Cabinet);
            content.add(MapleFurnitureBlocks.DARK_OAK_PLANKS_Four_Grid_Cabinet);
            content.add(MapleFurnitureBlocks.MANGROVE_WOOD_Four_Grid_Cabinet);
            content.add(MapleFurnitureBlocks.MANGROVE_PLANKS_Four_Grid_Cabinet);
            content.add(MapleFurnitureBlocks.CHERRY_WOOD_Four_Grid_Cabinet);
            content.add(MapleFurnitureBlocks.CHERRY_PLANKS_Four_Grid_Cabinet);
            content.add(MapleFurnitureBlocks.CRIMSON_HYPHAE_Four_Grid_Cabinet);
            content.add(MapleFurnitureBlocks.CRIMSON_PLANKS_Four_Grid_Cabinet);
            content.add(MapleFurnitureBlocks.WARPED_HYPHAE_Four_Grid_Cabinet);
            content.add(MapleFurnitureBlocks.WARPED_PLANKS_Four_Grid_Cabinet);
            content.add(MapleFurnitureBlocks.BAMBOO_BLOCK_Four_Grid_Cabinet);
            content.add(MapleFurnitureBlocks.BAMBOO_PLANKS_Four_Grid_Cabinet);

            content.add(MapleFurnitureBlocks.WHITE_KITCHEN_COUNTER);
            content.add(MapleFurnitureBlocks.ORANGE_KITCHEN_COUNTER);
            content.add(MapleFurnitureBlocks.MAGENTA_KITCHEN_COUNTER);
            content.add(MapleFurnitureBlocks.LIGHT_BLUE_KITCHEN_COUNTER);
            content.add(MapleFurnitureBlocks.YELLOW_KITCHEN_COUNTER);
            content.add(MapleFurnitureBlocks.LIME_KITCHEN_COUNTER);
            content.add(MapleFurnitureBlocks.PINK_KITCHEN_COUNTER);
            content.add(MapleFurnitureBlocks.GRAY_KITCHEN_COUNTER);
            content.add(MapleFurnitureBlocks.LIGHT_GRAY_KITCHEN_COUNTER);
            content.add(MapleFurnitureBlocks.CYAN_KITCHEN_COUNTER);
            content.add(MapleFurnitureBlocks.PURPLE_KITCHEN_COUNTER);
            content.add(MapleFurnitureBlocks.BLUE_KITCHEN_COUNTER);
            content.add(MapleFurnitureBlocks.BROWN_KITCHEN_COUNTER);
            content.add(MapleFurnitureBlocks.GREEN_KITCHEN_COUNTER);
            content.add(MapleFurnitureBlocks.RED_KITCHEN_COUNTER);
            content.add(MapleFurnitureBlocks.BLACK_KITCHEN_COUNTER);


            content.add(MapleFurnitureBlocks.WHITE_KITCHEN_COUNTER_DRAWER);
            content.add(MapleFurnitureBlocks.ORANGE_KITCHEN_COUNTER_DRAWER);
            content.add(MapleFurnitureBlocks.MAGENTA_KITCHEN_COUNTER_DRAWER);
            content.add(MapleFurnitureBlocks.LIGHT_BLUE_KITCHEN_COUNTER_DRAWER);
            content.add(MapleFurnitureBlocks.YELLOW_KITCHEN_COUNTER_DRAWER);
            content.add(MapleFurnitureBlocks.LIME_KITCHEN_COUNTER_DRAWER);
            content.add(MapleFurnitureBlocks.PINK_KITCHEN_COUNTER_DRAWER);
            content.add(MapleFurnitureBlocks.GRAY_KITCHEN_COUNTER_DRAWER);
            content.add(MapleFurnitureBlocks.LIGHT_GRAY_KITCHEN_COUNTER_DRAWER);
            content.add(MapleFurnitureBlocks.CYAN_KITCHEN_COUNTER_DRAWER);
            content.add(MapleFurnitureBlocks.PURPLE_KITCHEN_COUNTER_DRAWER);
            content.add(MapleFurnitureBlocks.BLUE_KITCHEN_COUNTER_DRAWER);
            content.add(MapleFurnitureBlocks.BROWN_KITCHEN_COUNTER_DRAWER);
            content.add(MapleFurnitureBlocks.GREEN_KITCHEN_COUNTER_DRAWER);
            content.add(MapleFurnitureBlocks.RED_KITCHEN_COUNTER_DRAWER);
            content.add(MapleFurnitureBlocks.BLACK_KITCHEN_COUNTER_DRAWER);
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

