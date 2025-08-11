package com.tazz.modulith.demo.order;

import com.tazz.modulith.demo.inventry.exposed.InventoryService;
import org.springframework.stereotype.Service;

@Service
public record OrderService(InventoryService inventoryService) {
}
