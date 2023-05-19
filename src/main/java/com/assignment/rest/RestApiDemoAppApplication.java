package com.assignment.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class RestApiDemoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiDemoAppApplication.class, args);
	}

}
