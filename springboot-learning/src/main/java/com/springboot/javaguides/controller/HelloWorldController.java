package com.springboot.javaguides.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@ResponseBody
@RestController
public class HelloWorldController {

//	GET
	// http://localhost:8080/hellow
	@GetMapping("/hellow")
	public String Hellow() {
		return "Hello World....";

	}

	// POST
//	PUT
//	DELETE
}
