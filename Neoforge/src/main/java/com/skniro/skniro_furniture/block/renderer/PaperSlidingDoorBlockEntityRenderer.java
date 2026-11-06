package com.skniro.skniro_furniture.block.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.skniro.skniro_furniture.block.entity.PaperSlidingDoorBlockEntity;
import com.skniro.skniro_furniture.block.init.SlidingDoorBlock;
import com.skniro.skniro_furniture.block.renderer.state.BannerDecoratedBlockEntityRenderState;
import com.skniro.skniro_furniture.block.renderer.state.PaperSlidingDoorBlockEntityRendererState;
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
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

/**
 * Draws banner-pattern decorations on the paper surface of paper sliding doors.
 *
 * <p>The front and back faces of the paper panel are covered separately. The
 * banner texture is split across the two door halves so the pattern stays
 * continuous from the bottom to the top of the door.</p>
 */
public class PaperSlidingDoorBlockEntityRenderer implements BlockEntityRenderer<PaperSlidingDoorBlockEntity, PaperSlidingDoorBlockEntityRendererState> {
    private static final float PX = 1.0F / 16.0F;
    private static final float U_MIN = 1.0F / 64.0F;
    private static final float U_MAX = 21.0F / 64.0F;
    private static final float V_TOP = 1.0F / 64.0F;
    private static final float V_MID = 21.0F / 64.0F;
    private static final float V_BOTTOM = 41.0F / 64.0F;
    private static final float LAYER_STEP = 0.001F;
    private static final float FACE_OFFSET = 0.006F;
    private static final float PAPER_Z_MIN = 7.5F / 16.0F;
    private static final float PAPER_Z_MAX = 8.5F / 16.0F;

    private final SpriteGetter sprites;

    public PaperSlidingDoorBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.sprites = context.sprites();
    }

    @Override
    public PaperSlidingDoorBlockEntityRendererState createRenderState() {
        return new PaperSlidingDoorBlockEntityRendererState();
    }

    @Override
    public void extractRenderState(PaperSlidingDoorBlockEntity entity, PaperSlidingDoorBlockEntityRendererState state,
                                   float tickProgress, Vec3 cameraPos,
                                   @Nullable ModelFeatureRenderer.CrumblingOverlay crumblingOverlay) {
        BlockEntityRenderer.super.extractRenderState(entity, state, tickProgress, cameraPos, crumblingOverlay);
        BlockState blockState = entity.getBlockState();
        state.facing = blockState.getValue(SlidingDoorBlock.FACING);
        state.half = blockState.getValue(SlidingDoorBlock.HALF);
        state.hinge = blockState.getValue(SlidingDoorBlock.HINGE);
        state.open = blockState.getValue(SlidingDoorBlock.OPEN);
        state.extractBanner(this.sprites, entity);
    }

    @Override
    public void submit(PaperSlidingDoorBlockEntityRendererState state, PoseStack poseStack,
                       SubmitNodeCollector collector, CameraRenderState cameraState) {
        if (!state.decorated || state.baseSprite == null) {
            return;
        }

        poseStack.pushPose();
        switch (state.facing) {
            case WEST -> {
                poseStack.translate(0.0F, 0.0F, 1.0F);
                poseStack.rotate(Axis.YP.rotationDegrees(90.0F));
            }
            case NORTH -> {
                poseStack.translate(1.0F, 0.0F, 1.0F);
                poseStack.rotate(Axis.YP.rotationDegrees(180.0F));
            }
            case EAST -> {
                poseStack.translate(1.0F, 0.0F, 0.0F);
                poseStack.rotate(Axis.YP.rotationDegrees(270.0F));
            }
            default -> {
            }
        }

        float x0;
        float x1;
        if (state.open) {
            if (state.hinge == DoorHingeSide.LEFT) {
                x0 = 15.0F;
                x1 = 29.5F;
            } else {
                x0 = -13.5F;
                x1 = 1.0F;
            }
        } else if (state.hinge == DoorHingeSide.LEFT) {
            x0 = 1.0F;
            x1 = 15.5F;
        } else {
            x0 = 0.5F;
            x1 = 15.0F;
        }

        float y0;
        float y1;
        float vMin;
        float vMax;
        if (state.half == DoubleBlockHalf.LOWER) {
            y0 = 0.5F;
            y1 = 16.0F;
            vMin = V_MID;
            vMax = V_BOTTOM;
        } else {
            y0 = 0.0F;
            y1 = 15.5F;
            vMin = V_TOP;
            vMax = V_MID;
        }

        x0 *= PX;
        x1 *= PX;
        y0 *= PX;
        y1 *= PX;

        int light = state.lightCoords;
        float northZ = PAPER_Z_MIN - FACE_OFFSET;
        float southZ = PAPER_Z_MAX + FACE_OFFSET;

        submitFace(poseStack, collector, state.baseSprite, state.baseColor, x0, x1, y0, y1, vMin, vMax,
                northZ, -1.0F, light, 1);
        submitFace(poseStack, collector, state.baseSprite, state.baseColor, x0, x1, y0, y1, vMin, vMax,
                southZ, 1.0F, light, 1);

        for (int i = 0; i < state.layers.size(); i++) {
            BannerDecoratedBlockEntityRenderState.Layer layer = state.layers.get(i);
            float layerNorthZ = northZ - (i + 1) * LAYER_STEP;
            float layerSouthZ = southZ + (i + 1) * LAYER_STEP;
            submitFace(poseStack, collector, layer.sprite(), layer.color(), x0, x1, y0, y1, vMin, vMax,
                    layerNorthZ, -1.0F, light, 2 + i);
            submitFace(poseStack, collector, layer.sprite(), layer.color(), x0, x1, y0, y1, vMin, vMax,
                    layerSouthZ, 1.0F, light, 2 + i);
        }

        poseStack.popPose();
    }

    private static void submitFace(PoseStack poseStack, SubmitNodeCollector collector, TextureAtlasSprite sprite,
                                   int color, float x0, float x1, float y0, float y1, float vMin, float vMax,
                                   float z, float normalZ, int light, int order) {
        RenderType renderType = RenderTypes.bannerPattern(Sheets.BANNER_SHEET);
        float uMin = sprite.getU(U_MIN);
        float uMax = sprite.getU(U_MAX);
        float vTop = sprite.getV(vMin);
        float vBottom = sprite.getV(vMax);
        collector.order(order).submitCustomGeometry(poseStack, renderType, (pose, consumer) -> {
            if (normalZ < 0.0F) {
                vertex(pose, consumer, x0, y0, z, uMin, vBottom, color, light, -1.0F);
                vertex(pose, consumer, x0, y1, z, uMin, vTop, color, light, -1.0F);
                vertex(pose, consumer, x1, y1, z, uMax, vTop, color, light, -1.0F);
                vertex(pose, consumer, x1, y0, z, uMax, vBottom, color, light, -1.0F);
            } else {
                vertex(pose, consumer, x0, y0, z, uMin, vBottom, color, light, 1.0F);
                vertex(pose, consumer, x1, y0, z, uMax, vBottom, color, light, 1.0F);
                vertex(pose, consumer, x1, y1, z, uMax, vTop, color, light, 1.0F);
                vertex(pose, consumer, x0, y1, z, uMin, vTop, color, light, 1.0F);
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
