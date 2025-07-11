package com.skniro.skniro_furniture.client.renderer;

import com.skniro.skniro_furniture.entity.furniture.CushionEntity;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

public class CushinoRenderer extends EntityRenderer<CushionEntity> {

    public CushinoRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public boolean shouldRender(CushionEntity livingEntity, Frustum camera, double camX, double camY, double camZ) {
        return true;
    }

    @Override
    public Identifier getTexture(CushionEntity entity) {
        return null;
    }
}