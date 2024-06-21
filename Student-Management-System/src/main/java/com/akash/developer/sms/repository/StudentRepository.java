package com.akash.developer.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akash.developer.sms.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	
}
