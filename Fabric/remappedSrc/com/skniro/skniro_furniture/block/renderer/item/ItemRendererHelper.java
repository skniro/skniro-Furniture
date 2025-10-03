package com.skniro.skniro_furniture.block.renderer.item;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.List;

@Environment(EnvType.CLIENT)
public class ItemRendererHelper extends ItemRenderer {
    private final ItemModelResolver itemModelManager;
    private final ItemStackRenderState itemRenderState = new ItemStackRenderState();

    public ItemRendererHelper(ItemModelResolver itemModelManager) {
        this.itemModelManager = itemModelManager;
    }


    public void renderItem(ItemStack stack, ItemDisplayContext displayContext, int light, int overlay, PoseStack matrices, SubmitNodeCollector vertexConsumers, @Nullable Level world, int seed, int tint) {
        this.renderItem((LivingEntity)null, stack, displayContext, matrices, vertexConsumers, world, light, overlay, seed, tint);
    }

    public void renderItem(@Nullable LivingEntity entity, ItemStack stack, ItemDisplayContext displayContext, PoseStack matrices, SubmitNodeCollector vertexConsumers, @Nullable Level world, int light, int overlay, int seed, int tint) {
        this.itemModelManager.updateForTopItem(this.itemRenderState, stack, displayContext, world, entity, seed);
        this.itemRenderState.submit(matrices, vertexConsumers, light, overlay, tint);
    }
}