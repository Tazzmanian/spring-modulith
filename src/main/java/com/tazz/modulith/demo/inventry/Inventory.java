package com.tazz.modulith.demo.inventry;

import jakarta.persistence.*;

@Entity
@Table(indexes = @Index(name="inventory_name_index", columnList = "name"))
public record Inventory(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        @Column(unique = true, nullable = false)
        String name,
        String description,
        long price
) {
}
