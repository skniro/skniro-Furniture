package com.skniro.skniro_furniture.block.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.skniro.skniro_furniture.block.entity.CabinetBlockEntity;
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

public class OtherCabinetBlockEntityRenderer implements BlockEntityRenderer<CabinetBlockEntity> {
    public OtherCabinetBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(CabinetBlockEntity entity, float tickDelta, PoseStack matrices,
                       MultiBufferSource vertexConsumers, int light, int overlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        Direction direction = entity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);

        matrices.pushPose();
        //if (entity.getCachedState().getBlock() instanceof TripleCabinetBlock) {
        // 方向修正
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

        matrices.translate(0.2f, 0.95f, 0.2f); // 整体抬高
        matrices.scale(0.25f, 0.25f, 0.25f); // 缩小尺寸

        for (int i = 0; i < 9; i++) {
            ItemStack stack = entity.getItem(i);
            if (!stack.isEmpty()) {
                matrices.pushPose();
                float x = (i % 3) * 1.1f;
                float z = (i / 3) * 1.1f;
                matrices.translate(x, 0, z);
                System.out.println("Slot " + i + ": " + stack);
                itemRenderer.renderStatic(stack, ItemDisplayContext.GUI, getLightLevel(entity.getLevel(), entity.getBlockPos()), OverlayTexture.NO_OVERLAY, matrices, vertexConsumers, entity.getLevel(), 1);
                matrices.popPose();
            }
        }

        matrices.popPose();
    }
    //}

    private int getLightLevel(Level world, BlockPos pos) {
        int bLight = world.getBrightness(LightLayer.BLOCK, pos);
        int sLight = world.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, Math.max(sLight, 15));
    }
}
