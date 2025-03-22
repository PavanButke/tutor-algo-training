package com.training.product.service;

import java.util.List;

import com.training.product.model.ProductDto;

public interface ProductService {
	
	public List<ProductDto> getProducts();
	
	public ProductDto getProductById(int productId);
	
	public ProductDto setProduct(ProductDto product );
	
	public List<ProductDto> updateProduct(int productId , ProductDto product);
	
	public String deleteProductById(int productId);

}
