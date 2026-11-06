package com.skniro.skniro_furniture.client.renderer;

import com.skniro.skniro_furniture.item.FurnitureBannerItem;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import org.jetbrains.annotations.Nullable;

/**
 * The banner data carried by a decorated furniture item (beds, cushions).
 */
public record ItemBannerDecoration(int baseColor, BannerPatternLayers patterns) {
    @Nullable
    public static ItemBannerDecoration of(ItemStack stack) {
        DyeColor fallback = stack.getItem() instanceof FurnitureBannerItem item ? item.getColor() : DyeColor.WHITE;
        return of(stack, fallback);
    }

    @Nullable
    public static ItemBannerDecoration of(ItemStack stack, DyeColor fallback) {
        boolean hasBaseOverride = stack.has(DataComponents.BASE_COLOR);
        BannerPatternLayers patterns = stack.getOrDefault(DataComponents.BANNER_PATTERNS, BannerPatternLayers.EMPTY);
        if (!hasBaseOverride && patterns.layers().isEmpty()) {
            return null;
        }
        DyeColor color = stack.get(DataComponents.BASE_COLOR);
        if (color == null) {
            color = fallback;
        }
        return new ItemBannerDecoration(0xFF000000 | color.getTextureDiffuseColor(), patterns);
    }
}
