package com.skniro.skniro_furniture.block.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.skniro.skniro_furniture.block.entity.CabinetBlockEntity;
import com.skniro.skniro_furniture.block.init.FourGridCabinetBlock;
import com.skniro.skniro_furniture.block.init.TripleCabinetBlock;
import com.skniro.skniro_furniture.block.renderer.item.ItemRendererHelper;
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

public class CabinetBlockEntityRenderer implements BlockEntityRenderer<CabinetBlockEntity, CabinetBlockEntityRendererState> {
    private final ItemModelResolver itemModelManager;

    public CabinetBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
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
    public CabinetBlockEntityRendererState createRenderState() {
        return new CabinetBlockEntityRendererState();
    }

    @Override
    public void render(CabinetBlockEntityRendererState state, PoseStack matrices, SubmitNodeCollector queue, CameraRenderState cameraRenderState) {
        Direction direction = state.blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
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

        if (state.blockState.getBlock() instanceof TripleCabinetBlock) {
            List<ItemStackRenderState> list = state.triplecabinetItemStates;

            float spacing = 1.2f;
            float spacing2 = 1.19f;
            matrices.translate(0.46f, 0.80f, 0.7f);
            matrices.scale(0.26f, 0.26f, 0.26f);

            for (int i = 0; i < 9; i++) {
                ItemStackRenderState itemRenderState = (ItemStackRenderState)list.get(i);
                ItemStack stack = state.stack.get(i);
                if (!stack.isEmpty()) {
                    matrices.pushPose();
                    int row = i / 3;
                    float col = (i % 3) * 1.1f;
                    matrices.translate((col - 1) * spacing2, -(row * spacing), 0);
                    itemRenderState.submit(matrices, queue, getLightLevel(state.world, state.blockPos), OverlayTexture.NO_OVERLAY,0);
                    matrices.popPose();
                }
            }
        }

        if (state.blockState.getBlock() instanceof FourGridCabinetBlock) {
            List<ItemStackRenderState> list = state.fourgridcabinetItemStates;
            float spacing = 1.2f;
            float spacing2 = 1.05f;
            matrices.translate(0.68f, 0.70f, 0.7f);
            matrices.scale(0.4f, 0.4f, 0.4f);

            for (int i = 0; i < 4; i++) {
                ItemStackRenderState itemRenderState = (ItemStackRenderState)list.get(i);
                ItemStack stack = state.stack.get(i);
                if (!stack.isEmpty()) {
                    matrices.pushPose();
                    int row = i / 2;
                    float col = (i % 2) * 1.1f;
                    matrices.translate((col - 1) * spacing2, -(row * spacing), 0);
                    itemRenderState.submit(matrices, queue, getLightLevel(state.world, state.blockPos), OverlayTexture.NO_OVERLAY,0);
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
