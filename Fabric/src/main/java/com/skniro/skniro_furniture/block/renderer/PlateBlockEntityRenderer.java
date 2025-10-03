package com.skniro.skniro_furniture.block.renderer;

import com.skniro.skniro_furniture.block.entity.KitchenSinkBlockEntity;
import com.skniro.skniro_furniture.block.entity.PlateBlockEntity;

import com.skniro.skniro_furniture.block.renderer.state.KitchenSinkBlockEntityRenderState;
import com.skniro.skniro_furniture.block.renderer.state.PlateBlockEntityRendererState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.ItemModelManager;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;

import net.minecraft.client.render.command.ModelCommandRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.item.ItemRenderState;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.state.CameraRenderState;
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
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PlateBlockEntityRenderer implements BlockEntityRenderer<PlateBlockEntity, PlateBlockEntityRendererState> {

    public PlateBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
    }

    @Override
    public void render(PlateBlockEntityRendererState state, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState cameraState) {
        Direction direction = state.blockState.get(Properties.HORIZONTAL_FACING);
        matrices.push();
        matrices.translate(0.5f, 0.01f, 0.5f);
        matrices.scale(0.35f, 0.35f, 0.35f);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90));
        switch (direction) {
            case NORTH -> matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(0));
            case SOUTH -> matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180));
            case WEST -> matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(90));
            case EAST -> matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(180));
        }
        state.item.render(matrices, queue, state.lightmapCoordinates, OverlayTexture.DEFAULT_UV,0);
        matrices.pop();
    }

    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }

    @Override
    public PlateBlockEntityRendererState createRenderState() {
        return new PlateBlockEntityRendererState();
    }

    @Override
    public void updateRenderState(PlateBlockEntity entity, PlateBlockEntityRendererState state, float tickProgress, Vec3d cameraPos, @Nullable ModelCommandRenderer.CrumblingOverlayCommand crumblingOverlay) {
        BlockEntityRenderer.super.updateRenderState(entity, state, tickProgress, cameraPos, crumblingOverlay);
        ItemModelManager itemModelResolver = MinecraftClient.getInstance().getItemModelManager();
        itemModelResolver.clearAndUpdate(state.item, entity.getRenderStack(), ItemDisplayContext.GUI, entity.getWorld(), null, 1);
        state.pos = entity.getPos();
        state.blockState = entity.getCachedState();
        state.lightmapCoordinates = getLightLevel(entity.getWorld(), entity.getPos());
    }
}