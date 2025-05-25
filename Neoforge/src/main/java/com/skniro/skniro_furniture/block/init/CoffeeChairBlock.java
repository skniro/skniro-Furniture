package com.skniro.skniro_furniture.block.init;

import com.mojang.serialization.MapCodec;
import com.skniro.skniro_furniture.entity.MapleEntityType;
import com.skniro.skniro_furniture.entity.furniture.ChairEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CoffeeChairBlock extends HorizontalDirectionalBlock {
    private static final VoxelShape SHAPE = Block.box(2.0, 0.0, 2.0, 14.0, 8.0, 14.0);
    public static final MapCodec<CoffeeChairBlock> CODEC = simpleCodec(CoffeeChairBlock::new);
    public CoffeeChairBlock(Properties settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }


    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        if(!level.isClientSide()) {
            Entity entity = null;
            List<ChairEntity> entities = level.getEntities(MapleEntityType.CHAIR_ENTITY.get(), new AABB(pos), chair -> true);
            if(entities.isEmpty()) {
                entity = MapleEntityType.CHAIR_ENTITY.get().spawn(((ServerLevel) level), pos, EntitySpawnReason.TRIGGERED);
            } else {
                entity = entities.get(0);
            }
            player.startRiding(entity);
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite());
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}