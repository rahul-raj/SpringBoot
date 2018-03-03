package com.example.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.exception.NoCoursesFoundException;

@ControllerAdvice
public class ErrorController {

	
	@ExceptionHandler(NoCoursesFoundException.class)
	public String handleCourseNotFoundException(Model model, NoCoursesFoundException e) {
		model.addAttribute("message",e.getMessage());	
		return "cnf";
	}
	
}
