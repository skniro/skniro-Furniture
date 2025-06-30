package com.skniro.skniro_furniture.block.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.skniro.skniro_furniture.block.entity.CabinetBlockEntity;
import com.skniro.skniro_furniture.block.init.FourGridCabinetBlock;
import com.skniro.skniro_furniture.block.init.TripleCabinetBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;

public class CabinetBlockEntityRenderer implements BlockEntityRenderer<CabinetBlockEntity> {
    public CabinetBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(CabinetBlockEntity entity, float tickDelta, PoseStack matrices,
                       MultiBufferSource vertexConsumers, int light, int overlay, Vec3 cameraPos) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        Direction direction = entity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);
        matrices.pushPose();

        switch (direction) {
            case NORTH -> {}
            case SOUTH -> {
                matrices.translate(1, 0, 1);
                matrices.mulPose(Axis.YP.rotationDegrees(180));
            }
            case WEST -> {
                matrices.translate(0, 0, 1);
                matrices.mulPose(Axis.YP.rotationDegrees(90));
            }
            case EAST -> {
                matrices.translate(1, 0, 0);
                matrices.mulPose(Axis.YP.rotationDegrees(270));
            }
        }

        if (entity.getBlockState().getBlock() instanceof TripleCabinetBlock) {
            float spacing = 1.2f;
            float spacing2 = 1.19f;
            matrices.translate(0.46f, 0.80f, 0.7f);
            matrices.scale(0.26f, 0.26f, 0.26f);

            for (int i = 0; i < 9; i++) {
                ItemStack stack = entity.getItem(i);
                if (!stack.isEmpty()) {
                    matrices.pushPose();
                    int row = i / 3;
                    float col = (i % 3) * 1.1f;
                    matrices.translate((col - 1) * spacing2, -(row * spacing), 0);
                    itemRenderer.renderStatic(stack, ItemDisplayContext.GUI, getLightLevel(entity.getLevel(), entity.getBlockPos()), OverlayTexture.NO_OVERLAY, matrices, vertexConsumers, entity.getLevel(), 1);
                    matrices.popPose();
                }
            }
        }

        if (entity.getBlockState().getBlock() instanceof FourGridCabinetBlock) {
            float spacing = 1.2f;
            float spacing2 = 1.05f;
            matrices.translate(0.68f, 0.70f, 0.7f);
            matrices.scale(0.4f, 0.4f, 0.4f);

            for (int i = 0; i < 4; i++) {
                ItemStack stack = entity.getItem(i);
                if (!stack.isEmpty()) {
                    matrices.pushPose();
                    int row = i / 2;
                    float col = (i % 2) * 1.1f;
                    matrices.translate((col - 1) * spacing2, -(row * spacing), 0);
                    itemRenderer.renderStatic(stack, ItemDisplayContext.GUI, getLightLevel(entity.getLevel(), entity.getBlockPos()), OverlayTexture.NO_OVERLAY, matrices, vertexConsumers, entity.getLevel(), 1);
                    matrices.popPose();
                }
            }
        }

        matrices.popPose();
    }

    private int getLightLevel(Level world, BlockPos pos) {
        int bLight = world.getBrightness(LightLayer.BLOCK, pos);
        int sLight = world.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, Math.max(sLight, 15));
    }
}
