package com.springboot.javaguides.StudentController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.javaguides.model.Student;

@RestController
public class StudentController {

	@GetMapping("/student")
	public Student getStudent() {
		return new Student("Akash", "Sarwade", "Pune");

	}

	@GetMapping("/students")
	public List<Student> studentList() {
		List<Student> stud = new ArrayList<>();
		stud.add(new Student("Rajesh", "Singhal", "Punjab"));
		stud.add(new Student("Priya", "Dixit", "Mimbai"));
		stud.add(new Student("Sham", "patil", "Mimbai"));
		stud.add(new Student("Vikrant", "sacksena", "kochi"));
		stud.add(new Student("venkata", "Ayyar", "Chennai"));
		return stud;
		//it will convert List of student object in =to array of JSON Object

	}
}
