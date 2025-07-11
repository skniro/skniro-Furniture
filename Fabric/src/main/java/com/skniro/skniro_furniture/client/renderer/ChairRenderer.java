package com.skniro.skniro_furniture.client.renderer;

import com.skniro.skniro_furniture.entity.furniture.ChairEntity;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;


public class ChairRenderer extends EntityRenderer<ChairEntity> {

    public ChairRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public boolean shouldRender(ChairEntity livingEntity, Frustum camera, double camX, double camY, double camZ) {
        return true;
    }

    @Override
    public Identifier getTexture(ChairEntity entity) {
        return null;
    }
}