package com.skniro.skniro_furniture.block.init;

import com.mojang.serialization.MapCodec;
import com.skniro.skniro_furniture.block.entity.BookDeskBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;


public class BookDeskBlock extends BaseEntityBlock {
    private static final VoxelShape SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0);
    public static final MapCodec<BookDeskBlock> CODEC = simpleCodec(BookDeskBlock::new);
    public static final EnumProperty<Direction> FACING;
    public static final BooleanProperty HAS_BOOK;

    public BookDeskBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(((this.stateDefinition.any()).setValue(FACING, Direction.NORTH)).setValue(HAS_BOOK, false));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return (BlockState)state.setValue(FACING, rotation.rotate((Direction)state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation((Direction)state.getValue(FACING)));
    }

    @Override
    public boolean useShapeForLightOcclusion(BlockState state) {
        return true;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        Level world = ctx.getLevel();
        ItemStack itemStack = ctx.getItemInHand();
        Player playerEntity = ctx.getPlayer();
        boolean bl = false;
        if (!world.isClientSide() && playerEntity != null && playerEntity.canUseGameMasterBlocks()) {
            CompoundTag nbtComponent = BlockItem.getBlockEntityData(itemStack);
            if (nbtComponent != null && nbtComponent.contains("Book")) {
                bl = true;
            }
        }

        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite()).setValue(HAS_BOOK, bl);
    }


    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BookDeskBlockEntity(pos, state);
    }

    public static boolean putBookIfAbsent(@Nullable LivingEntity user, Level world, BlockPos pos, BlockState state, ItemStack stack) {
        if (!(Boolean)state.getValue(HAS_BOOK)) {
            if (!world.isClientSide()) {
                putBook(user, world, pos, state, stack);
            }

            return true;
        } else {
            return false;
        }
    }

    private static void putBook(@Nullable LivingEntity user, Level world, BlockPos pos, BlockState state, ItemStack stack) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof BookDeskBlockEntity bookDeskBlockEntity) {
            bookDeskBlockEntity.setBook(stack.split(1));
            setHasBook(user, world, pos, state, true);
            world.playSound(null, pos, SoundEvents.BOOK_PUT, SoundSource.BLOCKS, 1.0F, 1.0F);
        }

    }

    public static void setHasBook(@Nullable Entity user, Level world, BlockPos pos, BlockState state, boolean hasBook) {
        BlockState blockState = state.setValue(HAS_BOOK, hasBook);
        world.setBlock(pos, blockState, 3);
        world.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(user, blockState));
    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    public int getAnalogOutputSignal(BlockState state, Level world, BlockPos pos) {
        if (state.getValue(HAS_BOOK)) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof BookDeskBlockEntity) {
                return ((BookDeskBlockEntity)blockEntity).getComparatorOutput();
            }
        }

        return 0;
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getItemInHand(hand);
        if (state.getValue(HAS_BOOK)) {
            if (!world.isClientSide) {
                this.openScreen(world, pos, player);
            }

            return InteractionResult.sidedSuccess(world.isClientSide);
        }
        if (itemStack.is(ItemTags.LECTERN_BOOKS)) {
            return putBookIfAbsent(player, world, pos, state, itemStack) ? InteractionResult.sidedSuccess(world.isClientSide) : InteractionResult.PASS;
        }
        return !itemStack.isEmpty() && !itemStack.is(ItemTags.LECTERN_BOOKS) ? InteractionResult.CONSUME : InteractionResult.PASS;
    }

    @Override
    public @Nullable MenuProvider getMenuProvider(BlockState state, Level world, BlockPos pos) {
        return !(Boolean)state.getValue(HAS_BOOK) ? null : super.getMenuProvider(state, world, pos);
    }

    private void openScreen(Level world, BlockPos pos, Player player) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof BookDeskBlockEntity) {
            player.openMenu((BookDeskBlockEntity)blockEntity);
            player.awardStat(Stats.INTERACT_WITH_LECTERN);
        }

    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, HAS_BOOK);
    }


    static {
        FACING = BlockStateProperties.HORIZONTAL_FACING;
        HAS_BOOK = BlockStateProperties.HAS_BOOK;
    }
}
