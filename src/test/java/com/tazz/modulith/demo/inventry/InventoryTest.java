package com.tazz.modulith.demo.inventry;

import com.tazz.modulith.demo.TestcontainerConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("testcontainers")
@Import(TestcontainerConfig.class)
@ApplicationModuleTest
class InventoryTest {
    @Test
    void verifyModule(){
//        Assertions.assertTrue(false);
    }
}