package com.spring.tutorial.lecture.controller.helper.config;

import com.spring.tutorial.lecture.controller.helper.enums.ConditionalOperatorEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConditionalOperatorEnumConverter implements Converter<String, ConditionalOperatorEnum> {

    @Override
    public ConditionalOperatorEnum convert(String conditionalOperator) {
        ConditionalOperatorEnum conditionalOperatorEnum = ConditionalOperatorEnum.getByName(conditionalOperator);

        if (conditionalOperatorEnum == null) {
            throw new IllegalArgumentException(conditionalOperator + " - conditional operator is not supported!");
        }

        return conditionalOperatorEnum;
    }
}
