package com.sso.student.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan({ "com.sso.student.app.Controller", "com.sso.student.app.service", "com.sso.student.app.security" })
//@EntityScan({ "com.sso.student.app.entity" })
//@EnableJpaRepositories({ "com.sso.student.app.repository" })
public class SSOProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SSOProjectApplication.class, args);
		
		System.err.println("Application Started.");
	}

}
