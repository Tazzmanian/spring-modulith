package com.tazz.modulith.demo.eventpublication;

import com.tazz.modulith.demo.TestTestcontainerConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.doReturn;

@Import(TestTestcontainerConfig.class)
@ActiveProfiles("testcontainers")
@ApplicationModuleTest
class CustomEventPublicationServiceTest {


    @MockitoBean
    CustomEventPublicationRepository customEventPublicationRepository;

    @Autowired
    CustomEventPublicationService customEventPublicationService;

    @Test
    void getUncompletedEvents() {
        CustomEventPublication event =
                new CustomEventPublication(UUID.randomUUID().toString(), "event type", "listener id", null,
                        Timestamp.from(Instant.now()), "serialized event");
        doReturn(List.of(event)).when(customEventPublicationRepository).getAllByPublicationDateNotNullAndCompletionDateIsNull();
        org.assertj.core.api.Assertions.assertThat(customEventPublicationService.getUncompletedEvents())
                .isNotEmpty()
                .allSatisfy( ev -> {
                            org.assertj.core.api.Assertions.assertThat(event.getCompletionDate()).isNull();
                        }
                );
    }

    @Test
    void getCompletedEvents() {
        CustomEventPublication event =
                new CustomEventPublication(UUID.randomUUID().toString(), "event type", "listener id", Timestamp.from(Instant.now()),
                        Timestamp.from(Instant.now()), "serialized event");
        doReturn(List.of(event)).when(customEventPublicationRepository).getAllByPublicationDateNotNullAndCompletionDateIsNotNull();
        org.assertj.core.api.Assertions.assertThat(customEventPublicationService.getCompletedEvents())
                .isNotEmpty()
                .allSatisfy( ev -> {
                            org.assertj.core.api.Assertions.assertThat(event.getCompletionDate()).isNotNull();
                        }
                );
    }

}