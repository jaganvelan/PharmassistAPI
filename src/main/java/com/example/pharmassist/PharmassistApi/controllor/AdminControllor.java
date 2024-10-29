package com.example.pharmassist.PharmassistApi.controllor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pharmassist.PharmassistApi.entity.Admin;
import com.example.pharmassist.PharmassistApi.requestdtos.AdminRequest;
import com.example.pharmassist.PharmassistApi.responsedtos.AdminResponse;
import com.example.pharmassist.PharmassistApi.service.AdminService;
import com.example.pharmassist.PharmassistApi.util.AppResponseBuilder;
import com.example.pharmassist.PharmassistApi.util.ResponseStructure;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/admins")
public class AdminControllor {
	private AdminService adminservice;
	private AppResponseBuilder responseBuilder;

	public AdminControllor(AdminService adminservice, AppResponseBuilder responseBuilder) {
		super();
		this.adminservice = adminservice;
		this.responseBuilder = responseBuilder;
	}

	@PostMapping("/")
	public  ResponseEntity<ResponseStructure<AdminResponse>> addAdmin(@RequestBody @Valid AdminRequest adminRequest) {
		AdminResponse response= adminservice.addAdmin(adminRequest);
		return responseBuilder.success(HttpStatus.CREATED, "Admin created", response);

	}
}

