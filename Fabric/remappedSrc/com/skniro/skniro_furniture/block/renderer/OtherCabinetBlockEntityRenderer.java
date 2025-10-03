package com.skniro.skniro_furniture.block.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.skniro.skniro_furniture.block.entity.CabinetBlockEntity;
import com.skniro.skniro_furniture.block.init.FourGridCabinetBlock;
import com.skniro.skniro_furniture.block.init.TripleCabinetBlock;
import com.skniro.skniro_furniture.block.renderer.state.CabinetBlockEntityRendererState;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.state.CameraRenderState;
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

public class OtherCabinetBlockEntityRenderer implements BlockEntityRenderer<CabinetBlockEntity, CabinetBlockEntityRendererState> {
    private final ItemModelResolver itemModelManager;

    public OtherCabinetBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.itemModelManager = context.itemModelResolver();
    }

    @Override
    public void updateRenderState(CabinetBlockEntity entity, CabinetBlockEntityRendererState state, float tickProgress, Vec3 cameraPos, @Nullable ModelFeatureRenderer.CrumblingOverlay crumblingOverlay) {
        BlockEntityRenderer.super.extractRenderState(entity, state, tickProgress, cameraPos, crumblingOverlay);
        state.stack = entity.inventory;
        state.world = entity.getLevel();
        state.blockPos = entity.getBlockPos();
        state.blockState = entity.getBlockState();
        if (state.blockState.getBlock() instanceof TripleCabinetBlock) {
            int j = (int)entity.getBlockPos().asLong();
            state.triplecabinetItemStates = new ArrayList();
            for (int i = 0; i < 9; i++) {
                ItemStackRenderState itemRenderState = new ItemStackRenderState();
                this.itemModelManager.updateForTopItem(itemRenderState, (ItemStack)entity.getItem(i), ItemDisplayContext.FIXED, entity.getLevel(), (ItemOwner)null, i+j);
                state.triplecabinetItemStates.add(itemRenderState);
            }
        }

        if (state.blockState.getBlock() instanceof FourGridCabinetBlock) {
            int j = (int)entity.getBlockPos().asLong();
            state.fourgridcabinetItemStates = new ArrayList();
            for (int i = 0; i < 4; i++) {
                ItemStackRenderState itemRenderState = new ItemStackRenderState();
                this.itemModelManager.updateForTopItem(itemRenderState, (ItemStack)entity.getItem(i), ItemDisplayContext.FIXED, entity.getLevel(), (ItemOwner)null, i+j);
                state.fourgridcabinetItemStates.add(itemRenderState);
            }
        }

    }

    @Override
    public void render(CabinetBlockEntityRendererState state, PoseStack matrices, SubmitNodeCollector queue, CameraRenderState cameraState) {
        Direction direction = state.blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);

        matrices.pushPose();
        if (state.blockState.getBlock() instanceof TripleCabinetBlock) {
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

            List<ItemStackRenderState> list = state.triplecabinetItemStates;
            for (int i = 0; i < 9; i++) {
                ItemStackRenderState itemRenderState = (ItemStackRenderState)list.get(i);
                ItemStack stack = state.stack.get(i);
                if (!stack.isEmpty()) {
                    matrices.pushPose();
                    float x = (i % 3) * 1.1f;
                    float z = (i / 3) * 1.1f;
                    matrices.translate(x, 0, z);
                    System.out.println("Slot " + i + ": " + stack);
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
        return LightTexture.pack(bLight, Math.max(sLight, 15));
    }

    @Override
    public CabinetBlockEntityRendererState createRenderState() {
        return null;
    }
}
