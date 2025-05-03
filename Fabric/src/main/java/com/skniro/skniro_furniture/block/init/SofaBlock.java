package com.skniro.skniro_furniture.block.init;

import com.mojang.serialization.MapCodec;
import com.skniro.skniro_furniture.entity.MapleEntityType;
import com.skniro.skniro_furniture.entity.furniture.ChairEntity;
import com.skniro.skniro_furniture.entity.furniture.SofaEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.block.WireOrientation;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SofaBlock extends HorizontalFacingBlock {
    public static final BooleanProperty LEFT = BooleanProperty.of("left");
    public static final BooleanProperty RIGHT = BooleanProperty.of("right");

    public static final MapCodec<SofaBlock> CODEC = createCodec(SofaBlock::new);

    private static final VoxelShape SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 16.0);

    public SofaBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(LEFT,false).with(RIGHT,false));
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return CODEC;
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, @Nullable WireOrientation wireOrientation, boolean notify) {
        super.neighborUpdate(state, world, pos, sourceBlock, wireOrientation, notify);

        if (world.isClient()) return;

        Direction direction = (Direction) state.get(FACING);
        BlockState blockState = world.getBlockState(pos.offset(direction));
        if (isCounter(blockState)) {
            Direction direction2 = (Direction) blockState.get(FACING);
            if (direction2.getAxis() != ((Direction) state.get(FACING)).getAxis() && isDifferentOrientation(state, world, pos, direction2.getOpposite())) {
                boolean leftConnected = isLeftConnected(world, pos, direction);
                boolean rightConnected = isRightConnected(world, pos, direction);

                BlockState newState = state.with(LEFT, leftConnected).with(RIGHT, rightConnected);
                if (!newState.equals(state)) {
                    world.setBlockState(pos, newState, Block.NOTIFY_LISTENERS);
                }
            }
        }
    }

    @Override
    protected ActionResult onUse(BlockState state, World level, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if(!level.isClient()) {
            Entity entity = null;
            List<SofaEntity> entities = level.getEntitiesByType(MapleEntityType.SOFA_ENTITY, new Box(pos), chair -> true);
            if(entities.isEmpty()) {
                entity = MapleEntityType.SOFA_ENTITY.spawn(((ServerWorld) level), pos, SpawnReason.TRIGGERED);
            } else {
                entity = entities.get(0);
            }
            player.startRiding(entity);
        }
        return ActionResult.SUCCESS;
    }


    public static boolean isCounter(BlockState state) {
        return state.getBlock() instanceof SofaBlock;
    }

    private static boolean isDifferentOrientation(BlockState state, BlockView world, BlockPos pos, Direction dir) {
        BlockState blockState = world.getBlockState(pos.offset(dir));
        return !isCounter(blockState) || blockState.get(FACING) != state.get(FACING);
    }

    private boolean isLeftConnected(World world, BlockPos pos, Direction facing) {
        BlockState neighborState = world.getBlockState(pos.offset(facing.rotateYCounterclockwise()));
        return neighborState.getBlock() == this && neighborState.get(FACING) == facing;
    }

    private boolean isRightConnected(World world, BlockPos pos, Direction facing) {
        BlockState neighborState = world.getBlockState(pos.offset(facing.rotateYClockwise()));
        return neighborState.getBlock() == this && neighborState.get(FACING) == facing;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        Direction facing = context.getHorizontalPlayerFacing().getOpposite();

        return this.getDefaultState().with(FACING, facing);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, LEFT, RIGHT);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}
