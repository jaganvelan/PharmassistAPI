package com.example.pharmassist.PharmassistApi.mapper;

import org.springframework.stereotype.Component;

import com.example.pharmassist.PharmassistApi.entity.Medicine;
import com.example.pharmassist.PharmassistApi.entity.Patient;
import com.example.pharmassist.PharmassistApi.requestdtos.MedicineRequest;
import com.example.pharmassist.PharmassistApi.requestdtos.PatientRequest;
import com.example.pharmassist.PharmassistApi.responsedtos.MedicineResponse;
import com.example.pharmassist.PharmassistApi.responsedtos.PatientResponse;
@Component
public class MedicineMapper {
	public Medicine mapToMedicine(MedicineRequest medicineRequest,Medicine medicine) {
		medicine.setMedicineName(medicineRequest.getMedicineName());
		medicine.setCategory(medicineRequest.getCategory());
		medicine .setDosageInMg(medicineRequest.getDosageInMg());
		medicine.setExpireDate(medicineRequest.getExpireDate());
		medicine.setForm(medicineRequest.getForm());
		medicine.setIngredients(medicineRequest.getIngredients());
		medicine.setManufacturer(medicineRequest.getManufacturer());
		medicine .setPrice(medicineRequest.getPrice());
		medicine.setStockQuantity(medicineRequest.getStockQuantity());
		return medicine;
	}
	public MedicineResponse mapToMedicineResponse(Medicine medicine) {
		MedicineResponse medicineResponse=new MedicineResponse(); 
		medicineResponse.setMedicineName(medicine.getMedicineName());
		medicineResponse.setCategory(medicine.getCategory());
		medicineResponse .setDosageInMg(medicine.getDosageInMg());
		medicineResponse.setExpireDate(medicine.getExpireDate());
		medicineResponse.setForm(medicine.getForm());
		medicineResponse.setIngredients(medicine.getIngredients());
		medicineResponse.setManufacturer(medicine.getManufacturer());
		medicineResponse .setPrice(medicine.getPrice());
		medicineResponse.setStockQuantity(medicine.getStockQuantity());
		medicineResponse.setMedicineId(medicine.getMedicineId());
		return medicineResponse;
	}
}
