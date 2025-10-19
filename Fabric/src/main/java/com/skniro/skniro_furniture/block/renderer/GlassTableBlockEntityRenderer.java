package com.skniro.skniro_furniture.block.renderer;

import com.skniro.skniro_furniture.block.entity.CabinetBlockEntity;
import com.skniro.skniro_furniture.block.entity.GlassTableBlockEntity;
import com.skniro.skniro_furniture.block.init.FourGridCabinetBlock;
import com.skniro.skniro_furniture.block.init.GlassTableBlock;
import com.skniro.skniro_furniture.block.init.TripleCabinetBlock;
import com.skniro.skniro_furniture.block.renderer.state.CabinetBlockEntityRendererState;
import com.skniro.skniro_furniture.block.renderer.state.GlassTableBlockEntityRendererState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.ItemModelManager;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.block.entity.state.BlockEntityRenderState;
import net.minecraft.client.render.command.ModelCommandRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.item.ItemRenderState;
import net.minecraft.client.render.item.ItemRenderer;
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

public class GlassTableBlockEntityRenderer implements BlockEntityRenderer<GlassTableBlockEntity, GlassTableBlockEntityRendererState> {
    private final ItemModelManager itemModelManager;

    public GlassTableBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
        this.itemModelManager = context.itemModelManager();
    }

    @Override
    public void updateRenderState(GlassTableBlockEntity entity, GlassTableBlockEntityRendererState state, float tickProgress, Vec3d cameraPos, @Nullable ModelCommandRenderer.CrumblingOverlayCommand crumblingOverlay) {
        BlockEntityRenderer.super.updateRenderState(entity, state, tickProgress, cameraPos, crumblingOverlay);
        state.stack = entity.inventory;
        state.world = entity.getWorld();
        state.pos = entity.getPos();
        state.blockState = entity.getCachedState();
        if (state.blockState.getBlock() instanceof GlassTableBlock) {
            int j = (int)entity.getPos().asLong();
            state.triplecabinetItemStates = new ArrayList();
            for (int i = 0; i < 9; i++) {
                ItemRenderState itemRenderState = new ItemRenderState();
                this.itemModelManager.clearAndUpdate(itemRenderState, (ItemStack)entity.getStack(i), ItemDisplayContext.FIXED, entity.getWorld(), (HeldItemContext)null, i+j);
                state.triplecabinetItemStates.add(itemRenderState);
            }
        }
    }

    @Override
    public void render(GlassTableBlockEntityRendererState state, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState cameraRenderState) {
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        Direction direction = state.blockState.get(Properties.HORIZONTAL_FACING);

        matrices.push();
        if (state.blockState.getBlock() instanceof GlassTableBlock) {
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

            matrices.translate(0.25f, 0.93f, 0.25f);
            matrices.scale(0.23f, 0.23f, 0.23f);

            List<ItemRenderState> list = state.triplecabinetItemStates;

            for (int i = 0; i < 9; i++) {
                ItemRenderState itemRenderState = (ItemRenderState)list.get(i);
                ItemStack stack = state.stack.get(i);
                if (!stack.isEmpty()) {
                    matrices.push();
                    float x = (i % 3) * 1.1f;
                    float z = (i / 3) * 1.1f;
                    matrices.translate(x, 0, z);
                    itemRenderState.render(matrices, queue, getLightLevel(state.world, state.pos), OverlayTexture.DEFAULT_UV,0);
                    matrices.pop();
                }
            }

            matrices.pop();
        }
    }

    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, Math.max(sLight, 15));
    }

    @Override
    public GlassTableBlockEntityRendererState createRenderState() {
        return new GlassTableBlockEntityRendererState();
    }
}
