package com.skniro.skniro_furniture.block.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.skniro.skniro_furniture.block.entity.MirrorBlockEntity;
import com.skniro.skniro_furniture.block.init.MirrorBlock;
import com.skniro.skniro_furniture.block.renderer.state.MirrorBlockEntityRendererState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

/**
 * Renders a live reflection of the local player on the mirror surface.
 *
 * <p>The player's current render state (skin, pose, armour and held items) is
 * drawn flattened into the mirror plane and mirrored across it, so the viewer
 * sees themselves the way they would in a real mirror. The glass is backed by
 * the material of the floor block underneath the mirror, so the reflection does
 * not look like a flat coloured pane.</p>
 */
public class MirrorBlockEntityRenderer implements BlockEntityRenderer<MirrorBlockEntity, MirrorBlockEntityRendererState> {
    private static final float FRONT_OFFSET = 0.02F;
    private static final float BACKGROUND_OFFSET = 0.01F;
    private static final float REFLECTION_DEPTH = 0.02F;
    private static final float REFLECTION_FEET_Y = 0.35F;
    private static final float REFLECTION_SCALE = 0.7F;
    private static final double MAX_DISTANCE = 16.0D;

    /** The glass opening inside the wooden frame, in block-local coordinates. */
    private static final float GLASS_MIN_X = 2.0F / 16.0F;
    private static final float GLASS_MAX_X = 14.0F / 16.0F;
    private static final float GLASS_MIN_Y = 2.0F / 16.0F;
    private static final float GLASS_MAX_Y = 30.0F / 16.0F;

    private static final int BACKGROUND_COLOR = 0xFFC4C8CC;

    private final EntityRenderDispatcher entityRenderDispatcher;

