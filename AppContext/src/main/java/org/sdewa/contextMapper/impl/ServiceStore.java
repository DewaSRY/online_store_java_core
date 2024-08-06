package org.sdewa.contextMapper.impl;

import org.sdewa.contextMapper.ContextMapper;

import java.util.Map;

public class ServiceStore implements ContextMapper {
    private final Map<String, Object> serviceMap;

    public ServiceStore(Map<String, Object> serviceMap) {
        this.serviceMap = serviceMap;
    }

    @Override
    public void putService(Object service, Object serviceObject) {
        serviceMap.put(
                getClassName(service),
                serviceObject
        );
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getService(Object service) {
        return (T) serviceMap.get(getClassName(service));
    }
}
