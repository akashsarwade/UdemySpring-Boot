package com.sso.student.app.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

	@GetMapping(value = { "/", "/login" })
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
}
