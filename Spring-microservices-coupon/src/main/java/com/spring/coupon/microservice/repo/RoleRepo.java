package com.spring.coupon.microservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.coupon.microservice.model.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {

}
