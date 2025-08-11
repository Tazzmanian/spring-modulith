package com.tazz.modulith.demo.inventry.exposed;

import com.tazz.modulith.demo.inventry.Inventory;
import com.tazz.modulith.demo.inventry.InventoryUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
record InventoryServiceImpl(InventoryRepository inventoryRepository)
        implements InventoryService {
    @Override
    public InventoryDto fetchInventoryByName(String name) {
        Inventory inv = inventoryRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Inventory not found: " + name));
        return InventoryUtils.convertToDto(inv);
    }

    @Override
    public List<InventoryDto> fetchAllWithNames(List<String> names) {
        return inventoryRepository.findByNameIn(names)
                .stream().map(InventoryUtils::convertToDto).toList();
    }
}
