package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
@OpenAPI30
@SpringBootApplication
public class EnviosApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnviosApplication.class, args);
	}

}
