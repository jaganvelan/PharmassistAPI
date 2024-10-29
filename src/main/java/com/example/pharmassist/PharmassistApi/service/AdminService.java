package com.example.pharmassist.PharmassistApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.pharmassist.PharmassistApi.entity.Admin;
import com.example.pharmassist.PharmassistApi.exception.AdminNotFoundByIdException;
import com.example.pharmassist.PharmassistApi.mapper.AdminMapper;
import com.example.pharmassist.PharmassistApi.repository.AdminRepository;
import com.example.pharmassist.PharmassistApi.requestdtos.AdminRequest;
import com.example.pharmassist.PharmassistApi.responsedtos.AdminResponse;

import jakarta.validation.Valid;

@Service
public class AdminService {

	private AdminRepository adminRepository;
	private AdminMapper adminMapper;
	
	public AdminService(AdminRepository adminRepository, AdminMapper adminMapper) {
		super();
		this.adminRepository = adminRepository;
		this.adminMapper = adminMapper;
	}

	public AdminResponse addAdmin(@Valid AdminRequest adminRequest) {
		Admin admin=adminRepository.save(adminMapper.mapToAdmin(adminRequest, new Admin()));
		return adminMapper.mapToAdminResponse(admin);
	}
	public AdminResponse findAdmin(String adminId) {
		return adminRepository.findById(adminId)
				.map(adminMapper::mapToAdminResponse)
				.orElseThrow(() -> new AdminNotFoundByIdException("Failed to find Admin"));
	}
	public AdminResponse updateAdmin(AdminRequest adminRequest,String adminId) {
		return adminRepository.findById(adminId)
				.map(exAdmin ->{
					adminMapper.mapToAdmin(adminRequest, exAdmin);
					return adminRepository.save(exAdmin);
				})
				.map(adminMapper::mapToAdminResponse)
				.orElseThrow(() -> new AdminNotFoundByIdException("Failed to update Admin"));
	}
	public List<AdminResponse> findAllAdmin(){
		return adminRepository.findAll()
				.stream()
				.map(adminMapper::mapToAdminResponse)
				.toList();
	}

}

