package com.skniro.skniro_furniture.block.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.skniro.skniro_furniture.block.entity.BookDeskBlockEntity;
import net.minecraft.client.model.BookModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.EnchantTableRenderer;
import net.minecraft.client.renderer.blockentity.state.LecternRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.MaterialSet;
import net.minecraft.world.level.block.LecternBlock;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

public class BookDeskBlockEntityRenderer implements BlockEntityRenderer<BookDeskBlockEntity, LecternRenderState> {
    private final MaterialSet spriteHolder;
    private final BookModel book;
    private final BookModel.State bookModelState = new BookModel.State(0.0F, 0.1F, 0.9F, 1.2F);

    public BookDeskBlockEntityRenderer(BlockEntityRendererProvider.Context ctx) {
        this.spriteHolder = ctx.materials();
        this.book = new BookModel(ctx.bakeLayer(ModelLayers.BOOK));
    }

    @Override
    public LecternRenderState createRenderState() {
        return new LecternRenderState();
    }

    @Override
    public void extractRenderState(BookDeskBlockEntity bookDeskBlockEntity, LecternRenderState lecternBlockEntityRenderState, float f, Vec3 vec3d, ModelFeatureRenderer.@Nullable CrumblingOverlay crumblingOverlayCommand) {
        BlockEntityRenderer.super.extractRenderState(bookDeskBlockEntity, lecternBlockEntityRenderState, f, vec3d, crumblingOverlayCommand);
        lecternBlockEntityRenderState.hasBook = bookDeskBlockEntity.getBlockState().getValue(LecternBlock.HAS_BOOK);
        lecternBlockEntityRenderState.yRot = bookDeskBlockEntity.getBlockState().getValue(LecternBlock.FACING).getClockWise().toYRot();
    }

    @Override
    public void submit(LecternRenderState lecternBlockEntityRenderState, PoseStack matrixStack, SubmitNodeCollector orderedRenderCommandQueue, CameraRenderState cameraRenderState) {
        if (lecternBlockEntityRenderState.hasBook) {
            matrixStack.pushPose();
            matrixStack.translate(0.5F, 1.1625F, 0.5F);
            matrixStack.translate(0.0F, 0.0F, 0.0F);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-lecternBlockEntityRenderState.yRot));
            matrixStack.mulPose(Axis.ZP.rotationDegrees(90F));
            matrixStack.mulPose(Axis.XP.rotationDegrees(180F));
            matrixStack.translate(-0.15F, 0.0F, 0.0F);
            orderedRenderCommandQueue.submitModel(this.book, this.bookModelState, matrixStack, EnchantTableRenderer.BOOK_LOCATION.renderType(RenderType::entitySolid), lecternBlockEntityRenderState.lightCoords, OverlayTexture.NO_OVERLAY, -1, this.spriteHolder.get(EnchantTableRenderer.BOOK_LOCATION), 0, lecternBlockEntityRenderState.breakProgress);
            matrixStack.popPose();
        }
    }
}