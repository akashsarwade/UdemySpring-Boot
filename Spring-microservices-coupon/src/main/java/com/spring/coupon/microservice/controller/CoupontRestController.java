package com.spring.coupon.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.coupon.microservice.model.Coupon;
import com.spring.coupon.microservice.repo.CouponRepo;

@RestController
@RequestMapping("/coupons")
public class CoupontRestController {

	@Autowired
	CouponRepo couponRepo;

	@PostMapping("/createCoupon")
	public Coupon createCoupon(@RequestBody Coupon coupon) {
			return couponRepo.save(coupon);
	}

	@GetMapping("/getCoupons/{code}")
	public Coupon getAllCoupons(@PathVariable("code") String code) {
		return couponRepo.getByCode(code);
	}
}
