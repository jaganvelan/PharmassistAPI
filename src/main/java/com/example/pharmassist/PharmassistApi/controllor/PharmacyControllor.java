package com.example.pharmassist.PharmassistApi.controllor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pharmassist.PharmassistApi.entity.Admin;
import com.example.pharmassist.PharmassistApi.entity.Pharmacy;
import com.example.pharmassist.PharmassistApi.requestdtos.AdminRequest;
import com.example.pharmassist.PharmassistApi.requestdtos.PharmacyRequest;
import com.example.pharmassist.PharmassistApi.responsedtos.AdminResponse;
import com.example.pharmassist.PharmassistApi.responsedtos.PharmacyResponse;
import com.example.pharmassist.PharmassistApi.service.PharmacyService;
import com.example.pharmassist.PharmassistApi.util.AppResponseBuilder;
import com.example.pharmassist.PharmassistApi.util.ErrorStructure;
import com.example.pharmassist.PharmassistApi.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@Tag(name = "Pharmacy Controller", description = "Controller for managing Pharmacy CRUD operations")
public class PharmacyControllor {
	private final  PharmacyService pharmacyService;
	private final  AppResponseBuilder responseBuilder;
	public PharmacyControllor(PharmacyService pharmacyService, AppResponseBuilder responseBuilder) {
		super();
		this.pharmacyService = pharmacyService;
		this.responseBuilder = responseBuilder;
	}
	@Operation(description = "the endpoint can be used to add the Pharmacy entity"
			,responses =  {
					@ApiResponse(responseCode ="201",description = "Pharmacy added"),
					@ApiResponse(responseCode = "404",description = "failed to add the Pharmacy entity",
					content = {
							@Content(schema = @Schema(implementation=ErrorStructure.class))
					})
			})
@PostMapping("/admins/{adminId}/pharmacys")
public ResponseEntity<ResponseStructure<PharmacyResponse>> addPharmacy(@RequestBody @Valid PharmacyRequest pharmacyRequest,@PathVariable String adminId){
	PharmacyResponse response=pharmacyService.addPharmacy(pharmacyRequest,adminId);
	return responseBuilder.success(HttpStatus.CREATED, "pharmacy added", response);
}
	@Operation(description = "the endpoint can be used to find the Pharmacy based on the unique ID"
			,responses =  {
					@ApiResponse(responseCode ="302",description = "Pharmacy Found"),
					@ApiResponse(responseCode = "404",description = "Pharmacy not found by ID",
					content = {
							@Content(schema = @Schema(implementation=ErrorStructure.class))
					})
			})
@GetMapping("/pharmacys/{adminId}")
public ResponseEntity<ResponseStructure<PharmacyResponse>> findPharmacy(@PathVariable String adminId){
	PharmacyResponse response =pharmacyService.findPharmacy(adminId);
	return responseBuilder.success(HttpStatus.CREATED,"Pharmacy Found",response);		
}
	@Operation(
		    description = "The endpoint can be used to update the Pharmacy information based on the unique ID",
		    responses = {
		        @ApiResponse(responseCode = "200", description = "Pharmacy updated successfully"),
		        @ApiResponse(responseCode = "404", description = "Pharmacy not found by ID", 
		            content = {
		                @Content(schema = @Schema(implementation = ErrorStructure.class))
		            }),
		        @ApiResponse(responseCode = "400", description = "Invalid input or malformed request",
		            content = {
		                @Content(schema = @Schema(implementation = ErrorStructure.class))
		            })
		    })	
@PutMapping("/{pharmacyId}")
public ResponseEntity<ResponseStructure<PharmacyResponse>> updatePharmacy(@RequestBody @Valid PharmacyRequest pharmacyRequest,@PathVariable String pharmacyId) {
	PharmacyResponse response= pharmacyService.updatePharmacy(pharmacyRequest,pharmacyId);
	return responseBuilder.success(HttpStatus.OK, "Admin updated", response);
}
	@Operation(description = "the endpoint can be used to findAll Pharmacy"
			,responses =  {
					@ApiResponse(responseCode ="302",description = "Pharmacy Found"),
					@ApiResponse(responseCode = "404",description = "Pharmacy not found",
					content = {
							@Content(schema = @Schema(implementation=ErrorStructure.class))
					})
			})
@GetMapping("/")
public ResponseEntity<ResponseStructure<List<PharmacyResponse>>> findAllPharmacy(){
	List<PharmacyResponse> response=pharmacyService.findAllPharmacy();
	return responseBuilder.success(HttpStatus.FOUND, "Pharmacy Found", response);
}
}
