package com.spring.tutorial.lecture.controller.helper.dto;

import com.spring.tutorial.lecture.controller.helper.enums.ConditionalOperatorEnum;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class MultipartDto {

    @Min(5)
    @Max(10)
    private int number;
    private String text;
    private ConditionalOperatorEnum conditionalOperator;
    @NotEmpty
    private List<Double> numbers;
    @NotNull
    private Person person;

    private MultipartFile file;

    public MultipartDto() {
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

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
