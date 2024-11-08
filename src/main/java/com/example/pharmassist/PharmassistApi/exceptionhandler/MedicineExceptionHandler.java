package com.example.pharmassist.PharmassistApi.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.pharmassist.PharmassistApi.exception.MedicineNotFoundException;
import com.example.pharmassist.PharmassistApi.util.AppResponseBuilder;
import com.example.pharmassist.PharmassistApi.util.ErrorStructure;
@RestControllerAdvice
public class MedicineExceptionHandler {
private final AppResponseBuilder responseBuilder;
	
	public MedicineExceptionHandler(AppResponseBuilder responseBuilder) {
		super();
		this.responseBuilder = responseBuilder;
	}
	
	@ExceptionHandler(MedicineNotFoundException.class)
	public ResponseEntity<ErrorStructure> handlePatientNotFoundById(MedicineNotFoundException ex) {
		
		return responseBuilder.error(HttpStatus.NOT_FOUND,ex.getMessage() ,"failed to find medicine in this criteria" );
	}
}
