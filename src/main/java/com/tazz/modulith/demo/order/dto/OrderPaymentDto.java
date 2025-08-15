package com.tazz.modulith.demo.order.dto;

import com.tazz.modulith.demo.eventactioin.action.Action;
import com.tazz.modulith.demo.eventactioin.action.CustomEventMarker;
import org.jmolecules.event.types.DomainEvent;

@CustomEventMarker(eventAction = Action.PAYMENT)
public record OrderPaymentDto(
        String orderId,
        long amount
) implements DomainEvent {
}
