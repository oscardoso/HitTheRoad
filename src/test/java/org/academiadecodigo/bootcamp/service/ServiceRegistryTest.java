package org.academiadecodigo.bootcamp.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * Created by codecadet on 18/07/2017.
 */
public class ServiceRegistryTest {

    ServiceRegistry serviceRegistry;
    Service mockedService;
    private final String serviceName = "MockedService";

    @Before
    public void setup() {
        serviceRegistry = ServiceRegistry.getInstance();
        mockedService = Mockito.mock(JdbcUserService.class);

        when(mockedService.getServiceName()).thenReturn(serviceName);
    }

    @Test
    public void testSingleton() {
        ServiceRegistry sr = ServiceRegistry.getInstance();
        assertEquals(sr, serviceRegistry);
    }

    @Test
    public void testAddAndGetService() {

        serviceRegistry.registerService(mockedService);
        assertEquals(serviceRegistry.getService(serviceName), mockedService);
    }

    @Test
    public void testUnregisterService() {

        serviceRegistry.registerService(mockedService);
        serviceRegistry.unregisterService(mockedService.getServiceName());
        assertEquals(serviceRegistry.getService(serviceName), null);
    }

}
