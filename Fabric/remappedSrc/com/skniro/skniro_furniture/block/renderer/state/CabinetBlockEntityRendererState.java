package com.skniro.skniro_furniture.block.renderer.state;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import java.util.Collections;
import java.util.List;

@Environment(EnvType.CLIENT)
public class CabinetBlockEntityRendererState extends BlockEntityRenderState {
    public List<ItemStackRenderState> triplecabinetItemStates = Collections.emptyList();
    public List<ItemStackRenderState> fourgridcabinetItemStates = Collections.emptyList();
    public NonNullList<ItemStack> stack;
    public Level world;
}