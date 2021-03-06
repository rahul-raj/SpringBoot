package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.User;

public interface RegistrationRepository extends CrudRepository<User, String> {
	
	public User findUserByUsername(String username);

}
