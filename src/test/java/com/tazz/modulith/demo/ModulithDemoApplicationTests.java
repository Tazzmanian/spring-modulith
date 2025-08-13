package com.tazz.modulith.demo;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.test.ApplicationModuleTest;

@Import(TestcontainerConfig.class)
@ApplicationModuleTest
//@Import(TestcontainerConfig.class)
class ModulithDemoApplicationTests {

	@Test
	void contextLoads() {
		ApplicationModules.of(ModulithDemoApplication.class).verify();
	}

}
