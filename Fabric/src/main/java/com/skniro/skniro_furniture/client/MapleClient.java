package com.skniro.skniro_furniture.client;

import com.skniro.skniro_furniture.FurnitureContent;
import com.skniro.skniro_furniture.block.FurnitureKitchenBlocks;
import com.skniro.skniro_furniture.block.MapleFurnitureBlocks;
import com.skniro.skniro_furniture.block.entity.DrawerBlockEntity;
import com.skniro.skniro_furniture.block.entity.FurnitureBlockEntityType;
import com.skniro.skniro_furniture.block.renderer.CabinetBlockEntityRenderer;
import com.skniro.skniro_furniture.block.renderer.OvenBlockEntityRenderer;
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

        BlockRenderLayerMap.INSTANCE.putBlock(FurnitureKitchenBlocks.WHITE_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(FurnitureKitchenBlocks.ORANGE_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(FurnitureKitchenBlocks.MAGENTA_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(FurnitureKitchenBlocks.LIGHT_BLUE_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(FurnitureKitchenBlocks.YELLOW_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(FurnitureKitchenBlocks.LIME_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(FurnitureKitchenBlocks.PINK_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(FurnitureKitchenBlocks.GRAY_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(FurnitureKitchenBlocks.LIGHT_GRAY_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(FurnitureKitchenBlocks.CYAN_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(FurnitureKitchenBlocks.PURPLE_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(FurnitureKitchenBlocks.BLUE_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(FurnitureKitchenBlocks.BROWN_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(FurnitureKitchenBlocks.GREEN_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(FurnitureKitchenBlocks.RED_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(FurnitureKitchenBlocks.BLACK_OVEN, renderLayer3);

        BlockRenderLayerMap.INSTANCE.putBlock(FurnitureKitchenBlocks.OAK_PLANKS_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(FurnitureKitchenBlocks.OAK_WOOD_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(FurnitureKitchenBlocks.SPRUCE_PLANKS_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(FurnitureKitchenBlocks.SPRUCE_WOOD_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(FurnitureKitchenBlocks.BIRCH_PLANKS_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(FurnitureKitchenBlocks.BIRCH_WOOD_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(FurnitureKitchenBlocks.JUNGLE_PLANKS_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(FurnitureKitchenBlocks.JUNGLE_WOOD_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(FurnitureKitchenBlocks.ACACIA_PLANKS_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(FurnitureKitchenBlocks.ACACIA_WOOD_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(FurnitureKitchenBlocks.DARK_OAK_PLANKS_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(FurnitureKitchenBlocks.DARK_OAK_WOOD_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(FurnitureKitchenBlocks.MANGROVE_PLANKS_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(FurnitureKitchenBlocks.MANGROVE_WOOD_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(FurnitureKitchenBlocks.CHERRY_PLANKS_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(FurnitureKitchenBlocks.CHERRY_WOOD_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(FurnitureKitchenBlocks.CRIMSON_PLANKS_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(FurnitureKitchenBlocks.CRIMSON_HYPHAE_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(FurnitureKitchenBlocks.WARPED_PLANKS_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(FurnitureKitchenBlocks.WARPED_HYPHAE_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(FurnitureKitchenBlocks.BAMBOO_PLANKS_OVEN, renderLayer3);
        BlockRenderLayerMap.INSTANCE.putBlock(FurnitureKitchenBlocks.BAMBOO_BLOCK_OVEN, renderLayer3);



        RenderLayer renderLayer4 = RenderLayer.getTranslucent();

        FurnitureContent.registerClientEntityRenderer();
        FurnitureContent.registerClientParticle();
    }
}
