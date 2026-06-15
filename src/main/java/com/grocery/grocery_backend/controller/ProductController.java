package com.grocery.grocery_backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.grocery_backend.model.Product;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	private List<Product> products = new ArrayList<>();
	
	@GetMapping()
	private List<Product> getProducts(){
		return products;
	}
	@PostMapping()
	public Product addProduct(@RequestBody Product product) {
		products.add(product);
		
		return product;
	}

}
