package com.tazz.modulith.demo.payment.type.converter;

import com.tazz.modulith.demo.payment.type.PaymentStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PaymentStatusConverter implements AttributeConverter<PaymentStatus, String> {

    @Override
    public String convertToDatabaseColumn(PaymentStatus attribute) {
        try {
            return attribute.getCode();
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid payment status: " + attribute.toString(), e);
        }
    }

    @Override
    public PaymentStatus convertToEntityAttribute(String dbData) {
        try {
            return PaymentStatus.valueOf(dbData);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid payment status code: " + dbData, e);
        }
    }
}
