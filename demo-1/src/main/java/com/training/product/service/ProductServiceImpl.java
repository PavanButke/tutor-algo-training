package com.training.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public ProductDto setProduct(ProductDto product) {
		
		//dtos.add(product);
		return productRepository.save(product);
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

}
