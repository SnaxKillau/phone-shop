package com.sna.java.school.phoneshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sna.java.school.phoneshop.dto.SaleDTO;
import com.sna.java.school.phoneshop.service.SaleService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("sales")
public class SaleController {

	private final SaleService service;
	
	@PostMapping
	public ResponseEntity<?> sale(@RequestBody SaleDTO dto){
		service.sell(dto);
		return ResponseEntity.ok().build();
		
	}

}
