package com.springframework.springdi.config;

import com.springframework.pets.DogPetService;
import com.springframework.pets.PetService;
import com.springframework.pets.PetServiceFactory;
import com.springframework.springdi.datasource.FakeDataSource;
import com.springframework.springdi.repositories.EnglishGreetingRepository;
import com.springframework.springdi.repositories.EnglishGreetingRepositoryImpl;
import com.springframework.springdi.services.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

@EnableConfigurationProperties(SpringConstructorConfig.class)
//@PropertySource("classpath:datasource.properties")
//Taking out @PropertySource annotation to use Spring boot capabilities.
@ImportResource("classpath:springdi-config.xml")
@Configuration
public class GreetingServiceConfig {
   // Implementing it with xml configuration
   /* @Bean
    ConstructorGreetingService constructorGreetingService(){
        return new ConstructorGreetingService();
    }*/

    //This is little verbose so we are changing to do it the below way
  /*  @Bean
    FakeDataSource fakeDataSource(@Value("${guru.username}") String username,
                                  @Value("${guru.password}") String password,
                                  @Value("${guru.jdbcurl}") String jdbcurl){
          FakeDataSource fakeDataSource = new FakeDataSource();
          fakeDataSource.setUsername(username);
          fakeDataSource.setPassword(password);
          fakeDataSource.setJdbcurl(jdbcurl);
          return fakeDataSource;
    }*/
    // You can use SpringdiConfiguration also as the method parameter here to supply the value
    @Bean
    FakeDataSource fakeDataSource(SpringConstructorConfig springConstructorConfig){
        FakeDataSource fakeDataSource= new FakeDataSource();
        fakeDataSource.setUsername(springConstructorConfig.getUsername());
        fakeDataSource.setPassword(springConstructorConfig.getPassword());
        fakeDataSource.setJdbcurl(springConstructorConfig.getJdbcurl());
        return fakeDataSource;
    }
    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){
        return new SetterInjectedGreetingService();
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){
          return new PrimaryGreetingService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean("i18nService")
    I18nEnglishGreetingService i18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository){
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }
    // If you dont give the name in the bean annotation, the name of the bean created will be the method name by default. You can
    // override it by giving a name in the @Bean annotation. In his example he changed the value of the method name for one
    // method and overrided the other using bean annotation.
    @Profile({"ES","default"})
    @Bean("i18nService")
    I18nSpanishGreetingService i18nSpanishGreetingService(){
        return new I18nSpanishGreetingService();
    }

    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }

    @Bean
    @Profile({"dog","default"})
    PetService dogPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("dog");
    }

    @Bean
    @Profile("cat")
    PetService catPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("cat");
    }
}
