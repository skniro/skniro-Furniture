package com.skniro.skniro_furniture.block.entity;

import com.mojang.datafixers.types.Type;
import com.skniro.skniro_furniture.Furniture;
import com.skniro.skniro_furniture.block.FurnitureBedroomBlocks;
import com.skniro.skniro_furniture.block.FurnitureKitchenBlocks;
import com.skniro.skniro_furniture.block.MapleFurnitureBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;


public class FurnitureBlockEntityType {
    public static final BlockEntityType<CabinetBlockEntity> Cabinet_BLOCK_ENTITY =
            create("cabinet_block_entity",
                    FabricBlockEntityTypeBuilder.create(CabinetBlockEntity::new,
                            MapleFurnitureBlocks.OAK_PLANK_TRIPLE_CABINET,
                            MapleFurnitureBlocks.OAK_WOOD_TRIPLE_CABINET,
                            MapleFurnitureBlocks.SPRUCE_PLANK_TRIPLE_CABINET,
                            MapleFurnitureBlocks.SPRUCE_WOOD_TRIPLE_CABINET,
                            MapleFurnitureBlocks.BIRCH_PLANK_TRIPLE_CABINET,
                            MapleFurnitureBlocks.BIRCH_WOOD_TRIPLE_CABINET,
                            MapleFurnitureBlocks.JUNGLE_PLANK_TRIPLE_CABINET,
                            MapleFurnitureBlocks.JUNGLE_WOOD_TRIPLE_CABINET,
                            MapleFurnitureBlocks.ACACIA_PLANK_TRIPLE_CABINET,
                            MapleFurnitureBlocks.ACACIA_WOOD_TRIPLE_CABINET,
                            MapleFurnitureBlocks.DARK_OAK_PLANK_TRIPLE_CABINET,
                            MapleFurnitureBlocks.DARK_OAK_WOOD_TRIPLE_CABINET,
                            MapleFurnitureBlocks.MANGROVE_PLANK_TRIPLE_CABINET,
                            MapleFurnitureBlocks.MANGROVE_WOOD_TRIPLE_CABINET,
                            MapleFurnitureBlocks.CRIMSON_PLANK_TRIPLE_CABINET,
                            MapleFurnitureBlocks.CRIMSON_WOOD_TRIPLE_CABINET,
                            MapleFurnitureBlocks.WARPED_PLANK_TRIPLE_CABINET,
                            MapleFurnitureBlocks.WARPED_WOOD_TRIPLE_CABINET,
                            MapleFurnitureBlocks.CHERRY_PLANK_TRIPLE_CABINET,
                            MapleFurnitureBlocks.CHERRY_WOOD_TRIPLE_CABINET,
                            MapleFurnitureBlocks.BAMBOO_PLANK_TRIPLE_CABINET,
                            MapleFurnitureBlocks.BAMBOO_WOOD_TRIPLE_CABINET,
                            MapleFurnitureBlocks.OAK_PLANKS_Four_Grid_Cabinet,
                            MapleFurnitureBlocks.OAK_WOOD_Four_Grid_Cabinet,
                            MapleFurnitureBlocks.SPRUCE_PLANKS_Four_Grid_Cabinet,
                            MapleFurnitureBlocks.SPRUCE_WOOD_Four_Grid_Cabinet,
                            MapleFurnitureBlocks.BIRCH_PLANKS_Four_Grid_Cabinet,
                            MapleFurnitureBlocks.BIRCH_WOOD_Four_Grid_Cabinet,
                            MapleFurnitureBlocks.JUNGLE_PLANKS_Four_Grid_Cabinet,
                            MapleFurnitureBlocks.JUNGLE_WOOD_Four_Grid_Cabinet,
                            MapleFurnitureBlocks.ACACIA_PLANKS_Four_Grid_Cabinet,
                            MapleFurnitureBlocks.ACACIA_WOOD_Four_Grid_Cabinet,
                            MapleFurnitureBlocks.DARK_OAK_PLANKS_Four_Grid_Cabinet,
                            MapleFurnitureBlocks.DARK_OAK_WOOD_Four_Grid_Cabinet,
                            MapleFurnitureBlocks.MANGROVE_PLANKS_Four_Grid_Cabinet,
                            MapleFurnitureBlocks.MANGROVE_WOOD_Four_Grid_Cabinet,
                            MapleFurnitureBlocks.CRIMSON_PLANKS_Four_Grid_Cabinet,
                            MapleFurnitureBlocks.CRIMSON_HYPHAE_Four_Grid_Cabinet,
                            MapleFurnitureBlocks.WARPED_PLANKS_Four_Grid_Cabinet,
                            MapleFurnitureBlocks.WARPED_HYPHAE_Four_Grid_Cabinet,
                            MapleFurnitureBlocks.CHERRY_PLANKS_Four_Grid_Cabinet,
                            MapleFurnitureBlocks.CHERRY_WOOD_Four_Grid_Cabinet,
                            MapleFurnitureBlocks.BAMBOO_PLANKS_Four_Grid_Cabinet,
                            MapleFurnitureBlocks.BAMBOO_BLOCK_Four_Grid_Cabinet

                    )
            );

