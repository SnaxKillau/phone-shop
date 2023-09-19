package com.sna.java.school.phoneshop.service;



import org.springframework.http.ResponseEntity;

import com.sna.java.school.phoneshop.dto.ModelDTO;

import com.sna.java.school.phoneshop.entity.Model;

public interface ModelService {
	
	ModelDTO createBrand(ModelDTO dto);
	ResponseEntity<?> showByBrandName(String name);
	Model findById(Long id);
}
