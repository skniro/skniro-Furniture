package com.skniro.skniro_furniture.entity;

import com.mojang.datafixers.types.Type;
import com.skniro.skniro_furniture.Furniture;
import com.skniro.skniro_furniture.block.entity.CabinetBlockEntity;
import com.skniro.skniro_furniture.entity.furniture.ChairEntity;
import com.skniro.skniro_furniture.entity.furniture.CushionEntity;
import com.skniro.skniro_furniture.entity.furniture.SofaEntity;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.entity.vehicle.ChestBoatEntity;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.function.Supplier;

public class MapleEntityType {
    public static final EntityType<ChairEntity> CHAIR_ENTITY =
            register("chair_entity",  EntityType.Builder.create(ChairEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5f, 0.5f));

    public static final EntityType<CushionEntity> Cushion_ENTITY =
            register("cushion_entity",  EntityType.Builder.create(CushionEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5f, 0.5f));

    public static final EntityType<SofaEntity> SOFA_ENTITY =
            register("sofa_entity",  EntityType.Builder.create(SofaEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5f, 0.5f));


    private static <T extends Entity> EntityType<T> register(String name, EntityType.Builder<T> builder) {
        Type<?> type = Util.getChoiceType(TypeReferences.ENTITY, name);
        return (EntityType) Registry.register(Registries.ENTITY_TYPE, Identifier.of(Furniture.MOD_ID, name), builder.build(keyOf(name)));
    }
    private static RegistryKey<EntityType<?>> keyOf(String name) {
        return RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(Furniture.MOD_ID, name));
    }

    private static EntityType.EntityFactory<BoatEntity> getBoatFactory(Supplier<Item> itemSupplier) {
        return (type, world) -> {
            return new BoatEntity(type, world, itemSupplier);
        };
    }

    private static EntityType.EntityFactory<ChestBoatEntity> getChestBoatFactory(Supplier<Item> itemSupplier) {
        return (type, world) -> {
            return new ChestBoatEntity(type, world, itemSupplier);
        };
    }

    public static void registerMapleEntityType() {
        Furniture.LOGGER.debug("Registering MapleEntityType for " + Furniture.MOD_ID);
    }
}