    public static final BlockEntityType<DrawerBlockEntity> Drawer_BLOCK_ENTITY =
            create("drawer_block_entity",
                    FabricBlockEntityTypeBuilder.create(DrawerBlockEntity::new,
                            FurnitureKitchenBlocks.WHITE_KITCHEN_COUNTER_DRAWER,
                            FurnitureKitchenBlocks.ORANGE_KITCHEN_COUNTER_DRAWER,
                            FurnitureKitchenBlocks.MAGENTA_KITCHEN_COUNTER_DRAWER,
                            FurnitureKitchenBlocks.LIGHT_BLUE_KITCHEN_COUNTER_DRAWER,
                            FurnitureKitchenBlocks.YELLOW_KITCHEN_COUNTER_DRAWER,
                            FurnitureKitchenBlocks.LIME_KITCHEN_COUNTER_DRAWER,
                            FurnitureKitchenBlocks.PINK_KITCHEN_COUNTER_DRAWER,
                            FurnitureKitchenBlocks.GRAY_KITCHEN_COUNTER_DRAWER,
                            FurnitureKitchenBlocks.LIGHT_GRAY_KITCHEN_COUNTER_DRAWER,
                            FurnitureKitchenBlocks.CYAN_KITCHEN_COUNTER_DRAWER,
                            FurnitureKitchenBlocks.PURPLE_KITCHEN_COUNTER_DRAWER,
                            FurnitureKitchenBlocks.BLUE_KITCHEN_COUNTER_DRAWER,
                            FurnitureKitchenBlocks.BROWN_KITCHEN_COUNTER_DRAWER,
                            FurnitureKitchenBlocks.GREEN_KITCHEN_COUNTER_DRAWER,
                            FurnitureKitchenBlocks.RED_KITCHEN_COUNTER_DRAWER,
                            FurnitureKitchenBlocks.BLACK_KITCHEN_COUNTER_DRAWER,
                            FurnitureKitchenBlocks.OAK_PLANKS_KITCHEN_COUNTER_DRAWER,
                            FurnitureKitchenBlocks.OAK_WOOD_KITCHEN_COUNTER_DRAWER,
                            FurnitureKitchenBlocks.SPRUCE_PLANKS_KITCHEN_COUNTER_DRAWER,
                            FurnitureKitchenBlocks.SPRUCE_WOOD_KITCHEN_COUNTER_DRAWER,
                            FurnitureKitchenBlocks.BIRCH_PLANKS_KITCHEN_COUNTER_DRAWER,
                            FurnitureKitchenBlocks.BIRCH_WOOD_KITCHEN_COUNTER_DRAWER,
                            FurnitureKitchenBlocks.JUNGLE_PLANKS_KITCHEN_COUNTER_DRAWER,
                            FurnitureKitchenBlocks.JUNGLE_WOOD_KITCHEN_COUNTER_DRAWER,
                            FurnitureKitchenBlocks.ACACIA_PLANKS_KITCHEN_COUNTER_DRAWER,
                            FurnitureKitchenBlocks.ACACIA_WOOD_KITCHEN_COUNTER_DRAWER,
                            FurnitureKitchenBlocks.DARK_OAK_PLANKS_KITCHEN_COUNTER_DRAWER,
                            FurnitureKitchenBlocks.DARK_OAK_WOOD_KITCHEN_COUNTER_DRAWER,
                            FurnitureKitchenBlocks.MANGROVE_PLANKS_KITCHEN_COUNTER_DRAWER,
                            FurnitureKitchenBlocks.MANGROVE_WOOD_KITCHEN_COUNTER_DRAWER,
                            FurnitureKitchenBlocks.CHERRY_PLANKS_KITCHEN_COUNTER_DRAWER,
                            FurnitureKitchenBlocks.CHERRY_WOOD_KITCHEN_COUNTER_DRAWER,
                            FurnitureKitchenBlocks.CRIMSON_PLANKS_KITCHEN_COUNTER_DRAWER,
                            FurnitureKitchenBlocks.CRIMSON_HYPHAE_KITCHEN_COUNTER_DRAWER,
                            FurnitureKitchenBlocks.WARPED_PLANKS_KITCHEN_COUNTER_DRAWER,
                            FurnitureKitchenBlocks.WARPED_HYPHAE_KITCHEN_COUNTER_DRAWER,
                            FurnitureKitchenBlocks.BAMBOO_PLANKS_KITCHEN_COUNTER_DRAWER,
                            FurnitureKitchenBlocks.BAMBOO_BLOCK_KITCHEN_COUNTER_DRAWER
                    )
            );

