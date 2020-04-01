package com.spring.tutorial.web.angular;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AngularController {

    /**
     * Match everything without a suffix (so not a static resource) and
     * then forward to home page so that route is preserved.
     **/
    @RequestMapping(value = "/**/{path:[^\\.]*}")
    public String index() {
        return "forward:/";
    }
}
