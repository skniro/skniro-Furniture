package com.skniro.skniro_furniture.block.renderer;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.skniro.skniro_furniture.block.entity.KitchenSinkBlockEntity;
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

public class KitchenSinkBlockEntityRenderer implements BlockEntityRenderer<KitchenSinkBlockEntity> {
    public KitchenSinkBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
    }
    @Override
    public void render(KitchenSinkBlockEntity entity, float tickDelta, PoseStack matrices,
                       MultiBufferSource vertexConsumers, int light, int overlay, Vec3 cameraPos) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack stack = entity.getRenderStack();
        Direction direction = entity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);
        matrices.pushPose();
        switch (direction) {
            case NORTH -> matrices.translate(0.5f, 1.0f, 0.65f);
            case SOUTH -> matrices.translate(0.5f, 1.0f, 0.35f);
            case WEST -> matrices.translate(0.65f, 1.0f, 0.5f);
            case EAST -> matrices.translate(0.35f, 1.0f, 0.5f);
        }
        matrices.scale(0.5f, 0.5f, 0.5f);
        switch (direction) {
            case NORTH -> matrices.mulPose(Axis.YP.rotationDegrees(0));
            case SOUTH -> matrices.mulPose(Axis.YP.rotationDegrees(180));
            case WEST -> matrices.mulPose(Axis.YP.rotationDegrees(90));
            case EAST -> matrices.mulPose(Axis.YP.rotationDegrees(270));
        }
        itemRenderer.renderStatic(stack, ItemDisplayContext.GUI, getLightLevel(entity.getLevel(),
                entity.getBlockPos()), OverlayTexture.NO_OVERLAY, matrices, vertexConsumers, entity.getLevel(), 1);
        matrices.popPose();
    }


    private int getLightLevel(Level world, BlockPos pos) {
        int bLight = world.getBrightness(LightLayer.BLOCK, pos);
        int sLight = world.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, Math.max(sLight, 15));
    }
}