package com.tazz.modulith.demo.order.dto;

import com.tazz.modulith.demo.eventaction.action.Action;
import com.tazz.modulith.demo.eventaction.action.CustomEventMarker;
import org.jmolecules.event.types.DomainEvent;

@CustomEventMarker(eventAction = Action.PAYMENT)
public record OrderPaymentDto(
        String orderId,
        long amount
) implements DomainEvent {
}
