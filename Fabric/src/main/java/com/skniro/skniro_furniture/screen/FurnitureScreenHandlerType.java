package com.skniro.skniro_furniture.screen;

import com.skniro.skniro_furniture.Furniture;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class FurnitureScreenHandlerType<T extends ScreenHandler>{
    public static final ScreenHandlerType<KitchenSinkBlockScreenHandler> Kitchen_Sink_Block_Screen_Handler =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(Furniture.MOD_ID, "kitchen_sink_screen_handler"),
                    new ExtendedScreenHandlerType<>(KitchenSinkBlockScreenHandler::new, BlockPos.PACKET_CODEC));

    public static void RegisterFurnitureScreenHandlerType () {
        Furniture.LOGGER.info("Registering Screen Handler for " + Furniture.MOD_ID);
    }
}
