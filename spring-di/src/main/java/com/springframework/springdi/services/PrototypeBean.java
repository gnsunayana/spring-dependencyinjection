package com.springframework.springdi.services;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class PrototypeBean {
    public PrototypeBean(){
        System.out.println("Creating a Prototype Bean !!!!!!!!!!!!!!!!");
    }

    public String getMyScope(){
        return "Iam a prototype";
    }
}
