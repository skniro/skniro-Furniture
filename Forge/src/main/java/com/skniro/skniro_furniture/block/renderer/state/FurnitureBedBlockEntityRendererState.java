package com.skniro.skniro_furniture.block.renderer.state;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.BedPart;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class FurnitureBedBlockEntityRendererState extends BlockEntityRenderState {
    public Direction facing = Direction.NORTH;
    public BedPart part = BedPart.FOOT;
    public boolean decorated;
    public int baseColor = 0xFFFFFFFF;
    @Nullable
    public TextureAtlasSprite baseSprite;
    public final List<Layer> layers = new ArrayList<>();

    public record Layer(TextureAtlasSprite sprite, int color) {
    }
}
