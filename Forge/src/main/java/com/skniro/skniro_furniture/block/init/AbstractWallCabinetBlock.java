package com.skniro.skniro_furniture.block.init;

import com.skniro.skniro_furniture.block.entity.CabinetBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractWallCabinetBlock extends BaseEntityBlock {
    public static final EnumProperty<Direction> FACING;
    private static final VoxelShape NORTH_SHAPE;
    private static final VoxelShape SOUTH_SHAPE;
    private static final VoxelShape EAST_SHAPE;
    private static final VoxelShape WEST_SHAPE;

    public AbstractWallCabinetBlock(Properties settings) {
        super(settings);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH)));
    }

    protected InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
        if (world instanceof ServerLevel serverWorld) {
            BlockEntity var8 = world.getBlockEntity(pos);
            if (var8 instanceof CabinetBlockEntity CabinetBlockEntity) {
                player.openMenu(CabinetBlockEntity);
                player.awardStat(Stats.OPEN_BARREL);
            }
        }

        return InteractionResult.SUCCESS;
    }

    public void affectNeighborsAfterRemoval(BlockState state, ServerLevel world, BlockPos pos, boolean moved) {
        Containers.updateNeighboursAfterDestroy(state, world, pos);
        super.affectNeighborsAfterRemoval(state, world, pos, moved);
    }

    protected void tick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof CabinetBlockEntity) {
            ((CabinetBlockEntity)blockEntity).tick();
        }

    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CabinetBlockEntity(pos, state);
    }

    protected boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    protected int getAnalogOutputSignal(BlockState state, Level world, BlockPos pos) {
        return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(world.getBlockEntity(pos));
    }

    protected BlockState rotate(BlockState state, Rotation rotation) {
        return (BlockState)state.setValue(FACING, rotation.rotate((Direction)state.getValue(FACING)));
    }

    protected BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation((Direction)state.getValue(FACING)));
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

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        switch (direction){
            case EAST:
                return EAST_SHAPE;
            case SOUTH:
                return SOUTH_SHAPE;
            case WEST:
                return WEST_SHAPE;
            case NORTH:
            default:
                return NORTH_SHAPE;
        }
    }

    static {
        FACING = BlockStateProperties.HORIZONTAL_FACING;
        NORTH_SHAPE = Block.box(0.0, 0.0, 10.0, 16.0, 16.0, 16.0);
        SOUTH_SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 6.0);
        EAST_SHAPE = Block.box(0.0, 0.0, 0.0, 6.0, 16.0, 16.0);
        WEST_SHAPE = Block.box(10.0, 0.0, 0.0, 16.0, 16.0, 16.0);
    }
}
