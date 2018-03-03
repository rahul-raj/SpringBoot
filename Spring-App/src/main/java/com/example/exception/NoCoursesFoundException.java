package com.example.exception;

public class NoCoursesFoundException extends Exception {
	
	private String message;
	
	public NoCoursesFoundException(String message) {
		super(message);
		this.message=message;
	}

	public String getMessage() {
		return message;
	}
    
}
