package com.tazz.modulith.demo.payment;

import com.tazz.modulith.demo.order.dto.OrderPaymentDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PaymentEventService {

    @ApplicationModuleListener
    void on(final OrderPaymentDto dto) {
        log.info("Order payment completed: {}", dto);
    }
}
