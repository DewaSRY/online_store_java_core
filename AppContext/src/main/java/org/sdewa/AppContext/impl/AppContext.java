package org.sdewa.AppContext.impl;

import org.sdewa.AppContext.Context;
import org.sdewa.AppContext.Menu;
import org.sdewa.AppContext.MenuGetter;
import org.sdewa.AppContext.Services;

import java.util.HashMap;

public class AppContext implements Context {
    private static AppContext instance;
    private final ServiceStore serviceStore;
    private final MenuStore menuStore;

    public AppContext(ServiceStore serviceStore, MenuStore menuStore) {
        this.serviceStore = serviceStore;
        this.menuStore = menuStore;
    }

    public static AppContext getInstance() {
        if (instance == null) {
            instance = new AppContext(
                    new ServiceStore(new HashMap<>()),
                    new MenuStore(new HashMap<>())
            );
        }
        return instance;
    }

    public <T extends Services> void putServices(T service) {
        serviceStore.storeObject(service.getClass(), service);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends Services> T getService(Class<? extends Services> service) {
        return (T) serviceStore.geObject(service).orElse(null);
    }


    @Override
    public void putMenu(MenuGetter menuGetter) {
        var menuObj = menuGetter.getMenu(this);
        this.menuStore.storeObject(menuObj.getClass(), menuObj);
    }

    @Override
    public void runMenu(Class<? extends Menu> menu) {
        this.menuStore.geObject(menu).ifPresentOrElse(currentMenu -> {
            System.out.printf("%s%n%s%n%s%n",
                    "=".repeat(50),
                    currentMenu.printMenu(),
                    "=".repeat(50));
            currentMenu.run();
        }, () -> {
            System.out.printf("Menu with name %s not found%n",
                    this.menuStore.parseClassName(menu));
        });
    }

}
