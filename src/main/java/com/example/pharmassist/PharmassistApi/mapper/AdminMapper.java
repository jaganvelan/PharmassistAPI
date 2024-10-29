package com.example.pharmassist.PharmassistApi.mapper;

import org.springframework.stereotype.Component;

import com.example.pharmassist.PharmassistApi.entity.Admin;
import com.example.pharmassist.PharmassistApi.requestdtos.AdminRequest;
import com.example.pharmassist.PharmassistApi.responsedtos.AdminResponse;



@Component
public class AdminMapper {
	public Admin mapToAdmin(AdminRequest adminRequest ,Admin admin) {
		admin.setEmail(adminRequest.getEmail());
		admin.setPassword(adminRequest.getPassword());
		admin.setPhoneNumber(adminRequest.getPhoneNumber());
		return admin;
	}

	public AdminResponse mapToAdminResponse(Admin admin) {
		AdminResponse response=new AdminResponse();
		response.setAdminId(admin.getAdminId());
		response.setEmail(admin.getEmail());
		return  response;
	}
}
