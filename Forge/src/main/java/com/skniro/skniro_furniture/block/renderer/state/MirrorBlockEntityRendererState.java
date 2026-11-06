package com.skniro.skniro_furniture.block.renderer.state;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import org.jetbrains.annotations.Nullable;

public class MirrorBlockEntityRendererState extends BlockEntityRenderState {
    public Direction facing = Direction.NORTH;
    @Nullable
    public EntityRenderState reflectedPlayer;
    @Nullable
    public TextureAtlasSprite backgroundSprite;
}
