package com.sna.java.school.phoneshop.controller;


import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sna.java.school.phoneshop.dto.BrandDTO;
import com.sna.java.school.phoneshop.dto.PageDTO;
import com.sna.java.school.phoneshop.entity.Brand;

import com.sna.java.school.phoneshop.mapper.MappingBrand;
import com.sna.java.school.phoneshop.service.BrandService;




@RestController
@RequestMapping("brands")
public class BrandController {

	@Autowired
   private BrandService brandService;
	
   
	@PostMapping
	public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO){
		Brand brand = MappingBrand.INSTANCE.toBrand(brandDTO);
		brand = brandService.created(brand);
		return ResponseEntity.ok(brand);	
		
	}
//	@GetMapping
//	public ResponseEntity<?> show(){
//	
//		List<Brand> brands = brandService.show();
//		brands.stream().map(t -> MappingBrand.INSTANCE.toBrandDTO(t)).collect(Collectors.toList());
//		return ResponseEntity.ok(brands);
//	}
	@GetMapping("{id}")
	public ResponseEntity<?> showById(@PathVariable Long id){
		Brand brand = brandService.findById(id);
		return ResponseEntity.ok(MappingBrand.INSTANCE.toBrandDTO(brand));
	}
//	@GetMapping
//	public ResponseEntity<?> showByName(@RequestParam Map<String, String> params ){
//		
//		List<BrandDTO> list = brandService.getBrands(params)
//				.stream().map((t -> MappingBrand.INSTANCE.toBrandDTO(t))).collect(Collectors.toList());
//		return ResponseEntity.ok(list);
//		
//	}
	@GetMapping
	public ResponseEntity<?> showByName(@RequestParam Map<String, String> params ){
		Page<Brand> page = brandService.getBrands(params);
		PageDTO pageDTO = new PageDTO(page);
		
		return ResponseEntity.ok(pageDTO);
		
	}
	@PutMapping("{id}")
	public ResponseEntity<?> update(@PathVariable Long id , @RequestBody BrandDTO dto){
		Brand brand = MappingBrand.INSTANCE.toBrand(dto);
		Brand updateBrand = brandService.update(id, brand );
		return ResponseEntity.ok(MappingBrand.INSTANCE.toBrandDTO(updateBrand));	
	}



	
}
