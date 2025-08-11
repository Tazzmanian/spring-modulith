package com.tazz.modulith.demo.inventry.exposed;

public record InventoryDto(
        Long id,
        String name,
        String description,
        long price
) {
}
