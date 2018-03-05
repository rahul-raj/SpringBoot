package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.entity.User;

@Controller
public class TestController {

	@GetMapping("/")
	public String getCourses(){
		return "index";
	}
	
	@GetMapping("/international")
	public String getIndex(){
		return "cnf";
	}
	
	@GetMapping("/login")
	public String login(){
		return "login";
	}
	
	@GetMapping("/register")
	public String register(Model model){
		model.addAttribute("user",new User());
		return "register";
	}
	
}
