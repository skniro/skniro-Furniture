package com.skniro.skniro_furniture;

import com.skniro.skniro_furniture.block.FurnitureBedroomBlocks;
import com.skniro.skniro_furniture.block.FurnitureKitchenBlocks;
import com.skniro.skniro_furniture.block.FurnitureLivingroomBlocks;
import com.skniro.skniro_furniture.block.MapleFurnitureBlocks;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Furniture implements ModInitializer {
    public static final String MOD_ID = "skniro_furniture";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final ModContainer MOD_CONTAINER = FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow();

    public static final ResourceKey<CreativeModeTab> Maple_Group_Furniture = ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.fromNamespaceAndPath(MOD_ID, "maple_group_furniture"));
    public static final ResourceKey<CreativeModeTab> Furniture_Group_Kitchen_Furniture = ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.fromNamespaceAndPath(MOD_ID, "furniture_kitchen_group_furniture"));
    public static final ResourceKey<CreativeModeTab> Furniture_Group_Bedroom_Furniture = ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.fromNamespaceAndPath(MOD_ID, "furniture_bedroom_group_furniture"));
    public static final ResourceKey<CreativeModeTab> Furniture_Group_Livingroom_Furniture = ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.fromNamespaceAndPath(MOD_ID, "furniture_livingroom_group_furniture"));

    @Override
    public void onInitialize() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, Maple_Group_Furniture, FabricItemGroup.builder()
                .icon(() -> new ItemStack(MapleFurnitureBlocks.OAK_PLANKS_Glass_Four_Grid_Cabinet))
                .title(Component.translatable("itemGroup.skniro_furniture.maple_group_furniture"))
                .build());
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, Furniture_Group_Kitchen_Furniture, FabricItemGroup.builder()
                .icon(() -> new ItemStack(FurnitureKitchenBlocks.OAK_PLANKS_OVEN))
                .title(Component.translatable("itemGroup.skniro_furniture.furniture_kitchen_group_furniture"))
                .build());
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, Furniture_Group_Bedroom_Furniture, FabricItemGroup.builder()
                .icon(() -> new ItemStack(FurnitureBedroomBlocks.OAK_PLANKS_BEDSIDE_CABINET))
                .title(Component.translatable("itemGroup.skniro_furniture.furniture_bedroom_group_furniture"))
                .build());
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, Furniture_Group_Livingroom_Furniture, FabricItemGroup.builder()
                .icon(() -> new ItemStack(FurnitureLivingroomBlocks.OAK_PLANKS_TV_STAND))
                .title(Component.translatable("itemGroup.skniro_furniture.furniture_livingroom_group_furniture"))
                .build());
        FurnitureContent.registerItem();
        FurnitureContent.registerBlock();
        FurnitureContent.registerFluid();
        FurnitureContent.CreativeTab();
        FurnitureContent.generateWorldGen();
        FurnitureContent.registerOthers();
        FurnitureContent.registerCommand();
        FurnitureContent.registerMapleLootTable();
        FurnitureContent.registerMapleCompostableItems();
        FurnitureContent.registerScreenType();
        FurnitureContent.registerRecipeType();
    }

    public static ResourceLocation asResource(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

}
