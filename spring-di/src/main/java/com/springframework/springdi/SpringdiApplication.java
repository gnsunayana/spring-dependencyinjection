package com.springframework.springdi;

import com.springframework.springdi.config.SpringConstructorConfig;
import com.springframework.springdi.config.SpringdiConfiguration;
import com.springframework.springdi.controllers.*;
import com.springframework.springdi.datasource.FakeDataSource;
import com.springframework.springdi.services.PrototypeBean;
import com.springframework.springdi.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.springframework.springdi","com.springframework.pets"})
public class SpringdiApplication {

	public static void main(String[] args) {

		ApplicationContext ctx =SpringApplication.run(SpringdiApplication.class, args);

		PetController petController =(PetController) ctx.getBean("petController");
		System.out.println("The Best pet is ");
		System.out.println(petController.whichPetIsTheBest());


		I18nController i18nController =(I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());

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


		System.out.println("--------Bean Scopes-----");
		SingletonBean singletonBean1 =(SingletonBean) ctx.getBean("singletonBean");
		//SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean1.getMyScope());
		SingletonBean singletonBean2 = (SingletonBean)ctx.getBean("singletonBean");
		System.out.println(singletonBean2.getMyScope());

		PrototypeBean prototypeBean1 = (PrototypeBean)ctx.getBean("prototypeBean");
		//PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean1.getMyScope());
		PrototypeBean prototypeBean2 = (PrototypeBean)ctx.getBean("prototypeBean");
		System.out.println(prototypeBean2.getMyScope());


		System.out.println("Fake Data Source:");
		FakeDataSource fakeDataSource= (FakeDataSource)ctx.getBean("fakeDataSource");
		System.out.println(fakeDataSource.getUsername());
		System.out.println(fakeDataSource.getPassword());
		System.out.println(fakeDataSource.getJdbcurl());


		System.out.println("--------Config Props Bean-------");
		SpringdiConfiguration springdiConfiguration = ctx.getBean(SpringdiConfiguration.class);
		System.out.println(springdiConfiguration.getUsername());
		System.out.println(springdiConfiguration.getPassword());
		System.out.println(springdiConfiguration.getJdbcurl());

		System.out.println("----------Constructor Binding --------");
		SpringConstructorConfig springConstructorConfig = ctx.getBean(SpringConstructorConfig.class);
		System.out.println(springConstructorConfig.getUsername());
		System.out.println(springConstructorConfig.getPassword());
		System.out.println(springConstructorConfig.getJdbcurl());

	}

}
