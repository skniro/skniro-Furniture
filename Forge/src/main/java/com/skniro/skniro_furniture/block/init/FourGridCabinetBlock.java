package com.skniro.skniro_furniture.block.init;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.BaseEntityBlock;

public class FourGridCabinetBlock extends AbstractWallCabinetBlock {
    public static final MapCodec<FourGridCabinetBlock> CODEC = simpleCodec(FourGridCabinetBlock::new);
    public FourGridCabinetBlock(Properties settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }
}
