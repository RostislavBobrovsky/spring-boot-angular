package com.itechart.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
//		SpringApplication.run(new Class<?>[]{Application.class, JpaConfiguration.class}, args);
		SpringApplication.run(Application.class, args);
	}
}
