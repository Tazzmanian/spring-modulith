package com.tazz.modulith.demo.order.type.converter;

import com.tazz.modulith.demo.order.type.Status;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<Status, String> {

    @Override
    public String convertToDatabaseColumn(Status attribute) {
        try {
            return attribute.getCode();
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid status: " + attribute.toString(), e);
        }
    }

    @Override
    public Status convertToEntityAttribute(String dbData) {
        try {
            return Status.valueOf(dbData);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid status code: " + dbData, e);
        }
    }
}
