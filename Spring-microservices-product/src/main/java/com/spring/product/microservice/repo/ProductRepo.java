package com.spring.product.microservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.product.microservice.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

	Product getProductById(Long id);

}
