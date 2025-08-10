package com.tazz.modulith.demo;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("compose")
//@SpringBootTest
@ApplicationModuleTest
class ModulithDemoApplicationTests {


	@Test
	void contextLoads() {
		ApplicationModules.of(ModulithDemoApplication.class).verify();
	}

}
