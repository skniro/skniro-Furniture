package com.skniro.skniro_furniture.block.init;

import com.skniro.skniro_furniture.block.entity.CoffeeChairBlockEntity;
import com.skniro.skniro_furniture.entity.MapleEntityType;
import com.skniro.skniro_furniture.entity.furniture.ChairEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class CoffeeChairBlock extends HorizontalDirectionalBlock implements EntityBlock, BannerDecoratedBlock {
    private static final VoxelShape SHAPE = Block.box(2.0, 0.0, 2.0, 14.0, 8.0, 14.0);
    /** Longest names first so light_blue/light_gray win over blue/gray. */
    private static final DyeColor[] COLORS_LONGEST_FIRST = Arrays.stream(DyeColor.values())
            .sorted((a, b) -> Integer.compare(b.getName().length(), a.getName().length()))
            .toArray(DyeColor[]::new);

    @Nullable
    private DyeColor cachedColor;

    public CoffeeChairBlock(Properties settings) {
        super(settings);
    }

    /** The seat colour resolved from its block id (e.g. {@code oak_plank_coffee_chair_light_blue}). */
    public DyeColor getColor() {
        if (this.cachedColor == null) {
            Identifier id = BuiltInRegistries.BLOCK.getKey(this);
            if (id == null) {
                return DyeColor.WHITE;
            }
            String path = id.getPath();
            DyeColor resolved = DyeColor.WHITE;
            for (DyeColor candidate : COLORS_LONGEST_FIRST) {
                if (path.endsWith("_coffee_chair_" + candidate.getName())) {
                    resolved = candidate;
                    break;
                }
            }
            this.cachedColor = resolved;
        }
        return this.cachedColor;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CoffeeChairBlockEntity(pos, state);
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos,
                                          Player player, InteractionHand hand, BlockHitResult hit) {
        InteractionResult result = BannerDecorationHelper.useItemOn(stack, level, pos, state, player, hand);
        return result != InteractionResult.PASS
                ? result
                : super.useItemOn(stack, state, level, pos, player, hand, hit);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        if (player.isSecondaryUseActive()
                && BannerDecorationHelper.clearIfDecorated(level, pos, this.getDecorationPositions(level, pos, state))) {
            return InteractionResult.SUCCESS;
        }
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
    public List<BlockPos> getDecorationPositions(Level level, BlockPos pos, BlockState state) {
        return List.of(pos);
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
