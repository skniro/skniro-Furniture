package com.skniro.skniro_furniture.block.init;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.BaseEntityBlock;

public class TripleCabinetBlock extends AbstractWallCabinetBlock {
    public static final MapCodec<TripleCabinetBlock> CODEC = simpleCodec(TripleCabinetBlock::new);

    public TripleCabinetBlock(Properties settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

}
