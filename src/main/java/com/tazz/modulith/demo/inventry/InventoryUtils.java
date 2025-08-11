package com.tazz.modulith.demo.inventry;

import com.tazz.modulith.demo.inventry.exposed.InventoryDto;

import java.util.List;


public interface InventoryUtils {
    static InventoryDto convertToDto(Inventory inventory) {
        return new InventoryDto(
            inventory.getId(), inventory.getName(), inventory.getDescription(), inventory.getPrice()
        );
    }

    static List<InventoryDto> convertToDto(List<Inventory> list) {
        return list.stream().map(InventoryUtils::convertToDto).toList();
    }
}
