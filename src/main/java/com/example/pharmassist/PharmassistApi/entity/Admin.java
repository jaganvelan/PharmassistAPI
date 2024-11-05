package com.example.pharmassist.PharmassistApi.entity;

import com.example.pharmassist.PharmassistApi.config.GenerateCustomId;
import com.example.pharmassist.PharmassistApi.responsedtos.PharmacyResponse;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Admin {
@Id
@GenerateCustomId
private String adminId;
private String email;
private String phoneNumber;
private String password;
@OneToOne
private Pharmacy pharmacy;
public Pharmacy getPharmacy() {
	return pharmacy;
}
public void setPharmacy(Pharmacy pharmacy) {
	this.pharmacy = pharmacy;
}
public String getAdminId() {
	return adminId;
}
public void setAdminId(String adminId) {
	this.adminId = adminId;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}

