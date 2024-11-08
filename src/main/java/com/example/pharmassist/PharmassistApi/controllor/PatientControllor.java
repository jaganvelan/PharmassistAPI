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
import com.example.pharmassist.PharmassistApi.util.ErrorStructure;
import com.example.pharmassist.PharmassistApi.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@Tag(name = "Patient Controller", description = "Controller for managing patient CRUD operations")
public class PatientControllor {
	private final AppResponseBuilder responseBuilder;
	private final PatientService patientService; 
	
public PatientControllor(AppResponseBuilder responseBuilder, PatientService patientService) {
		super();
		this.responseBuilder = responseBuilder;
		this.patientService = patientService;
	}


@Operation(description = "the endpoint can be used to add the Patient entity"
,responses =  {
		@ApiResponse(responseCode ="201",description = "Patient added"),
		@ApiResponse(responseCode = "404",description = "failed to add the Patient entity",
		content = {
				@Content(schema = @Schema(implementation=ErrorStructure.class))
		})
})
@PostMapping("/pharmacys/{pharmacyId}/patients")
public ResponseEntity<ResponseStructure<PatientResponse>> addPatient(@RequestBody @Valid PatientRequest patientRequest , @PathVariable String pharmacyId){
	PatientResponse response=patientService.addPatient(patientRequest,pharmacyId);
	return responseBuilder.success(HttpStatus.CREATED, "patient added", response);
}
@Operation(
	    description = "The endpoint can be used to update the patient information based on the unique ID",
	    responses = {
	        @ApiResponse(responseCode = "200", description = "Patient updated successfully"),
	        @ApiResponse(responseCode = "404", description = "Patient not found by ID", 
	            content = {
	                @Content(schema = @Schema(implementation = ErrorStructure.class))
	            }),
	        @ApiResponse(responseCode = "400", description = "Invalid input or malformed request",
	            content = {
	                @Content(schema = @Schema(implementation = ErrorStructure.class))
	            })
	    })	
@PutMapping("/patientId")
public ResponseEntity<ResponseStructure<PatientResponse>> updatePatient(@RequestBody @Valid PatientRequest patientRequest,@PathVariable String patientId){
	PatientResponse response=patientService.updatePatient(patientRequest,patientId);
	return responseBuilder.success(HttpStatus.OK,"updated the patient", response);
}
@Operation(description = "the endpoint can be used to find the Patient based on the unique ID"
,responses =  {
		@ApiResponse(responseCode ="302",description = "Patient Found"),
		@ApiResponse(responseCode = "404",description = "Patient not found by PharmacyID",
		content = {
				@Content(schema = @Schema(implementation=ErrorStructure.class))
		})
})
@GetMapping("pharmacy/{pharmacyId}/patients")
public ResponseEntity<ResponseStructure<List<PatientResponse>>>findPatient(@PathVariable String pharmacyId){
	List<PatientResponse> response=patientService.findPatient(pharmacyId);
	return responseBuilder.success(HttpStatus.FOUND,"patient found in that pharmacyId",response);
}
}
