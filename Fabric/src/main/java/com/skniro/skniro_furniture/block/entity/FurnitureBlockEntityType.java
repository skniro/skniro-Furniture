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
                            MapleFurnitureBlocks.BAMBOO_WOOD_TRIPLE_CABINET
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
