package com.grocery.grocery_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grocery.grocery_backend.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByemail(String email);

}
