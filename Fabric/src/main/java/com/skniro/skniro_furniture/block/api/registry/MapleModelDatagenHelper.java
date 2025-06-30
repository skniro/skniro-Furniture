package com.skniro.skniro_furniture.block.api.registry;

import com.mojang.datafixers.util.Pair;
import com.skniro.skniro_furniture.block.init.KitchenCounterBlock;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.enums.DoorHinge;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.client.data.*;
import net.minecraft.client.render.model.json.ModelVariantOperator;
import net.minecraft.client.render.model.json.WeightedVariant;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.AxisRotation;
import net.minecraft.util.math.Direction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.minecraft.client.data.BlockStateModelGenerator.*;

public class MapleModelDatagenHelper {
    private final BlockStateModelGenerator generator;;

    public MapleModelDatagenHelper(BlockStateModelGenerator generator) {
        this.generator = generator;
    }

    public void registerModSweetBerryBush(Item fruititem, Block block) {
        generator.registerItemModel(fruititem);
        generator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(block)
                .with(BlockStateVariantMap.models(Properties.AGE_3).generate(stage ->
                                createWeightedVariant(
                                generator.createSubModel(block, "_stage" + stage, Models.CROSS, TextureMap::cross)
                        )
                ))
        );
    }

    public void registerModBookshelf(Block block, Block plank) {
        TextureMap textureMap = TextureMap.sideEnd(TextureMap.getId(block), TextureMap.getId(plank));
        WeightedVariant identifier = createWeightedVariant(Models.CUBE_COLUMN.upload(block, textureMap, generator.modelCollector));
        generator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(block, identifier));
    }

    public void registerLamp(Block block) {
        WeightedVariant identifier = createWeightedVariant(ModelIds.getBlockModelId(block));
        WeightedVariant identifier2 = createWeightedVariant(ModelIds.getBlockSubModelId(block,"_on"));
        generator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(block).with(createBooleanModelMap(Properties.LIT, identifier2, identifier)));
    }

    public final void registerBlockState(Block block) {
        generator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(block, createWeightedVariant(ModelIds.getBlockModelId(block))));
    }

    public void registerFridge(Block block) {
        Identifier bottomModel = ModelIds.getBlockSubModelId(block, "_bottom");
        Identifier topModel = ModelIds.getBlockSubModelId(block, "_top");

        BlockStateVariantMap.DoubleProperty<WeightedVariant,Direction, DoubleBlockHalf> variantMap =
                BlockStateVariantMap.models(Properties.HORIZONTAL_FACING, Properties.DOUBLE_BLOCK_HALF);

        fillSimpleDoubleVariantMap(variantMap, DoubleBlockHalf.LOWER, bottomModel);
        fillSimpleDoubleVariantMap(variantMap, DoubleBlockHalf.UPPER, topModel);

        generator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(block).with(variantMap));
    }


    public static BlockStateVariantMap.DoubleProperty<WeightedVariant, Direction, DoubleBlockHalf> fillSimpleDoubleVariantMap(
            BlockStateVariantMap.DoubleProperty<WeightedVariant, Direction, DoubleBlockHalf> variantMap,
            DoubleBlockHalf targetHalf,
            Identifier baseModelId
    ) {
        return variantMap
                .register(Direction.NORTH, targetHalf, createWeightedVariant(baseModelId))
                .register(Direction.EAST, targetHalf, createWeightedVariant(baseModelId).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R90)))
                .register(Direction.SOUTH, targetHalf, createWeightedVariant(baseModelId).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R180)))
                .register(Direction.WEST, targetHalf, createWeightedVariant(baseModelId).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R270)));
    }
}