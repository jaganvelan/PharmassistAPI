package com.example.pharmassist.PharmassistApi.controllor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.pharmassist.PharmassistApi.entity.Medicine;
import com.example.pharmassist.PharmassistApi.repository.MedicineRepository;
import com.example.pharmassist.PharmassistApi.responsedtos.MedicineResponse;
import com.example.pharmassist.PharmassistApi.service.MedicineService;
import com.example.pharmassist.PharmassistApi.util.AppResponseBuilder;
import com.example.pharmassist.PharmassistApi.util.ErrorStructure;
import com.example.pharmassist.PharmassistApi.util.ResponseStructure;
import com.example.pharmassist.PharmassistApi.util.SimpleResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Medicine Controller", description = "Controller for managing Medicine CRUD operations and File uploading")
public class MedicineController {
	private final MedicineService medicineService;
	private final AppResponseBuilder responseBuilder;
	
	
	
public MedicineController(MedicineService medicineService, AppResponseBuilder responseBuilder) {
		super();
		this.medicineService = medicineService;
		this.responseBuilder = responseBuilder;
	}
@Operation(description = "the endpoint can be uploadFile into the data"
,responses =  {
		@ApiResponse(responseCode ="201",description = "upload successfully"),
		@ApiResponse(responseCode = "404",description = "failed to upload file",
		content = {
				@Content(schema = @Schema(implementation=ErrorStructure.class))
		})
})
@PostMapping("/pharmacys/{pharmacyId}/medicines")
public ResponseEntity<SimpleResponseStructure>uploadMedicines(@RequestParam MultipartFile file,@PathVariable String pharmacyId ){
String message=medicineService.uploadMedicine(file,pharmacyId);
return responseBuilder.success(HttpStatus.CREATED,message);
}
@Operation(description = "the endpoint can be used to find the Medicine based on MedicineName and Ingredients"
,responses =  {
		@ApiResponse(responseCode ="302",description = "successfully Found Medicine based on the medicineName and Ingredients"),
		@ApiResponse(responseCode = "404",description = "Medicine not found by based on the medicineName and Ingredients",
		content = {
				@Content(schema = @Schema(implementation=ErrorStructure.class))
		})
})
@GetMapping("/medicines/{medicineNameIngredients}")
public ResponseEntity<ResponseStructure<List<MedicineResponse>>>findMedicines(@PathVariable String medicineNameIngredients ) {
    List<MedicineResponse> response= medicineService.findMedicineByNameOrIngredients(medicineNameIngredients);
    return responseBuilder.success(HttpStatus.FOUND, "successfully found", response);
    
}
}
