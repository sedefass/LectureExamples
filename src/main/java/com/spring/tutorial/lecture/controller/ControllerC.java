package com.spring.tutorial.lecture.controller;

import com.spring.tutorial.lecture.controller.helper.enums.ConditionalOperatorEnum;
import com.spring.tutorial.lecture.controller.helper.enums.MathOperatorEnum;
import com.spring.tutorial.lecture.controller.helper.service.MyService;
import com.spring.tutorial.lecture.controller.helper.Resource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class ControllerC {

    private final MyService myService;

    public ControllerC(MyService myService) {
        this.myService = myService;
    }

    @GetMapping(value = "api/enum", produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource getResource(@RequestParam ConditionalOperatorEnum operator) {
        return myService.doWork(operator);
    }

    @GetMapping(value = "api/enum2", produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource getResource(@RequestParam MathOperatorEnum operator) {
        return myService.doWork(operator);
    }

    @GetMapping(value = "api/localDate", produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource getResource(@RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date) {
        return myService.doWork(date);
    }

}
