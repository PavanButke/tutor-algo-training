package com.practice.training.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.training.dto.VendorDto;

public interface VendorRepository extends JpaRepository<VendorDto, Integer> {

}
