package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.RegistrationRepository;

@Service
public class UserService {

	@Autowired
	private RegistrationRepository registrationRepository;
	
	public User findUserByUsername(String username) {
		return registrationRepository.findUserByUsername(username);
	}
}
