package com.akash.developer.sms.service;

import java.util.List;

import com.akash.developer.sms.entity.Student;


public interface StudentService {

	Student saveStudent(Student student);

	List<Student> getAllStudents();

	Student getStudentById(Long id);

	Student updateStudent(Student student);

	void deleteStudentById(long id);

}
