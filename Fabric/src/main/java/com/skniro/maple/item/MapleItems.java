package com.skniro.maple.item;

import com.skniro.maple.Maple;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class MapleItems {

    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Item item = factory.apply(settings.registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Maple.MOD_ID, name))));
        return Registry.register(Registries.ITEM, RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Maple.MOD_ID, name)), item);
    }

    private static Function<Item.Settings, Item> createBlockItemWithUniqueName(Block block) {
        return (settings) -> {
            return new BlockItem(block, settings.useItemPrefixedTranslationKey());
        };
    }

    public static void registerModItems() {
        Maple.LOGGER.info("Registering Mod Items for " + Maple.MOD_ID);
    }
}