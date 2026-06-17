package com.grocery.grocery_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "product")
public class Product {
	 
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

		@NotBlank(message = "Product name is required")
	    private String name;
	    private String description;
	    @Positive(message = "Price must be greater than zero")
	    private Double price;
	    @PositiveOrZero(message = "Stock cannot be negative")
	    private Integer stock;
	    private String category;
	    private String imageUrl;
	    
	    public Product() {}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public Integer getStock() {
			return stock;
		}

		public void setStock(Integer stock) {
			this.stock = stock;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public String getImageUrl() {
			return imageUrl;
		}

		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}

		@Override
		public String toString() {
			return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
					+ ", stock=" + stock + ", category=" + category + ", imageUrl=" + imageUrl + "]";
		}
	    
	
}