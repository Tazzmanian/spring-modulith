package com.tazz.modulith.demo;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.test.ApplicationModuleTest;

@ApplicationModuleTest
class ModulithDemoApplicationTests {


	@Test
	void contextLoads() {
		ApplicationModules.of(ModulithDemoApplication.class).verify();
	}

}
