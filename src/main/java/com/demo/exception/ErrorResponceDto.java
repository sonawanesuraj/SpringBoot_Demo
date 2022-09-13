package com.demo.exception;

public class ErrorResponceDto {
	private String message;
	
	private String messageKey;

	public ErrorResponceDto(String message, String messageKey) {
		super();
		this.message = message;
		this.messageKey = messageKey;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessageKey() {
		return messageKey;
	}

	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}

	
}
