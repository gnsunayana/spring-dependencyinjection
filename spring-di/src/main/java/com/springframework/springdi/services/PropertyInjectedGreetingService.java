package com.springframework.springdi.services;

import org.springframework.stereotype.Service;

@Service
public class PropertyInjectedGreetingService implements GreetingService{
    public String sayGreeting(){
        return "Hello World ---- Property";
    }

}
