package com.training.product.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.product.model.ProductDto;

@Repository
public interface ProductRepository extends JpaRepository<ProductDto, Integer> {
	
	public List<ProductDto> findByProductName(String productName);
}
