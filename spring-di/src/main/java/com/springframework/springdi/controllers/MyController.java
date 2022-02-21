package com.springframework.springdi.controllers;

import com.springframework.springdi.services.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    private final GreetingService greetingService;

    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    /* public String sayHello(){
        System.out.println("Hello World !!!");
        return "Hi Folks";
    }*/

    public String sayHello(){
           return greetingService.sayGreeting();
    }
}
