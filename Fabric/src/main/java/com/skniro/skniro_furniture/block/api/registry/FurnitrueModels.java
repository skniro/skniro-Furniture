package com.skniro.skniro_furniture.block.api.registry;

import com.skniro.skniro_furniture.Furniture;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.data.Model;
import net.minecraft.client.data.TextureKey;
import net.minecraft.util.Identifier;

import java.util.Optional;

@Environment(EnvType.CLIENT)
public class FurnitrueModels {
    public static final Model PAPER_SLIDING_DOOR_BOTTOM_LEFT;
    public static final Model PAPER_SLIDING_DOOR_BOTTOM_LEFT_OPEN;
    public static final Model PAPER_SLIDING_DOOR_BOTTOM_RIGHT;
    public static final Model PAPER_SLIDING_DOOR_BOTTOM_RIGHT_OPEN;
    public static final Model PAPER_SLIDING_DOOR_TOP_LEFT;
    public static final Model PAPER_SLIDING_DOOR_TOP_LEFT_OPEN;
    public static final Model PAPER_SLIDING_DOOR_TOP_RIGHT;
    public static final Model PAPER_SLIDING_DOOR_TOP_RIGHT_OPEN;


    static {
        PAPER_SLIDING_DOOR_BOTTOM_LEFT = block("paper_sliding_door_bottom_left", "_bottom_left", TextureKey.TOP, TextureKey.BOTTOM);
        PAPER_SLIDING_DOOR_BOTTOM_LEFT_OPEN = block("paper_sliding_door_bottom_left_open", "_bottom_left_open", TextureKey.TOP, TextureKey.BOTTOM);
        PAPER_SLIDING_DOOR_BOTTOM_RIGHT = block("paper_sliding_door_bottom_right", "_bottom_right", TextureKey.TOP, TextureKey.BOTTOM);
        PAPER_SLIDING_DOOR_BOTTOM_RIGHT_OPEN = block("paper_sliding_door_bottom_right_open", "_bottom_right_open", TextureKey.TOP, TextureKey.BOTTOM);
        PAPER_SLIDING_DOOR_TOP_LEFT = block("paper_sliding_door_top_left", "_top_left", TextureKey.TOP, TextureKey.BOTTOM);
        PAPER_SLIDING_DOOR_TOP_LEFT_OPEN = block("paper_sliding_door_top_left_open", "_top_left_open", TextureKey.TOP, TextureKey.BOTTOM);
        PAPER_SLIDING_DOOR_TOP_RIGHT = block("paper_sliding_door_top_right", "_top_right", TextureKey.TOP, TextureKey.BOTTOM);
        PAPER_SLIDING_DOOR_TOP_RIGHT_OPEN = block("paper_sliding_door_top_right_open", "_top_right_open", TextureKey.TOP, TextureKey.BOTTOM);
    }

    private static Model block(String parent, String variant, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(Identifier.of(Furniture.MOD_ID,"block/furniture/door/" + parent)), Optional.of(variant), requiredTextureKeys);
    }
}
