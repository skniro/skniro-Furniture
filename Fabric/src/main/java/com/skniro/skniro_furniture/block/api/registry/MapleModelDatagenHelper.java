package com.skniro.skniro_furniture.block.api.registry;

import com.mojang.datafixers.util.Pair;
import com.skniro.skniro_furniture.block.init.FurnitureBedBlock;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.enums.BedPart;
import net.minecraft.block.enums.DoorHinge;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.minecraft.data.client.BlockStateModelGenerator.*;


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
        Identifier identifier = ModelIds.getBlockModelId(block);
        Identifier identifier2 = ModelIds.getBlockSubModelId(block,"_on");
        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block).coordinate(createBooleanModelMap(Properties.LIT, identifier2, identifier)));
    }

    public void registerFridge(Block block) {
        Identifier bottomModel = ModelIds.getBlockSubModelId(block, "_bottom");
        Identifier topModel = ModelIds.getBlockSubModelId(block, "_top");

        BlockStateVariantMap.DoubleProperty<Direction, DoubleBlockHalf> variantMap =
                BlockStateVariantMap.create(Properties.HORIZONTAL_FACING, Properties.DOUBLE_BLOCK_HALF);

        fillSimpleDoubleVariantMap(variantMap, DoubleBlockHalf.LOWER, bottomModel);
        fillSimpleDoubleVariantMap(variantMap, DoubleBlockHalf.UPPER, topModel);

        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block).coordinate(variantMap));
    }


    public static BlockStateVariantMap.DoubleProperty<Direction, DoubleBlockHalf> fillSimpleDoubleVariantMap(
            BlockStateVariantMap.DoubleProperty<Direction, DoubleBlockHalf> variantMap,
            DoubleBlockHalf targetHalf,
            Identifier baseModelId
    ) {
        return variantMap
                .register(Direction.NORTH, targetHalf, BlockStateVariant.create().put(VariantSettings.MODEL, baseModelId))
                .register(Direction.EAST, targetHalf, BlockStateVariant.create().put(VariantSettings.MODEL, baseModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.SOUTH, targetHalf, BlockStateVariant.create().put(VariantSettings.MODEL, baseModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.WEST, targetHalf, BlockStateVariant.create().put(VariantSettings.MODEL, baseModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270));
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

    public void registerPaperSlidingDoor(Block doorBlock) {
        Identifier Identifier = ModelIds.getBlockSubModelId(doorBlock, "_bottom_left");
        Identifier Identifier2 = ModelIds.getBlockSubModelId(doorBlock, "_bottom_left_open");
        Identifier Identifier3 = ModelIds.getBlockSubModelId(doorBlock, "_bottom_right");
        Identifier Identifier4 = ModelIds.getBlockSubModelId(doorBlock, "_bottom_right_open");
        Identifier Identifier5 = ModelIds.getBlockSubModelId(doorBlock, "_top_left");
        Identifier Identifier6 = ModelIds.getBlockSubModelId(doorBlock, "_top_left_open");
        Identifier Identifier7 = ModelIds.getBlockSubModelId(doorBlock, "_top_right");
        Identifier Identifier8 = ModelIds.getBlockSubModelId(doorBlock, "_top_right_open");
        generator.blockStateCollector.accept(createDoorBlockState(doorBlock, Identifier, Identifier2, Identifier3, Identifier4, Identifier5, Identifier6, Identifier7, Identifier8));
    }

    public static VariantsBlockStateSupplier createDoorBlockState(Block doorBlock, Identifier bottomLeftClosedModel, Identifier bottomLeftOpenModel, Identifier bottomRightClosedModel, Identifier bottomRightOpenModel, Identifier topLeftClosedModel, Identifier topLeftOpenModel, Identifier topRightClosedModel, Identifier topRightOpenModel) {
        return VariantsBlockStateSupplier.create(doorBlock)
                .coordinate(BlockStateVariantMap
                        .create(Properties.HORIZONTAL_FACING, Properties.DOUBLE_BLOCK_HALF, Properties.DOOR_HINGE, Properties.OPEN)
                        .register(Direction.EAST,  DoubleBlockHalf.LOWER, DoorHinge.LEFT,  false,
                                BlockStateVariant.create().put(VariantSettings.MODEL, bottomLeftClosedModel).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                        .register(Direction.SOUTH, DoubleBlockHalf.LOWER, DoorHinge.LEFT,  false,
                                BlockStateVariant.create().put(VariantSettings.MODEL, bottomLeftClosedModel))
                        .register(Direction.WEST,  DoubleBlockHalf.LOWER, DoorHinge.LEFT,  false,
                                BlockStateVariant.create().put(VariantSettings.MODEL, bottomLeftClosedModel).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .register(Direction.NORTH, DoubleBlockHalf.LOWER, DoorHinge.LEFT,  false,
                                BlockStateVariant.create().put(VariantSettings.MODEL, bottomLeftClosedModel).put(VariantSettings.Y, VariantSettings.Rotation.R180))

                        .register(Direction.EAST,  DoubleBlockHalf.LOWER, DoorHinge.RIGHT, false,
                                BlockStateVariant.create().put(VariantSettings.MODEL, bottomRightClosedModel).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                        .register(Direction.SOUTH, DoubleBlockHalf.LOWER, DoorHinge.RIGHT, false,
                                BlockStateVariant.create().put(VariantSettings.MODEL, bottomRightClosedModel))
                        .register(Direction.WEST,  DoubleBlockHalf.LOWER, DoorHinge.RIGHT, false,
                                BlockStateVariant.create().put(VariantSettings.MODEL, bottomRightClosedModel).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .register(Direction.NORTH, DoubleBlockHalf.LOWER, DoorHinge.RIGHT, false,
                                BlockStateVariant.create().put(VariantSettings.MODEL, bottomRightClosedModel).put(VariantSettings.Y, VariantSettings.Rotation.R180))

                        .register(Direction.EAST,  DoubleBlockHalf.LOWER, DoorHinge.LEFT,  true,
                                BlockStateVariant.create().put(VariantSettings.MODEL, bottomLeftOpenModel).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                        .register(Direction.SOUTH, DoubleBlockHalf.LOWER, DoorHinge.LEFT,  true,
                                BlockStateVariant.create().put(VariantSettings.MODEL, bottomLeftOpenModel))
                        .register(Direction.WEST,  DoubleBlockHalf.LOWER, DoorHinge.LEFT,  true,
                                BlockStateVariant.create().put(VariantSettings.MODEL, bottomLeftOpenModel).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .register(Direction.NORTH, DoubleBlockHalf.LOWER, DoorHinge.LEFT,  true,
                                BlockStateVariant.create().put(VariantSettings.MODEL, bottomLeftOpenModel).put(VariantSettings.Y, VariantSettings.Rotation.R180))

                        .register(Direction.EAST,  DoubleBlockHalf.LOWER, DoorHinge.RIGHT, true,
                                BlockStateVariant.create().put(VariantSettings.MODEL, bottomRightOpenModel).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                        .register(Direction.SOUTH, DoubleBlockHalf.LOWER, DoorHinge.RIGHT, true,
                                BlockStateVariant.create().put(VariantSettings.MODEL, bottomRightOpenModel))
                        .register(Direction.WEST,  DoubleBlockHalf.LOWER, DoorHinge.RIGHT, true,
                                BlockStateVariant.create().put(VariantSettings.MODEL, bottomRightOpenModel).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .register(Direction.NORTH, DoubleBlockHalf.LOWER, DoorHinge.RIGHT, true,
                                BlockStateVariant.create().put(VariantSettings.MODEL, bottomRightOpenModel).put(VariantSettings.Y, VariantSettings.Rotation.R180))

                        .register(Direction.EAST,  DoubleBlockHalf.UPPER, DoorHinge.LEFT,  false,
                                BlockStateVariant.create().put(VariantSettings.MODEL, topLeftClosedModel).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                        .register(Direction.SOUTH, DoubleBlockHalf.UPPER, DoorHinge.LEFT,  false,
                                BlockStateVariant.create().put(VariantSettings.MODEL, topLeftClosedModel))
                        .register(Direction.WEST,  DoubleBlockHalf.UPPER, DoorHinge.LEFT,  false,
                                BlockStateVariant.create().put(VariantSettings.MODEL, topLeftClosedModel).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .register(Direction.NORTH, DoubleBlockHalf.UPPER, DoorHinge.LEFT,  false,
                                BlockStateVariant.create().put(VariantSettings.MODEL, topLeftClosedModel).put(VariantSettings.Y, VariantSettings.Rotation.R180))

                        .register(Direction.EAST,  DoubleBlockHalf.UPPER, DoorHinge.RIGHT, false,
                                BlockStateVariant.create().put(VariantSettings.MODEL, topRightClosedModel).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                        .register(Direction.SOUTH, DoubleBlockHalf.UPPER, DoorHinge.RIGHT, false,
                                BlockStateVariant.create().put(VariantSettings.MODEL, topRightClosedModel))
                        .register(Direction.WEST,  DoubleBlockHalf.UPPER, DoorHinge.RIGHT, false,
                                BlockStateVariant.create().put(VariantSettings.MODEL, topRightClosedModel).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .register(Direction.NORTH, DoubleBlockHalf.UPPER, DoorHinge.RIGHT, false,
                                BlockStateVariant.create().put(VariantSettings.MODEL, topRightClosedModel).put(VariantSettings.Y, VariantSettings.Rotation.R180))

                        .register(Direction.EAST,  DoubleBlockHalf.UPPER, DoorHinge.LEFT,  true,
                                BlockStateVariant.create().put(VariantSettings.MODEL, topLeftOpenModel).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                        .register(Direction.SOUTH, DoubleBlockHalf.UPPER, DoorHinge.LEFT,  true,
                                BlockStateVariant.create().put(VariantSettings.MODEL, topLeftOpenModel))
                        .register(Direction.WEST,  DoubleBlockHalf.UPPER, DoorHinge.LEFT,  true,
                                BlockStateVariant.create().put(VariantSettings.MODEL, topLeftOpenModel).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .register(Direction.NORTH, DoubleBlockHalf.UPPER, DoorHinge.LEFT,  true,
                                BlockStateVariant.create().put(VariantSettings.MODEL, topLeftOpenModel).put(VariantSettings.Y, VariantSettings.Rotation.R180))

                        .register(Direction.EAST,  DoubleBlockHalf.UPPER, DoorHinge.RIGHT, true,
                                BlockStateVariant.create().put(VariantSettings.MODEL, topRightOpenModel).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                        .register(Direction.SOUTH, DoubleBlockHalf.UPPER, DoorHinge.RIGHT, true,
                                BlockStateVariant.create().put(VariantSettings.MODEL, topRightOpenModel))
                        .register(Direction.WEST,  DoubleBlockHalf.UPPER, DoorHinge.RIGHT, true,
                                BlockStateVariant.create().put(VariantSettings.MODEL, topRightOpenModel).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .register(Direction.NORTH, DoubleBlockHalf.UPPER, DoorHinge.RIGHT, true,
                                BlockStateVariant.create().put(VariantSettings.MODEL, topRightOpenModel).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                );
    }

    public final void registerBed(Block block) {
        Identifier headModel = ModelIds.getBlockSubModelId(block, "_head");
        Identifier footModel = ModelIds.getBlockSubModelId(block, "_foot");

        BlockStateVariantMap.DoubleProperty<Direction, BedPart> variantMap =
                BlockStateVariantMap.create(Properties.HORIZONTAL_FACING, FurnitureBedBlock.PART);

        fillSimpleDoubleVariantMap(variantMap, BedPart.HEAD, headModel);
        fillSimpleDoubleVariantMap(variantMap, BedPart.FOOT, footModel);
        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block).coordinate(variantMap));
    }

    public void registerTV(Block block) {
        Identifier identifier = ModelIds.getBlockModelId(block);
        Identifier identifier2 = ModelIds.getBlockSubModelId(block,"_open");
        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block).coordinate(createBooleanModelMap(Properties.LIT, identifier2, identifier)).coordinate(createNorthDefaultHorizontalRotationStates()));
    }

    public static BlockStateVariantMap.DoubleProperty<Direction, BedPart> fillSimpleDoubleVariantMap(
            BlockStateVariantMap.DoubleProperty<Direction, BedPart> variantMap,
            BedPart targetHalf,
            Identifier baseModelId
    ) {
        return variantMap
                .register(Direction.NORTH, targetHalf, BlockStateVariant.create().put(VariantSettings.MODEL, baseModelId))
                .register(Direction.EAST, targetHalf, BlockStateVariant.create().put(VariantSettings.MODEL, baseModelId).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.SOUTH, targetHalf, BlockStateVariant.create().put(VariantSettings.MODEL, baseModelId).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.WEST, targetHalf, BlockStateVariant.create().put(VariantSettings.MODEL, baseModelId).put(VariantSettings.Y, VariantSettings.Rotation.R270));
    }
}