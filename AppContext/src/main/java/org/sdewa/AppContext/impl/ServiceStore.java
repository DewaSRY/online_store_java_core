package org.sdewa.AppContext.impl;

import org.sdewa.AppContext.Services;
import org.sdewa.AppContext.ContextMapper;

import java.util.Map;
import java.util.Optional;

public class ServiceStore implements ContextMapper<Services> {
    private final Map<String, Services> serviceMap;

    public ServiceStore(Map<String, Services> serviceMap) {
        this.serviceMap = serviceMap;
    }


    public boolean isServiceHaveKey(String serviceName) {
        return serviceMap.containsKey(serviceName);
    }

    @Override
    public <T extends Services> void storeObject(Class<? extends Services> objectClass, T object) {
        serviceMap.put(parseClassName(objectClass), object);
    }

    @Override
    public Optional<Services> geObject(Class<? extends Services> objectClass) {
        return Optional.of(serviceMap.get(parseClassName(objectClass)));
    }
}
