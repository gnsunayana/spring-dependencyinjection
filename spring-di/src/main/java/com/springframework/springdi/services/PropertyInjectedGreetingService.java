package com.springframework.springdi.services;

public class PropertyInjectedGreetingService implements GreetingService{
    public String sayGreeting(){
        return "Hello World ---- Property";
    }

}
