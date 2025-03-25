package com.practice.training.service;

import java.util.List;

import com.practice.training.dto.ProductDto;

public interface ProductService {
	
	public List<ProductDto> getProduct();
	public ProductDto getProductById(int productId);
	public ProductDto setProduct(ProductDto productDto);
	public ProductDto updateProduct(int productId , ProductDto productDto);
	public String deleteProduct(int productId);
	public List<ProductDto> getProductByName(String productName);
	public Long getCountByName(String productName);
}
