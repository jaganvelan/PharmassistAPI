package com.example.pharmassist.PharmassistApi.controllor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.pharmassist.PharmassistApi.requestdtos.PatientRequest;
import com.example.pharmassist.PharmassistApi.responsedtos.PatientResponse;
import com.example.pharmassist.PharmassistApi.service.PatientService;
import com.example.pharmassist.PharmassistApi.util.AppResponseBuilder;
import com.example.pharmassist.PharmassistApi.util.ResponseStructure;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class PatientControllor {
	private final AppResponseBuilder responseBuilder;
	private final PatientService patientService; 
	
public PatientControllor(AppResponseBuilder responseBuilder, PatientService patientService) {
		super();
		this.responseBuilder = responseBuilder;
		this.patientService = patientService;
	}

@PostMapping("/pharmacys/{pharmacyId}/patients")
public ResponseEntity<ResponseStructure<PatientResponse>> addPatient(@RequestBody @Valid PatientRequest patientRequest , @PathVariable String pharmacyId){
	PatientResponse response=patientService.addPatient(patientRequest,pharmacyId);
	return responseBuilder.success(HttpStatus.CREATED, "patient added", response);
}
@PutMapping("/patientId")
public ResponseEntity<ResponseStructure<PatientResponse>> updatePatient(@RequestBody @Valid PatientRequest patientRequest,@PathVariable String patientId){
	PatientResponse response=patientService.updatePatient(patientRequest,patientId);
	return responseBuilder.success(HttpStatus.OK,"updated the patient", response);
}
@GetMapping("pharmacy/{pharmacyId}/patients")
public ResponseEntity<ResponseStructure<List<PatientResponse>>>findPatient(@PathVariable String pharmacyId){
	List<PatientResponse> response=patientService.findPatient(pharmacyId);
	return responseBuilder.success(HttpStatus.FOUND,"patient found in that pharmacyId",response);
}
}
