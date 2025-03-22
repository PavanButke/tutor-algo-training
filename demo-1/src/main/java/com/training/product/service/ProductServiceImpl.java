package com.training.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.training.product.model.ProductDto;

@Service
public class ProductServiceImpl implements ProductService{

	List<ProductDto> dtos = new ArrayList<>();
	
	
	public ProductServiceImpl()
	{
		dtos.add(new ProductDto(1, "Chair" , 4000 , "Infra"));
		dtos.add(new ProductDto(2, "Table" , 5000 , "Infra"));
		dtos.add(new ProductDto(3, "Fan" , 500 , "Electronics"));
		
	}
	
	
	
	@Override
	public List<ProductDto> getProducts() {
		return dtos;
	}

	@Override
	public ProductDto getProductById(int productId) {
		for(ProductDto product: dtos)
		{
			if(product.getProductId()== productId)
			{
				return product;
			}
		}
		return null;
	}

	@Override
	public ProductDto setProduct(ProductDto product) {
		
		dtos.add(product);
		return product;
	}

	@Override
	public List<ProductDto> updateProduct(int productId, ProductDto product) {
		ProductDto updateProduct = getProductById(productId);
	    if (updateProduct != null) { 
	        updateProduct.setProductName(product.getProductName());
	        updateProduct.setProductPrice(product.getProductPrice());
	        updateProduct.setProductCatagory(product.getProductCatagory());
	        dtos.add(updateProduct);
	        return dtos;
	        
	    }
		return null;
	}

	@Override
	public String deleteProductById(int productId) {
		for(int i=0 ; i< dtos.size() ; i++)
		{
			if(dtos.get(i).getProductId() == productId)
			{
				dtos.remove(i);
				return "Product has been deleted";
			}
		}
		
		return null;
	}

}
