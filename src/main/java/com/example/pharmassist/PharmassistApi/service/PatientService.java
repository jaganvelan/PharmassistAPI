package com.example.pharmassist.PharmassistApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.pharmassist.PharmassistApi.entity.Patient;
import com.example.pharmassist.PharmassistApi.entity.Pharmacy;
import com.example.pharmassist.PharmassistApi.exception.PatientNotFoundByIdException;
import com.example.pharmassist.PharmassistApi.exception.PharmacyNotFoundByIdException;
import com.example.pharmassist.PharmassistApi.mapper.PatientMapper;
import com.example.pharmassist.PharmassistApi.repository.PatientRepository;
import com.example.pharmassist.PharmassistApi.repository.PharmacyRepository;
import com.example.pharmassist.PharmassistApi.requestdtos.PatientRequest;
import com.example.pharmassist.PharmassistApi.responsedtos.PatientResponse;

import jakarta.validation.Valid;

@Service
public class PatientService {
	private final  PatientRepository patientRepository;
	private  final  PharmacyRepository pharmacyRepository;
	private  final  PatientMapper patientMapper;
	public PatientService(PatientRepository patientRepository, PharmacyRepository pharmacyRepository,
			PatientMapper patientMapper) {
		super();
		this.patientRepository = patientRepository;
		this.pharmacyRepository = pharmacyRepository;
		this.patientMapper = patientMapper;
	}
	public PatientResponse addPatient(PatientRequest patientRequest, String pharmacyId) {
		return  pharmacyRepository.findById(pharmacyId)
		 .map(pharmacy->{
		Patient patient=patientRepository.save(patientMapper.mapToPatient(patientRequest, new Patient()));
		 patient.setPharmacy(pharmacy);
		 patientRepository.save(patient);
		 return patientMapper.mapToPatientResponse(patient);
		 })
		 .orElseThrow(()-> new PharmacyNotFoundByIdException("there is no pharmacy in this ID"));
	}
	public PatientResponse updatePatient(@Valid PatientRequest patientRequest, String patientId) {
		return patientRepository.findById(patientId)
		.map(exPatient->{
		patientMapper.mapToPatient(patientRequest, exPatient);
		return patientRepository.save(exPatient);
		})
		.map(patientMapper::mapToPatientResponse)
		.orElseThrow(()-> new PatientNotFoundByIdException("there is no patient in this ID"));
	}
	public List<PatientResponse> findPatient(String pharmacyId) {
		 List<Patient> patient= patientRepository.findPatientByPharmacyId(pharmacyId);
		 if(patient.isEmpty())
			 throw new PatientNotFoundByIdException("failed to find patient By pharmacyId");
		 return patient.stream()
				 .map(patientMapper::mapToPatientResponse)
				 .toList();
	
	}
}
