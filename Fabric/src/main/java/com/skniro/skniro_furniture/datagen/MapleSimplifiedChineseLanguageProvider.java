package com.skniro.skniro_furniture.datagen;

import com.skniro.skniro_furniture.Furniture;
import com.skniro.skniro_furniture.block.MapleFurnitureBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public class MapleSimplifiedChineseLanguageProvider extends FabricLanguageProvider {
    public MapleSimplifiedChineseLanguageProvider(FabricDataOutput dataGenerator, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup){
        super(dataGenerator, "zh_cn", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {

        translationBuilder.add(Furniture.Maple_Group_Furniture,"Skniro的家具");
        translationBuilder.add(Furniture.Furniture_Group_Bedroom_Furniture,"卧室家具");
        translationBuilder.add(Furniture.Furniture_Group_Kitchen_Furniture,"厨房家具");
        translationBuilder.add(Furniture.Furniture_Group_Livingroom_Furniture,"起居室家具");

        //cushion
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_OAK_WHITE,"白色橡木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_OAK_ORANGE,"橙色橡木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_OAK_MAGENTA,"品红色橡木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_OAK_LIGHT_BLUE,"淡蓝色橡木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_OAK_YELLOW,"黄色橡木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_OAK_LIME,"黄绿色橡木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_OAK_PINK,"粉色橡木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_OAK_GRAY,"灰色橡木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_OAK_LIGHT_GRAY,"淡灰色橡木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_OAK_CYAN,"青色橡木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_OAK_PURPLE,"紫色橡木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_OAK_BLUE,"蓝色橡木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_OAK_BROWN,"棕色橡木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_OAK_GREEN,"绿色橡木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_OAK_RED,"红色橡木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_OAK_BLACK,"黑色橡木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_SPRUCE_WHITE,"白色云杉木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_SPRUCE_ORANGE,"橙色云杉木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_SPRUCE_MAGENTA,"品红色云杉木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_SPRUCE_LIGHT_BLUE,"淡蓝色云杉木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_SPRUCE_YELLOW,"黄色云杉木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_SPRUCE_LIME,"黄绿色云杉木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_SPRUCE_PINK,"粉色云杉木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_SPRUCE_GRAY,"灰色云杉木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_SPRUCE_LIGHT_GRAY,"淡灰色云杉木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_SPRUCE_CYAN,"青色云杉木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_SPRUCE_PURPLE,"紫色云杉木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_SPRUCE_BLUE,"蓝色云杉木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_SPRUCE_BROWN,"棕色云杉木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_SPRUCE_GREEN,"绿色云杉木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_SPRUCE_RED,"红色云杉木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_SPRUCE_BLACK,"黑色云杉木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_BIRCH_WHITE,"白色白桦木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_BIRCH_ORANGE,"橙色白桦木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_BIRCH_MAGENTA,"品红色白桦木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_BIRCH_LIGHT_BLUE,"淡蓝色白桦木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_BIRCH_YELLOW,"黄色白桦木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_BIRCH_LIME,"黄绿色白桦木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_BIRCH_PINK,"粉色白桦木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_BIRCH_GRAY,"灰色白桦木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_BIRCH_LIGHT_GRAY,"淡灰色白桦木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_BIRCH_CYAN,"青色白桦木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_BIRCH_PURPLE,"紫色白桦木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_BIRCH_BLUE,"蓝色白桦木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_BIRCH_BROWN,"棕色白桦木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_BIRCH_GREEN,"绿色白桦木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_BIRCH_RED,"红色白桦木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_BIRCH_BLACK,"黑色白桦木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_JUNGLE_YELLOW,"黄色丛林木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_JUNGLE_LIME,"黄绿色丛林木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_JUNGLE_PINK,"粉色丛林木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_JUNGLE_GRAY,"灰色丛林木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_JUNGLE_LIGHT_GRAY,"淡灰色丛林木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_JUNGLE_CYAN,"青色丛林木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_JUNGLE_PURPLE,"紫色丛林木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_JUNGLE_BLUE,"蓝色丛林木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_JUNGLE_BROWN,"棕色丛林木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_JUNGLE_GREEN,"绿色丛林木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_JUNGLE_RED,"红色丛林木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_JUNGLE_BLACK,"黑色丛林木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_JUNGLE_WHITE,"白色丛林木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_JUNGLE_ORANGE,"橙色丛林木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_JUNGLE_MAGENTA,"品红色丛林木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_JUNGLE_LIGHT_BLUE,"淡蓝色丛林木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_ACACIA_WHITE,"白色金合欢木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_ACACIA_ORANGE,"橙色金合欢木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_ACACIA_MAGENTA,"品红色金合欢木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_ACACIA_LIGHT_BLUE,"淡蓝色金合欢木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_ACACIA_YELLOW,"黄色金合欢木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_ACACIA_LIME,"黄绿色金合欢木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_ACACIA_PINK,"粉色金合欢木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_ACACIA_GRAY,"灰色金合欢木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_ACACIA_LIGHT_GRAY,"淡灰色金合欢木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_ACACIA_CYAN,"青色金合欢木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_ACACIA_PURPLE,"紫色金合欢木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_ACACIA_BLUE,"蓝色金合欢木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_ACACIA_BROWN,"棕色金合欢木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_ACACIA_GREEN,"绿色金合欢木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_ACACIA_RED,"红色金合欢木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_ACACIA_BLACK,"黑色金合欢木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_DARK_OAK_WHITE,"白色深色橡木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_DARK_OAK_ORANGE,"橙色深色橡木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_DARK_OAK_MAGENTA,"品红色深色橡木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_DARK_OAK_LIGHT_BLUE,"淡蓝色深色橡木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_DARK_OAK_YELLOW,"黄色深色橡木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_DARK_OAK_LIME,"黄绿色深色橡木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_DARK_OAK_PINK,"粉色深色橡木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_DARK_OAK_GRAY,"灰色深色橡木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_DARK_OAK_LIGHT_GRAY,"淡灰色深色橡木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_DARK_OAK_CYAN,"青色深色橡木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_DARK_OAK_PURPLE,"紫色深色橡木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_DARK_OAK_BLUE,"蓝色深色橡木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_DARK_OAK_BROWN,"棕色深色橡木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_DARK_OAK_GREEN,"绿色深色橡木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_DARK_OAK_RED,"红色深色橡木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_DARK_OAK_BLACK,"黑色深色橡木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_CRIMSON_WHITE,"白色绯红木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_CRIMSON_ORANGE,"橙色绯红木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_CRIMSON_MAGENTA,"品红色绯红木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_CRIMSON_LIGHT_BLUE,"淡蓝色绯红木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_CRIMSON_YELLOW,"黄色绯红木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_CRIMSON_LIME,"黄绿色绯红木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_CRIMSON_PINK,"粉色绯红木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_CRIMSON_GRAY,"灰色绯红木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_CRIMSON_LIGHT_GRAY,"淡灰色绯红木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_CRIMSON_CYAN,"青色绯红木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_CRIMSON_PURPLE,"紫色绯红木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_CRIMSON_BLUE,"蓝色绯红木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_CRIMSON_BROWN,"棕色绯红木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_CRIMSON_GREEN,"绿色绯红木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_CRIMSON_RED,"红色绯红木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_CRIMSON_BLACK,"黑色绯红木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_WARPED_WHITE,"白色诡异木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_WARPED_ORANGE,"橙色诡异木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_WARPED_MAGENTA,"品红色诡异木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_WARPED_LIGHT_BLUE,"淡蓝色诡异木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_WARPED_YELLOW,"黄色诡异木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_WARPED_LIME,"黄绿色诡异木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_WARPED_PINK,"粉色诡异木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_WARPED_GRAY,"灰色诡异木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_WARPED_LIGHT_GRAY,"淡灰色诡异木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_WARPED_CYAN,"青色诡异木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_WARPED_PURPLE,"紫色诡异木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_WARPED_BLUE,"蓝色诡异木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_WARPED_BROWN,"棕色诡异木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_WARPED_GREEN,"绿色诡异木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_WARPED_RED,"红色诡异木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_WARPED_BLACK,"黑色诡异木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_MANGROVE_WHITE,"白色红树木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_MANGROVE_ORANGE,"橙色红树木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_MANGROVE_MAGENTA,"品红色红树木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_MANGROVE_LIGHT_BLUE,"淡蓝色红树木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_MANGROVE_YELLOW,"黄色红树木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_MANGROVE_LIME,"黄绿色红树木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_MANGROVE_PINK,"粉色红树木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_MANGROVE_GRAY,"灰色红树木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_MANGROVE_LIGHT_GRAY,"淡灰色红树木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_MANGROVE_CYAN,"青色红树木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_MANGROVE_PURPLE,"紫色红树木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_MANGROVE_BLUE,"蓝色红树木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_MANGROVE_BROWN,"棕色红树木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_MANGROVE_GREEN,"绿色红树木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_MANGROVE_RED,"红色红树木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_MANGROVE_BLACK,"黑色红树木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_CHERRY_WHITE,"白色樱花木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_CHERRY_ORANGE,"橙色樱花木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_CHERRY_MAGENTA,"品红色樱花木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_CHERRY_LIGHT_BLUE,"淡蓝色樱花木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_CHERRY_YELLOW,"黄色樱花木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_CHERRY_LIME,"黄绿色樱花木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_CHERRY_PINK,"粉色樱花木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_CHERRY_GRAY,"灰色樱花木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_CHERRY_LIGHT_GRAY,"淡灰色樱花木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_CHERRY_CYAN,"青色樱花木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_CHERRY_PURPLE,"紫色樱花木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_CHERRY_BLUE,"蓝色樱花木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_CHERRY_BROWN,"棕色樱花木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_CHERRY_GREEN,"绿色樱花木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_CHERRY_RED,"红色樱花木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_CHERRY_BLACK,"黑色樱花木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_BAMBOO_WHITE,"白色竹木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_BAMBOO_ORANGE,"橙色竹木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_BAMBOO_MAGENTA,"品红色竹木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_BAMBOO_LIGHT_BLUE,"淡蓝色竹木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_BAMBOO_YELLOW,"黄色竹木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_BAMBOO_LIME,"黄绿色竹木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_BAMBOO_PINK,"粉色竹木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_BAMBOO_GRAY,"灰色竹木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_BAMBOO_LIGHT_GRAY,"淡灰色竹木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_BAMBOO_CYAN,"青色竹木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_BAMBOO_PURPLE,"紫色竹木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_BAMBOO_BLUE,"蓝色竹木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_BAMBOO_BROWN,"棕色竹木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_BAMBOO_GREEN,"绿色竹木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_BAMBOO_RED,"红色竹木坐垫");
        translationBuilder.add(MapleFurnitureBlocks.CUSHION_BAMBOO_BLACK,"黑色竹木坐垫");


        //Table
        translationBuilder.add(MapleFurnitureBlocks.TABLE_OAK,"橡木桌");
        translationBuilder.add(MapleFurnitureBlocks.TABLE_SPRUCE,"云杉木桌");
        translationBuilder.add(MapleFurnitureBlocks.TABLE_BIRCH,"白桦木桌");
        translationBuilder.add(MapleFurnitureBlocks.TABLE_JUNGLE,"丛林木桌");
        translationBuilder.add(MapleFurnitureBlocks.TABLE_ACACIA,"金合欢木桌");
        translationBuilder.add(MapleFurnitureBlocks.TABLE_DARK_OAK,"深色橡木桌");
        translationBuilder.add(MapleFurnitureBlocks.TABLE_CRIMSON,"绯红木桌");
        translationBuilder.add(MapleFurnitureBlocks.TABLE_WARPED,"诡异木桌");
        translationBuilder.add(MapleFurnitureBlocks.TABLE_MANGROVE,"红树木桌");
        translationBuilder.add(MapleFurnitureBlocks.TABLE_BAMBOO,"竹木桌");
        translationBuilder.add(MapleFurnitureBlocks.TABLE_CHERRY,"樱花木桌");


        //Window
        translationBuilder.add(MapleFurnitureBlocks.Window_WOOD_OAK,"橡木木窗");
        translationBuilder.add(MapleFurnitureBlocks.Window_WOOD_BIRCH,"白桦木木窗");
        translationBuilder.add(MapleFurnitureBlocks.Window_WOOD_SPRUCE,"云杉木木窗");
        translationBuilder.add(MapleFurnitureBlocks.Window_WOOD_JUNGLE,"丛林木木窗");
        translationBuilder.add(MapleFurnitureBlocks.Window_WOOD_DARK_OAK,"深色橡木木窗");
        translationBuilder.add(MapleFurnitureBlocks.Window_WOOD_ACACIA,"金合欢木木窗");
        translationBuilder.add(MapleFurnitureBlocks.Window_WOOD_MANGROVE,"红树木木窗");
        translationBuilder.add(MapleFurnitureBlocks.Window_WOOD_CHERRY,"樱花木木窗");
        translationBuilder.add(MapleFurnitureBlocks.Window_WOOD_CRIMSON,"绯红木木窗");
        translationBuilder.add(MapleFurnitureBlocks.Window_WOOD_WARPED,"诡异木木窗");
        translationBuilder.add(MapleFurnitureBlocks.Window_PLANK_OAK,"橡木木板窗");
        translationBuilder.add(MapleFurnitureBlocks.Window_PLANK_BIRCH,"白桦木木板窗");
        translationBuilder.add(MapleFurnitureBlocks.Window_PLANK_SPRUCE,"云杉木木板窗");
        translationBuilder.add(MapleFurnitureBlocks.Window_PLANK_JUNGLE,"丛林木木板窗");
        translationBuilder.add(MapleFurnitureBlocks.Window_PLANK_DARK_OAK,"深色橡木木板窗");
        translationBuilder.add(MapleFurnitureBlocks.Window_PLANK_ACACIA,"金合欢木木板窗");
        translationBuilder.add(MapleFurnitureBlocks.Window_PLANK_MANGROVE,"红树木木板窗");
        translationBuilder.add(MapleFurnitureBlocks.Window_PLANK_CHERRY,"樱花木木板窗");
        translationBuilder.add(MapleFurnitureBlocks.Window_PLANK_CRIMSON,"绯红木木板窗");
        translationBuilder.add(MapleFurnitureBlocks.Window_PLANK_WARPED,"诡异木木板窗");

        //CoffeeTable
        translationBuilder.add(MapleFurnitureBlocks.Coffee_Table_WOOD_OAK,"橡木木咖啡桌");
        translationBuilder.add(MapleFurnitureBlocks.Coffee_Table_WOOD_SPRUCE,"云杉木咖啡桌");
        translationBuilder.add(MapleFurnitureBlocks.Coffee_Table_WOOD_BIRCH,"白桦木咖啡桌");
        translationBuilder.add(MapleFurnitureBlocks.Coffee_Table_WOOD_JUNGLE,"丛林木咖啡桌");
        translationBuilder.add(MapleFurnitureBlocks.Coffee_Table_WOOD_ACACIA,"金合欢木咖啡桌");
        translationBuilder.add(MapleFurnitureBlocks.Coffee_Table_WOOD_DARK_OAK,"深色橡木木咖啡桌");
        translationBuilder.add(MapleFurnitureBlocks.Coffee_Table_WOOD_CRIMSON,"绯红木咖啡桌");
        translationBuilder.add(MapleFurnitureBlocks.Coffee_Table_WOOD_WARPED,"诡异木咖啡桌");
        translationBuilder.add(MapleFurnitureBlocks.Coffee_Table_WOOD_MANGROVE,"红树木咖啡桌");
        translationBuilder.add(MapleFurnitureBlocks.Coffee_Table_WOOD_BAMBOO,"竹木咖啡桌");
        translationBuilder.add(MapleFurnitureBlocks.Coffee_Table_WOOD_CHERRY,"樱木咖啡桌");
        translationBuilder.add(MapleFurnitureBlocks.Coffee_Table_PLANK_OAK,"橡木木木板咖啡桌");
        translationBuilder.add(MapleFurnitureBlocks.Coffee_Table_PLANK_SPRUCE,"云杉木木板咖啡桌");
        translationBuilder.add(MapleFurnitureBlocks.Coffee_Table_PLANK_BIRCH,"白桦木木板咖啡桌");
        translationBuilder.add(MapleFurnitureBlocks.Coffee_Table_PLANK_JUNGLE,"丛林木木板咖啡桌");
        translationBuilder.add(MapleFurnitureBlocks.Coffee_Table_PLANK_ACACIA,"金合欢木木板咖啡桌");;
        translationBuilder.add(MapleFurnitureBlocks.Coffee_Table_PLANK_DARK_OAK,"深色橡木木木板咖啡桌");
        translationBuilder.add(MapleFurnitureBlocks.Coffee_Table_PLANK_CRIMSON,"绯红木木板咖啡桌");
        translationBuilder.add(MapleFurnitureBlocks.Coffee_Table_PLANK_WARPED,"诡异木木板咖啡桌");
        translationBuilder.add(MapleFurnitureBlocks.Coffee_Table_PLANK_MANGROVE,"红树木木板咖啡桌");
        translationBuilder.add(MapleFurnitureBlocks.Coffee_Table_PLANK_BAMBOO,"竹木木板咖啡桌");
        translationBuilder.add(MapleFurnitureBlocks.Coffee_Table_PLANK_CHERRY,"樱木木板咖啡桌");

        //Chair
        translationBuilder.add(MapleFurnitureBlocks.Chair_WOOD_OAK,"橡木木椅子");
        translationBuilder.add(MapleFurnitureBlocks.Chair_WOOD_SPRUCE,"云杉木椅子");
        translationBuilder.add(MapleFurnitureBlocks.Chair_WOOD_BIRCH,"白桦木椅子");
        translationBuilder.add(MapleFurnitureBlocks.Chair_WOOD_JUNGLE,"丛林木椅子");
        translationBuilder.add(MapleFurnitureBlocks.Chair_WOOD_ACACIA,"金合欢木椅子");
        translationBuilder.add(MapleFurnitureBlocks.Chair_WOOD_DARK_OAK,"深色橡木木椅子");
        translationBuilder.add(MapleFurnitureBlocks.Chair_WOOD_CRIMSON,"绯红木椅子");
        translationBuilder.add(MapleFurnitureBlocks.Chair_WOOD_WARPED,"诡异木椅子");
        translationBuilder.add(MapleFurnitureBlocks.Chair_WOOD_MANGROVE,"红树木椅子");;
        translationBuilder.add(MapleFurnitureBlocks.Chair_WOOD_BAMBOO,"竹木椅子");
        translationBuilder.add(MapleFurnitureBlocks.Chair_WOOD_CHERRY,"樱木椅子");
        translationBuilder.add(MapleFurnitureBlocks.Chair_PLANK_OAK,"橡木木木板椅子");
        translationBuilder.add(MapleFurnitureBlocks.Chair_PLANK_SPRUCE,"云杉木木板椅子");
        translationBuilder.add(MapleFurnitureBlocks.Chair_PLANK_BIRCH,"白桦木木板椅子");
        translationBuilder.add(MapleFurnitureBlocks.Chair_PLANK_JUNGLE,"丛林木木板椅子");
        translationBuilder.add(MapleFurnitureBlocks.Chair_PLANK_ACACIA,"金合欢木木板椅子");
        translationBuilder.add(MapleFurnitureBlocks.Chair_PLANK_DARK_OAK,"深色橡木木木板椅子");
        translationBuilder.add(MapleFurnitureBlocks.Chair_PLANK_CRIMSON,"绯红木木板椅子");
        translationBuilder.add(MapleFurnitureBlocks.Chair_PLANK_WARPED,"诡异木木板椅子");
        translationBuilder.add(MapleFurnitureBlocks.Chair_PLANK_MANGROVE,"红树木木板椅子");
        translationBuilder.add(MapleFurnitureBlocks.Chair_PLANK_BAMBOO,"竹木木板椅子");
        translationBuilder.add(MapleFurnitureBlocks.Chair_PLANK_CHERRY,"樱木木板椅子");

        translationBuilder.add(MapleFurnitureBlocks.END_TABLE_OAK,"橡木木木板茶几");
        translationBuilder.add(MapleFurnitureBlocks.END_TABLE_SPRUCE,"云杉木木板茶几");
        translationBuilder.add(MapleFurnitureBlocks.END_TABLE_BIRCH,"白桦木木板茶几");
        translationBuilder.add(MapleFurnitureBlocks.END_TABLE_JUNGLE,"丛林木木板茶几");
        translationBuilder.add(MapleFurnitureBlocks.END_TABLE_ACACIA,"金合欢木木板茶几");
        translationBuilder.add(MapleFurnitureBlocks.END_TABLE_DARK_OAK,"深色橡木木木板茶几");
        translationBuilder.add(MapleFurnitureBlocks.END_TABLE_CRIMSON,"绯红木木板茶几");
        translationBuilder.add(MapleFurnitureBlocks.END_TABLE_WARPED,"诡异木木板茶几");
        translationBuilder.add(MapleFurnitureBlocks.END_TABLE_MANGROVE,"红树木木板茶几");
        translationBuilder.add(MapleFurnitureBlocks.END_TABLE_BAMBOO,"竹木木板茶几");
        translationBuilder.add(MapleFurnitureBlocks.END_TABLE_CHERRY,"樱木木板茶几");



        try {
            Path existingFilePath = dataOutput.getModContainer().findPath("assets/skniro_furniture/lang/zh_cn.existing.json").get();
            translationBuilder.add(existingFilePath);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add existing language file!", e);
        }
    }
}
