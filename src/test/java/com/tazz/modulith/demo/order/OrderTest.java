package com.tazz.modulith.demo.order;

import com.tazz.modulith.demo.TestcontainerConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;
import org.springframework.modulith.test.ApplicationModuleTest;

@Import(TestcontainerConfig.class)
@ApplicationModuleTest(mode = ApplicationModuleTest.BootstrapMode.DIRECT_DEPENDENCIES)
class  OrderTest {

    @Test
    void verifyModule(){
    }
}