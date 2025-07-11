package com.skniro.skniro_furniture.entity;

import com.mojang.datafixers.types.Type;
import com.skniro.skniro_furniture.Furniture;
import com.skniro.skniro_furniture.block.entity.CabinetBlockEntity;
import com.skniro.skniro_furniture.entity.furniture.ChairEntity;
import com.skniro.skniro_furniture.entity.furniture.CushionEntity;
import com.skniro.skniro_furniture.entity.furniture.SofaEntity;
import java.util.function.Supplier;
import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class MapleEntityType {
    public static final EntityType<ChairEntity> CHAIR_ENTITY =
            register("chair_entity",  EntityType.Builder.of(ChairEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f));

    public static final EntityType<CushionEntity> Cushion_ENTITY =
            register("cushion_entity",  EntityType.Builder.of(CushionEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f));

    public static final EntityType<SofaEntity> SOFA_ENTITY =
            register("sofa_entity",  EntityType.Builder.of(SofaEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f));


    private static <T extends Entity> EntityType<T> register(String name, EntityType.Builder<T> builder) {
        Type<?> type = Util.fetchChoiceType(References.ENTITY, name);
        return (EntityType) Registry.register(BuiltInRegistries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(Furniture.MOD_ID, name), builder.build(name));
    }

    public static void registerMapleEntityType() {
        Furniture.LOGGER.debug("Registering MapleEntityType for " + Furniture.MOD_ID);
    }
}
