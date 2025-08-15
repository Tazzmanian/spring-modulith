package com.tazz.modulith.demo.eventaction;

import com.tazz.modulith.demo.eventaction.action.Action;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EventActionRepository extends CrudRepository<EventAction, Long> {
    Optional<EventAction> findByAction(Action action);
}
