package com.skniro.skniro_furniture.entity;

import com.skniro.skniro_furniture.Furniture;
import com.skniro.skniro_furniture.entity.furniture.ChairEntity;
import com.skniro.skniro_furniture.entity.furniture.CushionEntity;
import com.skniro.skniro_furniture.item.MapleItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class MapleEntityType {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Furniture.MOD_ID);

    public static final RegistryObject<EntityType<ChairEntity>> CHAIR_ENTITY =
            ENTITY_TYPES.register("chair_entity", ()-> EntityType.Builder.of(ChairEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build(keyOf("chair_entity")));

    public static final RegistryObject<EntityType<CushionEntity>> Cushion_ENTITY =
            ENTITY_TYPES.register("cushion_entity", ()-> EntityType.Builder.of(CushionEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build(keyOf("cushion_entity")));

    public static final RegistryObject<EntityType<Boat>> Maple_BOAT = ENTITY_TYPES.register("maple_boat", ()-> EntityType.Builder.of(getBoatFactory(() -> {
        return MapleItems.MAPLE_BOAT.get();
    }), MobCategory.MISC).noLootTable().sized(1.375F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10).build(keyOf("maple_boat")));

    public static final RegistryObject<EntityType<ChestBoat>> Maple_CHEST_BOAT = ENTITY_TYPES.register("maple_chest_boat",()-> EntityType.Builder.of(getChestBoatFactory(() -> {
        return MapleItems.MAPLE_CHEST_BOAT.get();
    }), MobCategory.MISC).noLootTable().sized(1.375F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10).build(keyOf("maple_chest_boat")));

    public static final RegistryObject<EntityType<Boat>> GINKGO_BOAT = ENTITY_TYPES.register("ginkgo_boat",()-> EntityType.Builder.of(getBoatFactory(() -> {
        return MapleItems.MAPLE_BOAT.get();
    }), MobCategory.MISC).noLootTable().sized(1.375F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10).build(keyOf("ginkgo_boat")));

    public static final RegistryObject<EntityType<ChestBoat>> GINKGO_CHEST_BOAT = ENTITY_TYPES.register("ginkgo_chest_boat",()-> EntityType.Builder.of(getChestBoatFactory(() -> {
        return MapleItems.MAPLE_CHEST_BOAT.get();
    }), MobCategory.MISC).noLootTable().sized(1.375F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10).build(keyOf("ginkgo_chest_boat")));


    private static ResourceKey<EntityType<?>> keyOf(String name) {
        return ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(Furniture.MOD_ID, name));
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