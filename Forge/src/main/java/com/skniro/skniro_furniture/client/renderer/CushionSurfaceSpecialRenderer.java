package com.skniro.skniro_furniture.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.serialization.MapCodec;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.sprite.SpriteGetter;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import org.joml.Vector3f;
import org.joml.Vector3fc;

import java.util.function.Consumer;

/**
 * Draws banner decorations on the top surface of a cushion item model.
 */
public class CushionSurfaceSpecialRenderer implements SpecialModelRenderer<ItemBannerDecoration> {
    // Same crop as the divider renderer: centered 20x20 of the 20x40 banner flag.
    private static final float U_MIN = 1.0F / 64.0F;
    private static final float U_MAX = 21.0F / 64.0F;
    private static final float V_MIN = 11.0F / 64.0F;
    private static final float V_MAX = 31.0F / 64.0F;
    private static final float PX = 1.0F / 16.0F;
    private static final float SURFACE_Y = 3.51F * PX;
    private static final float LAYER_STEP = 0.005F * PX;
    private static final float CLOTH_MIN = 0.5F * PX;
    private static final float CLOTH_MAX = 15.5F * PX;

    private final SpriteGetter sprites;

    public CushionSurfaceSpecialRenderer(SpriteGetter sprites) {
        this.sprites = sprites;
    }

    @Override
    public ItemBannerDecoration extractArgument(ItemStack stack) {
        return ItemBannerDecoration.of(stack);
    }

    @Override
    public void submit(ItemBannerDecoration decoration, PoseStack poseStack, SubmitNodeCollector collector,
                       int light, int overlay, boolean foil, int outlineColor) {
        if (decoration == null) {
            return;
        }
        RenderType renderType = RenderTypes.bannerPattern(Sheets.BANNER_SHEET);
        TextureAtlasSprite baseSprite = this.sprites.get(Sheets.BANNER_PATTERN_BASE);
        int baseColor = decoration.baseColor();
        collector.order(1).submitCustomGeometry(poseStack, renderType, (pose, consumer) ->
                drawTop(pose, consumer, baseSprite, baseColor, SURFACE_Y, light));
        for (int i = 0; i < decoration.patterns().layers().size(); i++) {
            BannerPatternLayers.Layer layer = decoration.patterns().layers().get(i);
            TextureAtlasSprite sprite = this.sprites.get(Sheets.getBannerSprite(layer.pattern()));
            int color = 0xFF000000 | layer.color().getTextureDiffuseColor();
            float y = SURFACE_Y + (i + 1) * LAYER_STEP;
            collector.order(2 + i).submitCustomGeometry(poseStack, renderType, (pose, consumer) ->
                    drawTop(pose, consumer, sprite, color, y, light));
        }
    }

    private static void drawTop(PoseStack.Pose pose, VertexConsumer consumer, TextureAtlasSprite sprite,
                                int argb, float y, int light) {
        float uMin = sprite.getU(U_MIN);
        float uMax = sprite.getU(U_MAX);
        float vMin = sprite.getV(V_MIN);
        float vMax = sprite.getV(V_MAX);
        // Outward-facing (+Y) winding, pattern top at +Z (same as the cushion block renderer).
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

    @Override
    public void getExtents(Consumer<Vector3fc> consumer) {
        consumer.accept(new Vector3f(CLOTH_MIN, SURFACE_Y, CLOTH_MIN));
        consumer.accept(new Vector3f(CLOTH_MAX, SURFACE_Y, CLOTH_MAX));
    }

    public record Unbaked() implements SpecialModelRenderer.Unbaked<ItemBannerDecoration> {
        public static final MapCodec<Unbaked> MAP_CODEC = MapCodec.unit(new Unbaked());

        @Override
        public MapCodec<? extends SpecialModelRenderer.Unbaked<ItemBannerDecoration>> type() {
            return MAP_CODEC;
        }

        @Override
        public SpecialModelRenderer<ItemBannerDecoration> bake(SpecialModelRenderer.BakingContext context) {
            return new CushionSurfaceSpecialRenderer(context.sprites());
        }
    }
}
