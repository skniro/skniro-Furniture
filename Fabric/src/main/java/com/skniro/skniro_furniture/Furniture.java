package com.skniro.skniro_furniture;

import com.skniro.skniro_furniture.block.MapleFurnitureBlocks;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Furniture implements ModInitializer {
    public static final String MOD_ID = "skniro_furniture";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final ModContainer MOD_CONTAINER = FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow();

    public static final RegistryKey<ItemGroup> Maple_Group_Furniture = RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(MOD_ID, "maple_group_furniture"));
    public static final RegistryKey<ItemGroup> Furniture_Group_Kitchen_Furniture = RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(MOD_ID, "furniture_kitchen_group_furniture"));
    public static final RegistryKey<ItemGroup> Furniture_Group_Bedroom_Furniture = RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(MOD_ID, "furniture_bedroom_group_furniture"));
    public static final RegistryKey<ItemGroup> Furniture_Group_Livingroom_Furniture = RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(MOD_ID, "furniture_livingroom_group_furniture"));

    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM_GROUP, Maple_Group_Furniture, FabricItemGroup.builder()
                .icon(() -> new ItemStack(MapleFurnitureBlocks.ACACIA_PLANK_COFFEE_CHAIR_BLACK))
                .displayName(Text.translatable("itemGroup.skniro_furniture.maple_group_furniture"))
                .build());
        Registry.register(Registries.ITEM_GROUP, Furniture_Group_Kitchen_Furniture, FabricItemGroup.builder()
                .icon(() -> new ItemStack(MapleFurnitureBlocks.ACACIA_PLANKS_KITCHEN_CABINET))
                .displayName(Text.translatable("itemGroup.skniro_furniture.furniture_kitchen_group_furniture"))
                .build());
        Registry.register(Registries.ITEM_GROUP, Furniture_Group_Bedroom_Furniture, FabricItemGroup.builder()
                .icon(() -> new ItemStack(MapleFurnitureBlocks.ACACIA_PLANKS_KITCHEN_CABINET))
                .displayName(Text.translatable("itemGroup.skniro_furniture.furniture_bedroom_group_furniture"))
                .build());
        Registry.register(Registries.ITEM_GROUP, Furniture_Group_Livingroom_Furniture, FabricItemGroup.builder()
                .icon(() -> new ItemStack(MapleFurnitureBlocks.ACACIA_PLANKS_KITCHEN_CABINET))
                .displayName(Text.translatable("itemGroup.skniro_furniture.furniture_livingroom_group_furniture"))
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

    public static Identifier asResource(String path) {
        return Identifier.of(MOD_ID, path);
    }

}
