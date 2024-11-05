package com.example.pharmassist.PharmassistApi.mapper;

import org.springframework.stereotype.Component;

import com.example.pharmassist.PharmassistApi.entity.Patient;
import com.example.pharmassist.PharmassistApi.requestdtos.PatientRequest;
import com.example.pharmassist.PharmassistApi.responsedtos.PatientResponse;

@Component
public class PatientMapper {
	public Patient mapToPatient(PatientRequest patientRequest,Patient patient) {
		patient.setPatientName(patientRequest.getPatientName());
		patient.setPhoneNumber(patientRequest.getPhoneNumber());
		patient .setEmail(patientRequest.getEmail());
		patient.setGender(patientRequest.getGender());
		patient.setDob(patientRequest.getDob());
		return patient;
	}
	public PatientResponse mapToPatientResponse(Patient patient) {
		PatientResponse patientResponse=new PatientResponse(); 
		patientResponse.setPatientId(patient.getPatientId());
		patientResponse.setPatientName(patient.getPatientName());
		patientResponse.setPhoneNumber(patient.getPhoneNumber());
		patientResponse.setEmail(patient.getEmail());
		patientResponse.setGender(patient.getGender());
		patientResponse.setDob(patient.getDob());
		return patientResponse;
	}
}
