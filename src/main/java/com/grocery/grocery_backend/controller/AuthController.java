package com.grocery.grocery_backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.grocery_backend.dto.LoginRequest;
import com.grocery.grocery_backend.dto.LoginResponse;
import com.grocery.grocery_backend.dto.RegisterRequest;
import com.grocery.grocery_backend.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private final UserService userService;
	
	public AuthController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/register")
	public String register(@Valid @RequestBody RegisterRequest request) {
		return userService.register(request);
	}
	@PostMapping("/login")
	public LoginResponse login(@Valid @RequestBody LoginRequest request) {
		
		return userService.login(request);
		
	}

}
