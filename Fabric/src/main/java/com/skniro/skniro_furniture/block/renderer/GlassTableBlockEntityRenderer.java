package com.skniro.skniro_furniture.block.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.skniro.skniro_furniture.block.entity.GlassTableBlockEntity;
import com.skniro.skniro_furniture.block.init.GlassTableBlock;
import com.skniro.skniro_furniture.block.renderer.state.GlassTableBlockEntityRendererState;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.util.LightCoordsUtil;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.ItemOwner;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;

public class GlassTableBlockEntityRenderer implements BlockEntityRenderer<GlassTableBlockEntity, GlassTableBlockEntityRendererState> {
    private final ItemModelResolver itemModelManager;

    public GlassTableBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.itemModelManager = context.itemModelResolver();
    }

    @Override
    public void extractRenderState(GlassTableBlockEntity entity, GlassTableBlockEntityRendererState state, float tickProgress, Vec3 cameraPos, @Nullable ModelFeatureRenderer.CrumblingOverlay crumblingOverlay) {
        BlockEntityRenderer.super.extractRenderState(entity, state, tickProgress, cameraPos, crumblingOverlay);
        state.stack = entity.inventory;
        state.world = entity.getLevel();
        state.blockPos = entity.getBlockPos();
        state.blockState = entity.getBlockState();
        if (state.blockState.getBlock() instanceof GlassTableBlock) {
            int j = (int)entity.getBlockPos().asLong();
            state.triplecabinetItemStates = new ArrayList();
            for (int i = 0; i < 9; i++) {
                ItemStackRenderState itemRenderState = new ItemStackRenderState();
                this.itemModelManager.updateForTopItem(itemRenderState, (ItemStack)entity.getItem(i), ItemDisplayContext.FIXED, entity.getLevel(), (ItemOwner)null, i+j);
                state.triplecabinetItemStates.add(itemRenderState);
            }
        }
    }

    @Override
    public void submit(GlassTableBlockEntityRendererState state, PoseStack matrices, SubmitNodeCollector queue, CameraRenderState cameraRenderState) {
        BlockEntityRenderDispatcher itemRenderer = Minecraft.getInstance().getBlockEntityRenderDispatcher();
        Direction direction = state.blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);

        matrices.pushPose();
        if (state.blockState.getBlock() instanceof GlassTableBlock) {
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

            matrices.translate(0.25f, 0.93f, 0.25f);
            matrices.scale(0.23f, 0.23f, 0.23f);

            List<ItemStackRenderState> list = state.triplecabinetItemStates;

            for (int i = 0; i < 9; i++) {
                ItemStackRenderState itemRenderState = (ItemStackRenderState)list.get(i);
                ItemStack stack = state.stack.get(i);
                if (!stack.isEmpty()) {
                    matrices.pushPose();
                    float x = (i % 3) * 1.1f;
                    float z = (i / 3) * 1.1f;
                    matrices.translate(x, 0, z);
                    itemRenderState.submit(matrices, queue, getLightLevel(state.world, state.blockPos), OverlayTexture.NO_OVERLAY,0);
                    matrices.popPose();
                }
            }

            matrices.popPose();
        }
    }

    private int getLightLevel(Level world, BlockPos pos) {
        int bLight = world.getBrightness(LightLayer.BLOCK, pos);
        int sLight = world.getBrightness(LightLayer.SKY, pos);
        return LightCoordsUtil.pack(bLight, Math.max(sLight, 15));
    }

    @Override
    public GlassTableBlockEntityRendererState createRenderState() {
        return new GlassTableBlockEntityRendererState();
    }
}
