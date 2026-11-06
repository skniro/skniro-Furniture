package com.skniro.skniro_furniture.block.entity;

import com.skniro.skniro_furniture.block.init.DividerBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.state.BlockState;

public class DividerBlockEntity extends AbstractBannerDecoratedBlockEntity {
    public DividerBlockEntity(BlockPos pos, BlockState state) {
        super(FurnitureBlockEntityType.Divider_BLOCK_ENTITY, pos, state);
    }

    @Override
    protected DyeColor getDefaultColor() {
        return this.getBlockState().getBlock() instanceof DividerBlock divider ? divider.getColor() : DyeColor.WHITE;
    }
}
