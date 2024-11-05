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
import com.example.pharmassist.PharmassistApi.util.ResponseStructure;

import jakarta.validation.Valid;

@RestController
public class PharmacyControllor {
	private   PharmacyService pharmacyService;
	private   AppResponseBuilder responseBuilder;
	public PharmacyControllor(PharmacyService pharmacyService, AppResponseBuilder responseBuilder) {
		super();
		this.pharmacyService = pharmacyService;
		this.responseBuilder = responseBuilder;
	}
@PostMapping("/admins/{adminId}/pharmacys")
public ResponseEntity<ResponseStructure<PharmacyResponse>> addPharmacy(@RequestBody @Valid PharmacyRequest pharmacyRequest,@PathVariable String adminId){
	PharmacyResponse response=pharmacyService.addPharmacy(pharmacyRequest,adminId);
	return responseBuilder.success(HttpStatus.CREATED, "pharmacy added", response);
}
@GetMapping("/pharmacys/{adminId}")
public ResponseEntity<ResponseStructure<PharmacyResponse>> findPharmacy(@PathVariable String adminId){
	PharmacyResponse response =pharmacyService.findPharmacy(adminId);
	return responseBuilder.success(HttpStatus.CREATED,"Pharmacy Found",response);		
}
@PutMapping("/{pharmacyId}")
public ResponseEntity<ResponseStructure<PharmacyResponse>> updatePharmacy(@RequestBody @Valid PharmacyRequest pharmacyRequest,@PathVariable String pharmacyId) {
	PharmacyResponse response= pharmacyService.updatePharmacy(pharmacyRequest,pharmacyId);
	return responseBuilder.success(HttpStatus.OK, "Admin updated", response);
}
@GetMapping("/")
public ResponseEntity<ResponseStructure<List<PharmacyResponse>>> findAllPharmacy(){
	List<PharmacyResponse> response=pharmacyService.findAllPharmacy();
	return responseBuilder.success(HttpStatus.FOUND, "User Found", response);
}
}
