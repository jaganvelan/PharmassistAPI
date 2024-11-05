package com.example.pharmassist.PharmassistApi.mapper;

import org.springframework.stereotype.Component;

import com.example.pharmassist.PharmassistApi.entity.Pharmacy;
import com.example.pharmassist.PharmassistApi.requestdtos.PharmacyRequest;
import com.example.pharmassist.PharmassistApi.responsedtos.PharmacyResponse;

@Component
public class PharmacyMapper {
public Pharmacy mapToPharmacy(PharmacyRequest pharmacyRequest,Pharmacy pharmacy) {
	pharmacy.setPharmacyName(pharmacyRequest.getPharmacyName());
	pharmacy.setGstNo(pharmacyRequest.getGstNo());
	pharmacy.setLicenceNO(pharmacyRequest.getLicenceNo());
	return pharmacy;
}
public PharmacyResponse mapToPharmacyResponse(Pharmacy pharmacy) {
	PharmacyResponse pharmacyResponse=new PharmacyResponse(); 
	pharmacyResponse.setPharmacyId(pharmacy.getPharmacyId());
	pharmacyResponse.setPharmacyName(pharmacy.getPharmacyName());
	pharmacyResponse.setGstNo(pharmacy.getGstNo());
	pharmacyResponse.setLicenceNo(pharmacy.getLicenceNO());
	pharmacyResponse.setAdminId(pharmacy.getAdmin().getAdminId());
	return pharmacyResponse;
}
}
