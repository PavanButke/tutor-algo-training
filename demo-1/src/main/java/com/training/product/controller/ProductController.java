package com.training.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.product.model.ProductDto;


@RestController
@RequestMapping("/app")
public class ProductController {

	@GetMapping(value="/products" )
	public List<ProductDto> getProducts()
	{
		return null;
		
	}
	
	@GetMapping(value="/product/{productId}")
	public ProductDto getProductById(@PathVariable("productId") int productId)
	{
		
		
		return null;
		
	}
	
	
	@PostMapping(value="/addProduct")
	public ProductDto setProduct(@RequestBody ProductDto product)
	{
			
		return product;
		
	}
	
	@PutMapping(value="/updateProduct/{productId}")
	public List<ProductDto> updateProduct(@PathVariable("productId") int productId, @RequestBody ProductDto product) {    

	    
		return null;
	    
	}
	
	@DeleteMapping(value="/delete/{productId}")
	public String deleteProductById(@PathVariable("productId") int productId)
	{
		
		return null;
		
	}
}
