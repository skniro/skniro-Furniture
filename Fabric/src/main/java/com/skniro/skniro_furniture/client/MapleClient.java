package com.skniro.skniro_furniture.client;

import com.skniro.skniro_furniture.FurnitureContent;
import com.skniro.skniro_furniture.block.MapleFurnitureBlocks;
import com.skniro.skniro_furniture.block.entity.DrawerBlockEntity;
import com.skniro.skniro_furniture.block.entity.FurnitureBlockEntityType;
import com.skniro.skniro_furniture.block.renderer.CabinetBlockEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class MapleClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        RenderLayer renderLayer2 = RenderLayer.getCutoutMipped();
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.TABLE_OAK,renderLayer2);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.TABLE_SPRUCE,renderLayer2);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.TABLE_BIRCH,renderLayer2);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.TABLE_JUNGLE,renderLayer2);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.TABLE_ACACIA,renderLayer2);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.TABLE_DARK_OAK,renderLayer2);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.TABLE_CRIMSON,renderLayer2);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.TABLE_WARPED,renderLayer2);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.TABLE_MANGROVE,renderLayer2);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.TABLE_BAMBOO,renderLayer2);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.TABLE_CHERRY,renderLayer2);

        RenderLayer renderLayer3 = RenderLayer.getCutout();
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.Window_WOOD_OAK, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.Window_WOOD_BIRCH, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.Window_WOOD_SPRUCE, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.Window_WOOD_JUNGLE, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.Window_WOOD_DARK_OAK, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.Window_WOOD_ACACIA, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.Window_WOOD_MANGROVE, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.Window_WOOD_CHERRY, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.Window_WOOD_CRIMSON, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.Window_WOOD_WARPED, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.Window_PLANK_OAK, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.Window_PLANK_BIRCH, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.Window_PLANK_SPRUCE, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.Window_PLANK_JUNGLE, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.Window_PLANK_DARK_OAK, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.Window_PLANK_ACACIA, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.Window_PLANK_MANGROVE, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.Window_PLANK_CHERRY, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.Window_PLANK_CRIMSON, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.Window_PLANK_WARPED, renderLayer3);

        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.WHITE_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.ORANGE_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.MAGENTA_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.LIGHT_BLUE_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.YELLOW_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.LIME_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.PINK_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.GRAY_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.LIGHT_GRAY_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.CYAN_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.PURPLE_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.BLUE_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.BROWN_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.GREEN_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.RED_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.BLACK_OVEN, renderLayer3);

        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.OAK_PLANKS_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.OAK_WOOD_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.SPRUCE_PLANKS_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.SPRUCE_WOOD_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.BIRCH_PLANKS_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.BIRCH_WOOD_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.JUNGLE_PLANKS_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.JUNGLE_WOOD_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.ACACIA_PLANKS_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.ACACIA_WOOD_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.DARK_OAK_PLANKS_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.DARK_OAK_WOOD_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.MANGROVE_PLANKS_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.MANGROVE_WOOD_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.CHERRY_PLANKS_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.CHERRY_WOOD_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.CRIMSON_PLANKS_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.CRIMSON_HYPHAE_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.WARPED_PLANKS_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.WARPED_HYPHAE_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.BAMBOO_PLANKS_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(MapleFurnitureBlocks.BAMBOO_BLOCK_OVEN, renderLayer3);


        RenderLayer renderLayer4 = RenderLayer.getTranslucent();

        FurnitureContent.registerClientEntityRenderer();
        FurnitureContent.registerClientParticle();
        BlockEntityRendererFactories.register(FurnitureBlockEntityType.Cabinet_BLOCK_ENTITY, CabinetBlockEntityRenderer::new);
    }
}
