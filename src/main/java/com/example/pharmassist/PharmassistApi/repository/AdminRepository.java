package com.example.pharmassist.PharmassistApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pharmassist.PharmassistApi.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String>{

}

