package com.skniro.skniro_furniture.block.entity;

import com.skniro.skniro_furniture.block.init.BookDeskBlock;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.Clearable;
import net.minecraft.world.Container;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.LecternMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.WritableBookContent;
import net.minecraft.world.item.component.WrittenBookContent;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class BookDeskBlockEntity extends BlockEntity implements Clearable, MenuProvider {
    private final Container inventory = new Container() {
        public int getContainerSize() {
            return 1;
        }

        public boolean isEmpty() {
            return BookDeskBlockEntity.this.book.isEmpty();
        }

        public ItemStack getItem(int slot) {
            return slot == 0 ? BookDeskBlockEntity.this.book : ItemStack.EMPTY;
        }

        public ItemStack removeItem(int slot, int amount) {
            if (slot == 0) {
                ItemStack itemStack = BookDeskBlockEntity.this.book.split(amount);
                if (BookDeskBlockEntity.this.book.isEmpty()) {
                    BookDeskBlockEntity.this.onBookRemoved();
                }

                return itemStack;
            } else {
                return ItemStack.EMPTY;
            }
        }

        public ItemStack removeItemNoUpdate(int slot) {
            if (slot == 0) {
                ItemStack itemStack = BookDeskBlockEntity.this.book;
                BookDeskBlockEntity.this.book = ItemStack.EMPTY;
                BookDeskBlockEntity.this.onBookRemoved();
                return itemStack;
            } else {
                return ItemStack.EMPTY;
            }
        }

        public void setItem(int slot, ItemStack stack) {
        }

        public int getMaxStackSize() {
            return 1;
        }

        public void setChanged() {
            BookDeskBlockEntity.this.setChanged();
        }

        public boolean stillValid(Player player) {
            return Container.stillValidBlockEntity(BookDeskBlockEntity.this, player) && BookDeskBlockEntity.this.hasBook();
        }

        public boolean canPlaceItem(int slot, ItemStack stack) {
            return false;
        }

        public void clearContent() {
        }
    };
    private final ContainerData propertyDelegate = new ContainerData() {
        public int get(int index) {
            return index == 0 ? BookDeskBlockEntity.this.currentPage : 0;
        }

        public void set(int index, int value) {
            if (index == 0) {
                BookDeskBlockEntity.this.setCurrentPage(value);
            }

        }

        public int getCount() {
            return 1;
        }
    };
    ItemStack book;
    int currentPage;
    private int pageCount;

    public BookDeskBlockEntity(BlockPos pos, BlockState state) {
        super(FurnitureBlockEntityType.BOOK_DESK_BLOCK_ENTITY.get(), pos, state);
        this.book = ItemStack.EMPTY;
    }

    public ItemStack getBook() {
        return this.book;
    }

    public boolean hasBook() {
        return this.book.has(DataComponents.WRITABLE_BOOK_CONTENT) || this.book.has(DataComponents.WRITTEN_BOOK_CONTENT);
    }

    public void setBook(ItemStack book) {
        this.setBook(book, null);
    }

    void onBookRemoved() {
        this.currentPage = 0;
        this.pageCount = 0;
        BookDeskBlock.setHasBook(null, this.getLevel(), this.getBlockPos(), this.getBlockState(), false);
    }

    public void setBook(ItemStack book, @Nullable Player player) {
        this.book = this.resolveBook(book, player);
        this.currentPage = 0;
        this.pageCount = getPageCount(this.book);
        this.setChanged();
    }

    void setCurrentPage(int currentPage) {
        int i = Mth.clamp(currentPage, 0, this.pageCount - 1);
        if (i != this.currentPage) {
            this.currentPage = i;
            this.setChanged();
        }

    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public int getComparatorOutput() {
        float f = this.pageCount > 1 ? (float)this.getCurrentPage() / ((float)this.pageCount - 1.0F) : 1.0F;
        return Mth.floor(f * 14.0F) + (this.hasBook() ? 1 : 0);
    }

    private ItemStack resolveBook(ItemStack book, @Nullable Player player) {
        Level var4 = this.level;
        if (var4 instanceof ServerLevel serverWorld) {
            WrittenBookContent.resolveForItem(book, this.getCommandSource(player, serverWorld), player);
        }

        return book;
    }

    private CommandSourceStack getCommandSource(@Nullable Player player, ServerLevel world) {
        String string;
        Component text;
        if (player == null) {
            string = "Book Desk";
            text = Component.literal("Book Desk");
        } else {
            string = player.getPlainTextName();
            text = player.getDisplayName();
        }

        Vec3 vec3d = Vec3.atCenterOf(this.worldPosition);
        return new CommandSourceStack(CommandSource.NULL, vec3d, Vec2.ZERO, world, 2, string, text, world.getServer(), player);
    }

    protected void loadAdditional(ValueInput view) {
        super.loadAdditional(view);
        this.book = view.read("Book", ItemStack.CODEC).map((itemStack) -> this.resolveBook(itemStack, null)).orElse(ItemStack.EMPTY);
        this.pageCount = getPageCount(this.book);
        this.currentPage = Mth.clamp(view.getIntOr("Page", 0), 0, this.pageCount - 1);
    }

    protected void saveAdditional(ValueOutput view) {
        super.saveAdditional(view);
        if (!this.getBook().isEmpty()) {
            view.store("Book", ItemStack.CODEC, this.getBook());
            view.putInt("Page", this.currentPage);
        }

    }

    public void clearContent() {
        this.setBook(ItemStack.EMPTY);
    }

    public void preRemoveSideEffects(BlockPos pos, BlockState oldState) {
        if (oldState.getValue(BookDeskBlock.HAS_BOOK) && this.level != null) {
            Direction direction = oldState.getValue(BookDeskBlock.FACING);
            ItemStack itemStack = this.getBook().copy();
            float f = 0.25F * (float)direction.getStepX();
            float g = 0.25F * (float)direction.getStepZ();
            ItemEntity itemEntity = new ItemEntity(this.level, (double)pos.getX() + (double)0.5F + (double)f, pos.getY() + 1, (double)pos.getZ() + (double)0.5F + (double)g, itemStack);
            itemEntity.setDefaultPickUpDelay();
            this.level.addFreshEntity(itemEntity);
        }

    }

    public AbstractContainerMenu createMenu(int i, Inventory playerInventory, Player playerEntity) {
        return new LecternMenu(i, this.inventory, this.propertyDelegate);
    }

    public Component getDisplayName() {
        return Component.translatable("container.lectern");
    }

    private static int getPageCount(ItemStack stack) {
        WrittenBookContent writtenBookContentComponent = stack.get(DataComponents.WRITTEN_BOOK_CONTENT);
        if (writtenBookContentComponent != null) {
            return writtenBookContentComponent.pages().size();
        } else {
            WritableBookContent writableBookContentComponent = stack.get(DataComponents.WRITABLE_BOOK_CONTENT);
            return writableBookContentComponent != null ? writableBookContentComponent.pages().size() : 0;
        }
    }
}