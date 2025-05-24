package com.skniro.skniro_furniture.block.api.registry;

import com.mojang.datafixers.util.Pair;
import com.skniro.skniro_furniture.block.init.KitchenCounterBlock;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.data.*;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.blockstates.Condition;
import net.minecraft.client.data.models.blockstates.MultiPartGenerator;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.blockstates.Variant;
import net.minecraft.client.data.models.blockstates.VariantProperties;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.minecraft.client.data.models.BlockModelGenerators.*;

public class MapleModelDatagenHelper {
    private final BlockModelGenerators generator;
    private static final Map<ChiseledBookshelfModelCacheKey, ResourceLocation> CHISELED_BOOKSHELF_MODEL_CACHE = new HashMap();;

    public MapleModelDatagenHelper(BlockModelGenerators generator) {
        this.generator = generator;
    }

    public void registerModSweetBerryBush(Item fruititem, Block block) {
        generator.registerSimpleFlatItemModel(fruititem);
        generator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block)
                .with(PropertyDispatch.property(BlockStateProperties.AGE_3).generate(stage ->
                        Variant.variant().with(VariantProperties.MODEL,
                                generator.createSuffixedVariant(block, "_stage" + stage, ModelTemplates.CROSS, TextureMapping::cross)
                        )
                ))
        );
    }

    public void registerModBookshelf(Block block, Block plank) {
        TextureMapping textureMap = TextureMapping.column(TextureMapping.getBlockTexture(block), TextureMapping.getBlockTexture(plank));
        ResourceLocation identifier = ModelTemplates.CUBE_COLUMN.create(block, textureMap, generator.modelOutput);
        generator.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block, identifier));
    }

    public void registerLamp(Block block) {
        ResourceLocation identifier = ModelLocationUtils.getModelLocation(block);
        ResourceLocation identifier2 = ModelLocationUtils.getModelLocation(block,"_on");
        generator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block).with(createBooleanModelDispatch(BlockStateProperties.LIT, identifier2, identifier)));
    }

    public void registerFridge(Block block) {
        ResourceLocation bottomModel = ModelLocationUtils.getModelLocation(block, "_bottom");
        ResourceLocation topModel = ModelLocationUtils.getModelLocation(block, "_top");

        PropertyDispatch.C2<Direction, DoubleBlockHalf> variantMap =
                PropertyDispatch.properties(BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.DOUBLE_BLOCK_HALF);

        fillSimpleDoubleVariantMap(variantMap, DoubleBlockHalf.LOWER, bottomModel);
        fillSimpleDoubleVariantMap(variantMap, DoubleBlockHalf.UPPER, topModel);

        generator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block).with(variantMap));
    }


    public static PropertyDispatch.C2<Direction, DoubleBlockHalf> fillSimpleDoubleVariantMap(
            PropertyDispatch.C2<Direction, DoubleBlockHalf> variantMap,
            DoubleBlockHalf targetHalf,
            ResourceLocation baseModelId
    ) {
        return variantMap
                .select(Direction.NORTH, targetHalf, Variant.variant().with(VariantProperties.MODEL, baseModelId))
                .select(Direction.EAST, targetHalf, Variant.variant().with(VariantProperties.MODEL, baseModelId).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.SOUTH, targetHalf, Variant.variant().with(VariantProperties.MODEL, baseModelId).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.WEST, targetHalf, Variant.variant().with(VariantProperties.MODEL, baseModelId).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270));
    }

    public void registerModChiseledBookshelf(Block block) {
        ResourceLocation identifier = ModelLocationUtils.getModelLocation(block);
        MultiPartGenerator multipartBlockStateSupplier = MultiPartGenerator.multiPart(block);
        List.of(Pair.of(Direction.NORTH, VariantProperties.Rotation.R0), Pair.of(Direction.EAST, VariantProperties.Rotation.R90), Pair.of(Direction.SOUTH, VariantProperties.Rotation.R180), Pair.of(Direction.WEST, VariantProperties.Rotation.R270)).forEach((pair) -> {
            Direction direction = (Direction)pair.getFirst();
            VariantProperties.Rotation rotation = (VariantProperties.Rotation)pair.getSecond();
            Condition.TerminalCondition propertyCondition = Condition.condition().term(BlockStateProperties.HORIZONTAL_FACING, direction);
            multipartBlockStateSupplier.with(propertyCondition, Variant.variant().with(VariantProperties.MODEL, identifier).with(VariantProperties.Y_ROT, rotation).with(VariantProperties.UV_LOCK, true));
            generator.addSlotStateAndRotationVariants(multipartBlockStateSupplier, propertyCondition, rotation);
        });
        generator.blockStateOutput.accept(multipartBlockStateSupplier);
        generator.registerSimpleItemModel(block, ModelLocationUtils.getModelLocation(block, "_inventory"));
        CHISELED_BOOKSHELF_MODEL_CACHE.clear();
    }

    @Environment(EnvType.CLIENT)
    static record ChiseledBookshelfModelCacheKey(ModelTemplate template, String modelSuffix) {
        ChiseledBookshelfModelCacheKey(ModelTemplate template, String modelSuffix) {
            this.template = template;
            this.modelSuffix = modelSuffix;
        }

        public ModelTemplate template() {
            return this.template;
        }

        public String modelSuffix() {
            return this.modelSuffix;
        }
    }
}