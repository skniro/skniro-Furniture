package com.skniro.skniro_furniture;


import com.skniro.skniro_furniture.block.FurnitureBedroomBlocks;
import com.skniro.skniro_furniture.block.FurnitureKitchenBlocks;
import com.skniro.skniro_furniture.block.FurnitureLivingroomBlocks;
import com.skniro.skniro_furniture.block.MapleFurnitureBlocks;
import com.skniro.skniro_furniture.block.entity.FurnitureBlockEntityType;
import com.skniro.skniro_furniture.block.renderer.CabinetBlockEntityRenderer;
import com.skniro.skniro_furniture.block.renderer.KitchenSinkBlockEntityRenderer;
import com.skniro.skniro_furniture.block.renderer.OvenBlockEntityRenderer;
import com.skniro.skniro_furniture.client.renderer.ChairRenderer;
import com.skniro.skniro_furniture.client.renderer.CushinoRenderer;
import com.skniro.skniro_furniture.client.renderer.SofaRenderer;
import com.skniro.skniro_furniture.entity.MapleEntityType;
import com.skniro.skniro_furniture.item.FurnitureCreativeModeTabs;
import com.skniro.skniro_furniture.item.FurnitureItems;
import com.skniro.skniro_furniture.recipe.FurnitureRecipeType;
import com.skniro.skniro_furniture.screen.FurnitureScreenHandlerType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;


public class FurnitureContent {


    public static void registerItem(IEventBus modEventBus){
        FurnitureItems.registerModItems(modEventBus);
    }
    public static void registerBlock(IEventBus modEventBus){
        MapleFurnitureBlocks.registerCushionBlocks(modEventBus);
        FurnitureBedroomBlocks.registerBedroomBlocks(modEventBus);
        FurnitureKitchenBlocks.registerKitchenBlocks(modEventBus);
        FurnitureLivingroomBlocks.registerLivingroomBlocks(modEventBus);
        FurnitureBlockEntityType.registerMapleBlockEntityType(modEventBus);
    }

    public static void registerFluid(IEventBus modEventBus){
    }

    public static void CreativeTab(IEventBus modEventBus) {
        FurnitureCreativeModeTabs.registerMapleCreativeModeTabs(modEventBus);
    }

    public static void generateWorldGen(IEventBus modEventBus) {
    }

    public static void registerRecipeType(IEventBus modEventBus) {
        FurnitureRecipeType.registerRecipes(modEventBus);
    }

    public static void registerScreenType(IEventBus modEventBus) {
        FurnitureScreenHandlerType.RegisterFurnitureScreenHandlerType(modEventBus);
    }

    public static void registerOthers(IEventBus modEventBus) {
        MapleEntityType.registerMapleEntityType(modEventBus);
    }

    public static void registerCommand(IEventBus modEventBus) {
    }

    public static void registerMapleLootTable(IEventBus modEventBus) {

    }

    public static void registerMapleCompostableItems(IEventBus modEventBus) {
    }
}

