package com.tazz.modulith.demo.eventpublication;

import java.util.List;

public interface CustomEventPublicationService {

    List<CustomEventPublication> getUncompletedEvents();
    List<CustomEventPublication> getCompletedEvents();
}
