package com.skniro.skniro_furniture.block.api.registry;

import com.mojang.datafixers.util.Pair;
import com.mojang.math.Quadrant;
import com.skniro.skniro_furniture.block.init.KitchenCounterBlock;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.data.*;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.renderer.block.model.VariantMutator;
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
    private final BlockModelGenerators generator;;

    public MapleModelDatagenHelper(BlockModelGenerators generator) {
        this.generator = generator;
    }

    public void registerModSweetBerryBush(Item fruititem, Block block) {
        generator.registerSimpleFlatItemModel(fruititem);
        generator.blockStateOutput.accept(MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(BlockStateProperties.AGE_3).generate(stage ->
                                plainVariant(
                                generator.createSuffixedVariant(block, "_stage" + stage, ModelTemplates.CROSS, TextureMapping::cross)
                        )
                ))
        );
    }

    public void registerModBookshelf(Block block, Block plank) {
        TextureMapping textureMap = TextureMapping.column(TextureMapping.getBlockTexture(block), TextureMapping.getBlockTexture(plank));
        MultiVariant identifier = plainVariant(ModelTemplates.CUBE_COLUMN.create(block, textureMap, generator.modelOutput));
        generator.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block, identifier));
    }

    public void registerLamp(Block block) {
        MultiVariant identifier = plainVariant(ModelLocationUtils.getModelLocation(block));
        MultiVariant identifier2 = plainVariant(ModelLocationUtils.getModelLocation(block,"_on"));
        generator.blockStateOutput.accept(MultiVariantGenerator.dispatch(block).with(createBooleanModelDispatch(BlockStateProperties.LIT, identifier2, identifier)));
    }

    public final void registerBlockState(Block block) {
        generator.blockStateOutput.accept(MultiVariantGenerator.dispatch(block, plainVariant(ModelLocationUtils.getModelLocation(block))));
    }

    public void registerFridge(Block block) {
        ResourceLocation bottomModel = ModelLocationUtils.getModelLocation(block, "_bottom");
        ResourceLocation topModel = ModelLocationUtils.getModelLocation(block, "_top");

        PropertyDispatch.C2<MultiVariant,Direction, DoubleBlockHalf> variantMap =
                PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.DOUBLE_BLOCK_HALF);

        fillSimpleDoubleVariantMap(variantMap, DoubleBlockHalf.LOWER, bottomModel);
        fillSimpleDoubleVariantMap(variantMap, DoubleBlockHalf.UPPER, topModel);

        generator.blockStateOutput.accept(MultiVariantGenerator.dispatch(block).with(variantMap));
    }


    public static PropertyDispatch.C2<MultiVariant, Direction, DoubleBlockHalf> fillSimpleDoubleVariantMap(
            PropertyDispatch.C2<MultiVariant, Direction, DoubleBlockHalf> variantMap,
            DoubleBlockHalf targetHalf,
            ResourceLocation baseModelId
    ) {
        return variantMap
                .select(Direction.NORTH, targetHalf, plainVariant(baseModelId))
                .select(Direction.EAST, targetHalf, plainVariant(baseModelId).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                .select(Direction.SOUTH, targetHalf, plainVariant(baseModelId).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                .select(Direction.WEST, targetHalf, plainVariant(baseModelId).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)));
    }
}