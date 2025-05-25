package com.skniro.skniro_furniture.block.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.skniro.skniro_furniture.Furniture;
import com.skniro.skniro_furniture.block.entity.OvenBlockEntity;
import com.skniro.skniro_furniture.block.init.OvenBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.joml.Matrix4f;

public class OvenBlockEntityRenderer implements BlockEntityRenderer<OvenBlockEntity> {

    private static final ResourceLocation LIGHT_TEXTURE = ResourceLocation.fromNamespaceAndPath(Furniture.MOD_ID, "textures/block/oven_light.png");

    public OvenBlockEntityRenderer(BlockEntityRendererProvider.Context ctx) {}

    @Override
    public void render(OvenBlockEntity entity, float tickDelta, PoseStack matrices,
                       MultiBufferSource vertexConsumers, int light, int overlay) {

        var state = entity.getBlockState();
        var facing = state.getValue(BlockStateProperties.HORIZONTAL_FACING);

        if (!(state.getBlock() instanceof OvenBlock)) return;
        matrices.pushPose();

        switch (facing) {
            case NORTH -> matrices.translate(0.5, 0.4, 0.15);
            case SOUTH -> matrices.translate(0.5, 0.4, 0.85);
            case WEST -> matrices.translate(0.15, 0.4, 0.5);
            case EAST -> matrices.translate(0.85, 0.4, 0.5);
        }

        float angle = switch (facing) {
            case NORTH -> 0f;
            case SOUTH -> 180f;
            case WEST -> 90f;
            case EAST -> -90f;
            default -> 0f;
        };

        matrices.mulPose(Axis.YP.rotationDegrees(angle)); // 按 Y 轴旋转

        Matrix4f mat = matrices.last().pose();

        if (state.getValue(OvenBlock.LIT)){
            VertexConsumer glowVc = vertexConsumers.getBuffer(RenderType.eyes(LIGHT_TEXTURE));
            drawQuad(mat, glowVc, 0x80FFFF00, light);
        }

        ItemStack stack = entity.getRenderStack();
        if (!stack.isEmpty()) {
            renderItemAsIcon(facing, stack, matrices, vertexConsumers, light, overlay);
        }
        matrices.popPose();
    }

    private void drawQuad(Matrix4f mat, VertexConsumer vc, int color, int light) {
        vc.addVertex(mat, -0.3F,  0.21F, 0F)
                .setColor(color)
                .setUv(0F, 0F)
                .setOverlay(OverlayTexture.NO_OVERLAY)
                .setLight(light)
                .setNormal(0F, 0F, -1F);
        vc.addVertex(mat,  0.3F,  0.21F, 0F)
                .setColor(color)
                .setUv(1F, 0F)
                .setOverlay(OverlayTexture.NO_OVERLAY)
                .setLight(light)
                .setNormal(0F, 0F, -1F);
        vc.addVertex(mat,  0.3F, -0.21F, 0F)
                .setColor(color)
                .setUv(1F, 1F)
                .setOverlay(OverlayTexture.NO_OVERLAY)
                .setLight(light)
                .setNormal(0F, 0F, -1F);
        vc.addVertex(mat, -0.3F, -0.21F, 0F)
                .setColor(color)
                .setUv(0F, 1F)
                .setOverlay(OverlayTexture.NO_OVERLAY)
                .setLight(light)
                .setNormal(0F, 0F, -1F);
    }

    private void renderItemAsIcon(Direction direction, ItemStack stack, PoseStack matrices,
                                  MultiBufferSource vertexConsumers, int light, int overlay) {

        matrices.pushPose();
        matrices.scale(0.4f, 0.4f, 0.4f);
        matrices.translate(0.0, 0.3, 0.3);

        Minecraft.getInstance().getItemRenderer()
                .renderStatic(stack, ItemDisplayContext.GUI, light, overlay, matrices, vertexConsumers, null, 0);
        matrices.popPose();
    }
}
