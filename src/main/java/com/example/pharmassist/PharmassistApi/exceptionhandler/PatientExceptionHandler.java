package com.example.pharmassist.PharmassistApi.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.pharmassist.PharmassistApi.exception.PatientNotFoundByIdException;
import com.example.pharmassist.PharmassistApi.util.AppResponseBuilder;
import com.example.pharmassist.PharmassistApi.util.ErrorStructure;
@RestControllerAdvice
public class PatientExceptionHandler {
private final AppResponseBuilder responseBuilder;
	
	public PatientExceptionHandler(AppResponseBuilder responseBuilder) {
		super();
		this.responseBuilder = responseBuilder;
	}
	
	@ExceptionHandler(PatientNotFoundByIdException.class)
	public ResponseEntity<ErrorStructure> handlePatientNotFoundById(PatientNotFoundByIdException ex) {
		
		return responseBuilder.error(HttpStatus.NOT_FOUND, "Patient not found","Patient is not found by id" );
	}
}
