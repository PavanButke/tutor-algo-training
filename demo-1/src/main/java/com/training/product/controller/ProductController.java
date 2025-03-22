package com.training.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.product.model.ProductDto;


@RestController
@RequestMapping("/app")
public class ProductController {

	List<ProductDto> dtos = new ArrayList<>();
	
	
	public ProductController()
	{
		dtos.add(new ProductDto(1, "Chair" , 4000 , "Infra"));
		dtos.add(new ProductDto(2, "Table" , 5000 , "Infra"));
		dtos.add(new ProductDto(3, "Fan" , 500 , "Electronics"));
		
	}
	
	@GetMapping(value="/products" )
	public List<ProductDto> getProducts()
	{
		return dtos;
		
	}
	
	@GetMapping(value="/product/{productId}")
	public ProductDto getProductById(@PathVariable("productId") int productId)
	{
		for(ProductDto product: dtos)
		{
			if(product.getProductId()== productId)
			{
				return product;
			}
		}
		
		return null;
		
	}
	
	@PutMapping(value="/updateProduct/{productId}")
	public List<ProductDto> updateProduct(@PathVariable("productId") int productId, @RequestBody ProductDto product) {    

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
}
