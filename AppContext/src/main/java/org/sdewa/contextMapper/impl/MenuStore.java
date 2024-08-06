package org.sdewa.contextMapper.impl;

import org.sdewa.contextMapper.ContextMapper;
import org.sdewa.AppContext.Menu;

import java.util.Map;

public class MenuStore implements ContextMapper {

    private final Map<String, Menu> menuMap;

    public MenuStore(Map<String, Menu> menuMap) {
        this.menuMap = menuMap;
    }

    @Override
    public <T> void putService(Object service, T serviceObject) {
        if (serviceObject instanceof Menu object) {
            menuMap.put(getClassName(service), object);
        }
    }


    @Override
    @SuppressWarnings("unchecked")
    public <T> T getService(Object serviceName) {
        return (T) menuMap.get(serviceName);
    }
}
