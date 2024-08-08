package org.sdewa.contextMapper.impl;

import com.sun.source.tree.BreakTree;
import org.sdewa.AppContext.Services;
import org.sdewa.contextMapper.ContextMapper;

import java.util.Map;
import java.util.Set;

public class ServiceStore implements ContextMapper<Services> {
    private final Map<String, Services> serviceMap;

    public ServiceStore(Map<String, Services> serviceMap) {
        this.serviceMap = serviceMap;
    }


    public boolean isServiceHaveKey(String serviceName) {
        return serviceMap.containsKey(serviceName);
    }

    @Override
    public <T extends Services> void putService(Class<? extends Services> serviceClass, T serviceObject) {

        serviceMap.put(
                parseClassName(serviceClass),
                serviceObject
        );
    }

    @Override
    public Services getService(Class<? extends Services> service) {
        return serviceMap.get(parseClassName(service));
    }

    public Services getService(String serviceName) {
        return serviceMap.get(serviceName);
    }
}
