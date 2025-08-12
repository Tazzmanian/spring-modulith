package com.tazz.modulith.demo;

import org.springframework.boot.devtools.restart.RestartScope;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
public class TestcontainerConfig {

    @Bean
    Network getNetwork() {
        return Network.newNetwork();
    }

    @Bean
    @ServiceConnection
    @RestartScope // when there is spring-boot-devtools, if not container.withReuse(true) and in testcontainers.properties testcontainers.reuse.enabled=true
    PostgreSQLContainer<?> postgreSQLContainer(Network network) {
        return new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"))
                .withCreateContainerCmdModifier(cmd -> cmd.withName("postgres"))
                .withDatabaseName("test")
                .withUsername("sa")
                .withPassword("sa")
                .withNetwork(network);
    }

    @Bean
    @RestartScope
    GenericContainer<?> pgAdmin(Network network) {
        return new GenericContainer<>(DockerImageName.parse("dpage/pgadmin4"))
                .withCreateContainerCmdModifier(cmd -> cmd.withName("pgadmin-testcontainer"))
                .withEnv("PGADMIN_DEFAULT_EMAIL", "pgadmin4@abv.bg")
                .withEnv("PGADMIN_DEFAULT_PASSWORD", "admin")
//                .withEnv("PGADMIN_CONFIG_SERVER_MODE", "false")
                .withExposedPorts(80)
                .withNetwork(network);
    }



}
