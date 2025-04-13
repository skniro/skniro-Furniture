package com.skniro.skniro_furniture.client;

import com.skniro.skniro_furniture.Furniture;
import com.skniro.skniro_furniture.block.MapleFurnitureBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Furniture.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MapleClient {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        RenderType renderLayer2 = RenderType.cutoutMipped();
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.TABLE_OAK.get(),renderLayer2);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.TABLE_SPRUCE.get(),renderLayer2);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.TABLE_BIRCH.get(),renderLayer2);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.TABLE_JUNGLE.get(),renderLayer2);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.TABLE_ACACIA.get(),renderLayer2);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.TABLE_DARK_OAK.get(),renderLayer2);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.TABLE_CRIMSON.get(),renderLayer2);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.TABLE_WARPED.get(),renderLayer2);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.TABLE_MANGROVE.get(),renderLayer2);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.TABLE_BAMBOO.get(),renderLayer2);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.TABLE_CHERRY.get(),renderLayer2);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.TABLE_MAPLE.get(),renderLayer2);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.TABLE_GINKGO.get(),renderLayer2);

        RenderType renderLayer3 = RenderType.cutout();
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_Wood_GINKGO.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_Wood_MAPLE.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_WOOD_OAK.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_WOOD_BIRCH.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_WOOD_SPRUCE.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_WOOD_JUNGLE.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_WOOD_DARK_OAK.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_WOOD_ACACIA.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_WOOD_MANGROVE.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_WOOD_CHERRY.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_WOOD_CRIMSON.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_WOOD_WARPED.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_PLANK_MAPLE.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_PLANK_GINKGO.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_PLANK_OAK.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_PLANK_BIRCH.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_PLANK_SPRUCE.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_PLANK_JUNGLE.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_PLANK_DARK_OAK.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_PLANK_ACACIA.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_PLANK_MANGROVE.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_PLANK_CHERRY.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_PLANK_CRIMSON.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_PLANK_WARPED.get(), renderLayer3);


        RenderType renderLayer4 = RenderType.translucent();
    }
}
