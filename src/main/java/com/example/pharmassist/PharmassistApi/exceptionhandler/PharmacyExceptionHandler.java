package com.example.pharmassist.PharmassistApi.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.pharmassist.PharmassistApi.exception.PharmacyNotFoundByIdException;
import com.example.pharmassist.PharmassistApi.util.AppResponseBuilder;
import com.example.pharmassist.PharmassistApi.util.ErrorStructure;

@RestControllerAdvice
public class PharmacyExceptionHandler {
private AppResponseBuilder responseBuilder;

public PharmacyExceptionHandler(AppResponseBuilder responseBuilder) {
	super();
	this.responseBuilder = responseBuilder;
}
@ExceptionHandler(PharmacyNotFoundByIdException.class)
public ResponseEntity<ErrorStructure> handlePharmacyNotFoundById(PharmacyNotFoundByIdException ex){
	return responseBuilder.error(HttpStatus.NOT_FOUND, "Pharmacy not found", "Pharmacy not found by Id ");
}
}
