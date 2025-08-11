package com.tazz.modulith.demo.order;

import com.tazz.modulith.demo.order.dto.OrderDto;
import com.tazz.modulith.demo.order.type.Status;

import java.util.UUID;

public interface OrderUtils {

    static Order mapDtoToOrder(OrderDto dto) {
        Order order = new Order();
        order.setStatus(Status.COMPLETED);
        order.setIdentifier(UUID.randomUUID().toString());
        order.setCustomerName(dto.customerName());
        order.setCustomerEmail(dto.customerEmail());

        return order;
    }
}
