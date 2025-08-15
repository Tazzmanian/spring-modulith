package com.tazz.modulith.demo;


import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.test.context.ActiveProfiles;

@Import(TestTestcontainerConfig.class)
@ActiveProfiles("testcontainers")
@ApplicationModuleTest(ApplicationModuleTest.BootstrapMode.DIRECT_DEPENDENCIES)
public class TestcontainersIntegrationTests {
    @Test
    void verifyModule(){
    }
}
