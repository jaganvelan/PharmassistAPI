package com.example.pharmassist.PharmassistApi.requestdtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class AdminRequest {
	@NotNull(message="email not allowed null")
	@NotBlank(message = "email must to be entered")
	@Email(regexp = "^[a-zA-Z0-9._%+-]+@gmail\\.com$" ,message = "invalid email ID")
	private String email;

	@NotNull(message="password not allowed null")
	@NotBlank(message = "don't to be your password as blank")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*])[a-zA-Z\\d!@#$%^&*]{8,12}$" ,message = "your password must be contain 1uppercase,lowercase,specialcharacter")
	private String Password;

	@NotNull(message="phone number not allowed null")
	@NotBlank(message = "phone number not allow be blank")
	@Pattern(regexp = "^[6-9]\\d{9}$",message = "invalid phone number")
	private String phoneNumber;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}

