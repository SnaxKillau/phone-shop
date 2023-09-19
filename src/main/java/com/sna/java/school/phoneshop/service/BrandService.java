package com.sna.java.school.phoneshop.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.sna.java.school.phoneshop.entity.Brand;

public interface BrandService {

	Brand created(Brand brand);
	List<Brand> show();
	Brand findById(Long id);
	Brand update(Long id,Brand brandUpdate);
//	List<Brand> getBrands(Map<String, String> params);
	Page<Brand> getBrands(Map<String, String> params);

}
 