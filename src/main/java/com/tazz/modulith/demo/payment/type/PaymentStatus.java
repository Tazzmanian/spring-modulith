package com.tazz.modulith.demo.payment.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum PaymentStatus {
    INCOMPLETED("I"),
    COMPLETED("C"),
    FAILED("F");

    private final String code;
}
