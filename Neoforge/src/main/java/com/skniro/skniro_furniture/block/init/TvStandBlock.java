package com.skniro.skniro_furniture.block.init;

import com.mojang.serialization.MapCodec;
import com.skniro.skniro_furniture.block.entity.TvStandBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;


public class TvStandBlock extends AbstractFurnitureContainerBlock {
    public static final MapCodec<TvStandBlock> CODEC = simpleCodec(TvStandBlock::new);

    public MapCodec<TvStandBlock> codec() {
        return CODEC;
    }

    public TvStandBlock(Properties settings) {
        super(settings);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH)));
    }

    protected InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
        if (world instanceof ServerLevel serverWorld) {
            BlockEntity var8 = world.getBlockEntity(pos);
            if (var8 instanceof TvStandBlockEntity BlockEntity) {
                player.openMenu(BlockEntity);
                player.awardStat(Stats.OPEN_BARREL);
            }
        }

        return InteractionResult.SUCCESS;
    }

    protected void tick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof TvStandBlockEntity) {
            ((TvStandBlockEntity)blockEntity).tick();
        }

    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TvStandBlockEntity(pos, state);
    }
}
