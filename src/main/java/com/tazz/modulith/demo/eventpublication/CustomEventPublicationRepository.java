package com.tazz.modulith.demo.eventpublication;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

interface CustomEventPublicationRepository extends CrudRepository<CustomEventPublication, UUID> {
    List<CustomEventPublication> getAllByPublicationDateNotNullAndCompletionDateIsNull();
    List<CustomEventPublication> getAllByPublicationDateNotNullAndCompletionDateIsNotNull();
}
