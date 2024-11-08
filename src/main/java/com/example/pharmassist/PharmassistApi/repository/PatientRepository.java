package com.example.pharmassist.PharmassistApi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.pharmassist.PharmassistApi.entity.Patient;
import com.example.pharmassist.PharmassistApi.entity.Pharmacy;
@Repository
public interface PatientRepository extends  JpaRepository<Patient, String> {
@Query("SELECT p FROM Patient p WHERE p.pharmacy.pharmacyId=:pharmacyId")
	public List<Patient> findPatientByPharmacyId(@Param("pharmacyId")String pharmacyId);

}
