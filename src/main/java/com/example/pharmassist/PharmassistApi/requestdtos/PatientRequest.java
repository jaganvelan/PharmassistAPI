package com.example.pharmassist.PharmassistApi.requestdtos;

import java.time.LocalDate;


import com.example.pharmassist.PharmassistApi.util.MyEnum;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class PatientRequest {
	@NotBlank(message = "patientName not allowed for blank")
	@NotNull(message = "patientName must be entered")
	@Pattern(regexp = "^[A-Za-z\\s'-]+$",message = "invalid patientName")
private String patientName;
	@NotBlank(message = "phoneNumber not allowed for blank")
	@NotNull(message = "phoneNumber must be entered")
	@Pattern(regexp = "^[1-9][0-9]{9}$",message = "invalid phoneNumber")
private String phoneNumber;
	@NotBlank(message = "email not allowed for blank")
	@NotNull(message = "email must be entered")
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$",message = "invalid email")
private String email;
private MyEnum gender;
private LocalDate dob;
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
