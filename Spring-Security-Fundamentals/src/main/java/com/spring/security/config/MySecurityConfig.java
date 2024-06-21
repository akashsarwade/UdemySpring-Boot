package com.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class MySecurityConfig {
	@Bean
	UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager userDetailService = new InMemoryUserDetailsManager();
		UserDetails user = User
				.withUsername("tom")
				.password(passEncoder()
				.encode("cruise")).authorities("read")
				.build();
		userDetailService.createUser(user);
		return userDetailService;
	}

	@Bean
	BCryptPasswordEncoder passEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain filterchain(HttpSecurity http) throws Exception {
		http.httpBasic();//
//		http.formLogin(); //2
		http.authorizeHttpRequests()
//1		.anyRequest()
		.requestMatchers("/hello")//with other request we can't access the page  only access for hello
		.authenticated();// authorised request must be authenticated
		http.addFilterBefore(new MySecurityFilter(), BasicAuthenticationFilter.class);
		return http.build();
	}
}
