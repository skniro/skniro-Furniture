package com.skniro.skniro_furniture.block.api.registry;

import com.mojang.datafixers.util.Pair;
import com.skniro.skniro_furniture.block.init.KitchenCounterBlock;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.client.data.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.minecraft.client.data.BlockStateModelGenerator.createBooleanModelMap;
import static net.minecraft.client.data.BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates;

public class MapleModelDatagenHelper {
    private final BlockStateModelGenerator generator;
    private static final Map<ChiseledBookshelfModelCacheKey, Identifier> CHISELED_BOOKSHELF_MODEL_CACHE = new HashMap();;

    public MapleModelDatagenHelper(BlockStateModelGenerator generator) {
        this.generator = generator;
    }

    public void registerModSweetBerryBush(Item fruititem, Block block) {
        generator.registerItemModel(fruititem);
        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block)
                .coordinate(BlockStateVariantMap.create(Properties.AGE_3).register(stage ->
                        BlockStateVariant.create().put(VariantSettings.MODEL,
                                generator.createSubModel(block, "_stage" + stage, Models.CROSS, TextureMap::cross)
                        )
                ))
        );
    }

    public void registerModBookshelf(Block block, Block plank) {
        TextureMap textureMap = TextureMap.sideEnd(TextureMap.getId(block), TextureMap.getId(plank));
        Identifier identifier = Models.CUBE_COLUMN.upload(block, textureMap, generator.modelCollector);
        generator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(block, identifier));
    }

    public void registerLamp(Block block) {
        Identifier identifier = Identifier.of(block.toString());
        Identifier identifier2 = Identifier.of(block.toString() + "_on");
        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block).coordinate(createBooleanModelMap(Properties.LIT, identifier2, identifier)));
    }


    public void registerModChiseledBookshelf(Block block) {
        Identifier identifier = ModelIds.getBlockModelId(block);
        MultipartBlockStateSupplier multipartBlockStateSupplier = MultipartBlockStateSupplier.create(block);
        List.of(Pair.of(Direction.NORTH, VariantSettings.Rotation.R0), Pair.of(Direction.EAST, VariantSettings.Rotation.R90), Pair.of(Direction.SOUTH, VariantSettings.Rotation.R180), Pair.of(Direction.WEST, VariantSettings.Rotation.R270)).forEach((pair) -> {
            Direction direction = (Direction)pair.getFirst();
            VariantSettings.Rotation rotation = (VariantSettings.Rotation)pair.getSecond();
            When.PropertyCondition propertyCondition = When.create().set(Properties.HORIZONTAL_FACING, direction);
            multipartBlockStateSupplier.with(propertyCondition, BlockStateVariant.create().put(VariantSettings.MODEL, identifier).put(VariantSettings.Y, rotation).put(VariantSettings.UVLOCK, true));
            generator.supplyChiseledBookshelfModels(multipartBlockStateSupplier, propertyCondition, rotation);
        });
        generator.blockStateCollector.accept(multipartBlockStateSupplier);
        generator.registerParentedItemModel(block, ModelIds.getBlockSubModelId(block, "_inventory"));
        CHISELED_BOOKSHELF_MODEL_CACHE.clear();
    }

    @Environment(EnvType.CLIENT)
    static record ChiseledBookshelfModelCacheKey(Model template, String modelSuffix) {
        ChiseledBookshelfModelCacheKey(Model template, String modelSuffix) {
            this.template = template;
            this.modelSuffix = modelSuffix;
        }

        public Model template() {
            return this.template;
        }

        public String modelSuffix() {
            return this.modelSuffix;
        }
    }
}