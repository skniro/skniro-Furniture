package com.skniro.skniro_furniture.block.renderer.state;

import com.skniro.skniro_furniture.block.entity.AbstractBannerDecoratedBlockEntity;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.sprite.SpriteGetter;
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Render state shared by furniture that displays banner patterns.
 */
public class BannerDecoratedBlockEntityRenderState extends BlockEntityRenderState {
    private static final int MAX_RENDERED_LAYERS = 16;

    public boolean decorated;
    public int baseColor = 0xFFFFFFFF;
    @Nullable
    public TextureAtlasSprite baseSprite;
    public final List<Layer> layers = new ArrayList<>();

    public record Layer(TextureAtlasSprite sprite, int color) {
    }

    public void extractBanner(SpriteGetter sprites, AbstractBannerDecoratedBlockEntity entity) {
        this.decorated = entity.isDecorated();
        this.baseColor = 0xFFFFFFFF;
        this.baseSprite = null;
        this.layers.clear();
        if (!this.decorated) {
            return;
        }
        this.baseColor = 0xFF000000 | entity.getBaseColor().getTextureDiffuseColor();
        this.baseSprite = sprites.get(Sheets.BANNER_PATTERN_BASE);
        for (BannerPatternLayers.Layer layer : entity.getPatterns().layers()) {
            if (this.layers.size() >= MAX_RENDERED_LAYERS) {
                break;
            }
            this.layers.add(new Layer(
                    sprites.get(Sheets.getBannerSprite(layer.pattern())),
                    0xFF000000 | layer.color().getTextureDiffuseColor()));
        }
    }
}
