package com.tazz.modulith.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.context.ImportTestcontainers;
import org.springframework.modulith.test.ApplicationModuleTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

//@Profile("testcontainers")
@TestConfiguration(proxyBeanMethods = false)
@ImportTestcontainers(MyContainers.class)
@ApplicationModuleTest
public class ModuleTests {

    @Test
    void verifyModule(){
        assertTrue(true);
    }
}
