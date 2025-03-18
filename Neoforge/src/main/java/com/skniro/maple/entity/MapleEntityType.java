package com.skniro.maple.entity;

import com.skniro.maple.Maple;
import com.skniro.maple.entity.furniture.ChairEntity;
import com.skniro.maple.entity.furniture.CushionEntity;
import com.skniro.maple.item.MapleItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class MapleEntityType {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, Maple.MOD_ID);

    public static final Supplier<EntityType<ChairEntity>> CHAIR_ENTITY =
            ENTITY_TYPES.register("chair_entity", ()-> EntityType.Builder.of(ChairEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build(keyOf("chair_entity")));

    public static final Supplier<EntityType<CushionEntity>> Cushion_ENTITY =
            ENTITY_TYPES.register("cushion_entity", ()-> EntityType.Builder.of(CushionEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build(keyOf("cushion_entity")));

    private static ResourceKey<EntityType<?>> keyOf(String name) {
        return ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(Maple.MOD_ID, name));
    }

    private static EntityType.EntityFactory<Boat> getBoatFactory(Supplier<Item> itemSupplier) {
        return (type, world) -> {
            return new Boat(type, world, itemSupplier);
        };
    }

    private static EntityType.EntityFactory<ChestBoat> getChestBoatFactory(Supplier<Item> itemSupplier) {
        return (type, world) -> {
            return new ChestBoat(type, world, itemSupplier);
        };
    }
    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}