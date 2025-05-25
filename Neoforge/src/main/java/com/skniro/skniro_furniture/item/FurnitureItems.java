package com.skniro.skniro_furniture.item;

import com.skniro.skniro_furniture.Furniture;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;

public class FurnitureItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, Furniture.MOD_ID);

    public static <B extends Item> Supplier<Item> register(String name, Function<Item.Properties, ? extends B> func) {
        return ITEMS.register(name, () -> {
            return (Item)func.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Furniture.MOD_ID, name))));
        });
    }

    public static <B extends Item> Supplier<Item> register(String name, Function<Item.Properties, ? extends B> func, Item.Properties props) {
        return ITEMS.register(name, () -> {
            return (Item)func.apply(props.setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Furniture.MOD_ID, name))));
        });
    }

    private static <T extends Item> Supplier<Item> registerItem(String name, Function<Item.Properties, ? extends T> item, Item.Properties properties) {
        Supplier<Item> toReturn = register(name, item, properties.setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Furniture.MOD_ID, name))));
        return toReturn;
    }

    public static void registerModItems(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}