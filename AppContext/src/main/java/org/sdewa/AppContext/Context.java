package org.sdewa.AppContext;


import org.sdewa.contextMapper.impl.MenuStore;
import org.sdewa.contextMapper.impl.ServiceStore;

import java.rmi.server.RemoteObjectInvocationHandler;
import java.util.HashMap;


public class Context {

    private static Context instance;
    private final ServiceStore serviceStore;
    private final MenuStore menuStore;

    public Context(ServiceStore serviceStore, MenuStore menuStore) {
        this.serviceStore = serviceStore;
        this.menuStore = menuStore;
    }

    public <T> void putServices(T service) {
        serviceStore.putService(service, service);
    }

    public <T> T getService(Object service) {
        return serviceStore.getService(service);
    }

    public void putMenu(Menu menu) {
        menuStore.putService(menu, menu);
    }

    public void runtMenu(Object menu) {
        var currentMenu = menuStore.<Menu>getService(menu);
        currentMenu.printMenu();
        currentMenu.run();
    }

    public static Context getInstance() {
        if (instance == null) {
            instance = new Context(
                    new ServiceStore(new HashMap<>()),
                    new MenuStore(new HashMap<>())
            );
        }
        return instance;
    }
}


