package com.practice.training.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.training.dto.ProductDto;
import com.practice.training.dto.VendorDto;
import com.practice.training.exceptions.ProductExistAlready;
import com.practice.training.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
//	List<ProductDto> dtos = new ArrayList<>();
//	
//	public ProductServiceImpl() { 
//		
//		dtos.add(new ProductDto(1, "MI", 13200 , "Mobile"));
//		dtos.add(new ProductDto(2 , "Iphone", 120200 , "Mobile"));
//		dtos.add(new ProductDto(3 , "Nokia", 1300 , "Mobile"));
//	}
	
	
	@Autowired
	public ProductRepository productRepository;

	@Override
	public List<ProductDto> getProduct() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public ProductDto getProductById(int productId) {
//		for(ProductDto product: dtos)
//		{
//			if(product.getProductId()== productId)
//			{
//				return product;
//			}
//		}
		return productRepository.findById(productId).get();
	}

	@Override
	public ProductDto setProduct(ProductDto productDto) throws ProductExistAlready {
		
//		dtos.add(productDto);
		ProductDto product = productRepository.findById(productDto.getProductId()).orElse(null);
		
		if(product != null)
		{
			throw new ProductExistAlready("Product with productId: "+product.getProductId()+" already exists.");
			
		}
		else if(productDto.getVendors() != null)
		{
			for(VendorDto vendor: productDto.getVendors())
			{
				vendor.setProductDto(productDto);
			}
		}
		
		return productRepository.save(productDto);

	}

	@Override
	public ProductDto updateProduct(int productId, ProductDto productDto) {
		
		ProductDto updateProduct= getProductById(productId);
		if(updateProduct != null)
		{
			updateProduct.setProductId(productDto.getProductId());
			updateProduct.setProductName(productDto.getProductName());
			updateProduct.setProductPrice(productDto.getProductPrice());
			updateProduct.setProductCatagory(productDto.getProductCatagory());
//			dtos.add(updateProduct);
//			return dtos;
		}
		
		
		return  productRepository.save(updateProduct);
	}

	@Override
	public String deleteProduct(int productId) {
		
//		for(int i=0 ; i< dtos.size(); i++)
//		{
//			if(dtos.get(i).getProductId() == productId)
//			{
//				dtos.remove(i);
//				
//				return "Product with " +productId+"is deleted!";
//				
//			}
//		}
		
		productRepository.deleteById(productId);
//		
		return "Product deleted successfully!";
	}

	@Override
	public List<ProductDto> getProductByName(String productName) {
		
		return productRepository.findByProductName(productName);
	}
	
	@Override
	public Long getCountByName(String productName) {
		
		return productRepository.getCountOfProducts(productName);
	}
	

}
