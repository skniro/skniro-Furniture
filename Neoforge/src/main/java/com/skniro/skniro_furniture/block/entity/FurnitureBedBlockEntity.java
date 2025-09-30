package com.skniro.skniro_furniture.block.entity;

import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

public class FurnitureBedBlockEntity extends BlockEntity {
    private static final Logger LOGGER = LogUtils.getLogger();
    private BannerPatternLayers patterns = BannerPatternLayers.EMPTY;
    @Nullable
    private Component customName;
    private final DyeColor baseColor;

    public FurnitureBedBlockEntity(BlockPos pos, BlockState state) {
        this(pos, state, DyeColor.WHITE);
    }


    public FurnitureBedBlockEntity(BlockPos pos, BlockState state, DyeColor baseColor) {
        super(FurnitureBlockEntityType.Bed_BLOCK_ENTITY.get(), pos, state);
        this.baseColor = baseColor;
    }

    public BannerPatternLayers getPatterns() {
        return patterns;
    }

    public void setPatterns(BannerPatternLayers patterns) {
        this.patterns = patterns;
        setChanged();
    }

    @Override
    protected void loadAdditional(CompoundTag nbt, HolderLookup.Provider registries) {
        super.loadAdditional(nbt, registries);
        if (!this.patterns.equals(BannerPatternLayers.EMPTY)) {
            nbt.put("patterns", (Tag)BannerPatternLayers.CODEC.encodeStart(registries.createSerializationContext(NbtOps.INSTANCE), this.patterns).getOrThrow());
        }

        if (this.customName != null) {
            nbt.putString("CustomName", Component.Serializer.toJson(this.customName, registries));
        }
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }


    @Override
    protected void saveAdditional(CompoundTag nbt, HolderLookup.Provider registries) {
        super.saveAdditional(nbt, registries);
        if (nbt.contains("CustomName", 8)) {
            this.customName = parseCustomNameSafe(nbt.getString("CustomName"), registries);
        }

        if (nbt.contains("patterns")) {
            BannerPatternLayers.CODEC.parse(registries.createSerializationContext(NbtOps.INSTANCE), nbt.get("patterns")).resultOrPartial((patterns) -> LOGGER.error("Failed to parse banner patterns: '{}'", patterns)).ifPresent((patterns) -> this.patterns = patterns);
        }
    }
}

