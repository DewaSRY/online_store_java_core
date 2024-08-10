package org.sdewa.AppContext.impl;

import org.sdewa.AppContext.Menu;
import org.sdewa.AppContext.ContextMapper;


import java.util.Map;
import java.util.Optional;

public class MenuStore implements ContextMapper<Menu> {

    private final Map<String, Menu> menuMap;

    public MenuStore(Map<String, Menu> menuMap) {
        this.menuMap = menuMap;
    }

    @Override
    public <T extends Menu> void storeObject(Class<? extends Menu> objectClass, T object) {
        menuMap.put(parseClassName(objectClass), object);
    }

    @Override
    public Optional<Menu> geObject(Class<? extends Menu> objectClass) {
        return Optional.of(this.menuMap.get(parseClassName(objectClass)));
    }

}
