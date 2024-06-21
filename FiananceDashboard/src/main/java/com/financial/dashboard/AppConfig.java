package com.financial.dashboard;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.financial.dashboard.service.UserService;

@Configuration
public class AppConfig {

	@Bean
	UserService createUserService() {

		String[] columnNames = { "Id", "firstName", "lastName", "email", "phoneNo", "dateRegistered", "lastVisitDate" };
		return new UserService(columnNames);
	}
	
	public 

}
