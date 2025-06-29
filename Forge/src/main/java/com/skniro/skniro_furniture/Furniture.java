package com.skniro.skniro_furniture;

import com.mojang.logging.LogUtils;
import com.skniro.skniro_furniture.client.renderer.ChairRenderer;
import com.skniro.skniro_furniture.client.renderer.CushinoRenderer;
import com.skniro.skniro_furniture.entity.MapleEntityType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Furniture.MOD_ID)
public class Furniture {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "skniro_furniture";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();





    public Furniture(FMLJavaModLoadingContext context) {
        var modEventBus = context.getModBusGroup();
        // Register the commonSetup method for modloading

        FurnitureContent.registerItem(modEventBus);
        FurnitureContent.registerBlock(modEventBus);
        FurnitureContent.registerFluid(modEventBus);
        FurnitureContent.CreativeTab(modEventBus);
        FurnitureContent.generateWorldGen(modEventBus);
        FurnitureContent.registerOthers(modEventBus);
        FurnitureContent.registerCommand(modEventBus);
        FurnitureContent.registerMapleLootTable(modEventBus);
        FurnitureContent.registerMapleCompostableItems(modEventBus);
        FurnitureContent.registerScreenType(modEventBus);
        FurnitureContent.registerRecipeType(modEventBus);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(MapleEntityType.Cushion_ENTITY.get(), CushinoRenderer::new);
            EntityRenderers.register(MapleEntityType.CHAIR_ENTITY.get(), ChairRenderer::new);
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ParticleFactoryRegistry {
        @SubscribeEvent
        public static void onParticleFactoryRegistration(RegisterParticleProvidersEvent event) {
        }

        @SubscribeEvent
        public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        }
    }
}
