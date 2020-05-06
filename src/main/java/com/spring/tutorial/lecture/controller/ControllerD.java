package com.spring.tutorial.lecture.controller;

import com.spring.tutorial.lecture.controller.helper.Resource;
import com.spring.tutorial.lecture.controller.helper.dto.MultipartDto;
import com.spring.tutorial.lecture.controller.helper.dto.SimpleRequestDto;
import com.spring.tutorial.lecture.controller.helper.dto.ValidatedRequestDto;
import com.spring.tutorial.lecture.controller.helper.service.MyService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ControllerD {

    private final MyService myService;

    public ControllerD(MyService myService) {
        this.myService = myService;
    }

    @PostMapping(value = "api/body/partA", produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource postA(@RequestBody() SimpleRequestDto simpleRequestDto) {
        return myService.doWork(simpleRequestDto);
    }

    @PostMapping(value = "api/body/partB", produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource postB(@RequestParam boolean isItReally, @RequestBody() SimpleRequestDto simpleRequestDto) {
        return myService.doWork(simpleRequestDto, isItReally);
    }

    @PostMapping(value = "api/body/partC", produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource postC(@Valid @RequestBody() ValidatedRequestDto validatedRequestDto) {
        return myService.doWork(validatedRequestDto);
    }

    @PostMapping(value = "api/body/partD", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource postD(@Valid @ModelAttribute() MultipartDto multipartDto) {
        return myService.doWork(multipartDto);
    }

}
