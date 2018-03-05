package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.User;
import com.example.service.RegistrationService;

@Controller
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@PostMapping("/register")
	public void registerUser(User user) {
		user.setPassword(passwordEncoder().encode(user.getPassword()));
		registrationService.addUser(user);
	}

}
