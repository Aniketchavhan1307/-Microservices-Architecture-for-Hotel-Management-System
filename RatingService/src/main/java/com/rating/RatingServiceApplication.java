package com.rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication				// @EnableEurekaClient no need to explicitly write this annotation spring boot automatically identify client by looking at pom file where we added a client dependency.........
public class RatingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingServiceApplication.class, args);
	}

}
