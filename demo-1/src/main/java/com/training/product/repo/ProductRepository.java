package com.training.product.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.training.product.model.ProductDto;

@Repository
public interface ProductRepository extends JpaRepository<ProductDto, Integer> {
	
	public List<ProductDto> findByProductName(String productName);

	@Query(value="SELECT count(*) FROM testing.product_dto p where p.product_name=:name ;" , nativeQuery = true)
	public int getProductCount(@Param("name") String productName);
	

}
