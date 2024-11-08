package com.example.pharmassist.PharmassistApi.service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.pharmassist.PharmassistApi.entity.Medicine;
import com.example.pharmassist.PharmassistApi.entity.Pharmacy;
import com.example.pharmassist.PharmassistApi.enums.Form;
import com.example.pharmassist.PharmassistApi.exception.InvalidFormException;
import com.example.pharmassist.PharmassistApi.exception.MedicineNotFoundException;
import com.example.pharmassist.PharmassistApi.exception.PharmacyNotFoundByIdException;
import com.example.pharmassist.PharmassistApi.mapper.MedicineMapper;
import com.example.pharmassist.PharmassistApi.repository.MedicineRepository;
import com.example.pharmassist.PharmassistApi.repository.PharmacyRepository;
import com.example.pharmassist.PharmassistApi.responsedtos.MedicineResponse;
import com.example.pharmassist.PharmassistApi.util.AppResponseBuilder;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
@Service
public class MedicineService {
private final MedicineRepository medicineRepository;
private final PharmacyRepository pharmacyRepository;
private final MedicineMapper medicineMapper;
public MedicineService(MedicineRepository medicineRepository, PharmacyRepository pharmacyRepository,MedicineMapper medicineMapper) {
	super();
	this.medicineRepository = medicineRepository;
	this.pharmacyRepository=pharmacyRepository;
	this.medicineMapper=medicineMapper;
}
@Transactional
public String uploadMedicine(MultipartFile file,String pharmacyId){
    Pharmacy pharmacy = pharmacyRepository.findById(pharmacyId)
	            .orElseThrow(() -> new PharmacyNotFoundByIdException("failed to find the Pharamcy in this ID"));
    
	List<Medicine> medicines =new ArrayList<Medicine>();
	
	 try(XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream())) {
         for(Sheet sheet : workbook) {
             for(Row row : sheet) {
                 if(row.getRowNum() != 0) {
                	Medicine medicine=validateMedicine(row);
                     medicine.setPharmacy(pharmacy);
                     saveMedicine(medicine);
                 }
                	 
             }
             
         }
     }catch (IOException e) {
		throw new RuntimeException(e);
	}
	
     return "successfully uploaded";
	
}
public List<MedicineResponse> findMedicineByNameOrIngredients(String medicineNameIngredients) {
	 List<Medicine>medicine=medicineRepository.findByMedicineNameLikeIgnoreCaseOrIngredientsLikeIgnoreCase(medicineNameIngredients,medicineNameIngredients);
	if (medicine.isEmpty()) {
        throw new MedicineNotFoundException("No medicines found with the provided keyword");
    }
    return medicine
    		.stream()
    		.map(medicineMapper::mapToMedicineResponse)
    		.toList();
}
public Medicine validateMedicine(Row row) {
	 Medicine medicine = new Medicine();
 	try {
     medicine.setMedicineName(row.getCell(0).getStringCellValue());
      medicine.setCategory(row.getCell(1).getStringCellValue());
      medicine.setDosageInMg((int) row.getCell(2).getNumericCellValue());
      medicine.setForm(Form.valueOf(row.getCell(3).getStringCellValue().toUpperCase()));  
      medicine.setIngredients(row.getCell(4).getStringCellValue());
      medicine.setManufacturer(row.getCell(5).getStringCellValue());
      medicine.setPrice(row.getCell(6).getNumericCellValue());
      LocalDate date = LocalDate.parse(row.getCell(7).getStringCellValue()) ;
      medicine.setExpireDate(date);
      medicine.setStockQuantity((int) row.getCell(8).getNumericCellValue());
  } catch (NullPointerException |NumberFormatException |DateTimeParseException  e) {
 	    throw new IllegalArgumentException("invalid Data in row: " + row.getRowNum() + e);
  }
     
return medicine;	
}
public void saveMedicine(@Valid Medicine medicine) {
	medicineRepository.save(medicine);
}
}
