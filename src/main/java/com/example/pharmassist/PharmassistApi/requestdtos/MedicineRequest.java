package com.example.pharmassist.PharmassistApi.requestdtos;

import java.time.LocalDate;

import com.example.pharmassist.PharmassistApi.entity.Pharmacy;
import com.example.pharmassist.PharmassistApi.enums.Form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class MedicineRequest {
	@NotNull(message="medicineName not allowed null")
	@NotBlank(message = "medicineName must to be entered")
	@Pattern(regexp = "" ,message = "invalid medicine name")
	private String medicineName;
	@NotNull(message="category not allowed null")
	@NotBlank(message = "category must to be entered")
	@Pattern(regexp = "" ,message = "invalid category ")
	private String category;
	@NotNull(message="ingredients not allowed null")
	@Size(min = 1, message = "There should be at least one ingredient")
	private String ingredients;
	@NotNull(message="manufacturer not allowed null")
	@NotBlank(message = "manufacturer must to be entered")
	@Pattern(regexp = "" ,message = "invalid manufacturer")
	private String manufacturer;
	private Form form;
	@NotNull(message="dosageInMg not allowed null")
	@NotBlank(message = "dosageInMg  must to be entered")
	@Pattern(regexp = "" ,message = "invalid dosageInMg ")
	private int dosageInMg;
	@NotNull(message="stockQuantity not allowed null")
	@NotBlank(message = "stockQuantity must to be entered")
	@Pattern(regexp = "" ,message = "invalid stockQuantity")
	private int stockQuantity;
	private LocalDate expireDate;
	@NotNull(message="price not allowed null")
	@NotBlank(message = "price must to be entered")
	@Pattern(regexp = "" ,message = "invalid price")
	private double price;
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public Form getForm() {
		return form;
	}
	public void setForm(Form form) {
		this.form = form;
	}
	public int getDosageInMg() {
		return dosageInMg;
	}
	public void setDosageInMg(int dosageInMg) {
		this.dosageInMg = dosageInMg;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public LocalDate getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(LocalDate expireDate) {
		this.expireDate = expireDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Pharmacy getPharmacy() {
		return pharmacy;
	}
	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}
	private Pharmacy pharmacy;
}
