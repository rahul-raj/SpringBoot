package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.RegistrationRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository registrationRepository;
	
	public void addUser(User user) {
		registrationRepository.save(user);
	}

}
