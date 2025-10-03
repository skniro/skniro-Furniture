package com.skniro.skniro_furniture.block.renderer.state;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import java.util.Collections;
import java.util.List;

@Environment(EnvType.CLIENT)
public class PlateBlockEntityRendererState extends BlockEntityRenderState {
    public final ItemStackRenderState item = new ItemStackRenderState();
}