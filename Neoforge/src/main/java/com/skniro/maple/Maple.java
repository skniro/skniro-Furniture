package com.skniro.maple;

import com.mojang.logging.LogUtils;
import com.skniro.maple.block.MapleFurnitureBlocks;
import com.skniro.maple.block.entity.MapleBlockEntities;
import com.skniro.maple.block.entity.MapleBlockEntityType;
import com.skniro.maple.block.entity.MapleWoodTypes;
import com.skniro.maple.block.renderer.MapleJuicerEntityRenderer;
import com.skniro.maple.client.boat.MapleModelLayers;
import com.skniro.maple.client.gui.screen.ingame.MapleJuicerBlockScreen;
import com.skniro.maple.client.particle.MapleCampfireSmokeParticle;
import com.skniro.maple.client.particle.MapleCherryLeavesParticle;
import com.skniro.maple.client.renderer.ChairRenderer;
import com.skniro.maple.client.renderer.CushinoRenderer;
import com.skniro.maple.entity.MapleEntityType;
import com.skniro.maple.fluid.MapleFluidBlockOrItem;
import com.skniro.maple.fluid.MapleFluidTypes;
import com.skniro.maple.fluid.MapleFluids;
import com.skniro.maple.item.*;
import com.skniro.maple.particle.MapleParticleTypes;
import com.skniro.maple.recipe.MapleRecipeType;
import com.skniro.maple.screen.MapleScreenHandlerType;
import com.skniro.maple.util.MapleLootModifiers;
import com.skniro.maple.world.biome.MapleTerrablender;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Maple.MOD_ID)
public class Maple{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "maple";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();


    public Maple(IEventBus modEventBus) {

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the Deferred Register to the mod event bus so blocks get registered
        MapleBlocks.registerMapleBlocks(modEventBus);
        MapleOreBlocks.registerMapleOreBlocks(modEventBus);
        MapleFurnitureBlocks.registerMapleBlocks(modEventBus);


        // Register the Deferred Register to the mod event bus so items get registered
        MapleItems.registerModItems(modEventBus);
        GlassCupItems.registerMapleGlassItems(modEventBus);
        MapleFoodComponents.registerModFoodItems(modEventBus);
        MapleArmorItems.registerMapleArmorItems(modEventBus);

        MapleFluids.registerFluids(modEventBus);
        MapleFluidBlockOrItem.registerFluidBlocks(modEventBus);
        MapleFluidBlockOrItem.registerFluidItems(modEventBus);

        MapleCreativeModeTabs.registerMapleCreativeModeTabs(modEventBus);

        MapleSignBlocks.registerMapleSignBlocks(modEventBus);

        MapleBlockEntities.registerMapleBlockEntities(modEventBus);
        MapleEntityType.register(modEventBus);
        MapleScreenHandlerType.registerMapleScreenHandlerType(modEventBus);
        MapleRecipeType.registerRecipes(modEventBus);
        MapleFluidTypes.register(modEventBus);

        MapleBlockEntityType.registerBlockEntityType(modEventBus);

        MapleParticleTypes.MapleParticleTypesRegister(modEventBus);

        MapleLootModifiers.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(MapleTerrablender::registerBiomes);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            WoodType.register(MapleWoodTypes.MAPLE);
            WoodType.register(MapleWoodTypes.GINKGO);
            BlockEntityRenderers.register(MapleBlockEntities.SIGN_BLOCK_ENTITIES.get(), SignRenderer::new);
            BlockEntityRenderers.register(MapleBlockEntities.Maple_HANGING_SIGN.get(), HangingSignRenderer::new);
            Sheets.addWoodType(MapleWoodTypes.MAPLE);
            Sheets.addWoodType(MapleWoodTypes.GINKGO);
            EntityRenderers.register(MapleEntityType.Cushion_ENTITY.get(), CushinoRenderer::new);
            EntityRenderers.register(MapleEntityType.CHAIR_ENTITY.get(), ChairRenderer::new);
            BlockEntityRenderers.register(MapleBlockEntityType.MAPLE_JUICER_BLOCK_ENTITY_BLOCK_ENTITY_TYPE.get(), MapleJuicerEntityRenderer::new);
        }

        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event) {
            event.register(MapleScreenHandlerType.Maple_JUICER.get(), MapleJuicerBlockScreen::new);
        }
    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ParticleFactoryRegistry {
        @SubscribeEvent
        public static void onParticleFactoryRegistration(RegisterParticleProvidersEvent event) {
            event.registerSpriteSet(MapleParticleTypes.HOT_SPRING.get(), MapleCampfireSmokeParticle.CosySmokeFactory::new);

            event.registerSpriteSet(MapleParticleTypes.CHERRY_LEAVES.get(),((spriteProvider) -> {
                return (parameters, world, x, y, z, velocityX, velocityY, velocityZ) -> {
                    return new MapleCherryLeavesParticle(world, x, y, z, spriteProvider);
                };
            }));

            event.registerSpriteSet(MapleParticleTypes.SAKURA_LEAVES.get(),((spriteProvider) -> {
                return (parameters, world, x, y, z, velocityX, velocityY, velocityZ) -> {
                    return new MapleCherryLeavesParticle(world, x, y, z, spriteProvider);
                };
            }));
        }

        @SubscribeEvent
        public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
            EntityRenderers.register(MapleEntityType.Maple_BOAT.get(), pContext -> new BoatRenderer(pContext, MapleModelLayers.Maple_BOAT_LAYER));
            EntityRenderers.register(MapleEntityType.Maple_CHEST_BOAT.get(), pContext -> new BoatRenderer(pContext, MapleModelLayers.Maple_CHEST_BOAT_LAYER));
            EntityRenderers.register(MapleEntityType.GINKGO_BOAT.get(), pContext -> new BoatRenderer(pContext, MapleModelLayers.Ginkgo_BOAT_LAYER));
            EntityRenderers.register(MapleEntityType.GINKGO_CHEST_BOAT.get(), pContext -> new BoatRenderer(pContext, MapleModelLayers.Ginkgo_CHEST_BOAT_LAYER));
            event.registerLayerDefinition(MapleModelLayers.Maple_BOAT_LAYER, BoatModel::createBoatModel);
            event.registerLayerDefinition(MapleModelLayers.Maple_CHEST_BOAT_LAYER, BoatModel::createChestBoatModel);
            event.registerLayerDefinition(MapleModelLayers.Ginkgo_BOAT_LAYER, BoatModel::createBoatModel);
            event.registerLayerDefinition(MapleModelLayers.Ginkgo_CHEST_BOAT_LAYER, BoatModel::createChestBoatModel);
        }
    }
}