    public static final BlockEntityType<BedsideCabinetBlockEntity> Bedside_Cabinet_BLOCK_ENTITY =
            create("bedside_cabinet_block_entity",
                    FabricBlockEntityTypeBuilder.create(BedsideCabinetBlockEntity::new,
                            FurnitureBedroomBlocks.OAK_PLANKS_BEDSIDE_CABINET,
                            FurnitureBedroomBlocks.OAK_WOOD_BEDSIDE_CABINET,
                            FurnitureBedroomBlocks.SPRUCE_PLANKS_BEDSIDE_CABINET,
                            FurnitureBedroomBlocks.SPRUCE_WOOD_BEDSIDE_CABINET,
                            FurnitureBedroomBlocks.BIRCH_PLANKS_BEDSIDE_CABINET,
                            FurnitureBedroomBlocks.BIRCH_WOOD_BEDSIDE_CABINET,
                            FurnitureBedroomBlocks.JUNGLE_PLANKS_BEDSIDE_CABINET,
                            FurnitureBedroomBlocks.JUNGLE_WOOD_BEDSIDE_CABINET,
                            FurnitureBedroomBlocks.ACACIA_PLANKS_BEDSIDE_CABINET,
                            FurnitureBedroomBlocks.ACACIA_WOOD_BEDSIDE_CABINET,
                            FurnitureBedroomBlocks.DARK_OAK_PLANKS_BEDSIDE_CABINET,
                            FurnitureBedroomBlocks.DARK_OAK_WOOD_BEDSIDE_CABINET,
                            FurnitureBedroomBlocks.MANGROVE_PLANKS_BEDSIDE_CABINET,
                            FurnitureBedroomBlocks.MANGROVE_WOOD_BEDSIDE_CABINET,
                            FurnitureBedroomBlocks.CHERRY_PLANKS_BEDSIDE_CABINET,
                            FurnitureBedroomBlocks.CHERRY_WOOD_BEDSIDE_CABINET,
                            FurnitureBedroomBlocks.CRIMSON_PLANKS_BEDSIDE_CABINET,
                            FurnitureBedroomBlocks.CRIMSON_HYPHAE_BEDSIDE_CABINET,
                            FurnitureBedroomBlocks.WARPED_PLANKS_BEDSIDE_CABINET,
                            FurnitureBedroomBlocks.WARPED_HYPHAE_BEDSIDE_CABINET,
                            FurnitureBedroomBlocks.BAMBOO_PLANKS_BEDSIDE_CABINET,
                            FurnitureBedroomBlocks.BAMBOO_BLOCK_BEDSIDE_CABINET
                    )
            );

