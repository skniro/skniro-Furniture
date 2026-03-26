package com.skniro.skniro_furniture.block.init;

import com.mojang.serialization.MapCodec;
import com.skniro.skniro_furniture.block.entity.BookDeskBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.TypedEntityData;
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

    public MapCodec<BookDeskBlock> codec() {
        return CODEC;
    }

    @Override
    protected BlockState rotate(BlockState state, Rotation rotation) {
        return (BlockState)state.setValue(FACING, rotation.rotate((Direction)state.getValue(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation((Direction)state.getValue(FACING)));
    }

    @Override
    protected boolean useShapeForLightOcclusion(BlockState state) {
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
            TypedEntityData typedEntityData = itemStack.get(DataComponents.BLOCK_ENTITY_DATA);
            if (typedEntityData != null && typedEntityData.contains("Book")) {
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
            bookDeskBlockEntity.setBook(stack.consumeAndReturn(1, user));
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
    protected boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    protected int getAnalogOutputSignal(BlockState state, Level world, BlockPos pos, Direction direction) {
        if (state.getValue(HAS_BOOK)) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof BookDeskBlockEntity) {
                return ((BookDeskBlockEntity)blockEntity).getComparatorOutput();
            }
        }

        return 0;
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (state.getValue(HAS_BOOK)) {
            return InteractionResult.TRY_WITH_EMPTY_HAND;
        } else if (stack.is(ItemTags.LECTERN_BOOKS)) {
            return putBookIfAbsent(player, world, pos, state, stack) ? InteractionResult.SUCCESS : InteractionResult.PASS;
        } else {
            return stack.isEmpty() && hand == InteractionHand.MAIN_HAND ? InteractionResult.PASS : InteractionResult.TRY_WITH_EMPTY_HAND;
        }
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
        if (state.getValue(HAS_BOOK)) {
            if (!world.isClientSide()) {
                this.openScreen(world, pos, player);
            }

            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.CONSUME;
        }
    }

    @Override
    protected @Nullable MenuProvider getMenuProvider(BlockState state, Level world, BlockPos pos) {
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
