package com.example.pharmassist.PharmassistApi.exception;

@SuppressWarnings("serial")
public class PharmacyNotFoundByIdException extends RuntimeException {
private String message;
public PharmacyNotFoundByIdException(String message) {
	super();
	this.message = message;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

}
