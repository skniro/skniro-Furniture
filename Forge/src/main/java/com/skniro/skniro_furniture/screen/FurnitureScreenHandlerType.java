package com.skniro.skniro_furniture.screen;

import com.skniro.skniro_furniture.Furniture;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FurnitureScreenHandlerType<T extends AbstractContainerMenu>{
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, Furniture.MOD_ID);


    public static final RegistryObject<MenuType<KitchenSinkBlockScreenHandler>> Kitchen_Sink_Block_Screen_Handler =
            registerMenuType("kitchen_sink_screen_handler", KitchenSinkBlockScreenHandler::new);

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(String name,
                                                                                                  IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void RegisterFurnitureScreenHandlerType (BusGroup eventBus) {
        MENUS.register(eventBus);
    }
}
