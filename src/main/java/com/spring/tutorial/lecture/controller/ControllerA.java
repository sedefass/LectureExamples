package com.spring.tutorial.lecture.controller;

import com.spring.tutorial.lecture.controller.helper.service.MyService;
import com.spring.tutorial.lecture.controller.helper.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@RestController
public class ControllerA {

    private final MyService myService;

    public ControllerA(MyService myService) {
        this.myService = myService;
    }

    @GetMapping(value = "api/resource/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource getResource(@PathVariable("id") Long id) {
        return myService.doWork(id);
    }

    @PostMapping(value = "api/resource/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource postResource(@PathVariable("id") Long id) {
        return myService.doWork(id);
    }

    @PutMapping(value = "api/resource/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource putResource(@PathVariable("id") Long id) {
        return myService.doWork(id);
    }

    @DeleteMapping(value = "api/resource/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource deleteResource(@PathVariable("id") Long id) {
        return myService.doWork(id);
    }



    // ResponseEntity
    @GetMapping(value = "api/resource/response-entity/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Resource> getResource2(@PathVariable("id") Long id) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Custom-Header", "Oops");
        return new ResponseEntity<>(myService.doNoWork(id), responseHeaders, HttpStatus.NOT_FOUND);
    }

    // Request and response headers
    @GetMapping(value = "api/resource/http-context/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Resource> getResource3(@PathVariable("id") Long id,
                                                 @RequestHeader HttpHeaders requestHeaders,
                                                 @RequestHeader(value = "optional-header", defaultValue = "3600") int optionalHeader,
                                                 HttpServletRequest request,
                                                 HttpServletResponse response,
                                                 Principal principal) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Custom-Header", "Oops");
        return new ResponseEntity<>(myService.doNoWork(id), responseHeaders, HttpStatus.NOT_FOUND);
    }

}
