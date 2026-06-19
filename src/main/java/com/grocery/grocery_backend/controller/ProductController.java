package com.grocery.grocery_backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.grocery_backend.dto.ProductDTO;
import com.grocery.grocery_backend.entity.Product;
import com.grocery.grocery_backend.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public List<ProductDTO> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@PostMapping
	public Product addProduct(@Valid @RequestBody Product product) {
		return productService.addProduct(product);
		
	}
	
	@RequestMapping("/{id}")
	public ProductDTO getProductByid(@PathVariable Long id) {
		return productService.getProductByid(id);
	}
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable Long id, @Valid @RequestBody Product product) {
		return productService.updateProduct(id, product);
	}
	
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		
		return "Product Sucessfully Deleted";
	}
	@RequestMapping("/search")
	public List<ProductDTO> searchProduct(@RequestParam String name){
		return productService.searchProduct(name);
		
	}
	@RequestMapping("/category/{category}")
	public List<ProductDTO> searchCategory(@PathVariable String category){
		return productService.searchCetagory(category);
	}
	
	@RequestMapping("/paged")
	public List<ProductDTO> getProductPaged(@RequestParam int page, @RequestParam int size){
		return productService.getProducts(page, size);
	}
}
	
