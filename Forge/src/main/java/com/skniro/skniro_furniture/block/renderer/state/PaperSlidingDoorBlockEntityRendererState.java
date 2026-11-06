package com.skniro.skniro_furniture.block.renderer.state;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

public class PaperSlidingDoorBlockEntityRendererState extends BannerDecoratedBlockEntityRenderState {
    public Direction facing = Direction.SOUTH;
    public DoubleBlockHalf half = DoubleBlockHalf.LOWER;
    public DoorHingeSide hinge = DoorHingeSide.LEFT;
    public boolean open;
}
