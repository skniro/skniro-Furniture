package com.skniro.skniro_furniture.block.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.skniro.skniro_furniture.block.entity.KitchenSinkBlockEntity;
import com.skniro.skniro_furniture.block.entity.PlateBlockEntity;

import com.skniro.skniro_furniture.block.renderer.state.KitchenSinkBlockEntityRenderState;
import com.skniro.skniro_furniture.block.renderer.state.PlateBlockEntityRendererState;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;

public class PlateBlockEntityRenderer implements BlockEntityRenderer<PlateBlockEntity, PlateBlockEntityRendererState> {

    public PlateBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(PlateBlockEntityRendererState state, PoseStack matrices, SubmitNodeCollector queue, CameraRenderState cameraState) {
        Direction direction = state.blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
        matrices.pushPose();
        matrices.translate(0.5f, 0.01f, 0.5f);
        matrices.scale(0.35f, 0.35f, 0.35f);
        matrices.mulPose(Axis.XP.rotationDegrees(90));
        switch (direction) {
            case NORTH -> matrices.mulPose(Axis.YP.rotationDegrees(0));
            case SOUTH -> matrices.mulPose(Axis.YP.rotationDegrees(180));
            case WEST -> matrices.mulPose(Axis.ZP.rotationDegrees(90));
            case EAST -> matrices.mulPose(Axis.ZP.rotationDegrees(180));
        }
        state.item.submit(matrices, queue, state.lightCoords, OverlayTexture.NO_OVERLAY,0);
        matrices.popPose();
    }

    private int getLightLevel(Level world, BlockPos pos) {
        int bLight = world.getBrightness(LightLayer.BLOCK, pos);
        int sLight = world.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, sLight);
    }

    @Override
    public PlateBlockEntityRendererState createRenderState() {
        return new PlateBlockEntityRendererState();
    }

    @Override
    public void updateRenderState(PlateBlockEntity entity, PlateBlockEntityRendererState state, float tickProgress, Vec3 cameraPos, @Nullable ModelFeatureRenderer.CrumblingOverlay crumblingOverlay) {
        BlockEntityRenderer.super.extractRenderState(entity, state, tickProgress, cameraPos, crumblingOverlay);
        ItemModelResolver itemModelResolver = Minecraft.getInstance().getItemModelResolver();
        itemModelResolver.updateForTopItem(state.item, entity.getRenderStack(), ItemDisplayContext.GUI, entity.getLevel(), null, 1);
        state.blockPos = entity.getBlockPos();
        state.blockState = entity.getBlockState();
        state.lightCoords = getLightLevel(entity.getLevel(), entity.getBlockPos());
    }
}