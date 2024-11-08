package com.example.pharmassist.PharmassistApi.controllor;

import org.springframework.web.bind.annotation.RestController;

import com.example.pharmassist.PharmassistApi.requestdtos.AdminRequest;
import com.example.pharmassist.PharmassistApi.responsedtos.AdminResponse;
import com.example.pharmassist.PharmassistApi.service.AdminService;
import com.example.pharmassist.PharmassistApi.util.AppResponseBuilder;
import com.example.pharmassist.PharmassistApi.util.ErrorStructure;
import com.example.pharmassist.PharmassistApi.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@Tag(name = "Admin Controller", description = "Controller for managing Admin CRUD operations")
public class AdminControllor {
	private final  AdminService adminservice;
	private final  AppResponseBuilder responseBuilder;

	public AdminControllor(AdminService adminservice, AppResponseBuilder responseBuilder) {
		super();
		this.adminservice = adminservice;
		this.responseBuilder = responseBuilder;
	}
	@Operation(description = "the endpoint can be used to add the Admin entity"
			,responses =  {
					@ApiResponse(responseCode ="201",description = "Admin added"),
					@ApiResponse(responseCode = "404",description = "failed to add the Admin entity",
					content = {
							@Content(schema = @Schema(implementation=ErrorStructure.class))
					})
			})
	@PostMapping("/admins")
	public  ResponseEntity<ResponseStructure<AdminResponse>> addAdmin(@RequestBody @Valid AdminRequest adminRequest) {
		AdminResponse response= adminservice.addAdmin(adminRequest);
		return responseBuilder.success(HttpStatus.CREATED, "Admin created", response);

	}
	@Operation(description = "the endpoint can be used to find the Admin based on the unique ID"
			,responses =  {
					@ApiResponse(responseCode ="302",description = "Admin Found"),
					@ApiResponse(responseCode = "404",description = "Admin not found by ID",
					content = {
							@Content(schema = @Schema(implementation=ErrorStructure.class))
					})
			})
	@GetMapping("/admins/{adminId}")
	public ResponseEntity<ResponseStructure<AdminResponse>> findadmin(@PathVariable String adminId){
		AdminResponse response =adminservice.findAdmin(adminId);
		return responseBuilder.success(HttpStatus.FOUND, " Admin Found",response); 
	}
	@Operation(
		    description = "The endpoint can be used to update the Admin information based on the unique ID",
		    responses = {
		        @ApiResponse(responseCode = "200", description = "Admin updated successfully"),
		        @ApiResponse(responseCode = "404", description = "Admin not found by ID", 
		            content = {
		                @Content(schema = @Schema(implementation = ErrorStructure.class))
		            }),
		        @ApiResponse(responseCode = "400", description = "Invalid input or malformed request",
		            content = {
		                @Content(schema = @Schema(implementation = ErrorStructure.class))
		            })
		    })	
	@PutMapping("/admins/{adminId}")
	public ResponseEntity<ResponseStructure<AdminResponse>> updateAdmin(@RequestBody @Valid AdminRequest adminRequest,@PathVariable String adminId) {
		AdminResponse response= adminservice.updateAdmin(adminRequest,adminId);
		return responseBuilder.success(HttpStatus.OK, "Admin updated", response);
	}
	@Operation(description = "the endpoint can be used to findAll Admin "
			,responses =  {
					@ApiResponse(responseCode ="302",description = "Admin Found"),
					@ApiResponse(responseCode = "404",description = "Admin not found",
					content = {
							@Content(schema = @Schema(implementation=ErrorStructure.class))
					})
			})
	@GetMapping("/admins")
	public ResponseEntity<ResponseStructure<List<AdminResponse>>> findAllAdmin(){
		List<AdminResponse> response=adminservice.findAllAdmin();
		return responseBuilder.success(HttpStatus.FOUND, "Admin Found", response);
	}
}

