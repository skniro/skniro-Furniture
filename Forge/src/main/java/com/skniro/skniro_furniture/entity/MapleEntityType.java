package com.skniro.skniro_furniture.entity;

import com.skniro.skniro_furniture.Furniture;
import com.skniro.skniro_furniture.entity.furniture.ChairEntity;
import com.skniro.skniro_furniture.entity.furniture.CushionEntity;
import com.skniro.skniro_furniture.entity.furniture.SofaEntity;

import java.util.function.Supplier;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MapleEntityType {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Furniture.MOD_ID);

    public static final Supplier<EntityType<ChairEntity>> CHAIR_ENTITY =
            ENTITY_TYPES.register("chair_entity", ()-> EntityType.Builder.of(ChairEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build(keyOf("chair_entity")));

    public static final Supplier<EntityType<CushionEntity>> Cushion_ENTITY =
            ENTITY_TYPES.register("cushion_entity", ()-> EntityType.Builder.of(CushionEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build(keyOf("cushion_entity")));

    public static final Supplier<EntityType<SofaEntity>> SOFA_ENTITY =
            ENTITY_TYPES.register("sofa_entity", ()-> EntityType.Builder.of(SofaEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build(keyOf("sofa_entity")));

    private static ResourceKey<EntityType<?>> keyOf(String name) {
        return ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(Furniture.MOD_ID, name));
    }

    public static void registerMapleEntityType(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
