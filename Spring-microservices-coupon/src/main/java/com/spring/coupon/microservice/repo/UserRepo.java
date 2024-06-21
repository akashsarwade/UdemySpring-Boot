package com.spring.coupon.microservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.coupon.microservice.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
