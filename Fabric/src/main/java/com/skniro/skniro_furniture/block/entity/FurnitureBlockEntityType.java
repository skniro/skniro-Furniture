package com.skniro.skniro_furniture.block.entity;

import com.mojang.datafixers.types.Type;
import com.skniro.skniro_furniture.Furniture;
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

    public static final BlockEntityType<CabinetBlockEntity> Drawer_BLOCK_ENTITY =
            create("drawer_block_entity",
                    FabricBlockEntityTypeBuilder.create(DrawerBlockEntity::new,
                            MapleFurnitureBlocks.WHITE_KITCHEN_COUNTER_DRAWER,
                            MapleFurnitureBlocks.ORANGE_KITCHEN_COUNTER_DRAWER,
                            MapleFurnitureBlocks.MAGENTA_KITCHEN_COUNTER_DRAWER,
                            MapleFurnitureBlocks.LIGHT_BLUE_KITCHEN_COUNTER_DRAWER,
                            MapleFurnitureBlocks.YELLOW_KITCHEN_COUNTER_DRAWER,
                            MapleFurnitureBlocks.LIME_KITCHEN_COUNTER_DRAWER,
                            MapleFurnitureBlocks.PINK_KITCHEN_COUNTER_DRAWER,
                            MapleFurnitureBlocks.GRAY_KITCHEN_COUNTER_DRAWER,
                            MapleFurnitureBlocks.LIGHT_GRAY_KITCHEN_COUNTER_DRAWER,
                            MapleFurnitureBlocks.CYAN_KITCHEN_COUNTER_DRAWER,
                            MapleFurnitureBlocks.PURPLE_KITCHEN_COUNTER_DRAWER,
                            MapleFurnitureBlocks.BLUE_KITCHEN_COUNTER_DRAWER,
                            MapleFurnitureBlocks.BROWN_KITCHEN_COUNTER_DRAWER,
                            MapleFurnitureBlocks.GREEN_KITCHEN_COUNTER_DRAWER,
                            MapleFurnitureBlocks.RED_KITCHEN_COUNTER_DRAWER,
                            MapleFurnitureBlocks.BLACK_KITCHEN_COUNTER_DRAWER,
                            MapleFurnitureBlocks.OAK_PLANKS_KITCHEN_COUNTER_DRAWER,
                            MapleFurnitureBlocks.OAK_WOOD_KITCHEN_COUNTER_DRAWER,
                            MapleFurnitureBlocks.SPRUCE_PLANKS_KITCHEN_COUNTER_DRAWER,
                            MapleFurnitureBlocks.SPRUCE_WOOD_KITCHEN_COUNTER_DRAWER,
                            MapleFurnitureBlocks.BIRCH_PLANKS_KITCHEN_COUNTER_DRAWER,
                            MapleFurnitureBlocks.BIRCH_WOOD_KITCHEN_COUNTER_DRAWER,
                            MapleFurnitureBlocks.JUNGLE_PLANKS_KITCHEN_COUNTER_DRAWER,
                            MapleFurnitureBlocks.JUNGLE_WOOD_KITCHEN_COUNTER_DRAWER,
                            MapleFurnitureBlocks.ACACIA_PLANKS_KITCHEN_COUNTER_DRAWER,
                            MapleFurnitureBlocks.ACACIA_WOOD_KITCHEN_COUNTER_DRAWER,
                            MapleFurnitureBlocks.DARK_OAK_PLANKS_KITCHEN_COUNTER_DRAWER,
                            MapleFurnitureBlocks.DARK_OAK_WOOD_KITCHEN_COUNTER_DRAWER,
                            MapleFurnitureBlocks.MANGROVE_PLANKS_KITCHEN_COUNTER_DRAWER,
                            MapleFurnitureBlocks.MANGROVE_WOOD_KITCHEN_COUNTER_DRAWER,
                            MapleFurnitureBlocks.CHERRY_PLANKS_KITCHEN_COUNTER_DRAWER,
                            MapleFurnitureBlocks.CHERRY_WOOD_KITCHEN_COUNTER_DRAWER,
                            MapleFurnitureBlocks.CRIMSON_PLANKS_KITCHEN_COUNTER_DRAWER,
                            MapleFurnitureBlocks.CRIMSON_HYPHAE_KITCHEN_COUNTER_DRAWER,
                            MapleFurnitureBlocks.WARPED_PLANKS_KITCHEN_COUNTER_DRAWER,
                            MapleFurnitureBlocks.WARPED_HYPHAE_KITCHEN_COUNTER_DRAWER,
                            MapleFurnitureBlocks.BAMBOO_PLANKS_KITCHEN_COUNTER_DRAWER,
                            MapleFurnitureBlocks.BAMBOO_BLOCK_KITCHEN_COUNTER_DRAWER
                    )
            );

    public static final BlockEntityType<BedsideCabinetBlockEntity> Bedside_Cabinet_BLOCK_ENTITY =
            create("bedside_cabinet_block_entity",
                    FabricBlockEntityTypeBuilder.create(DrawerBlockEntity::new,
                            MapleFurnitureBlocks.OAK_PLANKS_BEDSIDE_CABINET,
                            MapleFurnitureBlocks.OAK_WOOD_BEDSIDE_CABINET,
                            MapleFurnitureBlocks.SPRUCE_PLANKS_BEDSIDE_CABINET,
                            MapleFurnitureBlocks.SPRUCE_WOOD_BEDSIDE_CABINET,
                            MapleFurnitureBlocks.BIRCH_PLANKS_BEDSIDE_CABINET,
                            MapleFurnitureBlocks.BIRCH_WOOD_BEDSIDE_CABINET,
                            MapleFurnitureBlocks.JUNGLE_PLANKS_BEDSIDE_CABINET,
                            MapleFurnitureBlocks.JUNGLE_WOOD_BEDSIDE_CABINET,
                            MapleFurnitureBlocks.ACACIA_PLANKS_BEDSIDE_CABINET,
                            MapleFurnitureBlocks.ACACIA_WOOD_BEDSIDE_CABINET,
                            MapleFurnitureBlocks.DARK_OAK_PLANKS_BEDSIDE_CABINET,
                            MapleFurnitureBlocks.DARK_OAK_WOOD_BEDSIDE_CABINET,
                            MapleFurnitureBlocks.MANGROVE_PLANKS_BEDSIDE_CABINET,
                            MapleFurnitureBlocks.MANGROVE_WOOD_BEDSIDE_CABINET,
                            MapleFurnitureBlocks.CHERRY_PLANKS_BEDSIDE_CABINET,
                            MapleFurnitureBlocks.CHERRY_WOOD_BEDSIDE_CABINET,
                            MapleFurnitureBlocks.CRIMSON_PLANKS_BEDSIDE_CABINET,
                            MapleFurnitureBlocks.CRIMSON_HYPHAE_BEDSIDE_CABINET,
                            MapleFurnitureBlocks.WARPED_PLANKS_BEDSIDE_CABINET,
                            MapleFurnitureBlocks.WARPED_HYPHAE_BEDSIDE_CABINET,
                            MapleFurnitureBlocks.BAMBOO_PLANKS_BEDSIDE_CABINET,
                            MapleFurnitureBlocks.BAMBOO_BLOCK_BEDSIDE_CABINET
                    )
            );

    public static final BlockEntityType<KitchenCabinetBlockEntity> Kitchen_Cabinet_BLOCK_ENTITY =
            create("kitchen_cabinet_block_entity",
                    FabricBlockEntityTypeBuilder.create(DrawerBlockEntity::new,
                            MapleFurnitureBlocks.OAK_PLANKS_KITCHEN_CABINET,
                            MapleFurnitureBlocks.OAK_WOOD_KITCHEN_CABINET,
                            MapleFurnitureBlocks.SPRUCE_PLANKS_KITCHEN_CABINET,
                            MapleFurnitureBlocks.SPRUCE_WOOD_KITCHEN_CABINET,
                            MapleFurnitureBlocks.BIRCH_PLANKS_KITCHEN_CABINET,
                            MapleFurnitureBlocks.BIRCH_WOOD_KITCHEN_CABINET,
                            MapleFurnitureBlocks.JUNGLE_PLANKS_KITCHEN_CABINET,
                            MapleFurnitureBlocks.JUNGLE_WOOD_KITCHEN_CABINET,
                            MapleFurnitureBlocks.ACACIA_PLANKS_KITCHEN_CABINET,
                            MapleFurnitureBlocks.ACACIA_WOOD_KITCHEN_CABINET,
                            MapleFurnitureBlocks.DARK_OAK_PLANKS_KITCHEN_CABINET,
                            MapleFurnitureBlocks.DARK_OAK_WOOD_KITCHEN_CABINET,
                            MapleFurnitureBlocks.MANGROVE_PLANKS_KITCHEN_CABINET,
                            MapleFurnitureBlocks.MANGROVE_WOOD_KITCHEN_CABINET,
                            MapleFurnitureBlocks.CHERRY_PLANKS_KITCHEN_CABINET,
                            MapleFurnitureBlocks.CHERRY_WOOD_KITCHEN_CABINET,
                            MapleFurnitureBlocks.CRIMSON_PLANKS_KITCHEN_CABINET,
                            MapleFurnitureBlocks.CRIMSON_HYPHAE_KITCHEN_CABINET,
                            MapleFurnitureBlocks.WARPED_PLANKS_KITCHEN_CABINET,
                            MapleFurnitureBlocks.WARPED_HYPHAE_KITCHEN_CABINET,
                            MapleFurnitureBlocks.BAMBOO_PLANKS_KITCHEN_CABINET,
                            MapleFurnitureBlocks.BAMBOO_BLOCK_KITCHEN_CABINET,
                            MapleFurnitureBlocks.WHITE_KITCHEN_CABINET,
                            MapleFurnitureBlocks.ORANGE_KITCHEN_CABINET,
                            MapleFurnitureBlocks.MAGENTA_KITCHEN_CABINET,
                            MapleFurnitureBlocks.LIGHT_BLUE_KITCHEN_CABINET,
                            MapleFurnitureBlocks.YELLOW_KITCHEN_CABINET,
                            MapleFurnitureBlocks.LIME_KITCHEN_CABINET,
                            MapleFurnitureBlocks.PINK_KITCHEN_CABINET,
                            MapleFurnitureBlocks.GRAY_KITCHEN_CABINET,
                            MapleFurnitureBlocks.LIGHT_GRAY_KITCHEN_CABINET,
                            MapleFurnitureBlocks.CYAN_KITCHEN_CABINET,
                            MapleFurnitureBlocks.PURPLE_KITCHEN_CABINET,
                            MapleFurnitureBlocks.BLUE_KITCHEN_CABINET,
                            MapleFurnitureBlocks.BROWN_KITCHEN_CABINET,
                            MapleFurnitureBlocks.GREEN_KITCHEN_CABINET,
                            MapleFurnitureBlocks.RED_KITCHEN_CABINET,
                            MapleFurnitureBlocks.BLACK_KITCHEN_CABINET
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
