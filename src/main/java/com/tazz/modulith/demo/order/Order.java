package com.tazz.modulith.demo.order;

import com.tazz.modulith.demo.order.type.Status;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public final class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String identifier;
    private String customerName;
    private String customerEmail;
    @Setter(AccessLevel.NONE)
    private Timestamp orderDate;
    private Status status;

    public Order(
            Long id,
            String identifier, String customerName, String customerEmail, Timestamp orderDate, Status status) {
        if (status == null) {
            status = Status.OPEN;
        }
        this.id = id;
        this.identifier = identifier;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.orderDate = orderDate;
        this.status = status;
    }
}
