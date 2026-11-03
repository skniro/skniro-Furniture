package com.skniro.skniro_furniture.block.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.skniro.skniro_furniture.block.entity.FurnitureBedBlockEntity;
import com.skniro.skniro_furniture.block.init.FurnitureBedBlock;
import com.skniro.skniro_furniture.block.renderer.state.FurnitureBedBlockEntityRendererState;
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
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class FurnitureBedBlockEntityRenderer implements BlockEntityRenderer<FurnitureBedBlockEntity, FurnitureBedBlockEntityRendererState> {
    private static final float PX = 1.0F / 16.0F;
    private static final float SHEET_Y = 7.51F * PX;
    private static final float LAYER_STEP = 0.005F * PX;
    private static final float WIDTH_MIN = 0.99F * PX;
    private static final float WIDTH_MAX = 15.01F * PX;
    private static final float HEAD_Z_MIN = 8.51F * PX;
    private static final float HEAD_Z_MAX = 16.0F * PX;
    private static final float FOOT_Z_MIN = 0.01F * PX;
    private static final float FOOT_Z_MAX = 15.03F * PX;
    private static final float BANNER_PATTERN_HEIGHT = 40.0F;
    private static final float BED_SHEET_LENGTH_PX = 22.52F;
    private static final float UV_LEFT = 1.0F / 64.0F;
    private static final float UV_RIGHT = 21.0F / 64.0F;
    private static final float UV_TOP = 1.0F / 64.0F;
    private static final float UV_BOTTOM = 41.0F / 64.0F;
    private static final float V_MID = (1.0F + BANNER_PATTERN_HEIGHT * (7.50F / BED_SHEET_LENGTH_PX)) / 64.0F;
    private static final int MAX_RENDERED_LAYERS = 16;

    private final SpriteGetter sprites;

    public FurnitureBedBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.sprites = context.sprites();
    }

    @Override
    public FurnitureBedBlockEntityRendererState createRenderState() {
        return new FurnitureBedBlockEntityRendererState();
    }

    @Override
    public void extractRenderState(FurnitureBedBlockEntity entity, FurnitureBedBlockEntityRendererState state, float tickProgress, Vec3 cameraPos, @Nullable ModelFeatureRenderer.CrumblingOverlay crumblingOverlay) {
        BlockEntityRenderer.super.extractRenderState(entity, state, tickProgress, cameraPos, crumblingOverlay);
        BlockState blockState = entity.getBlockState();
        state.facing = blockState.getValue(FurnitureBedBlock.FACING);
        state.part = blockState.getValue(FurnitureBedBlock.PART);
        state.decorated = entity.isDecorated();
        state.baseColor = 0xFFFFFFFF;
        state.baseSprite = null;
        state.layers.clear();
        if (!state.decorated) {
            return;
        }
        state.baseColor = 0xFF000000 | entity.getBaseColor().getTextureDiffuseColor();
        state.baseSprite = this.sprites.get(Sheets.BANNER_PATTERN_BASE);
        for (BannerPatternLayers.Layer layer : entity.getPatterns().layers()) {
            if (state.layers.size() >= MAX_RENDERED_LAYERS) {
                break;
            }
            state.layers.add(new FurnitureBedBlockEntityRendererState.Layer(
                    this.sprites.get(Sheets.getBannerSprite(layer.pattern())),
                    0xFF000000 | layer.color().getTextureDiffuseColor()));
        }
    }

    @Override
    public void submit(FurnitureBedBlockEntityRendererState state, PoseStack poseStack, SubmitNodeCollector collector, CameraRenderState cameraState) {
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
        BedPart part = state.part;
        TextureAtlasSprite baseSprite = state.baseSprite;
        int baseColor = state.baseColor;
        collector.order(1).submitCustomGeometry(poseStack, renderType, (pose, consumer) ->
                drawSheet(pose, consumer, baseSprite, baseColor, part, SHEET_Y, light));
        for (int i = 0; i < state.layers.size(); i++) {
            FurnitureBedBlockEntityRendererState.Layer layer = state.layers.get(i);
            float y = SHEET_Y + (i + 1) * LAYER_STEP;
            collector.order(2 + i).submitCustomGeometry(poseStack, renderType, (pose, consumer) ->
                    drawSheet(pose, consumer, layer.sprite(), layer.color(), part, y, light));
        }
        poseStack.popPose();
    }

    private static void drawSheet(PoseStack.Pose pose, VertexConsumer consumer, TextureAtlasSprite sprite, int argb, BedPart part, float y, int light) {
        float uLeft = sprite.getU(UV_LEFT);
        float uRight = sprite.getU(UV_RIGHT);
        float vTop = sprite.getV(UV_TOP);
        float vMid = sprite.getV(V_MID);
        float vBottom = sprite.getV(UV_BOTTOM);
        float zMin;
        float zMax;
        float vMin;
        float vMax;
        if (part == BedPart.HEAD) {
            zMin = HEAD_Z_MIN;
            zMax = HEAD_Z_MAX;
            vMin = vTop;
            vMax = vMid;
        } else {
            zMin = FOOT_Z_MIN;
            zMax = FOOT_Z_MAX;
            vMin = vMid;
            vMax = vBottom;
        }
        // Outward-facing (+Y) winding: counter-clockwise seen from above (NW -> SW -> SE -> NE).
        vertex(pose, consumer, WIDTH_MIN, y, zMin, uLeft, vMin, argb, light);
        vertex(pose, consumer, WIDTH_MIN, y, zMax, uLeft, vMax, argb, light);
        vertex(pose, consumer, WIDTH_MAX, y, zMax, uRight, vMax, argb, light);
        vertex(pose, consumer, WIDTH_MAX, y, zMin, uRight, vMin, argb, light);
    }

    private static void vertex(PoseStack.Pose pose, VertexConsumer consumer, float x, float y, float z, float u, float v, int argb, int light) {
        consumer.addVertex(pose, x, y, z)
                .setColor(argb)
                .setUv(u, v)
                .setOverlay(OverlayTexture.NO_OVERLAY)
                .setLight(light)
                .setNormal(pose, 0.0F, 1.0F, 0.0F);
    }
}
