package com.danix43.herculesapi.exceptionhandling;

public class EntityNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 8015993687394574830L;
	private String message;
	private Throwable cause;
	
	public EntityNotFoundException(String message) {
		this.message = message;
		this.cause = null;
	}
	
	public EntityNotFoundException(String message, Throwable cause) {
		this.message = message;
		this.cause = cause;
	}
	
}
