package com.skniro.skniro_furniture.block.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.skniro.skniro_furniture.block.entity.DividerBlockEntity;
import com.skniro.skniro_furniture.block.init.DividerBlock;
import com.skniro.skniro_furniture.block.renderer.state.BannerDecoratedBlockEntityRenderState;
import com.skniro.skniro_furniture.block.renderer.state.DividerBlockEntityRendererState;
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
 * Draws banner patterns on the cloth of a divider.
 */
public class DividerBlockEntityRenderer implements BlockEntityRenderer<DividerBlockEntity, DividerBlockEntityRendererState> {
    private static final float U_MIN = 1.0F / 64.0F;
    private static final float U_MAX = 21.0F / 64.0F;
    // A banner flag is 20x40 texels while the divider cloth is 16x15, so using the
    // whole flag squashes the pattern. Sample the centered 20x20 square instead;
    // it maps to 16x15 with the same texel aspect as the divider cloth texture.
    private static final float V_MIN = 11.0F / 64.0F;
    private static final float V_MAX = 31.0F / 64.0F;
    private static final float PX = 1.0F / 16.0F;
    private static final float FACE_OFFSET = 0.006F;
    private static final float LAYER_STEP = 0.001F;
    private static final float CLOTH_MIN_X = 0.0F;
    private static final float CLOTH_MAX_X = 1.0F;
    private static final float CLOTH_MIN_Y = 0.0F;
    private static final float CLOTH_MAX_Y = 15.0F * PX;
    private static final float CLOTH_Z = 15.5F * PX;

    private final SpriteGetter sprites;

    public DividerBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.sprites = context.sprites();
    }

    @Override
    public DividerBlockEntityRendererState createRenderState() {
        return new DividerBlockEntityRendererState();
    }

    @Override
    public void extractRenderState(DividerBlockEntity entity, DividerBlockEntityRendererState state, float tickProgress,
                                   Vec3 cameraPos, @Nullable ModelFeatureRenderer.CrumblingOverlay crumblingOverlay) {
        BlockEntityRenderer.super.extractRenderState(entity, state, tickProgress, cameraPos, crumblingOverlay);
        BlockState blockState = entity.getBlockState();
        state.facing = blockState.getValue(DividerBlock.FACING);
        state.extractBanner(this.sprites, entity);
    }

    @Override
    public void submit(DividerBlockEntityRendererState state, PoseStack poseStack, SubmitNodeCollector collector,
                       CameraRenderState cameraState) {
        if (!state.decorated || state.baseSprite == null) {
            return;
        }

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
        float northZ = CLOTH_Z - FACE_OFFSET;
        float southZ = CLOTH_Z + FACE_OFFSET;
        submitFace(poseStack, collector, state.baseSprite, state.baseColor, CLOTH_MIN_X, CLOTH_MAX_X,
                CLOTH_MIN_Y, CLOTH_MAX_Y, northZ, -1.0F, light, 1);
        submitFace(poseStack, collector, state.baseSprite, state.baseColor, CLOTH_MIN_X, CLOTH_MAX_X,
                CLOTH_MIN_Y, CLOTH_MAX_Y, southZ, 1.0F, light, 1);
        for (int i = 0; i < state.layers.size(); i++) {
            BannerDecoratedBlockEntityRenderState.Layer layer = state.layers.get(i);
            submitFace(poseStack, collector, layer.sprite(), layer.color(), CLOTH_MIN_X, CLOTH_MAX_X,
                    CLOTH_MIN_Y, CLOTH_MAX_Y, northZ - (i + 1) * LAYER_STEP, -1.0F, light, 2 + i);
            submitFace(poseStack, collector, layer.sprite(), layer.color(), CLOTH_MIN_X, CLOTH_MAX_X,
                    CLOTH_MIN_Y, CLOTH_MAX_Y, southZ + (i + 1) * LAYER_STEP, 1.0F, light, 2 + i);
        }
        poseStack.popPose();
    }

    private static void submitFace(PoseStack poseStack, SubmitNodeCollector collector, TextureAtlasSprite sprite,
                                   int color, float x0, float x1, float y0, float y1, float z, float normalZ,
                                   int light, int order) {
        RenderType renderType = RenderTypes.bannerPattern(Sheets.BANNER_SHEET);
        float uMin = sprite.getU(U_MIN);
        float uMax = sprite.getU(U_MAX);
        float vMin = sprite.getV(V_MIN);
        float vMax = sprite.getV(V_MAX);
        collector.order(order).submitCustomGeometry(poseStack, renderType, (pose, consumer) -> {
            if (normalZ < 0.0F) {
                vertex(pose, consumer, x0, y0, z, uMin, vMax, color, light, -1.0F);
                vertex(pose, consumer, x0, y1, z, uMin, vMin, color, light, -1.0F);
                vertex(pose, consumer, x1, y1, z, uMax, vMin, color, light, -1.0F);
                vertex(pose, consumer, x1, y0, z, uMax, vMax, color, light, -1.0F);
            } else {
                vertex(pose, consumer, x0, y0, z, uMin, vMax, color, light, 1.0F);
                vertex(pose, consumer, x1, y0, z, uMax, vMax, color, light, 1.0F);
                vertex(pose, consumer, x1, y1, z, uMax, vMin, color, light, 1.0F);
                vertex(pose, consumer, x0, y1, z, uMin, vMin, color, light, 1.0F);
            }
        });
    }

    private static void vertex(PoseStack.Pose pose, VertexConsumer consumer, float x, float y, float z,
                               float u, float v, int color, int light, float normalZ) {
        consumer.addVertex(pose, x, y, z)
                .setColor(color)
                .setUv(u, v)
                .setOverlay(OverlayTexture.NO_OVERLAY)
                .setLight(light)
                .setNormal(pose, 0.0F, 0.0F, normalZ);
    }
}
