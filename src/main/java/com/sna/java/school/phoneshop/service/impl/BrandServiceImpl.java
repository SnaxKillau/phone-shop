package com.sna.java.school.phoneshop.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sna.java.school.phoneshop.entity.Brand;
import com.sna.java.school.phoneshop.exception.ResourceNotFoundException;
import com.sna.java.school.phoneshop.repository.BrandRepository;
import com.sna.java.school.phoneshop.service.BrandService;
import com.sna.java.school.phoneshop.service.util.PageUtil;
import com.sna.java.school.phoneshop.spec.BrandFilter;
import com.sna.java.school.phoneshop.spec.BrandSpec;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {


	private final BrandRepository brandRepository;
	@Override
	public Brand created(Brand brand) {
		
		return brandRepository.save(brand);
	}
	@Override
	public List<Brand> show() {
		
		return brandRepository.findAll();
	}
	@Override
	public Brand findById(Long id) {
		
		return brandRepository.findById(id).orElseThrow((() -> new ResourceNotFoundException(id, "Brand")));
	}
	@Override
	public Brand update(Long id, Brand brandUpdate) {

		Brand brand = findById(id);
		brand.setName(brandUpdate.getName());
		return brandRepository.save(brand);
	}
	@Override
	public Page<Brand> getBrands(Map<String, String> params) {
		
		BrandFilter brandFilter = new BrandFilter();
		
		if(params.containsKey("name")) {
			String name = params.get("name");
			brandFilter.setName(name);
		}
		if(params.containsKey("id")) {
			String id = params.get("id");
			brandFilter.setId(Integer.parseInt(id));
		}
		int pageLimit = PageUtil.DEFAULT_PAGE_LIMIT;
		if(params.containsKey(PageUtil.PAGE_LIMIT)) {
			pageLimit = Integer.parseInt(params.get(PageUtil.PAGE_LIMIT));
		}
		int pageNumber = PageUtil.DEFAULT_PAGE_NUMBER;
		if(params.containsKey(PageUtil.PAGE_NUMBER)) {
			pageNumber = Integer.parseInt(params.get(PageUtil.PAGE_NUMBER));
			
		}
		
		BrandSpec brandSpec = new BrandSpec(brandFilter);
		Pageable pageable = PageUtil.getPageable(pageNumber,pageLimit);
		
		
		Page<Brand> page = brandRepository.findAll(brandSpec,pageable);
		return page;
	}
//	@Override
//	public List<Brand> getBrands(Map<String, String> params) {
//	BrandFilter brandFilter = new BrandFilter();
//		
//		if(params.containsKey("name")) {
//			String name = params.get("name");
//			brandFilter.setName(name);
//		}
//		if(params.containsKey("id")) {
//			String id = params.get("id");
//			brandFilter.setId(Integer.parseInt(id));
//		}
//	   BrandSpec brandSpec = new BrandSpec(brandFilter);
//		
//		
//		return brandRepository.findAll(brandSpec);
//		
//	}


	


}
