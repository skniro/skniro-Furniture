package com.skniro.skniro_furniture.screen;

import com.skniro.skniro_furniture.Furniture;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class FurnitureScreenHandlerType<T extends AbstractContainerMenu>{
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(BuiltInRegistries.MENU, Furniture.MOD_ID);


    public static final Supplier<MenuType<KitchenSinkBlockScreenHandler>> Kitchen_Sink_Block_Screen_Handler =
            registerMenuType("kitchen_sink_screen_handler", KitchenSinkBlockScreenHandler::new);

    private static <T extends AbstractContainerMenu> Supplier<MenuType<T>> registerMenuType(String name,
                                                                                                  IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IMenuTypeExtension.create(factory));
    }

    public static void RegisterFurnitureScreenHandlerType (IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
