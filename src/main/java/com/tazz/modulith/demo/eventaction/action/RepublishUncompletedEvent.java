package com.tazz.modulith.demo.eventaction.action;

import com.tazz.modulith.demo.eventaction.EventActionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.env.Environment;
import org.springframework.modulith.events.CompletedEventPublications;
import org.springframework.modulith.events.IncompleteEventPublications;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@Slf4j
public record RepublishUncompletedEvent(EventActionRepository eventActionRepository,
                                        ApplicationEventPublisher applicationEventPublisher,
                                        IncompleteEventPublications incompleteEventPublications,
                                        CompletedEventPublications completedEventPublications,
                                        Environment environment) {

    public void republish(Action action) {


        eventActionRepository.findByAction(action).ifPresentOrElse(x -> {
            log.info("Republish uncompleted actions {}", action);
            try {
                Class<?> actionClass = Class.forName(x.getEventCanonicalName());
                incompleteEventPublications.resubmitIncompletePublications(ep -> ep.getEvent().getClass() == actionClass);
                completedEventPublications
                        .deletePublicationsOlderThan(Duration.ofHours(environment.getProperty("delete.event.action", Integer.class, 4)));
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }, () -> log.info("No event action found for action: {}", action));
    }
}
