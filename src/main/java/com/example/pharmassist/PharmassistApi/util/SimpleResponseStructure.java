package com.example.pharmassist.PharmassistApi.util;

import org.springframework.http.HttpStatus;

public class SimpleResponseStructure {
private int status;
private String message;
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public static SimpleResponseStructure create(HttpStatus status, String message) {
	SimpleResponseStructure response =new SimpleResponseStructure();
	response.setMessage(message);
	response.setStatus(status.value());
	return response;
}
}
