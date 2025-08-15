package com.tazz.modulith.demo.order;

import com.tazz.modulith.demo.TestcontainerConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("testcontainers")
@ApplicationModuleTest(mode = ApplicationModuleTest.BootstrapMode.DIRECT_DEPENDENCIES)
@Import(TestcontainerConfig.class)
class OrderInventoryTest {

    @Test
    void verifyModule(){
    }
}