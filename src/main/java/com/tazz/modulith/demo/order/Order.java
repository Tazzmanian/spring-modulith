package com.tazz.modulith.demo.order;

import com.tazz.modulith.demo.order.type.Status;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public record Order(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        @Column(unique = true, nullable = false)
        String identifier,
        String customerName,
        String customerEmail,
        Timestamp orderDate,
        Status status
) {
    public Order {
        if (status == null) {
            status = Status.OPEN;
        }
    }
}
