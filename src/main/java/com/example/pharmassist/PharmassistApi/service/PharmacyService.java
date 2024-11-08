package com.example.pharmassist.PharmassistApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.pharmassist.PharmassistApi.entity.Admin;
import com.example.pharmassist.PharmassistApi.entity.Pharmacy;
import com.example.pharmassist.PharmassistApi.exception.AdminNotFoundByIdException;
import com.example.pharmassist.PharmassistApi.exception.PharmacyNotFoundByIdException;
import com.example.pharmassist.PharmassistApi.mapper.PharmacyMapper;
import com.example.pharmassist.PharmassistApi.repository.AdminRepository;
import com.example.pharmassist.PharmassistApi.repository.PharmacyRepository;
import com.example.pharmassist.PharmassistApi.requestdtos.PharmacyRequest;
import com.example.pharmassist.PharmassistApi.responsedtos.PharmacyResponse;
@Service
public class PharmacyService {
private AdminRepository adminRepository;
public PharmacyService(AdminRepository adminRepository, PharmacyRepository pharmacyrepository,
		PharmacyMapper pharmacyMapper) {
	super();
	this.adminRepository = adminRepository;
	this.pharmacyrepository = pharmacyrepository;
	this.pharmacyMapper = pharmacyMapper;
}
private PharmacyRepository pharmacyrepository;
private PharmacyMapper pharmacyMapper;
	
	public PharmacyResponse addPharmacy(PharmacyRequest pharmacyRequest, String adminId) {
		return adminRepository.findById(adminId)
		.map((admin) -> {
			Pharmacy pharmacy=pharmacyrepository.save(pharmacyMapper.mapToPharmacy(pharmacyRequest, new Pharmacy()));
		            admin.setPharmacy(pharmacy); 
		            adminRepository.save(admin); 
		            return pharmacyMapper.mapToPharmacyResponse(pharmacy);
		        })
		.orElseThrow(() -> new AdminNotFoundByIdException("failed to add pharmacy due to no admin present"));
	}

	public PharmacyResponse findPharmacy(String adminId) {
		return adminRepository.findPharmacyByAdminId(adminId)
		.map(pharmacyMapper:: mapToPharmacyResponse)
		.orElseThrow(()-> new AdminNotFoundByIdException("Failed to find Pharmacy"));
		
	}
	public PharmacyResponse updatePharmacy(PharmacyRequest pharmacyRequest, String pharmacyId) {
		return pharmacyrepository.findById(pharmacyId)
							.map((pharmacy)->{
								pharmacy = pharmacyrepository.save(pharmacyMapper.mapToPharmacy(pharmacyRequest, pharmacy));
								return pharmacyMapper.mapToPharmacyResponse(pharmacy);
							})
							.orElseThrow(() -> new PharmacyNotFoundByIdException("Failed to Update the Pharmacy"));
	}
	public List<PharmacyResponse> findAllPharmacy() {
		return pharmacyrepository.findAll()
							.stream()
							.map(pharmacyMapper::mapToPharmacyResponse)
							.toList();
	}
}
