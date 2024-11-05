package com.example.pharmassist.PharmassistApi.requestdtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class PharmacyRequest {
	@NotBlank(message="pharmacy name don't allowed blank")
	@NotNull(message="pharmacy name must be entred")
	@Pattern(regexp = "^[a-zA-Z]{2,50}$",message = "invalid pharmacyName")
	private String pharmacyName;
	@NotBlank(message="gstNumber don't allowed blank")
	@NotNull(message="gstNumber must be entred")
	@Pattern(regexp = "^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}$",message = "invalid gstNumber")
	private String gstNo;
	@NotNull(message = "licence number must be entered")
	@NotBlank(message = "licence number not allow the blank value")
	@Pattern(regexp = "^[A-Za-z0-9]{10,15}$",message = "invalid licenece number")
	private String licenceNo;
	private String adminId;
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getPharmacyName() {
		return pharmacyName;
	}
	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}
	public String getGstNo() {
		return gstNo;
	}
	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}
	public String getLicenceNo() {
		return licenceNo;
	}
	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}
}
