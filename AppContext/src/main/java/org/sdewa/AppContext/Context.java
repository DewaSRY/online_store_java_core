package org.sdewa.AppContext;


import org.sdewa.contextMapper.impl.MenuStore;
import org.sdewa.contextMapper.impl.ServiceStore;

import java.lang.reflect.Field;
import java.util.HashMap;


public class Context {

    private static Context instance;
    private final ServiceStore serviceStore;
    private final MenuStore menuStore;

    public Context(ServiceStore serviceStore, MenuStore menuStore) {
        this.serviceStore = serviceStore;
        this.menuStore = menuStore;
    }

    public <T extends Services> void putServices(T service) {
        serviceStore.putService(service.getClass(), service);
    }

    public Services getService(Class<? extends Services> service) {
        return serviceStore.getService(service);
    }

    public void putMenu(Class<? extends Menu> menu) {
        try {
            var menuConstructor = menu.getConstructor();
            var menuInstance = menuConstructor.newInstance();
            var menuFiled = menu.getDeclaredFields();

            for (var field : menuFiled) {
                injectMenuDependency(menuInstance, field);
            }

            menuStore.putService(menu, menuInstance);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private <T extends Menu> void injectMenuDependency(
            T menu, Field field) throws Exception {
        field.setAccessible(true);
        var parseFiledType = serviceStore.parseClassName((Class<?>) field.getGenericType());
        if (parseFiledType.equalsIgnoreCase("Context")) {
            field.set(menu, this);
        } else if (serviceStore.isServiceHaveKey(parseFiledType)) {
            injectMenuDependency(
                    menu, field, parseFiledType);
        }
    }

    private <T extends Menu> void injectMenuDependency(
            T menu, Field field, String serviceName) throws Exception {
        field.set(menu, serviceStore.getService(serviceName));
    }

    public void runtMenu(Class<? extends Menu> menu) {
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


