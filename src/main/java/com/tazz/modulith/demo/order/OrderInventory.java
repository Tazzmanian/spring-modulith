package com.tazz.modulith.demo.order;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(indexes = {
        @Index(name = "order_index", columnList = "order_id"),
        @Index(name = "inventory_index", columnList = "inventory_id")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class OrderInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long orderId;
    private long inventoryId;
    private int quantity;
    private long totalQuantityPrice;
}
