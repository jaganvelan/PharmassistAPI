package com.example.pharmassist.PharmassistApi.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pharmassist.PharmassistApi.entity.Pharmacy;

public interface PharmacyRepository extends JpaRepository<Pharmacy, String> {


}
