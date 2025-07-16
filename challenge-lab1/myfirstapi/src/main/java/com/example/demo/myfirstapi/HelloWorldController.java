package com.example.demo.myfirstapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Value("${app.greeting.message}")
    private String customGreeting;

    @GetMapping("/hello")
    public String sayHello(){
        return customGreeting;
    }

    @GetMapping("/greet/{name}")
    public String greetUser(@PathVariable String name){
        return "Hello! " + name + ".";
    }

}
