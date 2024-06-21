package com.akash.developer.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.akash.developer.sms.entity.Student;
import com.akash.developer.sms.repository.StudentRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = StudentRepository.class)

public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
		System.out.println("Main Files Started");
	}

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
//		Student student1 = new Student("Akash", "Sarwade", "amsarwade18@gmail.com", "Sai Nagar Pune", 78654354);
//		studentRepository.save(student1);
//
//		Student student2 = new Student("Rajesh", "Khanna", "rk756@gmail.com", "Fatima Nagar Pune", 876908998);
//		studentRepository.save(student2);
//
//		Student student3 = new Student("Shivani", "Sahrma", "sm5642@gmail.com", "Punjab INDIA", 123435123);
//		studentRepository.save(student3);
	}

}
