package com.grocery.grocery_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grocery.grocery_backend.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	List<Product> findByNameContainingIgnoreCase(String name);
	List<Product> findByCategoryIgnoreCase(String category);
	
	

}
