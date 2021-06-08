package com.project.bootcamp.exceptions;

public class ExceptionResponse {
    
	
	private String message;

	public String getMessage() {
		return message;
	}

//	public void setMessage(String message) {
//		this.message = message;
//	}
    
	// Quem faz o set é o construtor
	public ExceptionResponse(String message) {
		this.message = message;
	}
}