    public static final BlockEntityType<KitchenCabinetBlockEntity> Kitchen_Cabinet_BLOCK_ENTITY =
            create("kitchen_cabinet_block_entity",
                    FabricBlockEntityTypeBuilder.create(KitchenCabinetBlockEntity::new,
                            FurnitureKitchenBlocks.OAK_PLANKS_KITCHEN_CABINET,
                            FurnitureKitchenBlocks.OAK_WOOD_KITCHEN_CABINET,
                            FurnitureKitchenBlocks.SPRUCE_PLANKS_KITCHEN_CABINET,
                            FurnitureKitchenBlocks.SPRUCE_WOOD_KITCHEN_CABINET,
                            FurnitureKitchenBlocks.BIRCH_PLANKS_KITCHEN_CABINET,
                            FurnitureKitchenBlocks.BIRCH_WOOD_KITCHEN_CABINET,
                            FurnitureKitchenBlocks.JUNGLE_PLANKS_KITCHEN_CABINET,
                            FurnitureKitchenBlocks.JUNGLE_WOOD_KITCHEN_CABINET,
                            FurnitureKitchenBlocks.ACACIA_PLANKS_KITCHEN_CABINET,
                            FurnitureKitchenBlocks.ACACIA_WOOD_KITCHEN_CABINET,
                            FurnitureKitchenBlocks.DARK_OAK_PLANKS_KITCHEN_CABINET,
                            FurnitureKitchenBlocks.DARK_OAK_WOOD_KITCHEN_CABINET,
                            FurnitureKitchenBlocks.MANGROVE_PLANKS_KITCHEN_CABINET,
                            FurnitureKitchenBlocks.MANGROVE_WOOD_KITCHEN_CABINET,
                            FurnitureKitchenBlocks.CHERRY_PLANKS_KITCHEN_CABINET,
                            FurnitureKitchenBlocks.CHERRY_WOOD_KITCHEN_CABINET,
                            FurnitureKitchenBlocks.CRIMSON_PLANKS_KITCHEN_CABINET,
                            FurnitureKitchenBlocks.CRIMSON_HYPHAE_KITCHEN_CABINET,
                            FurnitureKitchenBlocks.WARPED_PLANKS_KITCHEN_CABINET,
                            FurnitureKitchenBlocks.WARPED_HYPHAE_KITCHEN_CABINET,
                            FurnitureKitchenBlocks.BAMBOO_PLANKS_KITCHEN_CABINET,
                            FurnitureKitchenBlocks.BAMBOO_BLOCK_KITCHEN_CABINET,
                            FurnitureKitchenBlocks.WHITE_KITCHEN_CABINET,
                            FurnitureKitchenBlocks.ORANGE_KITCHEN_CABINET,
                            FurnitureKitchenBlocks.MAGENTA_KITCHEN_CABINET,
                            FurnitureKitchenBlocks.LIGHT_BLUE_KITCHEN_CABINET,
                            FurnitureKitchenBlocks.YELLOW_KITCHEN_CABINET,
                            FurnitureKitchenBlocks.LIME_KITCHEN_CABINET,
                            FurnitureKitchenBlocks.PINK_KITCHEN_CABINET,
                            FurnitureKitchenBlocks.GRAY_KITCHEN_CABINET,
                            FurnitureKitchenBlocks.LIGHT_GRAY_KITCHEN_CABINET,
                            FurnitureKitchenBlocks.CYAN_KITCHEN_CABINET,
                            FurnitureKitchenBlocks.PURPLE_KITCHEN_CABINET,
                            FurnitureKitchenBlocks.BLUE_KITCHEN_CABINET,
                            FurnitureKitchenBlocks.BROWN_KITCHEN_CABINET,
                            FurnitureKitchenBlocks.GREEN_KITCHEN_CABINET,
                            FurnitureKitchenBlocks.RED_KITCHEN_CABINET,
                            FurnitureKitchenBlocks.BLACK_KITCHEN_CABINET
                    )
            );

    public static final BlockEntityType<KitchenCabinetBlockEntity> Desk_Cabinet_BLOCK_ENTITY =
            create("desk_cabinet_block_entity",
                    FabricBlockEntityTypeBuilder.create(KitchenCabinetBlockEntity::new,
                            FurnitureBedroomBlocks.OAK_PLANKS_Desk_CABINET,
                            FurnitureBedroomBlocks.OAK_WOOD_Desk_CABINET,
                            FurnitureBedroomBlocks.SPRUCE_PLANKS_Desk_CABINET,
                            FurnitureBedroomBlocks.SPRUCE_WOOD_Desk_CABINET,
                            FurnitureBedroomBlocks.BIRCH_PLANKS_Desk_CABINET,
                            FurnitureBedroomBlocks.BIRCH_WOOD_Desk_CABINET,
                            FurnitureBedroomBlocks.JUNGLE_PLANKS_Desk_CABINET,
                            FurnitureBedroomBlocks.JUNGLE_WOOD_Desk_CABINET,
                            FurnitureBedroomBlocks.ACACIA_PLANKS_Desk_CABINET,
                            FurnitureBedroomBlocks.ACACIA_WOOD_Desk_CABINET,
                            FurnitureBedroomBlocks.DARK_OAK_PLANKS_Desk_CABINET,
                            FurnitureBedroomBlocks.DARK_OAK_WOOD_Desk_CABINET,
                            FurnitureBedroomBlocks.MANGROVE_PLANKS_Desk_CABINET,
                            FurnitureBedroomBlocks.MANGROVE_WOOD_Desk_CABINET,
                            FurnitureBedroomBlocks.CHERRY_PLANKS_Desk_CABINET,
                            FurnitureBedroomBlocks.CHERRY_WOOD_Desk_CABINET,
                            FurnitureBedroomBlocks.CRIMSON_PLANKS_Desk_CABINET,
                            FurnitureBedroomBlocks.CRIMSON_HYPHAE_Desk_CABINET,
                            FurnitureBedroomBlocks.WARPED_PLANKS_Desk_CABINET,
                            FurnitureBedroomBlocks.WARPED_HYPHAE_Desk_CABINET,
                            FurnitureBedroomBlocks.BAMBOO_PLANKS_Desk_CABINET,
                            FurnitureBedroomBlocks.BAMBOO_BLOCK_Desk_CABINET
                    )
            );

