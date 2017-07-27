package org.academiadecodigo.bootcamp.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by codecadet on 17/07/2017.
 */
public class ServiceRegistry {

    private Map<String, Service> services = new HashMap<>();
    private static ServiceRegistry instance = null;


    public static synchronized ServiceRegistry getInstance() {

        // the instance is created only the first time this method is called
        if(instance == null) {
            instance = new ServiceRegistry();
        }

        // it always returns the same instance, there is no way to have another one
        return instance;
    }

    public Service getService(String service) {
        return services.get(service);
    }

    public void unregisterService(String service) {
        services.remove(service);
    }

    public void registerService(Service service) {
        services.put(service.getServiceName(), service);
    }
}
