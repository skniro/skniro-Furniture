package com.skniro.skniro_furniture.mixin;

import com.skniro.skniro_furniture.block.init.DividerBlock;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.LoomScreen;
import net.minecraft.client.model.object.banner.BannerFlagModel;
import net.minecraft.world.item.BannerItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LoomScreen.class)
public class LoomScreenMixin {
    @Shadow
    @Final
    private ItemStack bannerStack;

    @Redirect(
            method = "extractBackground",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/GuiGraphicsExtractor;bannerPattern(Lnet/minecraft/client/model/object/banner/BannerFlagModel;Lnet/minecraft/world/item/DyeColor;Lnet/minecraft/world/level/block/entity/BannerPatternLayers;IIII)V"
            )
    )
    private void skniroFurniture$skipVanillaPreview(GuiGraphicsExtractor graphics, BannerFlagModel flag,
                                                    DyeColor color, BannerPatternLayers patterns,
                                                    int x0, int y0, int x1, int y1) {
        ItemStack preview = this.skniroFurniture$previewStack();
        if (preview.getItem() instanceof BannerItem banner && banner.getBlock() instanceof DividerBlock) {
            return;
        }
        graphics.bannerPattern(flag, color, patterns, x0, y0, x1, y1);
    }

    @Inject(method = "extractBackground", at = @At("RETURN"))
    private void skniroFurniture$renderDividerPreview(GuiGraphicsExtractor graphics, int mouseX, int mouseY,
                                                      float partialTick, CallbackInfo ci) {
        ItemStack preview = this.skniroFurniture$previewStack();
        if (!(preview.getItem() instanceof BannerItem banner) || !(banner.getBlock() instanceof DividerBlock)) {
            return;
        }
        AbstractContainerScreenAccessor accessor = (AbstractContainerScreenAccessor) (Object) this;
        graphics.pose().pushMatrix();
        graphics.pose().translate(accessor.skniroFurniture$getLeftPos() + 141.0F,
                accessor.skniroFurniture$getTopPos() + 18.0F);
        graphics.pose().scale(1.25F, 1.25F);
        graphics.item(preview, 0, 0);
        graphics.pose().popMatrix();
    }

    private ItemStack skniroFurniture$previewStack() {
        ItemStack result = ((LoomScreen) (Object) this).getMenu().getResultSlot().getItem();
        return result.isEmpty() ? this.bannerStack : result;
    }
}
