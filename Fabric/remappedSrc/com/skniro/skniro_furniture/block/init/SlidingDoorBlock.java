package com.skniro.skniro_furniture.block.init;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Map;
import java.util.function.BiConsumer;

import net.minecraft.block.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class SlidingDoorBlock extends AbstractSlidingDoorBlock {
    public static final MapCodec<SlidingDoorBlock> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(BlockSetType.CODEC.fieldOf("block_set_type").forGetter(SlidingDoorBlock::getBlockSetType), propertiesCodec()).apply(instance, SlidingDoorBlock::new));

    protected static final VoxelShape CLOSEB_SOUTH = Block.box(0.0D, 0.0D, 7.5D, 16.0D, 16.0D, 8.5D);
    protected static final VoxelShape CLOSEB_WEST =  Block.box(7.5D, 0.0D, 0.0D, 8.5D, 16.0D, 16.0D);
    protected static final VoxelShape CLOSEB_NORTH = Block.box(0.0D, 0.0D, 7.5D, 16.0D, 16.0D, 8.5D);
    protected static final VoxelShape CLOSEB_EAST =  Block.box(7.5D, 0.0D, 0.0D, 8.5D, 16.0D, 16.0D);

    protected static final VoxelShape OPENBR_SOUTH = Block.box(14.0D, 0.0D, 7.5D, 30.0D, 16.0D, 8.5D);
    protected static final VoxelShape OPENBR_WEST =  Block.box(7.5D, 0.0D, 14.0D, 8.5D, 16.0D, 30.0D);
    protected static final VoxelShape OPENBR_NORTH = Block.box(-14.0D, 0.0D, 7.5D, 2.0D, 16.0D, 8.5D);
    protected static final VoxelShape OPENBR_EAST =  Block.box(7.5D, 0.0D, -14.0D, 8.5D, 16.0D, 2.0D);

    protected static final VoxelShape OPENBL_SOUTH = Block.box(-14.0D, 0.0D, 7.5D, 2.0D, 16.0D, 8.5D);
    protected static final VoxelShape OPENBL_WEST =  Block.box(7.5D, 0.0D, -14.0D, 8.5D, 16.0D, 2.0D);
    protected static final VoxelShape OPENBL_NORTH = Block.box(14.0D, 0.0D, 7.5D, 30.0D, 16.0D, 8.5D);
    protected static final VoxelShape OPENBL_EAST =  Block.box(7.5D, 0.0D, 14.0D, 8.5D, 16.0D, 30.0D);

    protected static final VoxelShape CLOSET_SOUTH = Block.box(0.0D, 0.0D, 7.5D, 16.0D, 16.0D, 8.5D);
    protected static final VoxelShape CLOSET_WEST =  Block.box(7.5D, 0.0D, 0.0D, 8.5D, 16.0D, 16.0D);
    protected static final VoxelShape CLOSET_NORTH = Block.box(0.0D, 0.0D, 7.5D, 16.0D, 16.0D, 8.5D);
    protected static final VoxelShape CLOSET_EAST =  Block.box(7.5D, 0.0D, 0.0D, 8.5D, 16.0D, 16.0D);

    protected static final VoxelShape OPENTR_SOUTH = Block.box(14.0D, 0.0D, 7.5D, 30.0D, 16.0D, 8.5D);
    protected static final VoxelShape OPENTR_WEST =  Block.box(7.5D, 0.0D, 14.0D, 8.5D, 16.0D, 30.0D);
    protected static final VoxelShape OPENTR_NORTH = Block.box(-14.0D, 0.0D, 7.5D, 2.0D, 16.0D, 8.5D);
    protected static final VoxelShape OPENTR_EAST =  Block.box(7.5D, 0.0D, -14.0D, 8.5D, 16.0D, 2.0D);

    protected static final VoxelShape OPENTL_SOUTH = Block.box(-14.0D, 0.0D, 7.5D, 2.0D, 16.0D, 8.5D);
    protected static final VoxelShape OPENTL_WEST = Block.box(7.5D, 0.0D, -14.0D, 8.5D, 16.0D, 2.0D);
    protected static final VoxelShape OPENTL_NORTH = Block.box(14.0D, 0.0D, 7.5D, 30.0D, 16.0D, 8.5D);
    protected static final VoxelShape OPENTL_EAST = Block.box(7.5D, 0.0D, 14.0D, 8.5D, 16.0D, 30.0D);

    public MapCodec<? extends SlidingDoorBlock> codec() {
        return CODEC;
    }

    public SlidingDoorBlock(BlockSetType type, BlockBehaviour.Properties settings) {
        super( type, settings);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH)).setValue(OPEN, false)).setValue(HINGE, DoorHingeSide.LEFT)).setValue(POWERED, false)).setValue(HALF, DoubleBlockHalf.LOWER));
    }


    protected VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        DoubleBlockHalf half = state.getValue(HALF);
        boolean open = !state.getValue(OPEN);
        boolean right = (state.getValue(HINGE) == DoorHingeSide.RIGHT);

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
