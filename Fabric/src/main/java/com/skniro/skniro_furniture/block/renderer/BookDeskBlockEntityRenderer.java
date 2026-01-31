package com.skniro.skniro_furniture.block.renderer;

import com.skniro.skniro_furniture.block.entity.BookDeskBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.LecternBlock;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.block.entity.EnchantingTableBlockEntityRenderer;
import net.minecraft.client.render.block.entity.state.LecternBlockEntityRenderState;
import net.minecraft.client.render.command.ModelCommandRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.model.BookModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.texture.SpriteHolder;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class BookDeskBlockEntityRenderer implements BlockEntityRenderer<BookDeskBlockEntity, LecternBlockEntityRenderState> {
    private final SpriteHolder spriteHolder;
    private final BookModel book;
    private final BookModel.BookModelState bookModelState = new BookModel.BookModelState(0.0F, 0.1F, 0.9F, 1.2F);

    public BookDeskBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
        this.spriteHolder = ctx.spriteHolder();
        this.book = new BookModel(ctx.getLayerModelPart(EntityModelLayers.BOOK));
    }

    @Override
    public LecternBlockEntityRenderState createRenderState() {
        return new LecternBlockEntityRenderState();
    }

    @Override
    public void updateRenderState(BookDeskBlockEntity bookDeskBlockEntity, LecternBlockEntityRenderState lecternBlockEntityRenderState, float f, Vec3d vec3d, @Nullable ModelCommandRenderer.CrumblingOverlayCommand crumblingOverlayCommand) {
        BlockEntityRenderer.super.updateRenderState(bookDeskBlockEntity, lecternBlockEntityRenderState, f, vec3d, crumblingOverlayCommand);
        lecternBlockEntityRenderState.hasBook = bookDeskBlockEntity.getCachedState().get(LecternBlock.HAS_BOOK);
        lecternBlockEntityRenderState.bookRotationDegrees = bookDeskBlockEntity.getCachedState().get(LecternBlock.FACING).rotateYClockwise().getPositiveHorizontalDegrees();
    }

    @Override
    public void render(LecternBlockEntityRenderState lecternBlockEntityRenderState, MatrixStack matrixStack, OrderedRenderCommandQueue orderedRenderCommandQueue, CameraRenderState cameraRenderState) {
        if (lecternBlockEntityRenderState.hasBook) {
            matrixStack.push();
            matrixStack.translate(0.5F, 1.1625F, 0.5F);
            matrixStack.translate(0.0F, 0.0F, 0.0F);
            matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-lecternBlockEntityRenderState.bookRotationDegrees));
            matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(90F));
            matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180F));
            matrixStack.translate(-0.15F, 0.0F, 0.0F);
            orderedRenderCommandQueue.submitModel(this.book, this.bookModelState, matrixStack, EnchantingTableBlockEntityRenderer.BOOK_TEXTURE.getRenderLayer(RenderLayer::getEntitySolid), lecternBlockEntityRenderState.lightmapCoordinates, OverlayTexture.DEFAULT_UV, -1, this.spriteHolder.getSprite(EnchantingTableBlockEntityRenderer.BOOK_TEXTURE), 0, lecternBlockEntityRenderState.crumblingOverlay);
            matrixStack.pop();
        }
    }
}