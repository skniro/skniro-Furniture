package com.skniro.skniro_furniture.block.renderer;

import com.skniro.skniro_furniture.block.entity.CabinetBlockEntity;
import com.skniro.skniro_furniture.block.init.FourGridCabinetBlock;
import com.skniro.skniro_furniture.block.init.TripleCabinetBlock;
import com.skniro.skniro_furniture.block.renderer.state.CabinetBlockEntityRendererState;
import net.minecraft.client.item.ItemModelManager;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.command.ModelCommandRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.item.ItemRenderState;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.property.Properties;
import net.minecraft.util.HeldItemContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CabinetBlockEntityRenderer implements BlockEntityRenderer<CabinetBlockEntity, CabinetBlockEntityRendererState> {
    private final ItemModelManager itemModelManager;

    public CabinetBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
        this.itemModelManager = context.itemModelManager();
    }

    @Override
    public void updateRenderState(CabinetBlockEntity entity, CabinetBlockEntityRendererState state, float tickProgress, Vec3d cameraPos, @Nullable ModelCommandRenderer.CrumblingOverlayCommand crumblingOverlay) {
        BlockEntityRenderer.super.updateRenderState(entity, state, tickProgress, cameraPos, crumblingOverlay);
        state.stack = entity.inventory;
        state.world = entity.getWorld();
        state.pos = entity.getPos();
        state.blockState = entity.getCachedState();
        if (state.blockState.getBlock() instanceof TripleCabinetBlock) {
            int j = (int)entity.getPos().asLong();
            state.triplecabinetItemStates = new ArrayList();
            for (int i = 0; i < 9; i++) {
                ItemRenderState itemRenderState = new ItemRenderState();
                this.itemModelManager.clearAndUpdate(itemRenderState, (ItemStack)entity.getStack(i), ItemDisplayContext.FIXED, entity.getWorld(), (HeldItemContext)null, i+j);
                state.triplecabinetItemStates.add(itemRenderState);
            }
        }

        if (state.blockState.getBlock() instanceof FourGridCabinetBlock) {
            int j = (int)entity.getPos().asLong();
            state.fourgridcabinetItemStates = new ArrayList();
            for (int i = 0; i < 4; i++) {
                ItemRenderState itemRenderState = new ItemRenderState();
                this.itemModelManager.clearAndUpdate(itemRenderState, (ItemStack)entity.getStack(i), ItemDisplayContext.FIXED, entity.getWorld(), (HeldItemContext)null, i+j);
                state.fourgridcabinetItemStates.add(itemRenderState);
            }
        }

    }

    @Override
    public CabinetBlockEntityRendererState createRenderState() {
        return new CabinetBlockEntityRendererState();
    }

    @Override
    public void render(CabinetBlockEntityRendererState state, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState cameraRenderState) {
        Direction direction = state.blockState.get(Properties.HORIZONTAL_FACING);
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

        if (state.blockState.getBlock() instanceof TripleCabinetBlock) {
            List<ItemRenderState> list = state.triplecabinetItemStates;

            float spacing = 1.2f;
            float spacing2 = 1.19f;
            matrices.translate(0.46f, 0.80f, 0.7f);
            matrices.scale(0.26f, 0.26f, 0.26f);

            for (int i = 0; i < 9; i++) {
                ItemRenderState itemRenderState = (ItemRenderState)list.get(i);
                ItemStack stack = state.stack.get(i);
                if (!stack.isEmpty()) {
                    matrices.push();
                    int row = i / 3;
                    float col = (i % 3) * 1.1f;
                    matrices.translate((col - 1) * spacing2, -(row * spacing), 0);
                    itemRenderState.render(matrices, queue, getLightLevel(state.world, state.pos), OverlayTexture.DEFAULT_UV,0);
                    matrices.pop();
                }
            }
        }

        if (state.blockState.getBlock() instanceof FourGridCabinetBlock) {
            List<ItemRenderState> list = state.fourgridcabinetItemStates;
            float spacing = 1.2f;
            float spacing2 = 1.05f;
            matrices.translate(0.68f, 0.70f, 0.7f);
            matrices.scale(0.4f, 0.4f, 0.4f);

            for (int i = 0; i < 4; i++) {
                ItemRenderState itemRenderState = (ItemRenderState)list.get(i);
                ItemStack stack = state.stack.get(i);
                if (!stack.isEmpty()) {
                    matrices.push();
                    int row = i / 2;
                    float col = (i % 2) * 1.1f;
                    matrices.translate((col - 1) * spacing2, -(row * spacing), 0);
                    itemRenderState.render(matrices, queue, getLightLevel(state.world, state.pos), OverlayTexture.DEFAULT_UV,0);
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
