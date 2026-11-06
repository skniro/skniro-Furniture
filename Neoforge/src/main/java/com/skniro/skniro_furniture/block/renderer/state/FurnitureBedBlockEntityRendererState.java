package com.skniro.skniro_furniture.block.renderer.state;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.BedPart;

public class FurnitureBedBlockEntityRendererState extends BannerDecoratedBlockEntityRenderState {
    public Direction facing = Direction.NORTH;
    public BedPart part = BedPart.FOOT;
}
