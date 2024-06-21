package com.spring.product.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spring.product.microservice.dto.Coupon;
import com.spring.product.microservice.model.Product;
import com.spring.product.microservice.repo.ProductRepo;

@RestController
@RequestMapping("/products")
public class ProductRestController {

	@Autowired
	ProductRepo productRepo;

	@Autowired
	RestTemplate restTemplate;

	@Value("$couponService.url")
	private String couponServiceURL;
	
	@PostMapping("/addProduct")
	public Product createProduct(@RequestBody Product product) {
		Coupon cpn = restTemplate.getForObject("http://localhost:8080/coupons/getCoupons/" + product.getCouponCode(),
				Coupon.class);
		product.setPrice(product.getPrice().subtract(cpn.getDiscount()));
		return productRepo.save(product);
	}
	
	
	@GetMapping("/getProduct/{id}")
	public Product getProducts(@PathVariable("id") Long id) {
		return productRepo.getProductById(id);
	}
}
