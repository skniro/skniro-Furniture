package com.skniro.skniro_furniture.client.renderer;

import com.skniro.skniro_furniture.entity.furniture.SofaEntity;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class SofaRenderer extends EntityRenderer<SofaEntity> {

    public SofaRenderer(EntityRendererProvider.Context ctx) {
        super(ctx);
    }

    @Override
    public boolean shouldRender(SofaEntity livingEntity, Frustum camera, double camX, double camY, double camZ) {
        return true;
    }

    @Override
    public ResourceLocation getTextureLocation(SofaEntity sofaEntity) {
        return null;
    }
}