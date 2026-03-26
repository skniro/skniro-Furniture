package com.skniro.skniro_furniture.block.renderer.state;


import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.world.level.block.state.BlockState;

public class KitchenSinkBlockEntityRenderState extends BlockEntityRenderState {
    public final ItemStackRenderState item = new ItemStackRenderState();
    public BlockState blockState;
}