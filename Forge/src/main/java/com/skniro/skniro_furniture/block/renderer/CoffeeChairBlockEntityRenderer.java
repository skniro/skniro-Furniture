package com.skniro.skniro_furniture.block.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.skniro.skniro_furniture.block.entity.CoffeeChairBlockEntity;
import com.skniro.skniro_furniture.block.init.CoffeeChairBlock;
import com.skniro.skniro_furniture.block.renderer.state.BannerDecoratedBlockEntityRenderState;
import com.skniro.skniro_furniture.block.renderer.state.CoffeeChairBlockEntityRendererState;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.sprite.SpriteGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

/**
 * Draws banner decorations on the wool seat of a coffee chair.
 */
public class CoffeeChairBlockEntityRenderer implements BlockEntityRenderer<CoffeeChairBlockEntity, CoffeeChairBlockEntityRendererState> {
    // Same crop as the cushion renderer: centered 20x20 of the 20x40 banner flag.
    private static final float U_MIN = 1.0F / 64.0F;
    private static final float U_MAX = 21.0F / 64.0F;
    private static final float V_MIN = 11.0F / 64.0F;
    private static final float V_MAX = 31.0F / 64.0F;
    private static final float PX = 1.0F / 16.0F;
    /** The wool seat's top surface is at y = 8.5 in the block model. */
    private static final float SURFACE_Y = 8.51F * PX;
    private static final float LAYER_STEP = 0.005F * PX;
    private static final float CLOTH_MIN = 2.5F * PX;
    private static final float CLOTH_MAX = 13.5F * PX;

    private final SpriteGetter sprites;

    public CoffeeChairBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.sprites = context.sprites();
    }

    @Override
    public CoffeeChairBlockEntityRendererState createRenderState() {
        return new CoffeeChairBlockEntityRendererState();
    }

    @Override
    public void extractRenderState(CoffeeChairBlockEntity entity, CoffeeChairBlockEntityRendererState state, float tickProgress,
                                   Vec3 cameraPos, @Nullable ModelFeatureRenderer.CrumblingOverlay crumblingOverlay) {
        BlockEntityRenderer.super.extractRenderState(entity, state, tickProgress, cameraPos, crumblingOverlay);
        BlockState blockState = entity.getBlockState();
        state.facing = blockState.getValue(CoffeeChairBlock.FACING);
        state.extractBanner(this.sprites, entity);
    }

    @Override
    public void submit(CoffeeChairBlockEntityRendererState state, PoseStack poseStack, SubmitNodeCollector collector,
                       CameraRenderState cameraState) {
        if (!state.decorated || state.baseSprite == null) {
            return;
        }
        RenderType renderType = RenderTypes.bannerPattern(Sheets.BANNER_SHEET);
        poseStack.pushPose();
        switch (state.facing) {
            case SOUTH -> {
                poseStack.translate(1.0F, 0.0F, 1.0F);
                poseStack.rotate(Axis.YP.rotationDegrees(180.0F));
            }
            case WEST -> {
                poseStack.translate(0.0F, 0.0F, 1.0F);
                poseStack.rotate(Axis.YP.rotationDegrees(90.0F));
            }
            case EAST -> {
                poseStack.translate(1.0F, 0.0F, 0.0F);
                poseStack.rotate(Axis.YP.rotationDegrees(270.0F));
            }
            default -> {
            }
        }

        int light = state.lightCoords;
        collector.order(1).submitCustomGeometry(poseStack, renderType, (pose, consumer) ->
                drawTop(pose, consumer, state.baseSprite, state.baseColor, SURFACE_Y, light));
        for (int i = 0; i < state.layers.size(); i++) {
            BannerDecoratedBlockEntityRenderState.Layer layer = state.layers.get(i);
            float y = SURFACE_Y + (i + 1) * LAYER_STEP;
            collector.order(2 + i).submitCustomGeometry(poseStack, renderType, (pose, consumer) ->
                    drawTop(pose, consumer, layer.sprite(), layer.color(), y, light));
        }
        poseStack.popPose();
    }

    private static void drawTop(PoseStack.Pose pose, VertexConsumer consumer, TextureAtlasSprite sprite,
                                int argb, float y, int light) {
        float uMin = sprite.getU(U_MIN);
        float uMax = sprite.getU(U_MAX);
        float vMin = sprite.getV(V_MIN);
        float vMax = sprite.getV(V_MAX);
        // Outward-facing (+Y) winding, pattern top at +Z.
        vertex(pose, consumer, CLOTH_MIN, y, CLOTH_MIN, uMin, vMax, argb, light);
        vertex(pose, consumer, CLOTH_MIN, y, CLOTH_MAX, uMin, vMin, argb, light);
        vertex(pose, consumer, CLOTH_MAX, y, CLOTH_MAX, uMax, vMin, argb, light);
        vertex(pose, consumer, CLOTH_MAX, y, CLOTH_MIN, uMax, vMax, argb, light);
    }

    private static void vertex(PoseStack.Pose pose, VertexConsumer consumer, float x, float y, float z,
                               float u, float v, int argb, int light) {
        consumer.addVertex(pose, x, y, z)
                .setColor(argb)
                .setUv(u, v)
                .setOverlay(OverlayTexture.NO_OVERLAY)
                .setLight(light)
                .setNormal(pose, 0.0F, 1.0F, 0.0F);
    }
}
