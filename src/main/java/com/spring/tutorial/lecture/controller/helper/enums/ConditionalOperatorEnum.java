package com.spring.tutorial.lecture.controller.helper.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.spring.tutorial.lecture.controller.helper.config.ConditionalOperatorEnumConverter;

import java.util.Arrays;

public enum ConditionalOperatorEnum {
    AND,
    OR;

    ConditionalOperatorEnum() {
    }

    public static ConditionalOperatorEnum getByName(String conditionalOperatorName) {

        return Arrays.stream(ConditionalOperatorEnum.values()).
                filter(conditionalOperatorEnum -> conditionalOperatorEnum.name().equalsIgnoreCase(conditionalOperatorName))
                .findFirst()
                .orElse(null);
    }

    @JsonCreator
    public static ConditionalOperatorEnum fromString(String value) {
        ConditionalOperatorEnumConverter converter = new ConditionalOperatorEnumConverter();
        return converter.convert(value);
    }
}