    public static final BlockEntityType<OvenBlockEntity> OVEN_BLOCK_ENTITY =
            create("oven_block_entity",
                    FabricBlockEntityTypeBuilder.create(OvenBlockEntity::new,
                            FurnitureKitchenBlocks.OAK_PLANKS_OVEN,
                            FurnitureKitchenBlocks.OAK_WOOD_OVEN,
                            FurnitureKitchenBlocks.SPRUCE_PLANKS_OVEN,
                            FurnitureKitchenBlocks.SPRUCE_WOOD_OVEN,
                            FurnitureKitchenBlocks.BIRCH_PLANKS_OVEN,
                            FurnitureKitchenBlocks.BIRCH_WOOD_OVEN,
                            FurnitureKitchenBlocks.JUNGLE_PLANKS_OVEN,
                            FurnitureKitchenBlocks.JUNGLE_WOOD_OVEN,
                            FurnitureKitchenBlocks.ACACIA_PLANKS_OVEN,
                            FurnitureKitchenBlocks.ACACIA_WOOD_OVEN,
                            FurnitureKitchenBlocks.DARK_OAK_PLANKS_OVEN,
                            FurnitureKitchenBlocks.DARK_OAK_WOOD_OVEN,
                            FurnitureKitchenBlocks.MANGROVE_PLANKS_OVEN,
                            FurnitureKitchenBlocks.MANGROVE_WOOD_OVEN,
                            FurnitureKitchenBlocks.CHERRY_PLANKS_OVEN,
                            FurnitureKitchenBlocks.CHERRY_WOOD_OVEN,
                            FurnitureKitchenBlocks.CRIMSON_PLANKS_OVEN,
                            FurnitureKitchenBlocks.CRIMSON_HYPHAE_OVEN,
                            FurnitureKitchenBlocks.WARPED_PLANKS_OVEN,
                            FurnitureKitchenBlocks.WARPED_HYPHAE_OVEN,
                            FurnitureKitchenBlocks.BAMBOO_PLANKS_OVEN,
                            FurnitureKitchenBlocks.BAMBOO_BLOCK_OVEN,
                            FurnitureKitchenBlocks.WHITE_OVEN,
                            FurnitureKitchenBlocks.ORANGE_OVEN,
                            FurnitureKitchenBlocks.MAGENTA_OVEN,
                            FurnitureKitchenBlocks.LIGHT_BLUE_OVEN,
                            FurnitureKitchenBlocks.YELLOW_OVEN,
                            FurnitureKitchenBlocks.LIME_OVEN,
                            FurnitureKitchenBlocks.PINK_OVEN,
                            FurnitureKitchenBlocks.GRAY_OVEN,
                            FurnitureKitchenBlocks.LIGHT_GRAY_OVEN,
                            FurnitureKitchenBlocks.CYAN_OVEN,
                            FurnitureKitchenBlocks.PURPLE_OVEN,
                            FurnitureKitchenBlocks.BLUE_OVEN,
                            FurnitureKitchenBlocks.BROWN_OVEN,
                            FurnitureKitchenBlocks.GREEN_OVEN,
                            FurnitureKitchenBlocks.RED_OVEN,
                            FurnitureKitchenBlocks.BLACK_OVEN
                    )
            );


    private static <T extends BlockEntity> BlockEntityType create(String id, FabricBlockEntityTypeBuilder<T> builder) {
        Type<?> type = Util.getChoiceType(TypeReferences.BLOCK_ENTITY, id);
        return (BlockEntityType) Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Furniture.MOD_ID,id), builder.build(null));
    }

    public static void registerMapleBlockEntityType() {
        Furniture.LOGGER.debug("Registering BlockEntityType for " + Furniture.MOD_ID);
    }

}
