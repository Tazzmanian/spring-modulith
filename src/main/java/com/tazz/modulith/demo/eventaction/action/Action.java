package com.tazz.modulith.demo.eventaction.action;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum Action {
    PAYMENT("P"),
    EMAIL("E");

    private String code;

    public static Action getByName(final String code) {
        return Arrays.stream(Action.values()).filter(x -> code.equalsIgnoreCase(x.getCode()))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Invalid action code: " + code));
    }
}
