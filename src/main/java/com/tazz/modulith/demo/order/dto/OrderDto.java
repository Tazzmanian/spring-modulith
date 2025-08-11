package com.tazz.modulith.demo.order.dto;

import java.util.List;

public record OrderDto(
        String customerName,
        String customerEmail,
        List<InventoryRequestDto> inventoryRequestDtoList
) {
}
