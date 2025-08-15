package com.tazz.modulith.demo.eventactioin.action.converters;

import com.tazz.modulith.demo.eventactioin.action.Action;
import jakarta.persistence.AttributeConverter;

public class ActionConverter implements AttributeConverter<Action, String> {
    @Override
    public String convertToDatabaseColumn(Action attribute) {
        return Action.EMAIL.getCode();
    }

    @Override
    public Action convertToEntityAttribute(String dbData) {
        return Action.getByName(dbData);
    }
}
