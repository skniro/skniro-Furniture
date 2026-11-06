package com.skniro.skniro_furniture.block.entity;

import com.skniro.skniro_furniture.block.init.CushionBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.state.BlockState;

public class CushionBlockEntity extends AbstractBannerDecoratedBlockEntity {
    public CushionBlockEntity(BlockPos pos, BlockState state) {
        super(FurnitureBlockEntityType.Cushion_BLOCK_ENTITY.get(), pos, state);
    }

    @Override
    protected DyeColor getDefaultColor() {
        return this.getBlockState().getBlock() instanceof CushionBlock cushion
                ? cushion.getColor()
                : DyeColor.WHITE;
    }
}
