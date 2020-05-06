package com.spring.tutorial.lecture.controller.helper.service;

import com.spring.tutorial.lecture.controller.helper.Resource;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    public Resource doWork(Object... object) {
        // do some work
        return new Resource(8L, "Newsletter", "Our newsletter system is...");
    }

    public Resource doNoWork(Object... object) {
        // do some work
        return new Resource(null, "", "");
    }

}
