package com.skniro.skniro_furniture.block.init;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.*;
import net.minecraft.block.enums.DoorHinge;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class WindowBlock extends HorizontalFacingBlock {
    public static final MapCodec<WindowBlock> CODEC = RecordCodecBuilder.mapCodec((instance) -> {
        return instance.group(createSettingsCodec(),BlockSetType.CODEC.fieldOf("block_set_type").forGetter((block) -> {
            return block.blockSetType;
        })).apply(instance, WindowBlock::new);
    });
    public static final EnumProperty<Direction> FACING;
    public static final EnumProperty<DoorHinge> HINGE;
    public static final BooleanProperty OPEN;
    public static final BooleanProperty POWERED;
    public static final VoxelShape WEST_OPEN_SHAPE;
    public static final VoxelShape EAST_OPEN_SHAPE;
    public static final VoxelShape NORTH_OPEN_SHAPE;
    public static final VoxelShape SOUTH_OPEN_SHAPE;

    public static final VoxelShape WEST_CLOSED_SHAPE;
    public static final VoxelShape EAST_CLOSED_SHAPE;
    public static final VoxelShape NORTH_CLOSED_SHAPE;
    public static final VoxelShape SOUTH_CLOSED_SHAPE;
    private final BlockSetType blockSetType;

    public WindowBlock(Settings settings, BlockSetType blockSetType) {
        super(settings.sounds(blockSetType.soundType()));
        this.blockSetType = blockSetType;
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(FACING, Direction.NORTH)
                .with(OPEN, false)
                .with(HINGE, DoorHinge.LEFT)
                .with(POWERED, false));
    }


    public BlockSetType getBlockSetType() {
        return this.blockSetType;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction direction = state.get(FACING);
        boolean closed = !state.get(OPEN);
        boolean bl2 = state.get(HINGE) == DoorHinge.RIGHT;
        switch (direction) {
            case EAST:
                return closed ? EAST_CLOSED_SHAPE : (bl2 ? WEST_OPEN_SHAPE : EAST_OPEN_SHAPE);
            case SOUTH:
                return closed ? SOUTH_CLOSED_SHAPE : (bl2 ? NORTH_OPEN_SHAPE :SOUTH_OPEN_SHAPE);
            case WEST:
                return closed ? WEST_CLOSED_SHAPE : (bl2 ? EAST_OPEN_SHAPE :WEST_OPEN_SHAPE);
            case NORTH:
            default:
                return closed ? NORTH_CLOSED_SHAPE : (bl2 ? SOUTH_OPEN_SHAPE : NORTH_OPEN_SHAPE);
        }
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockPos blockPos = ctx.getBlockPos();
        World world = ctx.getWorld();
        boolean powered = world.isReceivingRedstonePower(blockPos);
        return this.getDefaultState()
                .with(FACING, ctx.getHorizontalPlayerFacing())
                .with(POWERED, powered)
                .with(HINGE, this.getHinge(ctx))
                .with(OPEN, powered);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!this.blockSetType.canOpenByHand()) {
            return ActionResult.PASS;
        }

        state = state.cycle(OPEN);
        world.setBlockState(pos, state, 10);
        this.playOpenCloseSound(player, world, pos, state.get(OPEN));
        world.emitGameEvent(player, state.get(OPEN) ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);

        return ActionResult.SUCCESS;
    }

    private DoorHinge getHinge(ItemPlacementContext ctx) {
        BlockView blockView = ctx.getWorld();
        BlockPos blockPos = ctx.getBlockPos();
        Direction direction = ctx.getHorizontalPlayerFacing();
        BlockPos blockPos2 = blockPos.up();
        Direction direction2 = direction.rotateYCounterclockwise();
        BlockPos blockPos3 = blockPos.offset(direction2);
        BlockState blockState = blockView.getBlockState(blockPos3);
        BlockPos blockPos4 = blockPos2.offset(direction2);
        BlockState blockState2 = blockView.getBlockState(blockPos4);
        Direction direction3 = direction.rotateYClockwise();
        BlockPos blockPos5 = blockPos.offset(direction3);
        BlockState blockState3 = blockView.getBlockState(blockPos5);
        BlockPos blockPos6 = blockPos2.offset(direction3);
        BlockState blockState4 = blockView.getBlockState(blockPos6);
        int i = (blockState.isFullCube(blockView, blockPos3) ? -1 : 0) + (blockState2.isFullCube(blockView, blockPos4) ? -1 : 0) + (blockState3.isFullCube(blockView, blockPos5) ? 1 : 0) + (blockState4.isFullCube(blockView, blockPos6) ? 1 : 0);
        if (i <= 0) {
            if (i >= 0) {
                int j = direction.getOffsetX();
                int k = direction.getOffsetZ();
                Vec3d vec3d = ctx.getHitPos();
                double d = vec3d.x - (double)blockPos.getX();
                double e = vec3d.z - (double)blockPos.getZ();
                return (j >= 0 || !(e < 0.5)) && (j <= 0 || !(e > 0.5)) && (k >= 0 || !(d > 0.5)) && (k <= 0 || !(d < 0.5)) ? DoorHinge.LEFT : DoorHinge.RIGHT;
            } else {
                return DoorHinge.LEFT;
            }
        } else {
            return DoorHinge.RIGHT;
        }
    }

    private void playOpenCloseSound(@Nullable Entity entity, World world, BlockPos pos, boolean open) {
        world.playSound(entity, pos, open ? this.blockSetType.doorOpen() : this.blockSetType.doorClose(), SoundCategory.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.1F + 0.9F);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, OPEN, HINGE, POWERED);
    }

    static {
        FACING = HorizontalFacingBlock.FACING;
        OPEN = Properties.OPEN;
        HINGE = Properties.DOOR_HINGE;
        POWERED = Properties.POWERED;


        WEST_CLOSED_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 1.5, 16.0, 16.0);
        EAST_CLOSED_SHAPE = Block.createCuboidShape(14.5, 0.0, 0.0, 16.0, 16.0, 16.0);
        NORTH_CLOSED_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 1.5);
        SOUTH_CLOSED_SHAPE = Block.createCuboidShape(0.0, 0.0, 14.5, 16.0, 16.0, 16.0);

        WEST_OPEN_SHAPE = Block.createCuboidShape(0.0, 0.0, 14.5, 16.0, 16.0, 16.0);
        EAST_OPEN_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 1.5);
        NORTH_OPEN_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 1.5, 16.0, 16.0);
        SOUTH_OPEN_SHAPE = Block.createCuboidShape(14.5, 0.0, 0.0, 16.0, 16.0, 16.0);
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return CODEC;
    }
}

