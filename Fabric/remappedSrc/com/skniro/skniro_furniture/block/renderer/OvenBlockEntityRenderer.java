package com.skniro.skniro_furniture.block.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.skniro.skniro_furniture.Furniture;
import com.skniro.skniro_furniture.block.entity.KitchenSinkBlockEntity;
import com.skniro.skniro_furniture.block.entity.OvenBlockEntity;
import com.skniro.skniro_furniture.block.init.OvenBlock;
import com.skniro.skniro_furniture.block.renderer.item.ItemRendererHelper;
import com.skniro.skniro_furniture.block.renderer.state.CabinetBlockEntityRendererState;
import com.skniro.skniro_furniture.block.renderer.state.KitchenSinkBlockEntityRenderState;
import com.skniro.skniro_furniture.block.renderer.state.OvenBlockEntityRenderState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.render.*;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.math.*;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;

public class OvenBlockEntityRenderer implements BlockEntityRenderer<OvenBlockEntity, OvenBlockEntityRenderState> {

    private static final Identifier LIGHT_TEXTURE = Identifier.fromNamespaceAndPath(Furniture.MOD_ID, "textures/block/oven_light.png");

    public OvenBlockEntityRenderer(BlockEntityRendererProvider.Context ctx) {}

    @Override
    public void render(OvenBlockEntityRenderState state, PoseStack matrices, SubmitNodeCollector queue, CameraRenderState cameraRenderState) {
        var facing = state.blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);

        if (!(state.blockState.getBlock() instanceof OvenBlock)) return;
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

        matrices.mulPose(Axis.YP.rotationDegrees(angle));

        if (state.blockState.getValue(OvenBlock.LIT)) {
            queue.submitCustomGeometry(matrices, RenderType.eyes(LIGHT_TEXTURE), (matricesEntry, vertexConsumer) -> {
                Matrix4f mat = matricesEntry.pose();
                int light = LightTexture.FULL_BRIGHT; // 保持全亮
                drawQuad(mat, vertexConsumer, 0x80FFFF00, light);
            });
        }


        renderItemAsIcon(state, matrices, queue);

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

    private void renderItemAsIcon(OvenBlockEntityRenderState state, PoseStack matrices,
                                  SubmitNodeCollector queue) {
        matrices.pushPose();
        matrices.scale(0.4f, 0.4f, 0.4f);
        matrices.translate(0.0, 0.3, 0.3);

        state.item.submit(matrices, queue, state.lightCoords, OverlayTexture.NO_OVERLAY,0);
        matrices.popPose();
    }

    @Override
    public OvenBlockEntityRenderState createRenderState() {
        return new OvenBlockEntityRenderState();
    }

    @Override
    public void updateRenderState(OvenBlockEntity entity, OvenBlockEntityRenderState state, float tickProgress, Vec3 cameraPos, @Nullable ModelFeatureRenderer.CrumblingOverlay crumblingOverlay) {
        BlockEntityRenderer.super.extractRenderState(entity, state, tickProgress, cameraPos, crumblingOverlay);
        ItemModelResolver itemModelResolver = Minecraft.getInstance().getItemModelResolver();
        itemModelResolver.updateForTopItem(state.item, entity.getRenderStack(), ItemDisplayContext.GUI, entity.getLevel(), null, 1);
        state.blockPos = entity.getBlockPos();
        state.blockState = entity.getBlockState();
    }
}
