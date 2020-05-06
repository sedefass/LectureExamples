package com.spring.tutorial.lecture.controller.helper.dto;

import com.spring.tutorial.lecture.controller.helper.enums.ConditionalOperatorEnum;

import javax.validation.constraints.*;
import java.util.List;

public class ValidatedRequestDto {

    @Min(5)
    @Max(10)
    private int number;
    private String text;
    private ConditionalOperatorEnum conditionalOperator;
    @NotEmpty
    private List<Double> numbers;
    @NotNull
    private Person person;

    public ValidatedRequestDto() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ConditionalOperatorEnum getConditionalOperator() {
        return conditionalOperator;
    }

    public void setConditionalOperator(ConditionalOperatorEnum conditionalOperator) {
        this.conditionalOperator = conditionalOperator;
    }

    public List<Double> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Double> numbers) {
        this.numbers = numbers;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
