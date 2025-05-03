package com.skniro.skniro_furniture.block.init;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockWithEntity;

public class TripleCabinetBlock extends AbstractWallCabinetBlock {
    public static final MapCodec<TripleCabinetBlock> CODEC = createCodec(TripleCabinetBlock::new);

    public TripleCabinetBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

}
