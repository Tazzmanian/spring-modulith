package com.tazz.modulith.demo.order;

import jakarta.persistence.*;

@Entity
@Table(indexes = {
        @Index(name = "order_index", columnList = "order_id"),
        @Index(name = "inventory_index", columnList = "inventory_id")
})
public record OrderInventory(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        long orderId,
        long inventoryId,
        int quantity,
        long totalQuantityPrice
) {
}
