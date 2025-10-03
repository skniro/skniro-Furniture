package com.skniro.skniro_furniture.block.renderer.state;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import java.util.Collections;
import java.util.List;

public class PlateBlockEntityRendererState extends BlockEntityRenderState {
    public final ItemStackRenderState item = new ItemStackRenderState();
}