package com.skniro.skniro_furniture.block.init;

import com.mojang.serialization.MapCodec;
import com.skniro.skniro_furniture.block.entity.WallCabinetBlockEntity;
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


public class WallCabinetBlock extends AbstractWallCabinetBlock {
    public static final MapCodec<WallCabinetBlock> CODEC = simpleCodec(WallCabinetBlock::new);

    public MapCodec<WallCabinetBlock> codec() {
        return CODEC;
    }

    public WallCabinetBlock(Properties settings) {
        super(settings);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH)));
    }

    protected InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
        if (world instanceof ServerLevel serverWorld) {
            BlockEntity var8 = world.getBlockEntity(pos);
            if (var8 instanceof WallCabinetBlockEntity BlockEntity) {
                player.openMenu(BlockEntity);
                player.awardStat(Stats.OPEN_BARREL);
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    protected void tick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof WallCabinetBlockEntity) {
            ((WallCabinetBlockEntity)blockEntity).tick();
        }

    }

    @Override
    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new WallCabinetBlockEntity(pos, state);
    }
}
