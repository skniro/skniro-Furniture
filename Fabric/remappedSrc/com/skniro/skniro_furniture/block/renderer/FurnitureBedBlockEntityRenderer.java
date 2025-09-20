package com.skniro.skniro_furniture.block.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.skniro.skniro_furniture.block.entity.FurnitureBedBlockEntity;
import com.skniro.skniro_furniture.block.entity.FurnitureBlockEntityType;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import java.util.Set;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BrightnessCombiner;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3f;

@Environment(EnvType.CLIENT)
public class FurnitureBedBlockEntityRenderer implements BlockEntityRenderer<FurnitureBedBlockEntity> {
    public final Model bedHead;
    public final Model bedFoot;

    public FurnitureBedBlockEntityRenderer(BlockEntityRendererProvider.Context ctx) {
        this(ctx.getModelSet());
    }

    public FurnitureBedBlockEntityRenderer(EntityModelSet models) {
        this.bedHead = new Model.Simple(models.bakeLayer(ModelLayers.BED_HEAD), RenderType::entitySolid);
        this.bedFoot = new Model.Simple(models.bakeLayer(ModelLayers.BED_FOOT), RenderType::entitySolid);
    }

    public static LayerDefinition getHeadTexturedModelData() {
        MeshDefinition modelData = new MeshDefinition();
        PartDefinition modelPartData = modelData.getRoot();
        modelPartData.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 6.0F), PartPose.ZERO);
        modelPartData.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(50, 6).addBox(0.0F, 6.0F, 0.0F, 3.0F, 3.0F, 3.0F), PartPose.rotation(((float)Math.PI / 2F), 0.0F, ((float)Math.PI / 2F)));
        modelPartData.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(50, 18).addBox(-16.0F, 6.0F, 0.0F, 3.0F, 3.0F, 3.0F), PartPose.rotation(((float)Math.PI / 2F), 0.0F, (float)Math.PI));
        return LayerDefinition.create(modelData, 64, 64);
    }

    public static LayerDefinition getFootTexturedModelData() {
        MeshDefinition modelData = new MeshDefinition();
        PartDefinition modelPartData = modelData.getRoot();
        modelPartData.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 22).addBox(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 6.0F), PartPose.ZERO);
        modelPartData.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(50, 0).addBox(0.0F, 6.0F, -16.0F, 3.0F, 3.0F, 3.0F), PartPose.rotation(((float)Math.PI / 2F), 0.0F, 0.0F));
        modelPartData.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(50, 12).addBox(-16.0F, 6.0F, -16.0F, 3.0F, 3.0F, 3.0F), PartPose.rotation(((float)Math.PI / 2F), 0.0F, ((float)Math.PI * 1.5F)));
        return LayerDefinition.create(modelData, 64, 64);
    }

    public void render(FurnitureBedBlockEntity bedBlockEntity, float f, PoseStack matrixStack, MultiBufferSource vertexConsumerProvider, int i, int j, Vec3 vec3d) {
        Level world = bedBlockEntity.getLevel();
        if (world != null) {
            Material spriteIdentifier = Sheets.getBedMaterial(DyeColor.BLACK);
            BlockState blockState = bedBlockEntity.getBlockState();
            DoubleBlockCombiner.NeighborCombineResult<? extends FurnitureBedBlockEntity> propertySource = DoubleBlockCombiner.combineWithNeigbour(FurnitureBlockEntityType.Bed_BLOCK_ENTITY, BedBlock::getBlockType, BedBlock::getConnectedDirection, ChestBlock.FACING, blockState, world, bedBlockEntity.getBlockPos(), (worldx, pos) -> false);
            int k = ((Int2IntFunction)propertySource.apply(new BrightnessCombiner())).get(i);
            this.renderPart(matrixStack, vertexConsumerProvider, blockState.getValue(BedBlock.PART) == BedPart.HEAD ? this.bedHead : this.bedFoot, (Direction)blockState.getValue(BedBlock.FACING), spriteIdentifier, k, j, false);
        }

    }

    public void renderAsItem(PoseStack matrices, MultiBufferSource vertexConsumers, int light, int overlay, Material textureId) {
        this.renderPart(matrices, vertexConsumers, this.bedHead, Direction.SOUTH, textureId, light, overlay, false);
        this.renderPart(matrices, vertexConsumers, this.bedFoot, Direction.SOUTH, textureId, light, overlay, true);
    }

    private void renderPart(PoseStack matrices, MultiBufferSource vertexConsumers, Model model, Direction direction, Material sprite, int light, int overlay, boolean isFoot) {
        matrices.pushPose();
        setTransforms(matrices, isFoot, direction);
        VertexConsumer vertexConsumer = sprite.buffer(vertexConsumers, RenderType::entitySolid);
        model.renderToBuffer(matrices, vertexConsumer, light, overlay);
        matrices.popPose();
    }

    private static void setTransforms(PoseStack matrices, boolean isFoot, Direction direction) {
        matrices.translate(0.0F, 0.5625F, isFoot ? -1.0F : 0.0F);
        matrices.mulPose(Axis.XP.rotationDegrees(90.0F));
        matrices.translate(0.5F, 0.5F, 0.5F);
        matrices.mulPose(Axis.ZP.rotationDegrees(180.0F + direction.toYRot()));
        matrices.translate(-0.5F, -0.5F, -0.5F);
    }

    public void collectVertices(Set<Vector3f> vertices) {
        PoseStack matrixStack = new PoseStack();
        setTransforms(matrixStack, false, Direction.SOUTH);
        this.bedHead.root().getExtentsForGui(matrixStack, vertices);
        matrixStack.setIdentity();
        setTransforms(matrixStack, true, Direction.SOUTH);
        this.bedFoot.root().getExtentsForGui(matrixStack, vertices);
    }
}