package com.practice.training.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class VendorDto {
	@Id
	private int vendorId;
	
	@Column
	private String vendorName;
	
	@ManyToOne(fetch = FetchType.EAGER , cascade = {CascadeType.ALL})
	@JoinColumn(name="product_id")
	@JsonIgnore
	private ProductDto productDto;

	public VendorDto() {
		super();
	}

	public VendorDto(int vendorId, String vendorName, ProductDto productDto) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.productDto = productDto;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public ProductDto getProductDto() {
		return productDto;
	}

	public void setProductDto(ProductDto productDto) {
		this.productDto = productDto;
	}

	@Override
	public String toString() {
		return "VendorDto [vendorId=" + vendorId + ", vendorName=" + vendorName + ", productDto=" + productDto + "]";
	}
	
	
}
