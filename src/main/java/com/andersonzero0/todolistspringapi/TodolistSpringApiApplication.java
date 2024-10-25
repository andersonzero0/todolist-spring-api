package com.andersonzero0.todolistspringapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TodolistSpringApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodolistSpringApiApplication.class, args);
    }

}
