package com.spring.tutorial.lecture.controller;

import com.spring.tutorial.lecture.controller.helper.service.MyService;
import com.spring.tutorial.lecture.controller.helper.Resource;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

@RestController
@Validated
public class ControllerB {

    private final MyService myService;

    public ControllerB(MyService myService) {
        this.myService = myService;
    }

    @GetMapping(value = "api/resource", produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource getResource(@RequestParam Long id) {
        return myService.doWork(id);
    }

    @GetMapping(value = "api/resource/criteria/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource getResourceByCriteria(@RequestParam String searchWord,
                                          @PathVariable("id") Long id,
                                          @RequestParam(required = false, name = "after_date") Instant after) {
        return myService.doWork(searchWord, after);
    }

    @GetMapping(value = "api/resource/validated_criteria", produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource getResourceByValidatedCriteria(@Size(min = 3, max = 7) @RequestParam String searchWord,
                                                   @NotNull @RequestParam Instant after,
                                                   @Min(2000) @Max(2025) @RequestParam int year) {
        return myService.doWork(searchWord, after, year);
    }

}
