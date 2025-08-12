package com.tazz.modulith.demo;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.test.ApplicationModuleTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

//@Profile("testcontainers")
@ApplicationModuleTest
public class ModuleTests {

    @Test
    void verifyModule(){
        assertTrue(true);
    }
}
