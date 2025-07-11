package com.skniro.skniro_furniture.client.renderer;

import com.skniro.skniro_furniture.entity.furniture.ChairEntity;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class ChairRenderer extends EntityRenderer<ChairEntity> {

    public ChairRenderer(EntityRendererProvider.Context ctx) {
        super(ctx);
    }

    @Override
    public boolean shouldRender(ChairEntity livingEntity, Frustum camera, double camX, double camY, double camZ) {
        return true;
    }

    @Override
    public ResourceLocation getTextureLocation(ChairEntity chairEntity) {
        return null;
    }
}