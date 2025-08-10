package com.tazz.modulith.demo.order.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public enum Status {
    OPEN("O"),
    COMPLETED("C");

    private final String code;
}
