package com.tazz.modulith.demo.payment;

import com.tazz.modulith.demo.payment.type.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
public final class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderId;
    private long amount;
    private Timestamp paymentDate;
    private PaymentStatus status;

    public Payment(
            Long id, String orderId, long amount, Timestamp paymentDate, PaymentStatus status) {
        paymentDate = Timestamp.from(Instant.now());
        this.id = id;
        this.orderId = orderId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.status = status;
    }
}
