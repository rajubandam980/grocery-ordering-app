package com.grocery.grocery_backend.service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.grocery.grocery_backend.dto.LoginRequest;
import com.grocery.grocery_backend.dto.LoginResponse;
import com.grocery.grocery_backend.dto.RegisterRequest;
import com.grocery.grocery_backend.entity.User;
import com.grocery.grocery_backend.exception.InvalidCredentialsException;
import com.grocery.grocery_backend.exception.UserAlreadyExistsException;
import com.grocery.grocery_backend.repository.UserRepository;
import com.grocery.grocery_backend.security.JwtService;

@Service
public class UserService {
	
	private final UserRepository userRepo;
	private final JwtService jwtService;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    
    public UserService(UserRepository userRepo, JwtService jwtService) {
    	this.userRepo = userRepo;
    	this.jwtService = jwtService;
    }
    public String register(RegisterRequest request) {
    	if(userRepo.findByemail(request.getEmail()).isPresent()) {
    		throw new UserAlreadyExistsException("Email Already Registered");
    	}

    	User user = new User();
    	
    	user.setName(request.getName());
    	user.setEmail(request.getEmail());
    	user.setPassword(encoder.encode(request.getPassword()));
    	user.setRole("CUSTOMER");
    	userRepo.save(user);
    	
    	return "Registration Successful";
    }
    
    public LoginResponse login(LoginRequest request) {

        User user = userRepo.findByemail(request.getEmail()).orElseThrow(() ->
                        new InvalidCredentialsException(
                                "Invalid email or password"));

        boolean matches =
                encoder.matches(
                        request.getPassword(),
                        user.getPassword());

        if (!matches) {
            throw new InvalidCredentialsException(
                    "Invalid email or password");
        }
        String token =
                jwtService.generateToken(
                        user.getEmail());

        return new LoginResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole(),
                token
        );
    }
    
    

}
