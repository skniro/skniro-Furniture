package com.skniro.skniro_furniture.block.renderer;

import com.skniro.skniro_furniture.block.entity.BookDeskBlockEntity;
import com.skniro.skniro_furniture.block.init.BookDeskBlock;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.LecternBlock;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.block.entity.EnchantingTableBlockEntityRenderer;
import net.minecraft.client.render.entity.model.BookModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;

@Environment(EnvType.CLIENT)
public class BookDeskBlockEntityRenderer implements BlockEntityRenderer<BookDeskBlockEntity> {
    private final BookModel book;
    public BookDeskBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
        this.book = new BookModel(ctx.getLayerModelPart(EntityModelLayers.BOOK));
    }

    @Override
    public void render(BookDeskBlockEntity bookDeskBlockEntity, float f, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, int j) {
        BlockState blockState = bookDeskBlockEntity.getCachedState();
        if (blockState.get(BookDeskBlock.HAS_BOOK)) {
            matrixStack.push();
            matrixStack.translate(0.5F, 1.1625F, 0.5F);
            matrixStack.translate(0.0F, 0.0F, 0.0F);
            float bookRotationDegrees = blockState.get(LecternBlock.FACING).rotateYClockwise().getPositiveHorizontalDegrees();
            matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-bookRotationDegrees));
            matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(90F));
            matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180F));
            matrixStack.translate(-0.15F, 0.0F, 0.0F);
            this.book.setPageAngles(0.0F, 0.1F, 0.9F, 1.2F);
            VertexConsumer vertexConsumer = EnchantingTableBlockEntityRenderer.BOOK_TEXTURE.getVertexConsumer(vertexConsumerProvider, RenderLayer::getEntitySolid);
            this.book.render(matrixStack, vertexConsumer, i, j, -1);
            matrixStack.pop();
        }
    }
}