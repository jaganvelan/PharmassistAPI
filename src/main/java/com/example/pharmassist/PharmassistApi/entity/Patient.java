package com.example.pharmassist.PharmassistApi.entity;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.example.pharmassist.PharmassistApi.config.GenerateCustomId;
import com.example.pharmassist.PharmassistApi.util.MyEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Patient {
	
	@Id
	@GenerateCustomId
	private String PatientId;
	private String patientName;
	private String phoneNumber;
	private String email;
	private MyEnum gender;
	private LocalDate dob;
	@ManyToOne
	private Pharmacy pharmacy;
	
	public Pharmacy getPharmacy() {
		return pharmacy;
	}
	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}
	public String getPatientId() {
		return PatientId;
	}
	public void setPatientId(String patientId) {
		PatientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public MyEnum getGender() {
		return gender;
	}
	public void setGender(MyEnum gender) {
		this.gender = gender;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
}
