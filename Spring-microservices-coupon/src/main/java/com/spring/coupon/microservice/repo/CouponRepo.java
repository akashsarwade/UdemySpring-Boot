package com.spring.coupon.microservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.coupon.microservice.model.Coupon;

public interface CouponRepo extends JpaRepository<Coupon, Long> {

	Coupon getByCode(String code);

}
