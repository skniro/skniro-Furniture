package com.skniro.skniro_furniture.block.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.skniro.skniro_furniture.block.entity.BookDeskBlockEntity;
import com.skniro.skniro_furniture.block.init.BookDeskBlock;
import net.minecraft.client.model.BookModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.EnchantTableRenderer;
import net.minecraft.world.level.block.LecternBlock;
import net.minecraft.world.level.block.state.BlockState;

public class BookDeskBlockEntityRenderer implements BlockEntityRenderer<BookDeskBlockEntity> {
    private final BookModel book;
    public BookDeskBlockEntityRenderer(BlockEntityRendererProvider.Context ctx) {
        this.book = new BookModel(ctx.bakeLayer(ModelLayers.BOOK));
    }

    @Override
    public void render(BookDeskBlockEntity bookDeskBlockEntity, float f, PoseStack matrixStack, MultiBufferSource vertexConsumerProvider, int i, int j) {
        BlockState blockState = bookDeskBlockEntity.getBlockState();
        if (blockState.getValue(BookDeskBlock.HAS_BOOK)) {
            matrixStack.pushPose();
            matrixStack.translate(0.5F, 1.1625F, 0.5F);
            matrixStack.translate(0.0F, 0.0F, 0.0F);
            float bookRotationDegrees = blockState.getValue(LecternBlock.FACING).getClockWise().toYRot();
            matrixStack.mulPose(Axis.YP.rotationDegrees(-bookRotationDegrees));
            matrixStack.mulPose(Axis.ZP.rotationDegrees(90F));
            matrixStack.mulPose(Axis.XP.rotationDegrees(180F));
            matrixStack.translate(-0.15F, 0.0F, 0.0F);
            this.book.setupAnim(0.0F, 0.1F, 0.9F, 1.2F);
            VertexConsumer vertexConsumer = EnchantTableRenderer.BOOK_LOCATION.buffer(vertexConsumerProvider, RenderType::entitySolid);
            this.book.render(matrixStack, vertexConsumer, i, j, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStack.popPose();
        }
    }
}