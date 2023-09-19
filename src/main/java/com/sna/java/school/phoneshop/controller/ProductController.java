package com.sna.java.school.phoneshop.controller;


import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sna.java.school.phoneshop.dto.ProductDTO;
import com.sna.java.school.phoneshop.dto.ProductImportDTO;
import com.sna.java.school.phoneshop.entity.Product;
import com.sna.java.school.phoneshop.mapper.ProductMapper;
import com.sna.java.school.phoneshop.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("products")
public class ProductController {


	private final ProductService productService;
	private final ProductMapper productMapper;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody ProductDTO dto){
		Product product = productMapper.toProduct(dto);
		product  = productService.create(product);
		return ResponseEntity.ok(product);
	}
	@PostMapping("importProduct")
	public ResponseEntity<?> importProduct (@RequestBody @Valid ProductImportDTO dto){
		productService.importProduct(dto);
	    return ResponseEntity.ok().build();
	}
	@PostMapping("uploadProduct")
	public ResponseEntity<?> uploadProduct(@RequestParam("file") MultipartFile file){
		Map<Integer, String> map = productService.uploadProduct(file);
		return ResponseEntity.ok(map);
	}
	
	
}
