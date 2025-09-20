package com.skniro.skniro_furniture.block.entity;

import com.skniro.skniro_furniture.block.init.FurnitureBedBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.DyeColor;
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
    private final DyeColor baseColor;

    public FurnitureBedBlockEntity(BlockPos pos, BlockState state) {
        this(pos, state, DyeColor.WHITE);
    }


    public FurnitureBedBlockEntity(BlockPos pos, BlockState state, DyeColor baseColor) {
        super(FurnitureBlockEntityType.Bed_BLOCK_ENTITY, pos, state);
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
    protected void loadAdditional(ValueInput view) {
        super.loadAdditional(view);
        this.customName = parseCustomNameSafe(view, "CustomName");
        this.patterns = view.read("patterns", BannerPatternLayers.CODEC)
                .orElse(BannerPatternLayers.EMPTY);
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
        view.storeNullable("CustomName", ComponentSerialization.CODEC, customName);
    }
}

