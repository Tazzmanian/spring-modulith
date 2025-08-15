package com.tazz.modulith.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.devtools.restart.RestartScope;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;


// https://spring.io/blog/2023/06/23/improved-testcontainers-support-in-spring-boot-3-1
@TestConfiguration(proxyBeanMethods = false)
public class TestTestcontainerConfig {

    @Bean
    Network getNetwork() {
        return Network.builder()
                .driver("bridge")
                .build();
    }

    @Bean
    @ServiceConnection
    @RestartScope // when there is spring-boot-devtools, if not container.withReuse(true) and in testcontainers.properties testcontainers.reuse.enabled=true
    @Qualifier("postgres")
    PostgreSQLContainer<?> postgreSQLContainer(Network network) {
        return new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"))
                .withDatabaseName("test")
                .withUsername("sa")
                .withPassword("sa")
                .withNetwork(network);
    }

//    @Bean
//    @RestartScope
//    @Qualifier("pgadmin")
    GenericContainer<?> pgAdmin(Network network) {
        var container = new GenericContainer<>(DockerImageName.parse("dpage/pgadmin4"))
                .withEnv("PGADMIN_DEFAULT_EMAIL", "pgadmin4@abv.bg")
                .withEnv("PGADMIN_DEFAULT_PASSWORD", "admin")
                .withNetwork(network);

        return container;
    }



}
