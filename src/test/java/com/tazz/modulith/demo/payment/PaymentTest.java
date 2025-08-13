package com.tazz.modulith.demo.payment;

import com.tazz.modulith.demo.TestcontainerConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;
import org.springframework.modulith.test.ApplicationModuleTest;

@Import(TestcontainerConfig.class)
@ApplicationModuleTest
class PaymentTest {

    @Test
    void verifyModule(){
    }
}