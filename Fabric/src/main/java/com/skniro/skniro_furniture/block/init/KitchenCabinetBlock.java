package com.skniro.skniro_furniture.block.init;

import com.mojang.serialization.MapCodec;
import com.skniro.skniro_furniture.block.entity.BedsideCabinetBlockEntity;
import com.skniro.skniro_furniture.block.entity.DrawerBlockEntity;
import com.skniro.skniro_furniture.block.entity.KitchenCabinetBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public class KitchenCabinetBlock extends AbstractFurnitureContainerBlock {
    public static final MapCodec<KitchenCabinetBlock> CODEC = createCodec(KitchenCabinetBlock::new);

    public MapCodec<KitchenCabinetBlock> getCodec() {
        return CODEC;
    }

    public KitchenCabinetBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(FACING, Direction.NORTH)));
    }

    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world instanceof ServerWorld serverWorld) {
            BlockEntity var8 = world.getBlockEntity(pos);
            if (var8 instanceof KitchenCabinetBlockEntity KitchenCounterDrawerBlockEntity) {
                player.openHandledScreen(KitchenCounterDrawerBlockEntity);
                player.incrementStat(Stats.OPEN_BARREL);
            }
        }

        return ActionResult.SUCCESS;
    }

    protected void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof BedsideCabinetBlockEntity) {
            ((KitchenCabinetBlockEntity)blockEntity).tick();
        }

    }

    @Nullable
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new KitchenCabinetBlockEntity(pos, state);
    }
}
