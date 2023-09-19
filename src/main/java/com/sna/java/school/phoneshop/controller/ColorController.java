package com.sna.java.school.phoneshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sna.java.school.phoneshop.entity.Color;
import com.sna.java.school.phoneshop.service.ColorService;

@RestController
@RequestMapping("/colors")
public class ColorController {


	@Autowired
	private ColorService colorService;
	
	@PostMapping
	private ResponseEntity<?> create(@RequestBody Color color){
		
		Color color2 = colorService.create(color);
		return ResponseEntity.ok(color2);
	}
	
}
