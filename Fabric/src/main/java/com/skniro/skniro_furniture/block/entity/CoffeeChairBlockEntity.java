package com.skniro.skniro_furniture.block.entity;

import com.skniro.skniro_furniture.block.init.CoffeeChairBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.state.BlockState;

public class CoffeeChairBlockEntity extends AbstractBannerDecoratedBlockEntity {
    public CoffeeChairBlockEntity(BlockPos pos, BlockState state) {
        super(FurnitureBlockEntityType.CoffeeChair_BLOCK_ENTITY, pos, state);
    }

    @Override
    protected DyeColor getDefaultColor() {
        return this.getBlockState().getBlock() instanceof CoffeeChairBlock chair
                ? chair.getColor()
                : DyeColor.WHITE;
    }
}
