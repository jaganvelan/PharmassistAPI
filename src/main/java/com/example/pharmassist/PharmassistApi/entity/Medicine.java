package com.example.pharmassist.PharmassistApi.entity;


import java.time.LocalDate;

import com.example.pharmassist.PharmassistApi.config.GenerateCustomId;
import com.example.pharmassist.PharmassistApi.enums.Form;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Medicine {
@Id
@GenerateCustomId
private String medicineId;
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
@Enumerated(EnumType.STRING)
private Form form;
@ManyToOne
private Pharmacy pharmacy;

public Pharmacy getPharmacy() {
	return pharmacy;
}
public void setPharmacy(Pharmacy pharmacy) {
	this.pharmacy = pharmacy;
}
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
@Override
public String toString() {
	return "Medicine [medicineId=" + medicineId + ", medicineName=" + medicineName + ", category=" + category
			+ ", ingredients=" + ingredients + ", manufacturer=" + manufacturer + ", form=" + form + ", dosageInMg="
			+ dosageInMg + ", stockQuantity=" + stockQuantity + ", expireDate=" + expireDate + ", price=" + price
			+ ", pharmacy=" + pharmacy + "]";
}


}
