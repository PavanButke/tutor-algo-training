package com.training.product.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.training.product.model.ProductDto;

@Repository
public interface ProductRepository extends JpaRepository<ProductDto, Integer> {

}
