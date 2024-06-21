package com.spring.coupon.microservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}// so this encoder will be use when the request coming to encode the password
		// and compare with what we have in the database

	@Bean // this method receive httpSecurity object
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//		http.httpBasic();// authentication method
//		http.authorizeHttpRequests()// authorize request
//				.requestMatchers(HttpMethod.GET, "/coupons/getCoupons/{code:[A-Z]*$}")
//				.hasAnyRole("USER", "ADMIN")
//				.requestMatchers(HttpMethod.POST, "/coupons/createCoupon/")
//				.hasRole("ADMIN")
//				.and()
//				.csrf()
//				.disable();
//		return http.build();
		
		
		
//		http.httpBasic();// authentication method
		http.formLogin();
        http.authorizeHttpRequests()// authorize request
                .requestMatchers(HttpMethod.GET, "/coupons/getCoupons/{code:^[A-Z]*$}","/")
                .hasAnyRole("USER","ADMIN")
                
                .requestMatchers(HttpMethod.POST, "/coupons/createCoupon")
                .hasRole("ADMIN")
                .and()
                .csrf()//cross-site request forging, post req will not work thats why we disabled it
                .disable();
        return http.build();

	}
}
