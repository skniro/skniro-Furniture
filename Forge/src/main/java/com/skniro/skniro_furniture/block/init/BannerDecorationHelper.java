package com.skniro.skniro_furniture.block.init;

import com.skniro.skniro_furniture.block.entity.AbstractBannerDecoratedBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
import java.util.function.Consumer;

/**
 * Shared dye/banner interaction logic for {@link BannerDecoratedBlock}s.
 */
public final class BannerDecorationHelper {
    /** Same limit as the vanilla banner block entity. */
    private static final int MAX_PATTERNS = 6;

    private BannerDecorationHelper() {
    }

    public static InteractionResult useItemOn(ItemStack stack, Level world, BlockPos pos, BlockState state,
                                              Player player, InteractionHand hand) {
        if (!(state.getBlock() instanceof BannerDecoratedBlock holder)) {
            return InteractionResult.PASS;
        }
        if (stack.isEmpty()) {
            return InteractionResult.TRY_WITH_EMPTY_HAND;
        }

        List<BlockPos> positions = holder.getDecorationPositions(world, pos, state);

        DyeColor dyeColor = stack.get(DataComponents.DYE);
        if (dyeColor != null) {
            if (!world.isClientSide()) {
                apply(world, positions, be -> be.setBaseColor(dyeColor));
                world.playSound(null, pos, SoundEvents.DYE_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
                stack.consume(1, player);
            }
            return InteractionResult.SUCCESS;
        }

        var providedPatterns = stack.get(DataComponents.PROVIDES_BANNER_PATTERNS);
        if (providedPatterns != null && providedPatterns.size() > 0) {
            InteractionHand otherHand = hand == InteractionHand.MAIN_HAND ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;
            ItemStack otherStack = player.getItemInHand(otherHand);
            DyeColor layerColor = otherStack.get(DataComponents.DYE);
            if (layerColor != null) {
                if (!world.isClientSide()) {
                    var pattern = providedPatterns.get(0);
                    apply(world, positions, be -> {
                        if (be.getPatterns().layers().size() < MAX_PATTERNS) {
                            BannerPatternLayers layers = new BannerPatternLayers.Builder()
                                    .addAll(be.getPatterns())
                                    .add(pattern, layerColor)
                                    .build();
                            be.setPatterns(layers);
                        }
                    });
                    world.playSound(null, pos, SoundEvents.DYE_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
                    otherStack.consume(1, player);
                }
                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.PASS;
    }

    public static boolean hasDecorations(Level world, List<BlockPos> positions) {
        for (BlockPos pos : positions) {
            if (world.getBlockEntity(pos) instanceof AbstractBannerDecoratedBlockEntity be && be.isDecorated()) {
                return true;
            }
        }
        return false;
    }

    public static boolean clearIfDecorated(Level world, BlockPos soundPos, List<BlockPos> positions) {
        if (!hasDecorations(world, positions)) {
            return false;
        }
        if (!world.isClientSide()) {
            apply(world, positions, AbstractBannerDecoratedBlockEntity::clearDecorations);
            world.playSound(null, soundPos, SoundEvents.WOOL_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
        }
        return true;
    }

    private static void apply(Level world, List<BlockPos> positions, Consumer<AbstractBannerDecoratedBlockEntity> action) {
        for (BlockPos pos : positions) {
            if (world.getBlockEntity(pos) instanceof AbstractBannerDecoratedBlockEntity be) {
                action.accept(be);
            }
        }
    }
}
