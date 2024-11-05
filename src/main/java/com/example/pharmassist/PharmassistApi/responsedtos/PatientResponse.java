package com.example.pharmassist.PharmassistApi.responsedtos;

import java.time.LocalDate;

import com.example.pharmassist.PharmassistApi.util.MyEnum;

public class PatientResponse {
private String patientId;
private String patientName;
private String phoneNumber;
private String email;
private MyEnum gender;
private LocalDate dob;
public String getPatientId() {
	return patientId;
}
public void setPatientId(String patientId) {
	this.patientId = patientId;
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
