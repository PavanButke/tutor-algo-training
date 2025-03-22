package com.training.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.product.model.ProductDto;
import com.training.product.service.ProductServiceImpl;


@RestController
@RequestMapping("/app")
public class ProductController {
	
	//Field based injection
	@Autowired
	ProductServiceImpl productServiceImpl;

	@GetMapping(value="/products" )
	public List<ProductDto> getProducts()
	{
		return productServiceImpl.getProducts();
		
	}
	
	@GetMapping(value="/product/{productId}")
	public ProductDto getProductById(@PathVariable("productId") int productId)
	{
		
		
		return productServiceImpl.getProductById(productId);
		
	}
	
	
	@PostMapping(value="/addProduct")
	public ProductDto setProduct(@RequestBody ProductDto product)
	{
			
		return productServiceImpl.setProduct(product);
		
	}
	
	@PutMapping(value="/updateProduct/{productId}")
	public List<ProductDto> updateProduct(@PathVariable("productId") int productId, @RequestBody ProductDto product) {    

	    
		return productServiceImpl.updateProduct(productId, product);
	    
	}
	
	@DeleteMapping(value="/delete/{productId}")
	public String deleteProductById(@PathVariable("productId") int productId)
	{
		
		return productServiceImpl.deleteProductById(productId);
		
	}
}
