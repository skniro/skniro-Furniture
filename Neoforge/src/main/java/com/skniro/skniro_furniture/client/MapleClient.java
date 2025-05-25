package com.skniro.skniro_furniture.client;

import com.skniro.skniro_furniture.Furniture;
import com.skniro.skniro_furniture.FurnitureContent;
import com.skniro.skniro_furniture.block.FurnitureKitchenBlocks;
import com.skniro.skniro_furniture.block.MapleFurnitureBlocks;
import com.skniro.skniro_furniture.block.entity.FurnitureBlockEntityType;
import com.skniro.skniro_furniture.block.renderer.CabinetBlockEntityRenderer;
import com.skniro.skniro_furniture.block.renderer.KitchenSinkBlockEntityRenderer;
import com.skniro.skniro_furniture.block.renderer.OvenBlockEntityRenderer;
import com.skniro.skniro_furniture.client.gui.screen.KitchenSinkBlockScreen;
import com.skniro.skniro_furniture.client.renderer.ChairRenderer;
import com.skniro.skniro_furniture.client.renderer.CushinoRenderer;
import com.skniro.skniro_furniture.client.renderer.SofaRenderer;
import com.skniro.skniro_furniture.entity.MapleEntityType;
import com.skniro.skniro_furniture.screen.FurnitureScreenHandlerType;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@EventBusSubscriber(modid = Furniture.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
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

        RenderType renderLayer3 = RenderType.cutout();
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
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_WOOD_OAK_STYLE2.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_WOOD_BIRCH_STYLE2.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_WOOD_SPRUCE_STYLE2.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_WOOD_JUNGLE_STYLE2.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_WOOD_DARK_OAK_STYLE2.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_WOOD_ACACIA_STYLE2.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_WOOD_MANGROVE_STYLE2.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_WOOD_CHERRY_STYLE2.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_WOOD_CRIMSON_STYLE2.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_WOOD_WARPED_STYLE2.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_PLANK_OAK_STYLE2.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_PLANK_BIRCH_STYLE2.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_PLANK_SPRUCE_STYLE2.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_PLANK_JUNGLE_STYLE2.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_PLANK_DARK_OAK_STYLE2.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_PLANK_ACACIA_STYLE2.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_PLANK_MANGROVE_STYLE2.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_PLANK_CHERRY_STYLE2.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_PLANK_CRIMSON_STYLE2.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.Window_PLANK_WARPED_STYLE2.get(), renderLayer3);

        ItemBlockRenderTypes.setRenderLayer(FurnitureKitchenBlocks.WHITE_OVEN.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(FurnitureKitchenBlocks.ORANGE_OVEN.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(FurnitureKitchenBlocks.MAGENTA_OVEN.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(FurnitureKitchenBlocks.LIGHT_BLUE_OVEN.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(FurnitureKitchenBlocks.YELLOW_OVEN.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(FurnitureKitchenBlocks.LIME_OVEN.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(FurnitureKitchenBlocks.PINK_OVEN.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(FurnitureKitchenBlocks.GRAY_OVEN.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(FurnitureKitchenBlocks.LIGHT_GRAY_OVEN.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(FurnitureKitchenBlocks.CYAN_OVEN.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(FurnitureKitchenBlocks.PURPLE_OVEN.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(FurnitureKitchenBlocks.BLUE_OVEN.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(FurnitureKitchenBlocks.BROWN_OVEN.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(FurnitureKitchenBlocks.GREEN_OVEN.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(FurnitureKitchenBlocks.RED_OVEN.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(FurnitureKitchenBlocks.BLACK_OVEN.get(), renderLayer3);

        ItemBlockRenderTypes.setRenderLayer(FurnitureKitchenBlocks.OAK_PLANKS_OVEN.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(FurnitureKitchenBlocks.OAK_WOOD_OVEN.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(FurnitureKitchenBlocks.SPRUCE_PLANKS_OVEN.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(FurnitureKitchenBlocks.SPRUCE_WOOD_OVEN.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(FurnitureKitchenBlocks.BIRCH_PLANKS_OVEN.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(FurnitureKitchenBlocks.BIRCH_WOOD_OVEN.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(FurnitureKitchenBlocks.JUNGLE_PLANKS_OVEN.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(FurnitureKitchenBlocks.JUNGLE_WOOD_OVEN.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(FurnitureKitchenBlocks.ACACIA_PLANKS_OVEN.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(FurnitureKitchenBlocks.ACACIA_WOOD_OVEN.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(FurnitureKitchenBlocks.DARK_OAK_PLANKS_OVEN.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(FurnitureKitchenBlocks.DARK_OAK_WOOD_OVEN.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(FurnitureKitchenBlocks.MANGROVE_PLANKS_OVEN.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(FurnitureKitchenBlocks.MANGROVE_WOOD_OVEN.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(FurnitureKitchenBlocks.CHERRY_PLANKS_OVEN.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(FurnitureKitchenBlocks.CHERRY_WOOD_OVEN.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(FurnitureKitchenBlocks.CRIMSON_PLANKS_OVEN.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(FurnitureKitchenBlocks.CRIMSON_HYPHAE_OVEN.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(FurnitureKitchenBlocks.WARPED_PLANKS_OVEN.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(FurnitureKitchenBlocks.WARPED_HYPHAE_OVEN.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(FurnitureKitchenBlocks.BAMBOO_PLANKS_OVEN.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(FurnitureKitchenBlocks.BAMBOO_BLOCK_OVEN.get(), renderLayer3);

        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.OAK_PLANK_Glass_TRIPLE_CABINET.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.OAK_WOOD_Glass_TRIPLE_CABINET.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.SPRUCE_PLANK_Glass_TRIPLE_CABINET.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.SPRUCE_WOOD_Glass_TRIPLE_CABINET.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.BIRCH_PLANK_Glass_TRIPLE_CABINET.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.BIRCH_WOOD_Glass_TRIPLE_CABINET.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.JUNGLE_PLANK_Glass_TRIPLE_CABINET.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.JUNGLE_WOOD_Glass_TRIPLE_CABINET.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.ACACIA_PLANK_Glass_TRIPLE_CABINET.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.ACACIA_WOOD_Glass_TRIPLE_CABINET.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.DARK_OAK_PLANK_Glass_TRIPLE_CABINET.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.DARK_OAK_WOOD_Glass_TRIPLE_CABINET.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.MANGROVE_PLANK_Glass_TRIPLE_CABINET.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.MANGROVE_WOOD_Glass_TRIPLE_CABINET.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.CHERRY_PLANK_Glass_TRIPLE_CABINET.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.CHERRY_WOOD_Glass_TRIPLE_CABINET.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.BAMBOO_PLANK_Glass_TRIPLE_CABINET.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.BAMBOO_WOOD_Glass_TRIPLE_CABINET.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.CRIMSON_PLANK_Glass_TRIPLE_CABINET.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.CRIMSON_WOOD_Glass_TRIPLE_CABINET.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.WARPED_PLANK_Glass_TRIPLE_CABINET.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.WARPED_WOOD_Glass_TRIPLE_CABINET.get(), renderLayer3);

        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.OAK_WOOD_Glass_Four_Grid_Cabinet.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.OAK_PLANKS_Glass_Four_Grid_Cabinet.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.SPRUCE_WOOD_Glass_Four_Grid_Cabinet.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.SPRUCE_PLANKS_Glass_Four_Grid_Cabinet.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.BIRCH_WOOD_Glass_Four_Grid_Cabinet.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.BIRCH_PLANKS_Glass_Four_Grid_Cabinet.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.JUNGLE_WOOD_Glass_Four_Grid_Cabinet.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.JUNGLE_PLANKS_Glass_Four_Grid_Cabinet.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.ACACIA_WOOD_Glass_Four_Grid_Cabinet.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.ACACIA_PLANKS_Glass_Four_Grid_Cabinet.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.DARK_OAK_WOOD_Glass_Four_Grid_Cabinet.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.DARK_OAK_PLANKS_Glass_Four_Grid_Cabinet.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.MANGROVE_WOOD_Glass_Four_Grid_Cabinet.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.MANGROVE_PLANKS_Glass_Four_Grid_Cabinet.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.CHERRY_WOOD_Glass_Four_Grid_Cabinet.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.CHERRY_PLANKS_Glass_Four_Grid_Cabinet.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.CRIMSON_HYPHAE_Glass_Four_Grid_Cabinet.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.CRIMSON_PLANKS_Glass_Four_Grid_Cabinet.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.WARPED_HYPHAE_Glass_Four_Grid_Cabinet.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.WARPED_PLANKS_Glass_Four_Grid_Cabinet.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.BAMBOO_BLOCK_Glass_Four_Grid_Cabinet.get(), renderLayer3);
        ItemBlockRenderTypes.setRenderLayer(MapleFurnitureBlocks.BAMBOO_PLANKS_Glass_Four_Grid_Cabinet.get(), renderLayer3);



        RenderType renderLayer4 = RenderType.translucent();
        registerClientEntityRenderer();
        registerClientParticle();
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerClientEntityRenderer() {
        EntityRenderers.register(MapleEntityType.CHAIR_ENTITY.get(), ChairRenderer::new);
        EntityRenderers.register(MapleEntityType.Cushion_ENTITY.get(), CushinoRenderer::new);
        EntityRenderers.register(MapleEntityType.SOFA_ENTITY.get(), SofaRenderer::new);
        BlockEntityRenderers.register(FurnitureBlockEntityType.Cabinet_BLOCK_ENTITY.get(), CabinetBlockEntityRenderer::new);
        BlockEntityRenderers.register(FurnitureBlockEntityType.OVEN_BLOCK_ENTITY.get(), OvenBlockEntityRenderer::new);
        BlockEntityRenderers.register(FurnitureBlockEntityType.Kitchen_Sink_BLOCK_ENTITY.get(), KitchenSinkBlockEntityRenderer::new);
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerClientParticle() {
    }

    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(FurnitureScreenHandlerType.Kitchen_Sink_Block_Screen_Handler.get(), KitchenSinkBlockScreen::new);
    }
}
