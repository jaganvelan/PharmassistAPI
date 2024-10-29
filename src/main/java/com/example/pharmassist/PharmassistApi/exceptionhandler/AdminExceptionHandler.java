package com.example.pharmassist.PharmassistApi.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.pharmassist.PharmassistApi.exception.AdminNotFoundByIdException;
import com.example.pharmassist.PharmassistApi.util.AppResponseBuilder;
import com.example.pharmassist.PharmassistApi.util.ErrorStructure;

@RestControllerAdvice
public class AdminExceptionHandler {
private final AppResponseBuilder responseBuilder;
	
	public AdminExceptionHandler(AppResponseBuilder responseBuilder) {
		super();
		this.responseBuilder = responseBuilder;
	}
	
	@ExceptionHandler(AdminNotFoundByIdException.class)
	public ResponseEntity<ErrorStructure> handleUserNotFoundById(AdminNotFoundByIdException ex) {
		
		return responseBuilder.error(HttpStatus.NOT_FOUND, "Admin not found","Admin is not found by id" );
	}
}

