package com.grocery.grocery_backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.grocery_backend.entity.Product;
import com.grocery.grocery_backend.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	List<Product> products  = new ArrayList<>();
	
	public List<Product> getAllProducts(){
		return productRepo.findAll();
	}
	
	public Product addProduct(Product product) {
		return productRepo.save(product);

	}
	
	public Product getProductByid(Long id) {
		return productRepo.findById(id).orElse(null);

	}
	
	public Product updateProduct(Long id, Product updateProduct) {
		Product existingProduct = productRepo.findById(id).orElse(null);
		
		if(existingProduct == null) {
			return null;
		}
		existingProduct.setName(updateProduct.getName());
		existingProduct.setDescription(updateProduct.getDescription());
		existingProduct.setPrice(updateProduct.getPrice());
	    existingProduct.setStock(updateProduct.getStock());
	    existingProduct.setCategory(updateProduct.getCategory());
	    existingProduct.setImageUrl(updateProduct.getImageUrl());
	    
	    return productRepo.save(existingProduct);
		
	}
	
	public void deleteProduct(Long id) {
		productRepo.deleteById(id);
	}

}
