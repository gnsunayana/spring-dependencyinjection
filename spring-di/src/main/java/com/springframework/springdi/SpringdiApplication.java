package com.springframework.springdi;

import com.springframework.springdi.controllers.ConstructorInjectedController;
import com.springframework.springdi.controllers.MyController;
import com.springframework.springdi.controllers.PropertyInjectedController;
import com.springframework.springdi.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringdiApplication {

	public static void main(String[] args) {

		ApplicationContext ctx =SpringApplication.run(SpringdiApplication.class, args);
		MyController myController =(MyController) ctx.getBean("myController");
		String greeting =myController.sayHello();
		System.out.println("Inside main method");
		System.out.println("-----Primary");
		System.out.println(greeting);

		System.out.println("--------Property");

		PropertyInjectedController propertyInjectedController = (PropertyInjectedController)ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("--------------Setter");

		SetterInjectedController setterInjectedController =(SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("----------Constructor");

		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController)ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());



	}

}
