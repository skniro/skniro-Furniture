package com.skniro.skniro_furniture.item;

import com.skniro.skniro_furniture.Furniture;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.item.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import java.util.function.Function;

public class MapleItems {

    private static Item registerItem(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, ResourceLocation.tryBuild(Furniture.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Furniture.LOGGER.info("Registering Mod Items for " + Furniture.MOD_ID);
    }
}