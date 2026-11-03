package com.skniro.skniro_furniture.block.entity;

import com.skniro.skniro_furniture.block.init.FurnitureBedBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jetbrains.annotations.Nullable;

public class FurnitureBedBlockEntity extends BlockEntity {
    private BannerPatternLayers patterns = BannerPatternLayers.EMPTY;
    @Nullable
    private Component customName;
    @Nullable
    private DyeColor baseColorOverride;

    public FurnitureBedBlockEntity(BlockPos pos, BlockState state) {
        super(FurnitureBlockEntityType.Bed_BLOCK_ENTITY, pos, state);
    }

    public BannerPatternLayers getPatterns() {
        return patterns;
    }

    public DyeColor getBaseColor() {
        if (this.baseColorOverride != null) {
            return this.baseColorOverride;
        }
        return this.getBlockState().getBlock() instanceof FurnitureBedBlock bed ? bed.getColor() : DyeColor.WHITE;
    }

    public boolean isDecorated() {
        return this.baseColorOverride != null || !this.patterns.equals(BannerPatternLayers.EMPTY);
    }

    public void setBaseColor(@Nullable DyeColor color) {
        this.baseColorOverride = color;
        this.markUpdated();
    }

    public void setPatterns(BannerPatternLayers patterns) {
        this.patterns = patterns;
        this.markUpdated();
    }

    public void setDecorations(@Nullable DyeColor color, BannerPatternLayers patterns) {
        this.baseColorOverride = color;
        this.patterns = patterns;
        this.markUpdated();
    }

    public void clearDecorations() {
        this.baseColorOverride = null;
        this.patterns = BannerPatternLayers.EMPTY;
        this.markUpdated();
    }

    public void copyDecorationFrom(FurnitureBedBlockEntity other) {
        this.baseColorOverride = other.baseColorOverride;
        this.patterns = other.patterns;
        this.customName = other.customName;
        this.markUpdated();
    }

    public void markUpdated() {
        this.setChanged();
        this.refreshComponents();
        if (this.level != null && !this.level.isClientSide()) {
            this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
        }
    }

    private void refreshComponents() {
        DataComponentMap.Builder builder = DataComponentMap.builder();
        builder.addAll(this.components().filter(type ->
                type != DataComponents.BASE_COLOR
                        && type != DataComponents.BANNER_PATTERNS
                        && type != DataComponents.CUSTOM_NAME));
        if (this.baseColorOverride != null) {
            builder.set(DataComponents.BASE_COLOR, this.baseColorOverride);
        }
        if (!this.patterns.equals(BannerPatternLayers.EMPTY)) {
            builder.set(DataComponents.BANNER_PATTERNS, this.patterns);
        }
        if (this.customName != null) {
            builder.set(DataComponents.CUSTOM_NAME, this.customName);
        }
        this.setComponents(builder.build());
    }

    @Override
    protected void loadAdditional(ValueInput view) {
        super.loadAdditional(view);
        this.customName = parseCustomNameSafe(view, "CustomName");
        this.patterns = view.read("patterns", BannerPatternLayers.CODEC)
                .orElse(BannerPatternLayers.EMPTY);
        this.baseColorOverride = view.read("base_color", DyeColor.CODEC).orElse(null);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return this.saveWithoutMetadata(registries);
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    protected void saveAdditional(ValueOutput view) {
        super.saveAdditional(view);
        if (!patterns.equals(BannerPatternLayers.EMPTY)) {
            view.store("patterns", BannerPatternLayers.CODEC, patterns);
        }
        view.storeNullable("base_color", DyeColor.CODEC, this.baseColorOverride);
        view.storeNullable("CustomName", ComponentSerialization.CODEC, customName);
    }

    @Override
    protected void applyImplicitComponents(DataComponentGetter getter) {
        super.applyImplicitComponents(getter);
        this.baseColorOverride = getter.get(DataComponents.BASE_COLOR);
        this.patterns = getter.getOrDefault(DataComponents.BANNER_PATTERNS, BannerPatternLayers.EMPTY);
        this.customName = getter.get(DataComponents.CUSTOM_NAME);
    }

    @Override
    protected void collectImplicitComponents(DataComponentMap.Builder builder) {
        super.collectImplicitComponents(builder);
        if (this.baseColorOverride != null) {
            builder.set(DataComponents.BASE_COLOR, this.baseColorOverride);
        }
        if (!this.patterns.equals(BannerPatternLayers.EMPTY)) {
            builder.set(DataComponents.BANNER_PATTERNS, this.patterns);
        }
        if (this.customName != null) {
            builder.set(DataComponents.CUSTOM_NAME, this.customName);
        }
    }

    @Override
    public void removeComponentsFromTag(ValueOutput view) {
        super.removeComponentsFromTag(view);
        view.discard("base_color");
        view.discard("patterns");
        view.discard("CustomName");
    }
}
