package com.skniro.skniro_furniture.block.renderer;

import com.skniro.skniro_furniture.block.entity.GlassTableBlockEntity;
import com.skniro.skniro_furniture.block.init.GlassTableBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.LightType;
import net.minecraft.world.World;

public class GlassTableBlockEntityRenderer implements BlockEntityRenderer<GlassTableBlockEntity> {
    public GlassTableBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
    }

    @Override
    public void render(GlassTableBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        Direction direction = entity.getCachedState().get(Properties.HORIZONTAL_FACING);

        matrices.push();
        if (entity.getCachedState().getBlock() instanceof GlassTableBlock) {
            switch (direction) {
                case NORTH -> {}
                case SOUTH -> {
                    matrices.translate(1, 0, 1);
                    matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180));
                }
                case WEST -> {
                    matrices.translate(0, 0, 1);
                    matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90));
                }
                case EAST -> {
                    matrices.translate(1, 0, 0);
                    matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(270));
                }
            }

            matrices.translate(0.25f, 0.93f, 0.25f);
            matrices.scale(0.23f, 0.23f, 0.23f);

            for (int i = 0; i < 9; i++) {
                ItemStack stack = entity.getStack(i);
                if (!stack.isEmpty()) {
                    matrices.push();
                    float x = (i % 3) * 1.1f;
                    float z = (i / 3) * 1.1f;
                    matrices.translate(x, 0, z);
                    itemRenderer.renderItem(stack, ModelTransformationMode.FIXED, getLightLevel(entity.getWorld(), entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
                    matrices.pop();
                }
            }

            matrices.pop();
        }
    }

    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, Math.max(sLight, 15));
    }
}
