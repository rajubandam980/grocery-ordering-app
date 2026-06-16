package com.grocery.grocery_backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.grocery.grocery_backend.model.Product;

@Service
public class ProductService {
	
	List<Product> products  = new ArrayList<>();
	
	public List<Product> getAllProducts(){
		return products;
	}
	
	public Product addProduct(Product product) {
		products.add(product);
		return product;
	}
	
	public Product getProductByid(Long id) {
		for(Product product: products) {
			if(product.getId().equals(id)) {
				return product;
			}
		}
		return null;
	}

}
