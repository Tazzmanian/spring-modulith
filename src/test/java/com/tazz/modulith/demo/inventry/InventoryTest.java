package com.tazz.modulith.demo.inventry;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("compose")
@ApplicationModuleTest
class InventoryTest {
    @Test
    void verifyModule(){
    }
}