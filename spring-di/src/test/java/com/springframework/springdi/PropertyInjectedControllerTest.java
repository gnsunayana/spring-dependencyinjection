package com.springframework.springdi;

import com.springframework.springdi.controllers.PropertyInjectedController;
import com.springframework.springdi.services.ConstructorGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropertyInjectedControllerTest {
    PropertyInjectedController controller;

    @BeforeEach
    void setUp(){
         controller = new PropertyInjectedController();
         controller.greetingService= new ConstructorGreetingService();

    }

    @Test
    void getGreeting(){
        System.out.println(controller.getGreeting());
    }
}
