package com.skniro.skniro_furniture.screen;

import com.skniro.skniro_furniture.Furniture;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

public class FurnitureScreenHandlerType<T extends AbstractContainerMenu>{
    public static final MenuType<KitchenSinkBlockScreenHandler> Kitchen_Sink_Block_Screen_Handler =
            Registry.register(BuiltInRegistries.MENU, ResourceLocation.fromNamespaceAndPath(Furniture.MOD_ID, "kitchen_sink_screen_handler"),
                    new ExtendedScreenHandlerType<>(KitchenSinkBlockScreenHandler::new, BlockPos.STREAM_CODEC));

    public static void RegisterFurnitureScreenHandlerType () {
        Furniture.LOGGER.info("Registering Screen Handler for " + Furniture.MOD_ID);
    }
}
