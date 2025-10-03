package com.skniro.skniro_furniture.block.renderer;


import com.skniro.skniro_furniture.block.entity.KitchenSinkBlockEntity;
import com.skniro.skniro_furniture.block.renderer.state.KitchenSinkBlockEntityRenderState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.ItemModelManager;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.command.ModelCommandRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class KitchenSinkBlockEntityRenderer implements BlockEntityRenderer<KitchenSinkBlockEntity, KitchenSinkBlockEntityRenderState> {
    public KitchenSinkBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
    }
    @Override
    public void render(KitchenSinkBlockEntityRenderState state, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState cameraState) {
        Direction direction = state.blockState.get(Properties.HORIZONTAL_FACING);
        matrices.push();
        switch (direction) {
            case NORTH -> matrices.translate(0.5f, 1.0f, 0.65f);
            case SOUTH -> matrices.translate(0.5f, 1.0f, 0.35f);
            case WEST -> matrices.translate(0.65f, 1.0f, 0.5f);
            case EAST -> matrices.translate(0.35f, 1.0f, 0.5f);
        }
        matrices.scale(0.5f, 0.5f, 0.5f);
        switch (direction) {
            case NORTH -> matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(0));
            case SOUTH -> matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180));
            case WEST -> matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90));
            case EAST -> matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(270));
        }
        state.item.render(matrices, queue, state.lightmapCoordinates, OverlayTexture.DEFAULT_UV,0);
        matrices.pop();
    }


    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, Math.max(sLight, 15));
    }

    @Override
    public KitchenSinkBlockEntityRenderState createRenderState() {
        return new KitchenSinkBlockEntityRenderState();
    }

    @Override
    public void updateRenderState(KitchenSinkBlockEntity entity, KitchenSinkBlockEntityRenderState state, float tickProgress, Vec3d cameraPos, @Nullable ModelCommandRenderer.CrumblingOverlayCommand crumblingOverlay) {
        BlockEntityRenderer.super.updateRenderState(entity, state, tickProgress, cameraPos, crumblingOverlay);
        ItemModelManager itemModelResolver = MinecraftClient.getInstance().getItemModelManager();
        itemModelResolver.clearAndUpdate(state.item, entity.getRenderStack(), ItemDisplayContext.GUI, entity.getWorld(), null, 1);
        state.pos = entity.getPos();
        state.blockState = entity.getCachedState();
        state.lightmapCoordinates = getLightLevel(entity.getWorld(), entity.getPos());
    }
}