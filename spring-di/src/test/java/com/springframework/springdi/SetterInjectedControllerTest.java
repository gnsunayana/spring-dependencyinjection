package com.springframework.springdi;

import com.springframework.springdi.controllers.SetterInjectedController;
import com.springframework.springdi.services.ConstructorGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SetterInjectedControllerTest {

    SetterInjectedController controller;

    @BeforeEach
    void setUp(){
         controller = new SetterInjectedController();
         controller.setGreetingService(new ConstructorGreetingService());
    }

    @Test
    void getGreeting(){
        System.out.println(controller.getGreeting());
    }
}
