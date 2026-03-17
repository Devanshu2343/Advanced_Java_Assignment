package com.lpu.LearnSpring.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(path="/hello")
    public String helloWrd(){
        return "hello world";
    }
}
