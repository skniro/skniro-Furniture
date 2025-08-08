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

    protected static final VoxelShape CLOSEB_SOUTH = Block.createCuboidShape(0.0D, 0.0D, 7.5D, 16.0D, 16.0D, 8.5D);
    protected static final VoxelShape CLOSEB_WEST =  Block.createCuboidShape(7.5D, 0.0D, 0.0D, 8.5D, 16.0D, 16.0D);
    protected static final VoxelShape CLOSEB_NORTH = Block.createCuboidShape(0.0D, 0.0D, 7.5D, 16.0D, 16.0D, 8.5D);
    protected static final VoxelShape CLOSEB_EAST =  Block.createCuboidShape(7.5D, 0.0D, 0.0D, 8.5D, 16.0D, 16.0D);

    protected static final VoxelShape OPENBR_SOUTH = Block.createCuboidShape(14.0D, 0.0D, 7.5D, 30.0D, 16.0D, 8.5D);
    protected static final VoxelShape OPENBR_WEST =  Block.createCuboidShape(7.5D, 0.0D, 14.0D, 8.5D, 16.0D, 30.0D);
    protected static final VoxelShape OPENBR_NORTH = Block.createCuboidShape(-14.0D, 0.0D, 7.5D, 2.0D, 16.0D, 8.5D);
    protected static final VoxelShape OPENBR_EAST =  Block.createCuboidShape(7.5D, 0.0D, -14.0D, 8.5D, 16.0D, 2.0D);

    protected static final VoxelShape OPENBL_SOUTH = Block.createCuboidShape(-14.0D, 0.0D, 7.5D, 2.0D, 16.0D, 8.5D);
    protected static final VoxelShape OPENBL_WEST =  Block.createCuboidShape(7.5D, 0.0D, -14.0D, 8.5D, 16.0D, 2.0D);
    protected static final VoxelShape OPENBL_NORTH = Block.createCuboidShape(14.0D, 0.0D, 7.5D, 30.0D, 16.0D, 8.5D);
    protected static final VoxelShape OPENBL_EAST =  Block.createCuboidShape(7.5D, 0.0D, 14.0D, 8.5D, 16.0D, 30.0D);

    protected static final VoxelShape CLOSET_SOUTH = Block.createCuboidShape(0.0D, 0.0D, 7.5D, 16.0D, 16.0D, 8.5D);
    protected static final VoxelShape CLOSET_WEST =  Block.createCuboidShape(7.5D, 0.0D, 0.0D, 8.5D, 16.0D, 16.0D);
    protected static final VoxelShape CLOSET_NORTH = Block.createCuboidShape(0.0D, 0.0D, 7.5D, 16.0D, 16.0D, 8.5D);
    protected static final VoxelShape CLOSET_EAST =  Block.createCuboidShape(7.5D, 0.0D, 0.0D, 8.5D, 16.0D, 16.0D);

    protected static final VoxelShape OPENTR_SOUTH = Block.createCuboidShape(14.0D, 0.0D, 7.5D, 30.0D, 16.0D, 8.5D);
    protected static final VoxelShape OPENTR_WEST =  Block.createCuboidShape(7.5D, 0.0D, 14.0D, 8.5D, 16.0D, 30.0D);
    protected static final VoxelShape OPENTR_NORTH = Block.createCuboidShape(-14.0D, 0.0D, 7.5D, 2.0D, 16.0D, 8.5D);
    protected static final VoxelShape OPENTR_EAST =  Block.createCuboidShape(7.5D, 0.0D, -14.0D, 8.5D, 16.0D, 2.0D);

    protected static final VoxelShape OPENTL_SOUTH = Block.createCuboidShape(-14.0D, 0.0D, 7.5D, 2.0D, 16.0D, 8.5D);
    protected static final VoxelShape OPENTL_WEST = Block.createCuboidShape(7.5D, 0.0D, -14.0D, 8.5D, 16.0D, 2.0D);
    protected static final VoxelShape OPENTL_NORTH = Block.createCuboidShape(14.0D, 0.0D, 7.5D, 30.0D, 16.0D, 8.5D);
    protected static final VoxelShape OPENTL_EAST = Block.createCuboidShape(7.5D, 0.0D, 14.0D, 8.5D, 16.0D, 30.0D);

    public MapCodec<? extends SlidingDoorBlock> getCodec() {
        return CODEC;
    }

    public SlidingDoorBlock(BlockSetType type, Settings settings) {
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
                        return open? CLOSET_NORTH : (right? OPENTL_NORTH : OPENTR_NORTH);
                    case SOUTH:
                        return open? CLOSET_SOUTH : (right? OPENTL_SOUTH : OPENTR_SOUTH);
                    case WEST:
                        return open? CLOSET_WEST : (right? OPENTL_WEST : OPENTR_WEST);
                    case EAST:
                        return open? CLOSET_EAST : (right? OPENTL_EAST : OPENTR_EAST);
                }
        }
    }
}
