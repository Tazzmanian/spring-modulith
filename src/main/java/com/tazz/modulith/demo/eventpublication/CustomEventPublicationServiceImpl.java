package com.tazz.modulith.demo.eventpublication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public record CustomEventPublicationServiceImpl(
        CustomEventPublicationRepository customEventPublicationRepository )
        implements CustomEventPublicationService {


    @Override
    public List<CustomEventPublication> getUncompletedEvents() {
        return customEventPublicationRepository.getAllByPublicationDateNotNullAndCompletionDateIsNull();
    }

    @Override
    public List<CustomEventPublication> getCompletedEvents() {
        return customEventPublicationRepository.getAllByPublicationDateNotNullAndCompletionDateIsNotNull();
    }
}
