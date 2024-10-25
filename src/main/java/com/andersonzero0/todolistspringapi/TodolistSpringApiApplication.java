package com.andersonzero0.todolistspringapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "To-do List API", version = "1", description = "A simple to-do list API"))
@EnableJpaAuditing
public class TodolistSpringApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodolistSpringApiApplication.class, args);
    }

}
