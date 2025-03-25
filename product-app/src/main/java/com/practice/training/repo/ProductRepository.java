package com.practice.training.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.practice.training.dto.ProductDto;

public interface ProductRepository extends JpaRepository<ProductDto, Integer>{
	
	List<ProductDto> findByProductName(String productName);
	
	@Query(value="Select count(*) from training.product_dto p where p.product_name=:name", nativeQuery = true)
	public Long getCountOfProducts(@Param("name") String productName);
	
}
