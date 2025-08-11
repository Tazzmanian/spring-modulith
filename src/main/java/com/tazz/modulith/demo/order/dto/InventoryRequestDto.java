package com.tazz.modulith.demo.order.dto;

public record InventoryRequestDto(
        String inventoryName,
        int quantity
) {
}
