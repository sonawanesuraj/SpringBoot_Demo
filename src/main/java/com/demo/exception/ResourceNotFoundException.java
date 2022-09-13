package com.demo.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	public ResourceNotFoundException() {
		super();
	}
	
	private static final long serialVersionUID=1L;
	public ResourceNotFoundException(final String message) {
		super(message);
	}
	
	

	

}
