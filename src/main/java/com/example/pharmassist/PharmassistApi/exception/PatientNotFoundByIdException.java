package com.example.pharmassist.PharmassistApi.exception;

@SuppressWarnings("serial")
public class PatientNotFoundByIdException extends RuntimeException {
	private String message;

	public PatientNotFoundByIdException(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
}