    public MirrorBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.entityRenderDispatcher = context.entityRenderer();
    }

    @Override
    public MirrorBlockEntityRendererState createRenderState() {
        return new MirrorBlockEntityRendererState();
    }

    @Override
    public void extractRenderState(MirrorBlockEntity entity, MirrorBlockEntityRendererState state, float tickProgress,
                                   Vec3 cameraPos, @Nullable ModelFeatureRenderer.CrumblingOverlay crumblingOverlay) {
        BlockEntityRenderer.super.extractRenderState(entity, state, tickProgress, cameraPos, crumblingOverlay);
        state.facing = entity.getBlockState().getValue(MirrorBlock.FACING);
        state.reflectedPlayer = null;
        state.backgroundSprite = null;

        if (entity.getBlockState().getValue(MirrorBlock.HALF) != DoubleBlockHalf.LOWER) {
            return;
        }
        Level level = entity.getLevel();
        if (level == null) {
            return;
        }

        BlockState floorState = findFloor(level, entity.getBlockPos());
        if (floorState != null) {
            Material.Baked material = Minecraft.getInstance().getModelManager().getBlockStateModelSet().getParticleMaterial(floorState);
            if (material != null) {
                state.backgroundSprite = material.sprite();
            }
        }

        LocalPlayer player = Minecraft.getInstance().player;
        if (player == null || player.isSpectator() || player.isInvisible()) {
            return;
        }

        Direction facing = state.facing;
        BlockPos pos = entity.getBlockPos();
        Vec3 normal = new Vec3(facing.getStepX(), 0.0D, facing.getStepZ());
        Vec3 mirrorCenter = new Vec3(pos.getX() + 0.5D, pos.getY() + 1.0D, pos.getZ() + 0.5D);
        Vec3 toPlayer = player.position().subtract(mirrorCenter);
        double frontDistance = toPlayer.dot(normal);
        if (frontDistance <= 0.05D || frontDistance > MAX_DISTANCE) {
            return;
        }
        if (toPlayer.lengthSqr() < 1.0D) {
            return;
        }

        EntityRenderState playerState = this.entityRenderDispatcher.extractEntity(player, tickProgress);
        if (playerState instanceof LivingEntityRenderState livingState) {
            livingState.nameTag = null;
            livingState.scoreText = null;
            livingState.shadowRadius = 0.0F;
            livingState.shadowPieces.clear();
            if (livingState.leashStates != null) {
                livingState.leashStates.clear();
            }
            livingState.displayFireAnimation = false;
            livingState.outlineColor = EntityRenderState.NO_OUTLINE;
            livingState.scale *= REFLECTION_SCALE;
            // Mirror the player's actual body direction across the mirror plane so the
            // reflection shows the player's front, back or side depending on how they stand.
            livingState.bodyRot = 2.0F * facing.toYRot() - livingState.bodyRot + 180.0F;
            // yRot/xRot are relative to the body rotation for humanoid models.
            livingState.yRot = -livingState.yRot;
            livingState.xRot = 0.0F;
            state.reflectedPlayer = livingState;
        }
    }

    @Nullable
    private static BlockState findFloor(Level level, BlockPos pos) {
        BlockPos below = pos.below();
        for (int i = 0; i < 8; i++) {
            BlockState candidate = level.getBlockState(below);
            if (!candidate.isAir()) {
                return candidate;
            }
            if (below.getY() <= level.getMinY()) {
                break;
            }
            below = below.below();
        }
        return null;
    }

    @Override
    public void submit(MirrorBlockEntityRendererState state, PoseStack poseStack, SubmitNodeCollector collector,
                       CameraRenderState cameraState) {
        if (state.backgroundSprite != null) {
            submitBackground(state, poseStack, collector);
        }

        EntityRenderState reflectedPlayer = state.reflectedPlayer;
        if (reflectedPlayer == null) {
            return;
        }

        float x = 0.5F;
        float z = 0.5F;
        switch (state.facing) {
            case NORTH -> z = 15.5F / 16.0F - FRONT_OFFSET;
            case SOUTH -> z = 0.5F / 16.0F + FRONT_OFFSET;
            case EAST -> x = 0.5F / 16.0F + FRONT_OFFSET;
            case WEST -> x = 15.5F / 16.0F - FRONT_OFFSET;
            default -> {
            }
        }

        poseStack.pushPose();
        poseStack.translate(x, REFLECTION_FEET_Y, z);
        switch (state.facing) {
            case NORTH, SOUTH -> poseStack.scale(1.0F, 1.0F, REFLECTION_DEPTH);
            case EAST, WEST -> poseStack.scale(REFLECTION_DEPTH, 1.0F, 1.0F);
            default -> {
            }
        }
        this.entityRenderDispatcher.submit(reflectedPlayer, cameraState, 0.0D, 0.0D, 0.0D, poseStack, collector);
        poseStack.popPose();
    }

    private static void submitBackground(MirrorBlockEntityRendererState state, PoseStack poseStack,
                                         SubmitNodeCollector collector) {
        TextureAtlasSprite sprite = state.backgroundSprite;
        if (sprite == null) {
            return;
        }
        RenderType renderType = RenderTypes.entityCutout(sprite.atlasLocation());
        float u0 = sprite.getU0();
        float u1 = sprite.getU1();
        float v0 = sprite.getV0();
        float v1 = sprite.getV1();
        int light = state.lightCoords;
        float nx = state.facing.getStepX();
        float nz = state.facing.getStepZ();

        float middle = (GLASS_MIN_Y + GLASS_MAX_Y) * 0.5F;
        collector.submitCustomGeometry(poseStack, renderType, (pose, consumer) -> {
            float min = GLASS_MIN_X;
            float max = GLASS_MAX_X;
            // Two stacked tiles keep the floor texture roughly square instead of stretching
            // it over the full two-block-tall glass.
            for (int tile = 0; tile < 2; tile++) {
                float bottom = tile == 0 ? GLASS_MIN_Y : middle;
                float top = tile == 0 ? middle : GLASS_MAX_Y;
                switch (state.facing) {
                    case NORTH -> {
                        float z = 15.5F / 16.0F - BACKGROUND_OFFSET;
                        vertex(consumer, pose, min, bottom, z, u0, v1, light, nx, nz);
                        vertex(consumer, pose, min, top, z, u0, v0, light, nx, nz);
                        vertex(consumer, pose, max, top, z, u1, v0, light, nx, nz);
                        vertex(consumer, pose, max, bottom, z, u1, v1, light, nx, nz);
                    }
                    case SOUTH -> {
                        float z = 0.5F / 16.0F + BACKGROUND_OFFSET;
                        vertex(consumer, pose, min, bottom, z, u0, v1, light, nx, nz);
                        vertex(consumer, pose, max, bottom, z, u1, v1, light, nx, nz);
                        vertex(consumer, pose, max, top, z, u1, v0, light, nx, nz);
                        vertex(consumer, pose, min, top, z, u0, v0, light, nx, nz);
                    }
                    case EAST -> {
                        float x = 0.5F / 16.0F + BACKGROUND_OFFSET;
                        vertex(consumer, pose, x, bottom, min, u0, v1, light, nx, nz);
                        vertex(consumer, pose, x, top, min, u0, v0, light, nx, nz);
                        vertex(consumer, pose, x, top, max, u1, v0, light, nx, nz);
                        vertex(consumer, pose, x, bottom, max, u1, v1, light, nx, nz);
                    }
                    case WEST -> {
                        float x = 15.5F / 16.0F - BACKGROUND_OFFSET;
                        vertex(consumer, pose, x, bottom, min, u0, v1, light, nx, nz);
                        vertex(consumer, pose, x, bottom, max, u1, v1, light, nx, nz);
                        vertex(consumer, pose, x, top, max, u1, v0, light, nx, nz);
                        vertex(consumer, pose, x, top, min, u0, v0, light, nx, nz);
                    }
                    default -> {
                    }
                }
            }
        });
    }

    private static void vertex(VertexConsumer consumer, PoseStack.Pose pose, float x, float y, float z,
                               float u, float v, int light, float normalX, float normalZ) {
        consumer.addVertex(pose, x, y, z)
                .setColor(BACKGROUND_COLOR)
                .setUv(u, v)
                .setOverlay(OverlayTexture.NO_OVERLAY)
                .setLight(light)
                .setNormal(pose, normalX, 0.0F, normalZ);
    }
}
