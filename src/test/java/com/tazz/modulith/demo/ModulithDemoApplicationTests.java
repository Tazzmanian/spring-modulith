package com.tazz.modulith.demo;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.test.context.ActiveProfiles;

@Import(TestTestcontainerConfig.class)
@ApplicationModuleTest
@ActiveProfiles("testcontainers")
class ModulithDemoApplicationTests {

	@Test
	void contextLoads() {
		ApplicationModules.of(ModulithDemoApplication.class).verify();
	}

	@Test
	void writeDocumentationSnippets() {
		ApplicationModules modules = ApplicationModules.of(ModulithDemoApplication.class);
		new Documenter(modules)
				.writeModulesAsPlantUml()
				.writeIndividualModulesAsPlantUml();
	}

}
