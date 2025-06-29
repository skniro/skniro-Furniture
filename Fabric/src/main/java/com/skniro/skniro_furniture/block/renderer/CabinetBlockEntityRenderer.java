package com.skniro.skniro_furniture.block.renderer;

import com.skniro.skniro_furniture.block.entity.CabinetBlockEntity;
import com.skniro.skniro_furniture.block.init.FourGridCabinetBlock;
import com.skniro.skniro_furniture.block.init.TripleCabinetBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.LightType;
import net.minecraft.world.World;

public class CabinetBlockEntityRenderer implements BlockEntityRenderer<CabinetBlockEntity> {
    public CabinetBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
    }

    @Override
    public void render(CabinetBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay, Vec3d cameraPos) {
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        Direction direction = entity.getCachedState().get(Properties.HORIZONTAL_FACING);
        matrices.push();

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

        if (entity.getCachedState().getBlock() instanceof TripleCabinetBlock) {
            float spacing = 1.2f;
            float spacing2 = 1.19f;
            matrices.translate(0.46f, 0.80f, 0.7f);
            matrices.scale(0.26f, 0.26f, 0.26f);

            for (int i = 0; i < 9; i++) {
                ItemStack stack = entity.getStack(i);
                if (!stack.isEmpty()) {
                    matrices.push();
                    int row = i / 3;
                    float col = (i % 3) * 1.1f;
                    matrices.translate((col - 1) * spacing2, -(row * spacing), 0);
                    itemRenderer.renderItem(stack, ItemDisplayContext.GUI, getLightLevel(entity.getWorld(), entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
                    matrices.pop();
                }
            }
        }

        if (entity.getCachedState().getBlock() instanceof FourGridCabinetBlock) {
            float spacing = 1.2f;
            float spacing2 = 1.05f;
            matrices.translate(0.68f, 0.70f, 0.7f);
            matrices.scale(0.4f, 0.4f, 0.4f);

            for (int i = 0; i < 4; i++) {
                ItemStack stack = entity.getStack(i);
                if (!stack.isEmpty()) {
                    matrices.push();
                    int row = i / 2;
                    float col = (i % 2) * 1.1f;
                    matrices.translate((col - 1) * spacing2, -(row * spacing), 0);
                    itemRenderer.renderItem(stack, ItemDisplayContext.GUI, getLightLevel(entity.getWorld(), entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
                    matrices.pop();
                }
            }
        }

        matrices.pop();
    }

    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, Math.max(sLight, 15));
    }
}
