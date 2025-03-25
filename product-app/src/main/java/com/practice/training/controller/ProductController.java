package com.practice.training.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.training.dto.ProductDto;
import com.practice.training.service.ProductServiceImpl;

@RestController
@RequestMapping("/app")
public class ProductController {
	
//	List<ProductDto> dtos = new ArrayList<>();
//	
//	public ProductController() {
//		dtos.add(new ProductDto(1, "MI", 13200 , "Mobile"));
//		dtos.add(new ProductDto(2 , "Iphone", 120200 , "Mobile"));
//		dtos.add(new ProductDto(3 , "Nokia", 1300 , "Mobile"));
//	}
//	
	@Autowired
	public ProductServiceImpl productServiceImpl;
	
	
	@GetMapping(value="/products" )
	public List<ProductDto> getProduct()
	{
		List<ProductDto>dtos= productServiceImpl.getProduct();
		return dtos;
		
	}
	
	@GetMapping(value="/product/{productId}" )
	public ProductDto getProductById(@PathVariable("productId") int productId)
	{
//		for(ProductDto dto: dtos)
//		{
//			if(dto.getProductId() == productId)
//			{
//				return dto;
//			}
//		}

		ProductDto dto = productServiceImpl.getProductById(productId);
		
		
		//return null;
		return dto;
	}
	
	
	
	
	@PostMapping(value="/addProduct")
	public ProductDto setProduct(@RequestBody ProductDto product)
	{
		//dtos.add(product);
		
		ProductDto addedProduct = productServiceImpl.setProduct(product);
		
		return addedProduct;
		
	}
	
	
	@PutMapping(value="/updateProduct/{productId}")
	public ProductDto updateProduct(@PathVariable("productId") int productId, @RequestBody ProductDto product) {    
	    ProductDto dto = productServiceImpl.updateProduct(productId, product);
		return  dto;
//	    ProductDto updateProduct = getProductById(productId);
//		
//	    if (updateProduct != null) { 
//	        updateProduct.setProductName(product.getProductName());
//	        updateProduct.setProductPrice(product.getProductPrice());
//	        updateProduct.setProductCatagory(product.getProductCatagory());
//	        return dtos;
//	        
//	    }
//		return null;
//	    
	}

	@DeleteMapping(value = "/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId")int productId)
	{
//		for(int i=0 ; i<dtos.size() ; i++)
//		{
//			if(dtos.get(i).getProductId()== productId)
//			{
//				dtos.remove(dtos.get(i));
//				return "Product has been deleted!";
//			}
//		}
//		
		return productServiceImpl.deleteProduct(productId);
	}

	
	@GetMapping(value="/getByName")
	public List<ProductDto> getProductByName(@RequestParam("productName") String productName)
	{
		
		return productServiceImpl.getProductByName(productName);
	}
	
	
	@GetMapping(value="/getCount")
	public Long getCountOfProduct(@RequestParam("productName") String productName)
	{
		
		return productServiceImpl.getCountByName(productName);
	}
	
	
}
