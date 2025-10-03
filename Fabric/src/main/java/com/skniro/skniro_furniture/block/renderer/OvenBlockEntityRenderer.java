package com.skniro.skniro_furniture.block.renderer;

import com.skniro.skniro_furniture.Furniture;
import com.skniro.skniro_furniture.block.entity.OvenBlockEntity;
import com.skniro.skniro_furniture.block.init.OvenBlock;
import com.skniro.skniro_furniture.block.renderer.state.OvenBlockEntityRenderState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.ItemModelManager;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.command.ModelCommandRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.*;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;

public class OvenBlockEntityRenderer implements BlockEntityRenderer<OvenBlockEntity, OvenBlockEntityRenderState> {

    private static final Identifier LIGHT_TEXTURE = Identifier.of(Furniture.MOD_ID, "textures/block/oven_light.png");

    public OvenBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {}

    @Override
    public void render(OvenBlockEntityRenderState state, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState cameraRenderState) {
        var facing = state.blockState.get(Properties.HORIZONTAL_FACING);

        if (!(state.blockState.getBlock() instanceof OvenBlock)) return;
        matrices.push();

        switch (facing) {
            case NORTH -> matrices.translate(0.5, 0.4, 0.15);
            case SOUTH -> matrices.translate(0.5, 0.4, 0.85);
            case WEST -> matrices.translate(0.15, 0.4, 0.5);
            case EAST -> matrices.translate(0.85, 0.4, 0.5);
        }

        float angle = switch (facing) {
            case NORTH -> 0f;
            case SOUTH -> 180f;
            case WEST -> 90f;
            case EAST -> -90f;
            default -> 0f;
        };

        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(angle));

        if (state.blockState.get(OvenBlock.LIT)) {
            queue.submitCustom(matrices, RenderLayer.getEyes(LIGHT_TEXTURE), (matricesEntry, vertexConsumer) -> {
                Matrix4f mat = matricesEntry.getPositionMatrix();
                int light = LightmapTextureManager.MAX_LIGHT_COORDINATE; // 保持全亮
                drawQuad(mat, vertexConsumer, 0x80FFFF00, light);
            });
        }


        renderItemAsIcon(state, matrices, queue);

        matrices.pop();
    }

    private void drawQuad(Matrix4f mat, VertexConsumer vc, int color, int light) {
        vc.vertex(mat, -0.3F,  0.21F, 0F)
                .color(color)
                .texture(0F, 0F)
                .overlay(OverlayTexture.DEFAULT_UV)
                .light(light)
                .normal(0F, 0F, -1F);
        vc.vertex(mat,  0.3F,  0.21F, 0F)
                .color(color)
                .texture(1F, 0F)
                .overlay(OverlayTexture.DEFAULT_UV)
                .light(light)
                .normal(0F, 0F, -1F);
        vc.vertex(mat,  0.3F, -0.21F, 0F)
                .color(color)
                .texture(1F, 1F)
                .overlay(OverlayTexture.DEFAULT_UV)
                .light(light)
                .normal(0F, 0F, -1F);
        vc.vertex(mat, -0.3F, -0.21F, 0F)
                .color(color)
                .texture(0F, 1F)
                .overlay(OverlayTexture.DEFAULT_UV)
                .light(light)
                .normal(0F, 0F, -1F);
    }

    private void renderItemAsIcon(OvenBlockEntityRenderState state, MatrixStack matrices,
                                  OrderedRenderCommandQueue queue) {
        matrices.push();
        matrices.scale(0.4f, 0.4f, 0.4f);
        matrices.translate(0.0, 0.3, 0.3);

        state.item.render(matrices, queue, state.lightmapCoordinates, OverlayTexture.DEFAULT_UV,0);
        matrices.pop();
    }

    @Override
    public OvenBlockEntityRenderState createRenderState() {
        return new OvenBlockEntityRenderState();
    }

    @Override
    public void updateRenderState(OvenBlockEntity entity, OvenBlockEntityRenderState state, float tickProgress, Vec3d cameraPos, @Nullable ModelCommandRenderer.CrumblingOverlayCommand crumblingOverlay) {
        BlockEntityRenderer.super.updateRenderState(entity, state, tickProgress, cameraPos, crumblingOverlay);
        ItemModelManager itemModelResolver = MinecraftClient.getInstance().getItemModelManager();
        itemModelResolver.clearAndUpdate(state.item, entity.getRenderStack(), ItemDisplayContext.GUI, entity.getWorld(), null, 1);
        state.pos = entity.getPos();
        state.blockState = entity.getCachedState();
    }
}
