package com.mahim.jokesapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JokesappApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(JokesappApplication.class, args);
        FakeDataSource fakeDataSource = context.getBean(FakeDataSource.class);
        System.out.println("Application class: " + fakeDataSource);

        FakeJmsBroker fakeJmsBroker = context.getBean(FakeJmsBroker.class);
        System.out.println("fake jsm broker: " + fakeJmsBroker);
    }

}
