package com.tazz.modulith.demo.eventactioin;

import com.tazz.modulith.demo.eventactioin.action.Action;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EventActionRepository extends CrudRepository<EventAction, Long> {
    Optional<EventAction> findByAction(Action action);
}
