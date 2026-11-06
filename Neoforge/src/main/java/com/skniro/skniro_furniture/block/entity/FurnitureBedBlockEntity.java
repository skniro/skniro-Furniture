package com.skniro.skniro_furniture.block.entity;

import com.skniro.skniro_furniture.block.init.FurnitureBedBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.state.BlockState;

public class FurnitureBedBlockEntity extends AbstractBannerDecoratedBlockEntity {
    public FurnitureBedBlockEntity(BlockPos pos, BlockState state) {
        super(FurnitureBlockEntityType.Bed_BLOCK_ENTITY.get(), pos, state);
    }

    @Override
    protected DyeColor getDefaultColor() {
        return this.getBlockState().getBlock() instanceof FurnitureBedBlock bed ? bed.getColor() : DyeColor.WHITE;
    }
}
