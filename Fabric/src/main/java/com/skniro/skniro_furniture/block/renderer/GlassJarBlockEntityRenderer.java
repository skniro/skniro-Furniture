package com.skniro.skniro_furniture.block.renderer;


import com.skniro.skniro_furniture.block.entity.GlassJarBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ModelTransformationMode;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.LightType;
import net.minecraft.world.World;

import java.util.Random;

public class GlassJarBlockEntityRenderer implements BlockEntityRenderer<GlassJarBlockEntity> {

    public GlassJarBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
    }

    @Override
    public void render(GlassJarBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        ItemStack stack = entity.getStack(0);
        if (stack.isEmpty()) return;

        int itemCount = Math.min(30, stack.getCount());
        Random random = new Random(entity.getPos().asLong());

        matrices.push();
        matrices.translate(0.51, 0.0, 0.47); // 现在 (0,0,0) = 瓶子中心

        float radius = 0.13f;
        float baseY = 0.03f;
        float maxHeight = 0.5f;

        for (int i = 0; i < itemCount; i++) {
            matrices.push();

            double angle = random.nextDouble() * Math.PI * 2;
            double r = radius * Math.sqrt(random.nextDouble());
            double offsetX = r * Math.cos(angle);
            double offsetZ = r * Math.sin(angle);

            double offsetY = baseY + random.nextDouble() * maxHeight * 0.4;

            matrices.translate(offsetX, offsetY, offsetZ);

            float scale = 0.33f + random.nextFloat() * 0.02f;
            matrices.scale(scale, scale, scale);

            float horizontalTilt = 80f + random.nextFloat() * 10f;
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(horizontalTilt));

            itemRenderer.renderItem(stack, ModelTransformationMode.GROUND, getLightLevel(entity.getWorld(), entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);

            matrices.pop();
        }

        matrices.pop();
    }


    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, Math.max(sLight, 15));
    }
}