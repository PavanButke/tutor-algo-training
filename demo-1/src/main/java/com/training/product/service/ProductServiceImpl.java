package com.training.product.service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;
import com.training.product.exception.ProductExistsAlready;
import com.training.product.model.ProductDto;
import com.training.product.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

//	List<ProductDto> dtos = new ArrayList<>();
//	
//	
//	public ProductServiceImpl()
//	{
//		dtos.add(new ProductDto(1, "Chair" , 4000 , "Infra"));
//		dtos.add(new ProductDto(2, "Table" , 5000 , "Infra"));
//		dtos.add(new ProductDto(3, "Fan" , 500 , "Electronics"));
//		
//	}
	
	@Autowired
	ProductRepository productRepository;

	
	
	@Override
	public List<ProductDto> getProducts() {
		
		
		return productRepository.findAll();
	}

	@Override
	public ProductDto getProductById(int productId) {
		
	
//		for(Product product: dtos)
//		{
//			if(product.getProductId()== productId)
//			{
//				return product;
//			}
//		}
		return productRepository.findById(productId).get();
		
	}

	@Override
	public ProductDto setProduct(ProductDto productDto) {
		
//		dtos.add(productDto);
		ProductDto product = productRepository.findById(productDto.getProductId()).orElse(null);
		
		if(product != null)
		{
			throw new ProductExistsAlready("Product with productId: "+product.getProductId()+" already exists.");
			
		}
//		else if(productDto.getVendors() != null)
//		{
//			for(VendorDto vendor: productDto.getVendors())
//			{
//				vendor.setProductDto(productDto);
//			}
//		}
//		
		return productRepository.save(productDto);

	}
	@Override
	public ProductDto updateProduct(int productId, ProductDto product) {
		ProductDto updateProduct = getProductById(productId);
	    if (updateProduct != null) { 
	        updateProduct.setProductName(product.getProductName());
	        updateProduct.setProductPrice(product.getProductPrice());
	    }
		return productRepository.save(updateProduct);
	}

	@Override
	public String deleteProductById(int productId) {
//		
//		for(int i=0 ; i< dtos.size() ; i++)
//		{
//			if(dtos.get(i).getProductId() == productId)
//			{
//				dtos.remove(i);
//				return "Product has been deleted";
//			}
//		}
//		
		productRepository.deleteById(productId);
		return "Product with product id : "+productId+ " is deleted ";
	}

	public List<ProductDto> getProductByName(String productName)
	{
		try {
			checkResult();
		}catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}
		return productRepository.findByProductName(productName);
		
	}
	
	
	
	public void checkResult()
	{
		int result = 14/0;
	}

	@Override
	public int getProductCountByName(String productName) {
		
		return productRepository.getProductCount(productName);
	}
	

}
