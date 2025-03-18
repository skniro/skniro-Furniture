package com.skniro.maple;

import com.skniro.maple.block.MapleFurnitureBlocks;
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

public class Maple implements ModInitializer {
    public static final String MOD_ID = "maple";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final ModContainer MOD_CONTAINER = FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow();

    public static final RegistryKey<ItemGroup> Maple_Group_Furniture = RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(MOD_ID, "maple_group_furniture"));


    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM_GROUP, Maple_Group_Furniture, FabricItemGroup.builder()
                .icon(() -> new ItemStack(MapleFurnitureBlocks.CUSHION_MAPLE_YELLOW))
                .displayName(Text.translatable("itemGroup.maple.maple_group_furniture"))
                .build());
        MapleContent.registerItem();
        MapleContent.registerBlock();
        MapleContent.registerFluid();
        MapleContent.CreativeTab();
        MapleContent.generateWorldGen();
        MapleContent.registerOthers();
        MapleContent.registerCommand();
        MapleContent.registerMapleLootTable();
        MapleContent.registerMapleCompostableItems();
        MapleContent.registerScreenType();
        MapleContent.registerRecipeType();
    }

    public static Identifier asResource(String path) {
        return Identifier.of(MOD_ID, path);
    }

}
