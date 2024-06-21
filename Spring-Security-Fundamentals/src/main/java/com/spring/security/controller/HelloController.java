package com.spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

	@GetMapping("/hello")
	public String Hello() {
		return "Welcome to Spring Security";
	}

	@GetMapping("/bye")
	public String Bye() {
		return "Get Lost........!";
	}

}
