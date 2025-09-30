package com.skniro.skniro_furniture.block.entity;

import com.mojang.logging.LogUtils;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.component.type.BannerPatternsComponent;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

public class FurnitureBedBlockEntity extends BlockEntity {
    private static final Logger LOGGER = LogUtils.getLogger();
    private BannerPatternsComponent patterns = BannerPatternsComponent.DEFAULT;
    @Nullable
    private Text customName;
    private final DyeColor baseColor;

    public FurnitureBedBlockEntity(BlockPos pos, BlockState state) {
        this(pos, state, DyeColor.WHITE);
    }


    public FurnitureBedBlockEntity(BlockPos pos, BlockState state, DyeColor baseColor) {
        super(FurnitureBlockEntityType.Bed_BLOCK_ENTITY, pos, state);
        this.baseColor = baseColor;
    }

    public BannerPatternsComponent getPatterns() {
        return patterns;
    }

    public void setPatterns(BannerPatternsComponent patterns) {
        this.patterns = patterns;
        markDirty();
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
        super.readNbt(nbt, registries);
        if (!this.patterns.equals(BannerPatternsComponent.DEFAULT)) {
            nbt.put("patterns", (NbtElement)BannerPatternsComponent.CODEC.encodeStart(registries.getOps(NbtOps.INSTANCE), this.patterns).getOrThrow());
        }

        if (this.customName != null) {
            nbt.putString("CustomName", Text.Serialization.toJsonString(this.customName, registries));
        }
    }

    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }


    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
        super.writeNbt(nbt, registries);
        if (nbt.contains("CustomName", 8)) {
            this.customName = tryParseCustomName(nbt.getString("CustomName"), registries);
        }

        if (nbt.contains("patterns")) {
            BannerPatternsComponent.CODEC.parse(registries.getOps(NbtOps.INSTANCE), nbt.get("patterns")).resultOrPartial((patterns) -> LOGGER.error("Failed to parse banner patterns: '{}'", patterns)).ifPresent((patterns) -> this.patterns = patterns);
        }
    }
}

