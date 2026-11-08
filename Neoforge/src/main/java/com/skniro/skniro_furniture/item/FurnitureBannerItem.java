package com.skniro.skniro_furniture.item;

import com.skniro.skniro_furniture.block.init.CoffeeChairBlock;
import com.skniro.skniro_furniture.block.init.CushionBlock;
import com.skniro.skniro_furniture.block.init.FurnitureBedBlock;
import net.minecraft.world.item.BannerItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

/**
 * A banner item that wraps furniture blocks which implement
 * {@link com.skniro.skniro_furniture.block.init.BannerDecoratedBlock}.
 *
 * <p>It keeps the vanilla {@link BannerItem} behaviour that the loom uses (banner slot,
 * pattern layers), but places the furniture block like a normal {@code BlockItem}
 * instead of the standing/wall banner placement.</p>
 */
public class FurnitureBannerItem extends BannerItem {
    public FurnitureBannerItem(Block block, Item.Properties properties) {
        super(block, block, properties);
    }

    @Override
    public DyeColor getColor() {
        Block block = this.getBlock();
        if (block instanceof FurnitureBedBlock bed) {
            return bed.getColor();
        }
        if (block instanceof CushionBlock cushion) {
            return cushion.getColor();
        }
        if (block instanceof CoffeeChairBlock chair) {
            return chair.getColor();
        }
        return DyeColor.WHITE;
    }

    @Override
    protected BlockState getPlacementState(BlockPlaceContext context) {
        BlockState state = this.getBlock().getStateForPlacement(context);
        return state != null && this.canPlace(context, state) ? state : null;
    }
}
