package com.skniro.skniro_furniture.block.renderer;

import com.skniro.skniro_furniture.Furniture;
import com.skniro.skniro_furniture.block.entity.OvenBlockEntity;
import com.skniro.skniro_furniture.block.init.OvenBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.FurnaceBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.data.VariantSettings;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ModelTransformationMode;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.*;
import org.joml.Matrix4f;

public class OvenBlockEntityRenderer implements BlockEntityRenderer<OvenBlockEntity> {

    private static final Identifier LIGHT_TEXTURE = Identifier.of(Furniture.MOD_ID, "textures/block/oven_light.png");

    public OvenBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {}

    @Override
    public void render(OvenBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {

        var state = entity.getCachedState();
        var facing = state.get(Properties.HORIZONTAL_FACING);

        if (!(state.getBlock() instanceof OvenBlock)) return;

        matrices.push();

        matrices.translate(0.5, 0.5, 0.5);
        float angle = switch (facing) {
            case NORTH -> 0f;
            case SOUTH -> 180f;
            case WEST -> 90f;
            case EAST -> -90f;
            default -> 0f;
        };
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(angle));
        matrices.translate(0.0, 0.0, -0.501);
        Matrix4f mat = matrices.peek().getPositionMatrix();

        if (state.get(OvenBlock.LIT)){
            VertexConsumer glowVc = vertexConsumers.getBuffer(RenderLayer.getEyes(LIGHT_TEXTURE));
            drawQuad(mat, glowVc, 0x80FFFF00, light);
        }

        ItemStack stack = entity.getStack(0);
        if (!stack.isEmpty()) {
            renderItemAsIcon(stack, matrices, vertexConsumers, light, overlay);
        }
        matrices.pop();
    }

    private void drawQuad(Matrix4f mat, VertexConsumer vc, int color, int light) {
        vc.vertex(mat, -0.25F,  0.25F, 0F)
                .color(color)
                .texture(0F, 0F)
                .overlay(OverlayTexture.DEFAULT_UV)
                .light(light)
                .normal(0F, 0F, -1F);
        vc.vertex(mat,  0.25F,  0.25F, 0F)
                .color(color)
                .texture(1F, 0F)
                .overlay(OverlayTexture.DEFAULT_UV)
                .light(light)
                .normal(0F, 0F, -1F);
        vc.vertex(mat,  0.25F, -0.25F, 0F)
                .color(color)
                .texture(1F, 1F)
                .overlay(OverlayTexture.DEFAULT_UV)
                .light(light)
                .normal(0F, 0F, -1F);
        vc.vertex(mat, -0.25F, -0.25F, 0F)
                .color(color)
                .texture(0F, 1F)
                .overlay(OverlayTexture.DEFAULT_UV)
                .light(light)
                .normal(0F, 0F, -1F);
    }

    private void renderItemAsIcon(ItemStack stack, MatrixStack matrices,
                                  VertexConsumerProvider vertexConsumers, int light, int overlay) {

        matrices.push();
        matrices.translate(0, 0, 0.001);
        matrices.scale(0.4f, 0.4f, 0.4f);
        matrices.translate(-0.5f, -0.5f, 0);

        MinecraftClient.getInstance().getItemRenderer()
                .renderItem(stack, ModelTransformationMode.GUI, light, overlay, matrices, vertexConsumers, null, 0);
        matrices.pop();
    }
}
