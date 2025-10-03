package com.skniro.skniro_furniture.block.renderer.state;


import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;

public class OvenBlockEntityRenderState extends BlockEntityRenderState {
    public final ItemStackRenderState item = new ItemStackRenderState();
}