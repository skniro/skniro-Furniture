package com.skniro.skniro_furniture.client;

import com.skniro.skniro_furniture.block.FurnitureKitchenBlocks;
import com.skniro.skniro_furniture.block.MapleFurnitureBlocks;
import com.skniro.skniro_furniture.block.entity.FurnitureBlockEntityType;
import com.skniro.skniro_furniture.block.renderer.CabinetBlockEntityRenderer;
import com.skniro.skniro_furniture.block.renderer.KitchenSinkBlockEntityRenderer;
import com.skniro.skniro_furniture.block.renderer.OvenBlockEntityRenderer;
import com.skniro.skniro_furniture.block.renderer.PlateBlockEntityRenderer;
import com.skniro.skniro_furniture.client.gui.screen.KitchenSinkBlockScreen;
import com.skniro.skniro_furniture.client.renderer.ChairRenderer;
import com.skniro.skniro_furniture.client.renderer.CushinoRenderer;
import com.skniro.skniro_furniture.client.renderer.SofaRenderer;
import com.skniro.skniro_furniture.entity.MapleEntityType;
import com.skniro.skniro_furniture.screen.FurnitureScreenHandlerType;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class MapleClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        BlockRenderLayer renderLayer2 = BlockRenderLayer.CUTOUT_MIPPED;
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.TABLE_OAK,renderLayer2);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.TABLE_SPRUCE,renderLayer2);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.TABLE_BIRCH,renderLayer2);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.TABLE_JUNGLE,renderLayer2);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.TABLE_ACACIA,renderLayer2);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.TABLE_DARK_OAK,renderLayer2);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.TABLE_CRIMSON,renderLayer2);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.TABLE_WARPED,renderLayer2);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.TABLE_MANGROVE,renderLayer2);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.TABLE_BAMBOO,renderLayer2);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.TABLE_CHERRY,renderLayer2);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.TABLE_PALE_OAK,renderLayer2);

        BlockRenderLayer renderLayer3 = BlockRenderLayer.CUTOUT;
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_WOOD_OAK, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_WOOD_BIRCH, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_WOOD_SPRUCE, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_WOOD_JUNGLE, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_WOOD_DARK_OAK, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_WOOD_ACACIA, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_WOOD_MANGROVE, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_WOOD_CHERRY, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_WOOD_CRIMSON, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_WOOD_WARPED, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_WOOD_PALE_OAK, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_WOOD_BAMBOO, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_PLANK_OAK, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_PLANK_BIRCH, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_PLANK_SPRUCE, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_PLANK_JUNGLE, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_PLANK_DARK_OAK, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_PLANK_ACACIA, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_PLANK_MANGROVE, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_PLANK_CHERRY, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_PLANK_CRIMSON, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_PLANK_WARPED, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_PLANK_PALE_OAK, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_PLANK_BAMBOO, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_WOOD_OAK_STYLE2, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_WOOD_BIRCH_STYLE2, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_WOOD_SPRUCE_STYLE2, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_WOOD_JUNGLE_STYLE2, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_WOOD_DARK_OAK_STYLE2, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_WOOD_ACACIA_STYLE2, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_WOOD_MANGROVE_STYLE2, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_WOOD_CHERRY_STYLE2, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_WOOD_CRIMSON_STYLE2, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_WOOD_WARPED_STYLE2, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_WOOD_PALE_OAK_STYLE2, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_WOOD_BAMBOO_STYLE2, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_PLANK_OAK_STYLE2, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_PLANK_BIRCH_STYLE2, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_PLANK_SPRUCE_STYLE2, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_PLANK_JUNGLE_STYLE2, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_PLANK_DARK_OAK_STYLE2, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_PLANK_ACACIA_STYLE2, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_PLANK_MANGROVE_STYLE2, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_PLANK_CHERRY_STYLE2, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_PLANK_CRIMSON_STYLE2, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_PLANK_WARPED_STYLE2, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_PLANK_PALE_OAK_STYLE2, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.Window_PLANK_BAMBOO_STYLE2, renderLayer3);

        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.WHITE_OVEN, renderLayer3);
        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.ORANGE_OVEN, renderLayer3);
        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.MAGENTA_OVEN, renderLayer3);
        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.LIGHT_BLUE_OVEN, renderLayer3);
        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.YELLOW_OVEN, renderLayer3);
        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.LIME_OVEN, renderLayer3);
        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.PINK_OVEN, renderLayer3);
        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.GRAY_OVEN, renderLayer3);
        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.LIGHT_GRAY_OVEN, renderLayer3);
        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.CYAN_OVEN, renderLayer3);
        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.PURPLE_OVEN, renderLayer3);
        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.BLUE_OVEN, renderLayer3);
        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.BROWN_OVEN, renderLayer3);
        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.GREEN_OVEN, renderLayer3);
        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.RED_OVEN, renderLayer3);
        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.BLACK_OVEN, renderLayer3);

        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.OAK_PLANKS_OVEN, renderLayer3);
        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.OAK_WOOD_OVEN, renderLayer3);
        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.SPRUCE_PLANKS_OVEN, renderLayer3);
        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.SPRUCE_WOOD_OVEN, renderLayer3);
        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.BIRCH_PLANKS_OVEN, renderLayer3);
        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.BIRCH_WOOD_OVEN, renderLayer3);
        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.JUNGLE_PLANKS_OVEN, renderLayer3);
        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.JUNGLE_WOOD_OVEN, renderLayer3);
        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.ACACIA_PLANKS_OVEN, renderLayer3);
        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.ACACIA_WOOD_OVEN, renderLayer3);
        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.DARK_OAK_PLANKS_OVEN, renderLayer3);
        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.DARK_OAK_WOOD_OVEN, renderLayer3);
        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.MANGROVE_PLANKS_OVEN, renderLayer3);
        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.MANGROVE_WOOD_OVEN, renderLayer3);
        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.CHERRY_PLANKS_OVEN, renderLayer3);
        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.CHERRY_WOOD_OVEN, renderLayer3);
        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.CRIMSON_PLANKS_OVEN, renderLayer3);
        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.CRIMSON_HYPHAE_OVEN, renderLayer3);
        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.WARPED_PLANKS_OVEN, renderLayer3);
        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.WARPED_HYPHAE_OVEN, renderLayer3);
        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.BAMBOO_PLANKS_OVEN, renderLayer3);
        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.BAMBOO_BLOCK_OVEN, renderLayer3);
        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.PALE_OAK_PLANKS_OVEN, renderLayer3);
        BlockRenderLayerMap.putBlock(FurnitureKitchenBlocks.PALE_OAK_WOOD_OVEN, renderLayer3);

        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.OAK_PLANK_Glass_TRIPLE_CABINET, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.OAK_WOOD_Glass_TRIPLE_CABINET, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.SPRUCE_PLANK_Glass_TRIPLE_CABINET, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.SPRUCE_WOOD_Glass_TRIPLE_CABINET, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.BIRCH_PLANK_Glass_TRIPLE_CABINET, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.BIRCH_WOOD_Glass_TRIPLE_CABINET, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.JUNGLE_PLANK_Glass_TRIPLE_CABINET, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.JUNGLE_WOOD_Glass_TRIPLE_CABINET, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.ACACIA_PLANK_Glass_TRIPLE_CABINET, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.ACACIA_WOOD_Glass_TRIPLE_CABINET, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.DARK_OAK_PLANK_Glass_TRIPLE_CABINET, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.DARK_OAK_WOOD_Glass_TRIPLE_CABINET, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.MANGROVE_PLANK_Glass_TRIPLE_CABINET, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.MANGROVE_WOOD_Glass_TRIPLE_CABINET, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.CHERRY_PLANK_Glass_TRIPLE_CABINET, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.CHERRY_WOOD_Glass_TRIPLE_CABINET, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.BAMBOO_PLANK_Glass_TRIPLE_CABINET, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.BAMBOO_WOOD_Glass_TRIPLE_CABINET, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.CRIMSON_PLANK_Glass_TRIPLE_CABINET, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.CRIMSON_WOOD_Glass_TRIPLE_CABINET, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.WARPED_PLANK_Glass_TRIPLE_CABINET, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.WARPED_WOOD_Glass_TRIPLE_CABINET, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.PALE_OAK_PLANK_Glass_TRIPLE_CABINET, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.PALE_OAK_WOOD_Glass_TRIPLE_CABINET, renderLayer3);

        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.OAK_WOOD_Glass_Four_Grid_Cabinet, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.OAK_PLANKS_Glass_Four_Grid_Cabinet, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.SPRUCE_WOOD_Glass_Four_Grid_Cabinet, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.SPRUCE_PLANKS_Glass_Four_Grid_Cabinet, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.BIRCH_WOOD_Glass_Four_Grid_Cabinet, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.BIRCH_PLANKS_Glass_Four_Grid_Cabinet, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.JUNGLE_WOOD_Glass_Four_Grid_Cabinet, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.JUNGLE_PLANKS_Glass_Four_Grid_Cabinet, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.ACACIA_WOOD_Glass_Four_Grid_Cabinet, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.ACACIA_PLANKS_Glass_Four_Grid_Cabinet, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.DARK_OAK_WOOD_Glass_Four_Grid_Cabinet, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.DARK_OAK_PLANKS_Glass_Four_Grid_Cabinet, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.MANGROVE_WOOD_Glass_Four_Grid_Cabinet, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.MANGROVE_PLANKS_Glass_Four_Grid_Cabinet, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.CHERRY_WOOD_Glass_Four_Grid_Cabinet, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.CHERRY_PLANKS_Glass_Four_Grid_Cabinet, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.CRIMSON_HYPHAE_Glass_Four_Grid_Cabinet, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.CRIMSON_PLANKS_Glass_Four_Grid_Cabinet, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.WARPED_HYPHAE_Glass_Four_Grid_Cabinet, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.WARPED_PLANKS_Glass_Four_Grid_Cabinet, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.BAMBOO_BLOCK_Glass_Four_Grid_Cabinet, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.BAMBOO_PLANKS_Glass_Four_Grid_Cabinet, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.PALE_OAK_WOOD_Glass_Four_Grid_Cabinet, renderLayer3);
        BlockRenderLayerMap.putBlock(MapleFurnitureBlocks.PALE_OAK_PLANKS_Glass_Four_Grid_Cabinet, renderLayer3);



        BlockRenderLayer renderLayer4 = BlockRenderLayer.TRANSLUCENT;
        HandledScreens.register(FurnitureScreenHandlerType.Kitchen_Sink_Block_Screen_Handler, KitchenSinkBlockScreen::new);
        registerClientEntityRenderer();
        registerClientParticle();
    }


    @Environment(EnvType.CLIENT)
    public static void registerClientEntityRenderer() {
        EntityRendererRegistry.register(MapleEntityType.CHAIR_ENTITY, ChairRenderer::new);
        EntityRendererRegistry.register(MapleEntityType.Cushion_ENTITY, CushinoRenderer::new);
        EntityRendererRegistry.register(MapleEntityType.SOFA_ENTITY, SofaRenderer::new);
        BlockEntityRendererFactories.register(FurnitureBlockEntityType.Cabinet_BLOCK_ENTITY, CabinetBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(FurnitureBlockEntityType.OVEN_BLOCK_ENTITY, OvenBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(FurnitureBlockEntityType.Kitchen_Sink_BLOCK_ENTITY, KitchenSinkBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(FurnitureBlockEntityType.Plate_BLOCK_ENTITY, PlateBlockEntityRenderer::new);
    }

    @Environment(EnvType.CLIENT)
    public static void registerClientParticle() {

    }
}
