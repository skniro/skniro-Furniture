package com.skniro.skniro_furniture.item;

import com.skniro.skniro_furniture.Furniture;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class MapleItems {

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Furniture.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Furniture.LOGGER.info("Registering Mod Items for " + Furniture.MOD_ID);
    }
}