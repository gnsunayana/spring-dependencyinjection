package com.springframework.springdi;

import com.springframework.springdi.controllers.ConstructorInjectedController;
import com.springframework.springdi.services.ConstructorGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConstructorInjectedControllerTest {

    ConstructorInjectedController controller;
    @BeforeEach
    void setUp(){

        controller = new ConstructorInjectedController(new ConstructorGreetingService());
    }

    @Test
    void getGreeting(){
        System.out.println(controller.getGreeting());
    }
}
