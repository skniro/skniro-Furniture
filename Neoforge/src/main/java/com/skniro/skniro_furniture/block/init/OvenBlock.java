package com.skniro.skniro_furniture.block.init;

import com.mojang.serialization.MapCodec;
import com.skniro.skniro_furniture.block.entity.FurnitureBlockEntityType;
import com.skniro.skniro_furniture.block.entity.OvenBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class OvenBlock extends AbstractFurnaceBlock {
    public static final MapCodec<OvenBlock> CODEC = simpleCodec(OvenBlock::new);

    public MapCodec<OvenBlock> codec() {
        return CODEC;
    }

    public OvenBlock(Properties settings) {
        super(settings);
    }

    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new OvenBlockEntity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type) {
        return createFurnaceTicker(world, type, FurnitureBlockEntityType.OVEN_BLOCK_ENTITY.get());
    }

    protected void openContainer(Level world, BlockPos pos, Player player) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof OvenBlockEntity) {
            player.openMenu((MenuProvider)blockEntity);
            player.awardStat(Stats.INTERACT_WITH_SMOKER);
        }

    }

    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random) {
        if ((Boolean)state.getValue(LIT)) {
            double d = (double)pos.getX() + 0.5;
            double e = (double)pos.getY();
            double f = (double)pos.getZ() + 0.5;
            if (random.nextDouble() < 0.1) {
                world.playLocalSound(d, e, f, SoundEvents.FURNACE_FIRE_CRACKLE, SoundSource.BLOCKS, 1.0F, 1.0F, false);
            }

            Direction direction = (Direction)state.getValue(FACING);
            Direction.Axis axis = direction.getAxis();
            double g = 0.52;
            double h = random.nextDouble() * 0.6 - 0.3;
            double i = axis == Direction.Axis.X ? (double)direction.getStepX() * 0.52 : h;
            double j = random.nextDouble() * 6.0 / 16.0;
            double k = axis == Direction.Axis.Z ? (double)direction.getStepZ() * 0.52 : h;
        }
    }
}
