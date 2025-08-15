package com.tazz.modulith.demo.order;

import com.tazz.modulith.demo.order.dto.OrderPaymentDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderEventService {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public void completeOrder(final OrderPaymentDto order) {
        log.info("completing order payment: {}", order);
        applicationEventPublisher.publishEvent(order);
    }
}
