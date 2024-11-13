package com.example.pharmassist.PharmassistApi.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.pharmassist.PharmassistApi.entity.Admin;
import com.example.pharmassist.PharmassistApi.exception.AdminNotFoundByIdException;
import com.example.pharmassist.PharmassistApi.mapper.AdminMapper;
import com.example.pharmassist.PharmassistApi.repository.AdminRepository;
import com.example.pharmassist.PharmassistApi.requestdtos.AdminRequest;
import com.example.pharmassist.PharmassistApi.responsedtos.AdminResponse;


@Service
public class AdminService {

	private AdminRepository adminRepository;
	private  AdminMapper adminMapper;
	private PasswordEncoder passwordEncoder;
	public AdminService(AdminRepository adminRepository, AdminMapper adminMapper ,PasswordEncoder passwordEncoder) {
		super();
		this.adminRepository = adminRepository;
		this.adminMapper = adminMapper;
		this.passwordEncoder=passwordEncoder;
	}

	public AdminResponse addAdmin( AdminRequest adminRequest) {
		Admin admin=adminMapper.mapToAdmin(adminRequest, new Admin());
				admin.setPassword(passwordEncoder.encode(admin.getPassword()));
				adminRepository.save(admin);
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

