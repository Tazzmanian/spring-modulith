package com.tazz.modulith.demo.payment;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("compose")
@ApplicationModuleTest
class PaymentTest {

    @Test
    void verifyModule(){
    }
}