package com.example.pharmassist.PharmassistApi.responsedtos;

import java.time.LocalDate;

import com.example.pharmassist.PharmassistApi.entity.Pharmacy;
import com.example.pharmassist.PharmassistApi.enums.Form;
public class MedicineResponse {
	private String medicineId;
	private String medicineName;
	private String category;
	private String ingredients;
	private String manufacturer;
	private Form form;
	private int dosageInMg;
	private int stockQuantity;
	public String getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(String medicineId) {
		this.medicineId = medicineId;
	}
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
	private LocalDate expireDate;
	private double price;
}
