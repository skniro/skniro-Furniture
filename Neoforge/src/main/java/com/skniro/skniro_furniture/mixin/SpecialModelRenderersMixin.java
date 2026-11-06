package com.skniro.skniro_furniture.mixin;

import com.skniro.skniro_furniture.Furniture;
import com.skniro.skniro_furniture.client.renderer.BedSheetSpecialRenderer;
import com.skniro.skniro_furniture.client.renderer.CushionSurfaceSpecialRenderer;
import com.skniro.skniro_furniture.client.renderer.DividerBannerSpecialRenderer;
import net.minecraft.client.renderer.special.SpecialModelRenderers;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ExtraCodecs;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SpecialModelRenderers.class)
public class SpecialModelRenderersMixin {
    @Shadow
    @Final
    private static ExtraCodecs.LateBoundIdMapper ID_MAPPER;

    @Inject(method = "bootstrap", at = @At("RETURN"))
    private static void skniroFurniture$registerDividerBanner(CallbackInfo ci) {
        if (!ID_MAPPER.values().contains(DividerBannerSpecialRenderer.Unbaked.MAP_CODEC)) {
            ID_MAPPER.put(Identifier.fromNamespaceAndPath(Furniture.MOD_ID, "divider_banner"),
                    DividerBannerSpecialRenderer.Unbaked.MAP_CODEC);
        }
        if (!ID_MAPPER.values().contains(BedSheetSpecialRenderer.Unbaked.MAP_CODEC)) {
            ID_MAPPER.put(Identifier.fromNamespaceAndPath(Furniture.MOD_ID, "bed_sheet"),
                    BedSheetSpecialRenderer.Unbaked.MAP_CODEC);
        }
        if (!ID_MAPPER.values().contains(CushionSurfaceSpecialRenderer.Unbaked.MAP_CODEC)) {
            ID_MAPPER.put(Identifier.fromNamespaceAndPath(Furniture.MOD_ID, "cushion_surface"),
                    CushionSurfaceSpecialRenderer.Unbaked.MAP_CODEC);
        }
    }
}
