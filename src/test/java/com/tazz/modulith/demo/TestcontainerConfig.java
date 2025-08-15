package com.tazz.modulith.demo;

import com.github.dockerjava.api.model.*;
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
public class TestcontainerConfig {

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
                .withCreateContainerCmdModifier(cmd -> {
                    cmd.withName("postgres");
//                    cmd.getHostConfig().withBinds(new Bind("postgres-data", new Volume("/var/lib/postgresql/data")));
                })
//                .withEnv("PGDATA", "/var/lib/postgresql/data/pgdata")
                .withDatabaseName("test")
                .withUsername("sa")
                .withPassword("sa")
                .withNetwork(network);
    }

    @Bean
    @RestartScope
    @Qualifier("pgadmin")
    GenericContainer<?> pgAdmin(Network network) {
        var container = new GenericContainer<>(DockerImageName.parse("dpage/pgadmin4"))
                .withCreateContainerCmdModifier(cmd -> {
                    cmd.withName("pgadmin-testcontainer");
                    var hostConfig = cmd.getHostConfig();
                    var ports = new Ports();
                    var portBinding = new PortBinding(new Ports.Binding(null, "5050"), ExposedPort.parse("80"));
                    ports.add(portBinding);
                    hostConfig.withPortBindings(ports);
                    hostConfig.withBinds(new Bind("pg-admin", new Volume("/var/lib/pgadmin")));
                    cmd.withHostConfig(hostConfig);
                })
                .withEnv("PGADMIN_DEFAULT_EMAIL", "pgadmin4@abv.bg")
                .withEnv("PGADMIN_DEFAULT_PASSWORD", "admin")
                .withNetwork(network);

        return container;
    }



}
