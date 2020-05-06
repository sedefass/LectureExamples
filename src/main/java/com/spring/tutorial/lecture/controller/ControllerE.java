package com.spring.tutorial.lecture.controller;

import com.spring.tutorial.lecture.controller.helper.dto.Person;
import com.spring.tutorial.lecture.controller.helper.dto.SimpleRequestDto;
import com.spring.tutorial.lecture.controller.helper.enums.ConditionalOperatorEnum;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ControllerE {

    @GetMapping(value = "api/response/partA", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person getA() {
        return new Person("John Does", 28);
    }

    @GetMapping(value = "api/response/partB", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<String> getB() {
        return new ArrayList<>() {{ add("List"); add("of"); add("strings"); }};
    }

    @GetMapping(value = "api/response/partC", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Person> getC() {
        ArrayList<Person> result = new ArrayList<>();
        result.add(new Person("John Does", 28));
        result.add(new Person("Aes Dana", 32));
        result.add(new Person("John Does", 28));
        return result;
    }

    @GetMapping(value = "api/response/partD", produces = MediaType.APPLICATION_JSON_VALUE)
    public SimpleRequestDto getD() {
        SimpleRequestDto result = new SimpleRequestDto();
        result.setNumber(1);
        result.setText("Yeah");
        result.setConditionalOperator(ConditionalOperatorEnum.OR);
        result.setNumbers(new ArrayList<>(){{add(1.0); add(2.0);}});
        result.setPerson(new Person("John Does", 28));
        return result;
    }

}
