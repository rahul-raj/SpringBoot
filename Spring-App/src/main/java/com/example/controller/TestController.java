package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/")
	public String getCourses(){
		return "cnf";
	}
	
	@GetMapping("/international")
	public String getIndex(){
		return "cnf";
	}
	
	@GetMapping("/login")
	public String login(){
		return "login";
	}
}
