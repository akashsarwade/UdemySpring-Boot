package com.springboot.javaguides;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springboot.javaguides.sub1.SpringComponent;

@SpringBootApplication
public class SpringbootLearningApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringbootLearningApplication.class,
				args);
		SpringComponent component = applicationContext.getBean(SpringComponent.class);
		System.out.println(component.getMsg());
		System.out.println("Welcome to Spring Boot Application");
	}

}
