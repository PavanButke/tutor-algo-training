package com.practice.training.service;

import java.util.List;

import com.practice.training.dto.ProductDto;
import com.practice.training.dto.VendorDto;

public interface VendorService {
	
	public List<VendorDto> getVendor();
	public VendorDto getVendorById(int vendorId);
	public VendorDto setVendor(VendorDto vendorDto);
	public VendorDto updatVendor(int vendorId , VendorDto vendorDto);
	public String deleteVendor(int vendorId);

}
