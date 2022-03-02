package com.springframework.springdi.services;

public class SetterInjectedGreetingService implements GreetingService{
    @Override
    public String sayGreeting(){
        return "Hello World----Setter";
    }
}
