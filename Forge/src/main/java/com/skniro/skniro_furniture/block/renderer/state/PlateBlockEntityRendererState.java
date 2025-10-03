package com.skniro.skniro_furniture.block.renderer.state;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PlateBlockEntityRendererState extends BlockEntityRenderState {
    public final ItemStackRenderState item = new ItemStackRenderState();
}