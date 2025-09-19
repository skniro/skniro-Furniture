package com.skniro.skniro_furniture.block.entity;

import com.skniro.skniro_furniture.block.init.FurnitureBedBlock;
import net.minecraft.block.AbstractBannerBlock;
import net.minecraft.block.BannerBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.component.type.BannerPatternsComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.text.Text;
import net.minecraft.text.TextCodecs;
import net.minecraft.util.DyeColor;
import org.jetbrains.annotations.Nullable;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class FurnitureBedBlockEntity extends BlockEntity {
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
    protected void readData(ReadView view) {
        super.readData(view);
        this.customName = tryParseCustomName(view, "CustomName");
        this.patterns = view.read("patterns", BannerPatternsComponent.CODEC)
                .orElse(BannerPatternsComponent.DEFAULT);
    }

    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }


    @Override
    protected void writeData(WriteView view) {
        super.writeData(view);
        if (!patterns.equals(BannerPatternsComponent.DEFAULT)) {
            view.put("patterns", BannerPatternsComponent.CODEC, patterns);
        }
        view.putNullable("CustomName", TextCodecs.CODEC, customName);
    }
}

