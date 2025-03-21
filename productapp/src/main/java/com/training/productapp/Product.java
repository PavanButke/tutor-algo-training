package com.training.productapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Product {
//	@Value("${nameOfDevice}")
	private  String nameOfDevice;
	
//	@Value("${price}")
	private int price;
	
//	@Value("${c")
	private String company;
	
	public Product() {
		super();
	}

	public Product(String nameOfDevice, int price, String company) {
		super();
		this.nameOfDevice = nameOfDevice;
		this.price = price;
		this.company = company;
	}

	public String getNameOfDevice() {
		return nameOfDevice;
	}

	public void setNameOfDevice(String nameOfDevice) {
		this.nameOfDevice = nameOfDevice;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Product [nameOfDevice=" + nameOfDevice + ", price=" + price + ", company=" + company + "]";
	}
	
	
	

}
