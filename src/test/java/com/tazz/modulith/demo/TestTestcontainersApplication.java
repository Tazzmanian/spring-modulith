package com.tazz.modulith.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@Profile("testcontainers")
@TestConfiguration(proxyBeanMethods = false)
public class TestTestcontainersApplication {

    @Bean
    @ServiceConnection
    PostgreSQLContainer<?> postgreSQLContainer() {
        return new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"))
                .withDatabaseName("test")
                .withUsername("sa")
                .withPassword("sa");
    }

    public static void main(String[] args) {
        SpringApplication.from(ModulithDemoApplication::main)
                .with(TestTestcontainersApplication.class).run(args);
    }
}
