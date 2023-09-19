package com.sna.java.school.phoneshop.service;


import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.sna.java.school.phoneshop.dto.ProductImportDTO;
import com.sna.java.school.phoneshop.entity.Product;

public interface ProductService {
	
	Product create(Product product);
	Product getByID(Long id);
	 void importProduct(ProductImportDTO importDTO);
	 Map<Integer, String> uploadProduct(MultipartFile file);

}
