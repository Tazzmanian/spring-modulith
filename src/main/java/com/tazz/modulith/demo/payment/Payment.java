package com.tazz.modulith.demo.payment;

import com.tazz.modulith.demo.payment.type.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Timestamp;
import java.time.Instant;

@Entity
public record Payment(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        String orderId,
        long amount,
        Timestamp paymentDate,
        PaymentStatus status
) {

    public Payment {
        paymentDate = Timestamp.from(Instant.now());
    }
}
