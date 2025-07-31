package com.skniro.skniro_furniture.block.init;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Map;
import java.util.function.BiConsumer;

import net.minecraft.block.*;
import net.minecraft.block.enums.DoorHinge;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.block.WireOrientation;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.world.tick.ScheduledTickView;
import org.jetbrains.annotations.Nullable;

public class SlidingDoorBlock extends AbstractSlidingDoorBlock {
    public static final MapCodec<SlidingDoorBlock> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(BlockSetType.CODEC.fieldOf("block_set_type").forGetter(SlidingDoorBlock::getBlockSetType), createSettingsCodec()).apply(instance, SlidingDoorBlock::new));

    protected static final VoxelShape CLOSEB_SOUTH = Block.createCuboidShape(0.0D, 0.0D, 8.0D, 16.0D, 16.0D, 9.5D);
    protected static final VoxelShape CLOSEB_WEST =  Block.createCuboidShape(6.5D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D);
    protected static final VoxelShape CLOSEB_NORTH = Block.createCuboidShape(0.0D, 0.0D, 6.5D, 16.0D, 16.0D, 8.0D);
    protected static final VoxelShape CLOSEB_EAST =  Block.createCuboidShape(8.0D, 0.0D, 0.0D, 9.5D, 16.0D, 16.0D);

    protected static final VoxelShape OPENBR_SOUTH = Block.createCuboidShape(14.0D, 0.0D, 8.0D, 30.0D, 16.0D, 9.5D);
    protected static final VoxelShape OPENBR_WEST =  Block.createCuboidShape(6.5D, 0.0D, 14.0D, 8.0D, 16.0D, 30.0D);
    protected static final VoxelShape OPENBR_NORTH = Block.createCuboidShape(-14.0D, 0.0D, 6.5D, 2.0D, 16.0D, 8.0D);
    protected static final VoxelShape OPENBR_EAST =  Block.createCuboidShape(8.0D, 0.0D, -14.0D, 9.5D, 16.0D, 2.0D);

    protected static final VoxelShape OPENBL_SOUTH = Block.createCuboidShape(-14.0D, 0.0D, 8.0D, 2.0D, 16.0D, 9.5D);
    protected static final VoxelShape OPENBL_WEST =  Block.createCuboidShape(6.5D, 0.0D, -14.0D, 8.0D, 16.0D, 2.0D);
    protected static final VoxelShape OPENBL_NORTH = Block.createCuboidShape(14.0D, 0.0D, 6.5D, 30.0D, 16.0D, 8.0D);
    protected static final VoxelShape OPENBL_EAST =  Block.createCuboidShape(8.0D, 0.0D, 14.0D, 9.5D, 16.0D, 30.0D);

    protected static final VoxelShape CLOSE_SOUTH = Block.createCuboidShape(0.0D, 0.0D, 8.0D, 16.0D, 16.0D, 9.5D);
    protected static final VoxelShape CLOSE_WEST =  Block.createCuboidShape(6.5D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D);
    protected static final VoxelShape CLOSE_NORTH = Block.createCuboidShape(0.0D, 0.0D, 6.5D, 16.0D, 16.0D, 8.0D);
    protected static final VoxelShape CLOSE_EAST =  Block.createCuboidShape(8.0D, 0.0D, 0.0D, 9.5D, 16.0D, 16.0D);

    protected static final VoxelShape OPENR_SOUTH = Block.createCuboidShape(14.0D, 0.0D, 8.0D, 30.0D, 16.0D, 9.5D);
    protected static final VoxelShape OPENR_WEST =  Block.createCuboidShape(6.5D, 0.0D, 14.0D, 8.0D, 16.0D, 30.0D);
    protected static final VoxelShape OPENR_NORTH = Block.createCuboidShape(-14.0D, 0.0D, 6.5D, 2.0D, 16.0D, 8.0D);
    protected static final VoxelShape OPENR_EAST =  Block.createCuboidShape(8.0D, 0.0D, -14.0D, 9.5D, 16.0D, 2.0D);

    protected static final VoxelShape OPENL_SOUTH = Block.createCuboidShape(-14.0D, 0.0D, 8.0D, 2.0D, 16.0D, 9.5D);
    protected static final VoxelShape OPENL_WEST = Block.createCuboidShape(6.5D, 0.0D, -14.0D, 8.0D, 16.0D, 2.0D);
    protected static final VoxelShape OPENL_NORTH = Block.createCuboidShape(14.0D, 0.0D, 6.5D, 30.0D, 16.0D, 8.0D);
    protected static final VoxelShape OPENL_EAST = Block.createCuboidShape(8.0D, 0.0D, 14.0D, 9.5D, 16.0D, 30.0D);

    public MapCodec<? extends SlidingDoorBlock> getCodec() {
        return CODEC;
    }

    public SlidingDoorBlock(BlockSetType type, AbstractBlock.Settings settings) {
        super( type, settings);
        this.setDefaultState((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(FACING, Direction.NORTH)).with(OPEN, false)).with(HINGE, DoorHinge.LEFT)).with(POWERED, false)).with(HALF, DoubleBlockHalf.LOWER));
    }


    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction direction = state.get(FACING);
        DoubleBlockHalf half = state.get(HALF);
        boolean open = !state.get(OPEN);
        boolean right = (state.get(HINGE) == DoorHinge.RIGHT);

        switch (half) {
            case LOWER:
            default:
                switch (direction) {
                    case NORTH:
                    default:
                        return open? CLOSEB_NORTH : (right? OPENBL_NORTH : OPENBR_NORTH);
                    case SOUTH:
                        return open? CLOSEB_SOUTH : (right? OPENBL_SOUTH : OPENBR_SOUTH);
                    case WEST:
                        return open? CLOSEB_WEST : (right? OPENBL_WEST : OPENBR_WEST);
                    case EAST:
                        return open? CLOSEB_EAST : (right? OPENBL_EAST : OPENBR_EAST);
                }

            case UPPER:
                switch (direction) {
                    case NORTH:
                    default:
                        return open? CLOSE_NORTH : (right? OPENL_NORTH : OPENR_NORTH);
                    case SOUTH:
                        return open? CLOSE_SOUTH : (right? OPENL_SOUTH : OPENR_SOUTH);
                    case WEST:
                        return open? CLOSE_WEST : (right? OPENL_WEST : OPENR_WEST);
                    case EAST:
                        return open? CLOSE_EAST : (right? OPENL_EAST : OPENR_EAST);
                }
        }
    }
}
