package com.tazz.modulith.demo.payment;

import com.tazz.modulith.demo.TestcontainerConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.test.context.ActiveProfiles;

@Import(TestcontainerConfig.class)
@ApplicationModuleTest
@ActiveProfiles("testcontainers")
class PaymentTest {

    @Test
    void verifyModule(){
    }
}