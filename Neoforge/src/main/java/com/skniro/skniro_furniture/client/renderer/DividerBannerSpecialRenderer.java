package com.skniro.skniro_furniture.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.sprite.SpriteGetter;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import org.joml.Vector3f;
import org.joml.Vector3fc;

import java.util.function.Consumer;

/**
 * Renders the banner pattern layers of a divider item on top of the divider model.
 * Used by the loom result and by patterned divider items in inventories.
 */
public class DividerBannerSpecialRenderer implements SpecialModelRenderer<BannerPatternLayers> {
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
    private final DyeColor baseColor;

    public DividerBannerSpecialRenderer(SpriteGetter sprites, DyeColor baseColor) {
        this.sprites = sprites;
        this.baseColor = baseColor;
    }

    @Override
    public BannerPatternLayers extractArgument(ItemStack stack) {
        return stack.getOrDefault(DataComponents.BANNER_PATTERNS, BannerPatternLayers.EMPTY);
    }

    @Override
    public void submit(BannerPatternLayers patterns, PoseStack poseStack, SubmitNodeCollector collector,
                       int light, int overlay, boolean foil, int outlineColor) {
        if (patterns.layers().isEmpty()) {
            return;
        }

        TextureAtlasSprite baseSprite = this.sprites.get(Sheets.BANNER_PATTERN_BASE);
        int baseArgb = 0xFF000000 | this.baseColor.getTextureDiffuseColor();
        submitFace(poseStack, collector, baseSprite, baseArgb, CLOTH_Z - FACE_OFFSET, -1.0F, light, overlay, 1);
        submitFace(poseStack, collector, baseSprite, baseArgb, CLOTH_Z + FACE_OFFSET, 1.0F, light, overlay, 1);

        for (int i = 0; i < patterns.layers().size(); i++) {
            BannerPatternLayers.Layer layer = patterns.layers().get(i);
            TextureAtlasSprite sprite = this.sprites.get(Sheets.getBannerSprite(layer.pattern()));
            int color = 0xFF000000 | layer.color().getTextureDiffuseColor();
            submitFace(poseStack, collector, sprite, color, CLOTH_Z - FACE_OFFSET - (i + 1) * LAYER_STEP,
                    -1.0F, light, overlay, 2 + i);
            submitFace(poseStack, collector, sprite, color, CLOTH_Z + FACE_OFFSET + (i + 1) * LAYER_STEP,
                    1.0F, light, overlay, 2 + i);
        }
    }

    private static void submitFace(PoseStack poseStack, SubmitNodeCollector collector, TextureAtlasSprite sprite,
                                   int color, float z, float normalZ, int light, int overlay, int order) {
        RenderType renderType = RenderTypes.bannerPattern(Sheets.BANNER_SHEET);
        float uMin = sprite.getU(U_MIN);
        float uMax = sprite.getU(U_MAX);
        float vMin = sprite.getV(V_MIN);
        float vMax = sprite.getV(V_MAX);
        collector.order(order).submitCustomGeometry(poseStack, renderType, (pose, consumer) -> {
            if (normalZ < 0.0F) {
                vertex(pose, consumer, CLOTH_MIN_X, CLOTH_MIN_Y, z, uMin, vMax, color, light, overlay, -1.0F);
                vertex(pose, consumer, CLOTH_MIN_X, CLOTH_MAX_Y, z, uMin, vMin, color, light, overlay, -1.0F);
                vertex(pose, consumer, CLOTH_MAX_X, CLOTH_MAX_Y, z, uMax, vMin, color, light, overlay, -1.0F);
                vertex(pose, consumer, CLOTH_MAX_X, CLOTH_MIN_Y, z, uMax, vMax, color, light, overlay, -1.0F);
            } else {
                vertex(pose, consumer, CLOTH_MIN_X, CLOTH_MIN_Y, z, uMin, vMax, color, light, overlay, 1.0F);
                vertex(pose, consumer, CLOTH_MAX_X, CLOTH_MIN_Y, z, uMax, vMax, color, light, overlay, 1.0F);
                vertex(pose, consumer, CLOTH_MAX_X, CLOTH_MAX_Y, z, uMax, vMin, color, light, overlay, 1.0F);
                vertex(pose, consumer, CLOTH_MIN_X, CLOTH_MAX_Y, z, uMin, vMin, color, light, overlay, 1.0F);
            }
        });
    }

    private static void vertex(PoseStack.Pose pose, VertexConsumer consumer, float x, float y, float z,
                               float u, float v, int color, int light, int overlay, float normalZ) {
        consumer.addVertex(pose, x, y, z)
                .setColor(color)
                .setUv(u, v)
                .setOverlay(overlay)
                .setLight(light)
                .setNormal(pose, 0.0F, 0.0F, normalZ);
    }

    @Override
    public void getExtents(Consumer<Vector3fc> consumer) {
        consumer.accept(new Vector3f(0.0F, 0.0F, 0.0F));
        consumer.accept(new Vector3f(1.0F, CLOTH_MAX_Y, 1.0F));
    }

    public record Unbaked(DyeColor baseColor) implements SpecialModelRenderer.Unbaked<BannerPatternLayers> {
        public static final MapCodec<Unbaked> MAP_CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                DyeColor.CODEC.fieldOf("color").forGetter(Unbaked::baseColor)
        ).apply(instance, Unbaked::new));

        @Override
        public MapCodec<? extends SpecialModelRenderer.Unbaked<BannerPatternLayers>> type() {
            return MAP_CODEC;
        }

        @Override
        public SpecialModelRenderer<BannerPatternLayers> bake(SpecialModelRenderer.BakingContext context) {
            return new DividerBannerSpecialRenderer(context.sprites(), this.baseColor);
        }
    }
}
