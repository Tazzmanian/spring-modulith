package com.tazz.modulith.demo.inventry;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(indexes = @Index(name = "inventory_name_index", columnList = "name"))
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    private String description;
    private long price;
}
