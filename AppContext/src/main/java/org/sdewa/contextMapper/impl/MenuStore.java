package org.sdewa.contextMapper.impl;

import org.sdewa.contextMapper.ContextMapper;
import org.sdewa.AppContext.Menu;

import java.util.Map;

public class MenuStore implements ContextMapper<Menu> {

    private final Map<String, Menu> menuMap;

    public MenuStore(Map<String, Menu> menuMap) {
        this.menuMap = menuMap;
    }

    @Override
    public <T extends Menu> void putService(Class<? extends Menu> menuClass, T menuObject) {
        menuMap.put(parseClassName(menuClass), menuObject);
    }

    @Override
    public Menu getService(Class<? extends Menu> serviceClass) {
        return menuMap.get(parseClassName(serviceClass));
    }


}
