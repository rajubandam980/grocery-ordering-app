package com.grocery.grocery_backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class ProductRequestDTO {
	
	@NotBlank
	private Long id;
	
	private String description;
	@Positive
	private Double price;
	
	@PositiveOrZero
	private Integer stock;
	
	private String category;
	
	private String imageUrl;

}
