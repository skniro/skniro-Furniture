package com.skniro.skniro_furniture.block.init;

import com.skniro.skniro_furniture.block.entity.MirrorBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class MirrorBlock extends HorizontalDirectionalBlock implements EntityBlock {
    public static final EnumProperty<DoubleBlockHalf> HALF;
    private static final VoxelShape NORTH_SHAPE;
    private static final VoxelShape SOUTH_SHAPE;
    private static final VoxelShape EAST_SHAPE;
    private static final VoxelShape WEST_SHAPE;

    public MirrorBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(HALF, DoubleBlockHalf.LOWER));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        Direction face = ctx.getClickedFace();
        if (!face.getAxis().isHorizontal()) {
            return null;
        }
        Level world = ctx.getLevel();
        BlockPos pos = ctx.getClickedPos();
        if (pos.getY() >= world.getMaxY() - 1 || !world.getBlockState(pos.above()).canBeReplaced(ctx)) {
            return null;
        }
        BlockPos wallPos = pos.relative(face.getOpposite());
        if (!world.getBlockState(wallPos).isFaceSturdy(world, wallPos, face)) {
            return null;
        }
        BlockPos upperWallPos = wallPos.above();
        if (!world.getBlockState(upperWallPos).isFaceSturdy(world, upperWallPos, face)) {
            return null;
        }
        return this.defaultBlockState().setValue(FACING, face).setValue(HALF, DoubleBlockHalf.LOWER);
    }

    @Override
    public void setPlacedBy(Level world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        world.setBlock(pos.above(), state.setValue(HALF, DoubleBlockHalf.UPPER), 3);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return state.getValue(HALF) == DoubleBlockHalf.LOWER ? new MirrorBlockEntity(pos, state) : null;
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        Direction facing = state.getValue(FACING);
        BlockPos wallPos = pos.relative(facing.getOpposite());
        if (!world.getBlockState(wallPos).isFaceSturdy(world, wallPos, facing)) {
            return false;
        }
        if (state.getValue(HALF) == DoubleBlockHalf.UPPER) {
            BlockState lowerState = world.getBlockState(pos.below());
            return lowerState.is(this) && lowerState.getValue(HALF) == DoubleBlockHalf.LOWER;
        }
        return true;
    }

    @Override
    protected BlockState updateShape(BlockState state, LevelReader world, ScheduledTickAccess tickView, BlockPos pos,
                                     Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource random) {
        DoubleBlockHalf half = state.getValue(HALF);
        if (direction.getAxis() == Direction.Axis.Y && half == DoubleBlockHalf.LOWER == (direction == Direction.UP)) {
            return neighborState.is(this) && neighborState.getValue(HALF) != half ? state : Blocks.AIR.defaultBlockState();
        }
        return state.canSurvive(world, pos) ? super.updateShape(state, world, tickView, pos, direction, neighborPos, neighborState, random) : Blocks.AIR.defaultBlockState();
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case EAST -> EAST_SHAPE;
            case SOUTH -> SOUTH_SHAPE;
            case WEST -> WEST_SHAPE;
            default -> NORTH_SHAPE;
        };
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, HALF);
    }

    static {
        HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
        NORTH_SHAPE = Block.box(0.0, 0.0, 15.5, 16.0, 16.0, 16.0);
        SOUTH_SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 0.5);
        EAST_SHAPE = Block.box(0.0, 0.0, 0.0, 0.5, 16.0, 16.0);
        WEST_SHAPE = Block.box(15.5, 0.0, 0.0, 16.0, 16.0, 16.0);
    }
}
