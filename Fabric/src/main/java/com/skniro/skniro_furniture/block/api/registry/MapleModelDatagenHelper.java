package com.skniro.skniro_furniture.block.api.registry;

import com.skniro.skniro_furniture.block.init.KitchenCounterBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.client.data.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import static net.minecraft.client.data.BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates;

public class MapleModelDatagenHelper {
    private final BlockStateModelGenerator generator;

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
}