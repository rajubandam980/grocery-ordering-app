package com.grocery.grocery_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grocery.grocery_backend.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	

}
