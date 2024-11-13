package com.example.pharmassist.PharmassistApi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.pharmassist.PharmassistApi.entity.Admin;
import com.example.pharmassist.PharmassistApi.entity.Pharmacy;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String>{
	
@Query("SELECT a.pharmacy FROM Admin a WHERE a.adminId=:adminId")
public Optional<Pharmacy> findPharmacyByAdminId(@Param("adminId") String adminId);


public Optional<Admin> findByEmail(String email);

}

