package com.tazz.modulith.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.test.context.ActiveProfiles;


@ActiveProfiles("testcontainers")
public class TestTestcontainersApplication {

    public static void main(String[] args) {
        SpringApplication.from(ModulithDemoApplication::main)
                .with(TestcontainerConfig.class)
                .run(args);
    }
}
