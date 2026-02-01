package com.skniro.skniro_furniture.block.entity;

import com.skniro.skniro_furniture.block.init.BookDeskBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.WritableBookContentComponent;
import net.minecraft.component.type.WrittenBookContentComponent;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.WrittenBookItem;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.LecternScreenHandler;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Clearable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BookDeskBlockEntity extends BlockEntity implements Clearable, NamedScreenHandlerFactory {
    private final Inventory inventory = new Inventory() {
        public int size() {
            return 1;
        }

        public boolean isEmpty() {
            return BookDeskBlockEntity.this.book.isEmpty();
        }

        public ItemStack getStack(int slot) {
            return slot == 0 ? BookDeskBlockEntity.this.book : ItemStack.EMPTY;
        }

        public ItemStack removeStack(int slot, int amount) {
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

        public ItemStack removeStack(int slot) {
            if (slot == 0) {
                ItemStack itemStack = BookDeskBlockEntity.this.book;
                BookDeskBlockEntity.this.book = ItemStack.EMPTY;
                BookDeskBlockEntity.this.onBookRemoved();
                return itemStack;
            } else {
                return ItemStack.EMPTY;
            }
        }

        public void setStack(int slot, ItemStack stack) {
        }

        public int getMaxCountPerStack() {
            return 1;
        }

        public void markDirty() {
            BookDeskBlockEntity.this.markDirty();
        }

        public boolean canPlayerUse(PlayerEntity player) {
            return Inventory.canPlayerUse(BookDeskBlockEntity.this, player) && BookDeskBlockEntity.this.hasBook();
        }

        public boolean isValid(int slot, ItemStack stack) {
            return false;
        }

        public void clear() {
        }
    };
    private final PropertyDelegate propertyDelegate = new PropertyDelegate() {
        public int get(int index) {
            return index == 0 ? BookDeskBlockEntity.this.currentPage : 0;
        }

        public void set(int index, int value) {
            if (index == 0) {
                BookDeskBlockEntity.this.setCurrentPage(value);
            }

        }

        public int size() {
            return 1;
        }
    };
    ItemStack book;
    int currentPage;
    private int pageCount;

    public BookDeskBlockEntity(BlockPos pos, BlockState state) {
        super(FurnitureBlockEntityType.BOOK_DESK_BLOCK_ENTITY, pos, state);
        this.book = ItemStack.EMPTY;
    }

    public ItemStack getBook() {
        return this.book;
    }

    public boolean hasBook() {
        return this.book.contains(DataComponentTypes.WRITABLE_BOOK_CONTENT) || this.book.contains(DataComponentTypes.WRITTEN_BOOK_CONTENT);
    }

    public void setBook(ItemStack book) {
        this.setBook(book, null);
    }

    void onBookRemoved() {
        this.currentPage = 0;
        this.pageCount = 0;
        BookDeskBlock.setHasBook(null, this.getWorld(), this.getPos(), this.getCachedState(), false);
    }

    public void setBook(ItemStack book, @Nullable PlayerEntity player) {
        this.book = this.resolveBook(book, player);
        this.currentPage = 0;
        this.pageCount = getPageCount(this.book);
        this.markDirty();
    }

    void setCurrentPage(int currentPage) {
        int i = MathHelper.clamp(currentPage, 0, this.pageCount - 1);
        if (i != this.currentPage) {
            this.currentPage = i;
            this.markDirty();
        }

    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public int getComparatorOutput() {
        float f = this.pageCount > 1 ? (float)this.getCurrentPage() / ((float)this.pageCount - 1.0F) : 1.0F;
        return MathHelper.floor(f * 14.0F) + (this.hasBook() ? 1 : 0);
    }

    private ItemStack resolveBook(ItemStack book, @Nullable PlayerEntity player) {
        World var4 = this.world;
        if (var4 instanceof ServerWorld serverWorld) {
            WrittenBookItem.resolve(book, this.getCommandSource(player, serverWorld), player);
        }

        return book;
    }

    private ServerCommandSource getCommandSource(@Nullable PlayerEntity player, ServerWorld world) {
        String string;
        Text text;
        if (player == null) {
            string = "Book Desk";
            text = Text.literal("Book Desk");
        } else {
            string = player.getName().getString();
            text = player.getDisplayName();
        }

        Vec3d vec3d = Vec3d.ofCenter(this.pos);
        return new ServerCommandSource(CommandOutput.DUMMY, vec3d, Vec2f.ZERO, world, 2, string, text, world.getServer(), player);
    }

    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        if (nbt.contains("Book", 10)) {
            this.book = this.resolveBook((ItemStack)ItemStack.fromNbt(registryLookup, nbt.getCompound("Book")).orElse(ItemStack.EMPTY), (PlayerEntity)null);
        } else {
            this.book = ItemStack.EMPTY;
        }

        this.pageCount = getPageCount(this.book);
        this.currentPage = MathHelper.clamp(nbt.getInt("Page"), 0, this.pageCount - 1);
    }

    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        if (!this.getBook().isEmpty()) {
            nbt.put("Book", this.getBook().toNbt(registryLookup));
            nbt.putInt("Page", this.currentPage);
        }

    }

    public void clear() {
        this.setBook(ItemStack.EMPTY);
    }

    public void onBlockReplaced(BlockPos pos, BlockState oldState) {
        if (oldState.get(BookDeskBlock.HAS_BOOK) && this.world != null) {
            Direction direction = oldState.get(BookDeskBlock.FACING);
            ItemStack itemStack = this.getBook().copy();
            float f = 0.25F * (float)direction.getOffsetX();
            float g = 0.25F * (float)direction.getOffsetZ();
            ItemEntity itemEntity = new ItemEntity(this.world, (double)pos.getX() + (double)0.5F + (double)f, pos.getY() + 1, (double)pos.getZ() + (double)0.5F + (double)g, itemStack);
            itemEntity.setToDefaultPickupDelay();
            this.world.spawnEntity(itemEntity);
        }

    }

    public ScreenHandler createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        return new LecternScreenHandler(i, this.inventory, this.propertyDelegate);
    }

    public Text getDisplayName() {
        return Text.translatable("container.lectern");
    }

    private static int getPageCount(ItemStack stack) {
        WrittenBookContentComponent writtenBookContentComponent = stack.get(DataComponentTypes.WRITTEN_BOOK_CONTENT);
        if (writtenBookContentComponent != null) {
            return writtenBookContentComponent.pages().size();
        } else {
            WritableBookContentComponent writableBookContentComponent = stack.get(DataComponentTypes.WRITABLE_BOOK_CONTENT);
            return writableBookContentComponent != null ? writableBookContentComponent.pages().size() : 0;
        }
    }
}