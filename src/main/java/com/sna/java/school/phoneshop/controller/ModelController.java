package com.sna.java.school.phoneshop.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sna.java.school.phoneshop.dto.ModelDTO;
import com.sna.java.school.phoneshop.service.ModelService;


@RestController
@RequestMapping("models")
public class ModelController {

	@Autowired
	private ModelService modelService;
	
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody ModelDTO modelDTO){
	
		ModelDTO modelDTO2 = modelService.createBrand(modelDTO);
		return ResponseEntity.ok(modelDTO2);
	}
	
	@GetMapping
	public ResponseEntity<?> show(@RequestParam String name){
		
	     return modelService.showByBrandName(name);
		
	}

}
