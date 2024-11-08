package com.example.pharmassist.PharmassistApi.entity;

import java.util.List;
import java.util.Optional;

import com.example.pharmassist.PharmassistApi.config.GenerateCustomId;
import com.example.pharmassist.PharmassistApi.responsedtos.PharmacyResponse;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity

public class Pharmacy {
	
@Id
@GenerateCustomId
private String pharmacyId;
private String pharmacyName;
private String gstNo;
private String licenceNO;

@OneToOne(mappedBy = "pharmacy")
private Admin admin;

@OneToMany(mappedBy = "pharmacy")
private List<Patient> patient;

@OneToMany(mappedBy = "pharmacy")
private List<Medicine> medicine; 

public List<Medicine> getMedicine() {
	return medicine;
}
public void setMedicine(List<Medicine> medicine) {
	this.medicine = medicine;
}
public Admin getAdmin() {
	return admin;
}
public void setAdmin(Admin admin) {
	this.admin = admin;
}
public List<Patient> getPatient() {
	return patient;
}
public void setPatient(List<Patient> patient) {
	this.patient = patient;
}
public String getPharmacyId() {
	return pharmacyId;
}
public void setPharmacyId(String pharmacyId) {
	this.pharmacyId = pharmacyId;
}

public String getPharmacyName() {
	return pharmacyName;
}
public void setPharmacyName(String pharmacyName) {
	this.pharmacyName = pharmacyName;
}
public String getGstNo() {
	return gstNo;
}
public void setGstNo(String gstNo) {
	this.gstNo = gstNo;
}
public String getLicenceNO() {
	return licenceNO;
}
public void setLicenceNO(String licenceNO) {
	this.licenceNO = licenceNO;
}
public PharmacyResponse map(Object object) {
	return null;
}
}
