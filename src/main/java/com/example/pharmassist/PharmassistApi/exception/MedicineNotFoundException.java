package com.example.pharmassist.PharmassistApi.exception;

@SuppressWarnings("serial")
public class MedicineNotFoundException extends RuntimeException {
	private String message;

	public MedicineNotFoundException(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
}
