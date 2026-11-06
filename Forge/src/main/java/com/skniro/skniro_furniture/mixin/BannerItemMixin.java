package com.skniro.skniro_furniture.mixin;

import com.skniro.skniro_furniture.block.init.BannerDecoratedBlock;
import net.minecraft.world.item.BannerItem;
import net.minecraft.world.level.block.Block;
import org.apache.commons.lang3.Validate;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/**
 * Allows {@link BannerItem} subclasses to wrap furniture blocks that are not
 * {@code AbstractBannerBlock}, as long as they support banner decorations.
 */
@Mixin(BannerItem.class)
public class BannerItemMixin {
    @Redirect(
            method = "<init>",
            at = @At(
                    value = "INVOKE",
                    target = "Lorg/apache/commons/lang3/Validate;isInstanceOf(Ljava/lang/Class;Ljava/lang/Object;)V"
            )
    )
    private void skniroFurniture$allowDecoratedFurnitureBlock(Class<?> type, Object value) {
        if (value instanceof Block block && block instanceof BannerDecoratedBlock) {
            return;
        }
        Validate.isInstanceOf(type, value);
    }
}
