package com.skniro.skniro_furniture.block.api.registry;

import com.mojang.datafixers.util.Pair;
import com.skniro.skniro_furniture.block.init.FurnitureBedBlock;
import com.skniro.skniro_furniture.block.init.KitchenCounterBlock;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.enums.BedPart;
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
    private static final BlockStateVariantMap<ModelVariantOperator> NORTH_DEFAULT_HORIZONTAL_ROTATION_OPERATIONS;

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

    public void registerPaperSlidingDoor(Block doorBlock) {
        WeightedVariant weightedVariant = createWeightedVariant(ModelIds.getBlockSubModelId(doorBlock, "_bottom_left"));
        WeightedVariant weightedVariant2 = createWeightedVariant(ModelIds.getBlockSubModelId(doorBlock, "_bottom_left_open"));
        WeightedVariant weightedVariant3 = createWeightedVariant(ModelIds.getBlockSubModelId(doorBlock, "_bottom_right"));
        WeightedVariant weightedVariant4 = createWeightedVariant(ModelIds.getBlockSubModelId(doorBlock, "_bottom_right_open"));
        WeightedVariant weightedVariant5 = createWeightedVariant(ModelIds.getBlockSubModelId(doorBlock, "_top_left"));
        WeightedVariant weightedVariant6 = createWeightedVariant(ModelIds.getBlockSubModelId(doorBlock, "_top_left_open"));
        WeightedVariant weightedVariant7 = createWeightedVariant(ModelIds.getBlockSubModelId(doorBlock, "_top_right"));
        WeightedVariant weightedVariant8 = createWeightedVariant(ModelIds.getBlockSubModelId(doorBlock, "_top_right_open"));
        generator.blockStateCollector.accept(createDoorBlockState(doorBlock, weightedVariant, weightedVariant2, weightedVariant3, weightedVariant4, weightedVariant5, weightedVariant6, weightedVariant7, weightedVariant8));
    }

    public static BlockModelDefinitionCreator createDoorBlockState(Block doorBlock, WeightedVariant bottomLeftClosedModel, WeightedVariant bottomLeftOpenModel, WeightedVariant bottomRightClosedModel, WeightedVariant bottomRightOpenModel, WeightedVariant topLeftClosedModel, WeightedVariant topLeftOpenModel, WeightedVariant topRightClosedModel, WeightedVariant topRightOpenModel) {
        return VariantsBlockModelDefinitionCreator.of(doorBlock)
                .with(BlockStateVariantMap
                        .models(Properties.HORIZONTAL_FACING, Properties.DOUBLE_BLOCK_HALF, Properties.DOOR_HINGE, Properties.OPEN)
                        .register(Direction.EAST, DoubleBlockHalf.LOWER, DoorHinge.LEFT, false, bottomLeftClosedModel.apply(ROTATE_Y_270))
                        .register(Direction.SOUTH, DoubleBlockHalf.LOWER, DoorHinge.LEFT, false, bottomLeftClosedModel)
                        .register(Direction.WEST, DoubleBlockHalf.LOWER, DoorHinge.LEFT, false, bottomLeftClosedModel.apply(ROTATE_Y_90))
                        .register(Direction.NORTH, DoubleBlockHalf.LOWER, DoorHinge.LEFT, false, bottomLeftClosedModel.apply(ROTATE_Y_180))
                        .register(Direction.EAST, DoubleBlockHalf.LOWER, DoorHinge.RIGHT, false, bottomRightClosedModel.apply(ROTATE_Y_270))
                        .register(Direction.SOUTH, DoubleBlockHalf.LOWER, DoorHinge.RIGHT, false, bottomRightClosedModel)
                        .register(Direction.WEST, DoubleBlockHalf.LOWER, DoorHinge.RIGHT, false, bottomRightClosedModel.apply(ROTATE_Y_90))
                        .register(Direction.NORTH, DoubleBlockHalf.LOWER, DoorHinge.RIGHT, false, bottomRightClosedModel.apply(ROTATE_Y_180))
                        .register(Direction.EAST, DoubleBlockHalf.LOWER, DoorHinge.LEFT, true, bottomLeftOpenModel.apply(ROTATE_Y_270))
                        .register(Direction.SOUTH, DoubleBlockHalf.LOWER, DoorHinge.LEFT, true, bottomLeftOpenModel)
                        .register(Direction.WEST, DoubleBlockHalf.LOWER, DoorHinge.LEFT, true, bottomLeftOpenModel.apply(ROTATE_Y_90))
                        .register(Direction.NORTH, DoubleBlockHalf.LOWER, DoorHinge.LEFT, true, bottomLeftOpenModel.apply(ROTATE_Y_180))
                        .register(Direction.EAST, DoubleBlockHalf.LOWER, DoorHinge.RIGHT, true, bottomRightOpenModel.apply(ROTATE_Y_270))
                        .register(Direction.SOUTH, DoubleBlockHalf.LOWER, DoorHinge.RIGHT, true, bottomRightOpenModel)
                        .register(Direction.WEST, DoubleBlockHalf.LOWER, DoorHinge.RIGHT, true, bottomRightOpenModel.apply(ROTATE_Y_90))
                        .register(Direction.NORTH, DoubleBlockHalf.LOWER, DoorHinge.RIGHT, true, bottomRightOpenModel.apply(ROTATE_Y_180))
                        .register(Direction.EAST, DoubleBlockHalf.UPPER, DoorHinge.LEFT, false, topLeftClosedModel.apply(ROTATE_Y_270))
                        .register(Direction.SOUTH, DoubleBlockHalf.UPPER, DoorHinge.LEFT, false, topLeftClosedModel)
                        .register(Direction.WEST, DoubleBlockHalf.UPPER, DoorHinge.LEFT, false, topLeftClosedModel.apply(ROTATE_Y_90))
                        .register(Direction.NORTH, DoubleBlockHalf.UPPER, DoorHinge.LEFT, false, topLeftClosedModel.apply(ROTATE_Y_180))
                        .register(Direction.EAST, DoubleBlockHalf.UPPER, DoorHinge.RIGHT, false, topRightClosedModel.apply(ROTATE_Y_270))
                        .register(Direction.SOUTH, DoubleBlockHalf.UPPER, DoorHinge.RIGHT, false, topRightClosedModel)
                        .register(Direction.WEST, DoubleBlockHalf.UPPER, DoorHinge.RIGHT, false, topRightClosedModel.apply(ROTATE_Y_90))
                        .register(Direction.NORTH, DoubleBlockHalf.UPPER, DoorHinge.RIGHT, false, topRightClosedModel.apply(ROTATE_Y_180))
                        .register(Direction.EAST, DoubleBlockHalf.UPPER, DoorHinge.LEFT, true, topLeftOpenModel.apply(ROTATE_Y_270))
                        .register(Direction.SOUTH, DoubleBlockHalf.UPPER, DoorHinge.LEFT, true, topLeftOpenModel)
                        .register(Direction.WEST, DoubleBlockHalf.UPPER, DoorHinge.LEFT, true, topLeftOpenModel.apply(ROTATE_Y_90))
                        .register(Direction.NORTH, DoubleBlockHalf.UPPER, DoorHinge.LEFT, true, topLeftOpenModel.apply(ROTATE_Y_180))
                        .register(Direction.EAST, DoubleBlockHalf.UPPER, DoorHinge.RIGHT, true, topRightOpenModel.apply(ROTATE_Y_270))
                        .register(Direction.SOUTH, DoubleBlockHalf.UPPER, DoorHinge.RIGHT, true, topRightOpenModel)
                        .register(Direction.WEST, DoubleBlockHalf.UPPER, DoorHinge.RIGHT, true, topRightOpenModel.apply(ROTATE_Y_90))
                        .register(Direction.NORTH, DoubleBlockHalf.UPPER, DoorHinge.RIGHT, true, topRightOpenModel.apply(ROTATE_Y_180)));
    }


    public final void registerBed(Block block) {
        Identifier headModel = ModelIds.getBlockSubModelId(block, "_head");
        Identifier footModel = ModelIds.getBlockSubModelId(block, "_foot");

        BlockStateVariantMap.DoubleProperty<WeightedVariant,Direction, BedPart> variantMap =
                BlockStateVariantMap.models(Properties.HORIZONTAL_FACING, FurnitureBedBlock.PART);

        fillSimpleDoubleVariantMap(variantMap, BedPart.HEAD, headModel);
        fillSimpleDoubleVariantMap(variantMap, BedPart.FOOT, footModel);
        generator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(block).with(variantMap));
    }

    public void registerTV(Block block) {
        WeightedVariant identifier = createWeightedVariant(ModelIds.getBlockModelId(block));
        WeightedVariant identifier2 = createWeightedVariant(ModelIds.getBlockSubModelId(block,"_open"));
        generator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(block).with(createBooleanModelMap(Properties.LIT, identifier2, identifier)).coordinate(NORTH_DEFAULT_HORIZONTAL_ROTATION_OPERATIONS));
    }

    public static BlockStateVariantMap.DoubleProperty<WeightedVariant, Direction, BedPart> fillSimpleDoubleVariantMap(
            BlockStateVariantMap.DoubleProperty<WeightedVariant, Direction, BedPart> variantMap,
            BedPart targetHalf,
            Identifier baseModelId
    ) {
        return variantMap
                .register(Direction.NORTH, targetHalf, createWeightedVariant(baseModelId))
                .register(Direction.EAST, targetHalf, createWeightedVariant(baseModelId).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R90)))
                .register(Direction.SOUTH, targetHalf, createWeightedVariant(baseModelId).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R180)))
                .register(Direction.WEST, targetHalf, createWeightedVariant(baseModelId).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R270)));
    }

    static {
        NORTH_DEFAULT_HORIZONTAL_ROTATION_OPERATIONS = BlockStateVariantMap.operations(Properties.HORIZONTAL_FACING).register(Direction.EAST, ROTATE_Y_90).register(Direction.SOUTH, ROTATE_Y_180).register(Direction.WEST, ROTATE_Y_270).register(Direction.NORTH, NO_OP);
    }
}