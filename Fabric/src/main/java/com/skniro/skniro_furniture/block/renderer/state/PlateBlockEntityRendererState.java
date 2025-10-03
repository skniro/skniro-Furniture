package com.skniro.skniro_furniture.block.renderer.state;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.entity.state.BlockEntityRenderState;
import net.minecraft.client.render.item.ItemRenderState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.List;

@Environment(EnvType.CLIENT)
public class PlateBlockEntityRendererState extends BlockEntityRenderState {
    public final ItemRenderState item = new ItemRenderState();
}