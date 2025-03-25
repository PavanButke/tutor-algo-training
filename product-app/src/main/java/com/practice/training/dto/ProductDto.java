package com.practice.training.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Component
@Entity
public class ProductDto {
	@Id
	private int productId;
	
	@Column
	private String productName;
	
	@Column
	private Integer productPrice;
	
	@Column
	private String productCatagory;
	
	@OneToMany(mappedBy="productDto" , fetch = FetchType.EAGER , cascade = {CascadeType.ALL} , orphanRemoval = true)
	private List<VendorDto> vendors;
	
	public ProductDto() {
		super();
	}

	public ProductDto(int productId, String productName, Integer productPrice, String productCatagory) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCatagory = productCatagory;
	}


	


	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductCatagory() {
		return productCatagory;
	}

	public void setProductCatagory(String productCatagory) {
		this.productCatagory = productCatagory;
	}

	
	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}
	


	public List<VendorDto> getVendors() {
		return vendors;
	}


	public void setVendors(List<VendorDto> vendors) {
		this.vendors = vendors;
	}




	@Override
	public String toString() {
		return "ProductDto [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productCatagory=" + productCatagory + "]";
	}

}
