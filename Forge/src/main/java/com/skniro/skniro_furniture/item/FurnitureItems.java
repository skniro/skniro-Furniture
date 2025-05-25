package com.skniro.skniro_furniture.item;

import com.skniro.skniro_furniture.Furniture;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class FurnitureItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Furniture.MOD_ID);

    public static <B extends Item> RegistryObject<Item> register(String name, Function<Item.Properties, ? extends B> func) {
        return ITEMS.register(name, () -> {
            return (Item)func.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Furniture.MOD_ID, name))));
        });
    }

    public static <B extends Item> RegistryObject<Item> register(String name, Function<Item.Properties, ? extends B> func, Item.Properties props) {
        return ITEMS.register(name, () -> {
            return (Item)func.apply(props.setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Furniture.MOD_ID, name))));
        });
    }

    private static <T extends Item> RegistryObject<Item> registerItem(String name, Function<Item.Properties, ? extends T> item, Item.Properties properties) {
        RegistryObject<Item> toReturn = register(name, item, properties.setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Furniture.MOD_ID, name))));
        return toReturn;
    }

    public static void registerModItems(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}