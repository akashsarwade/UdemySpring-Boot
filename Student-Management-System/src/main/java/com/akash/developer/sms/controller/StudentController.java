package com.akash.developer.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.akash.developer.sms.entity.Student;
import com.akash.developer.sms.repository.StudentRepository;
import com.akash.developer.sms.service.StudentService;

@Controller
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	// CREATE

	@GetMapping("/students")
	public String listStudents(org.springframework.ui.Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}

	@GetMapping("/students/new")
	public String createStudentForm(Model model) {

		// create student object to hold student form data
		Student student = new Student();
		model.addAttribute("student", student);
		return "create-student";

	}

	@PostMapping("/students")
	public String saveStudents(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}

	@GetMapping("/students/edit/{id}")
	public String studentEditForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit-student";

	}

	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {

		// get student from DB
		Student existstud = studentService.getStudentById(id);
		existstud.setId(id);
		existstud.setFirstName(student.getFirstName());
		existstud.setLastName(student.getLastName());
		existstud.setEmail(student.getEmail());
		existstud.setAddress(student.getAddress());
		existstud.setContact(student.getContact());

		// save update student to Object
		studentService.updateStudent(existstud);
		return "redirect:/students";
	}

	// Handler method to delete student request

	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
}
