package com.sna.java.school.phoneshop.service.impl;


import java.util.List;
import java.util.stream.Collectors;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sna.java.school.phoneshop.dto.ModelDTO;
import com.sna.java.school.phoneshop.entity.Brand;
import com.sna.java.school.phoneshop.entity.Model;
import com.sna.java.school.phoneshop.exception.ResourceNotFoundException;
import com.sna.java.school.phoneshop.mapper.ModelMapper;
import com.sna.java.school.phoneshop.repository.BrandRepository;
import com.sna.java.school.phoneshop.repository.ModelRepository;
import com.sna.java.school.phoneshop.service.ModelService;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ModelServiceImpl implements ModelService {

	private final ModelMapper modelMapper;
	private final ModelRepository modelRepository;
	private final BrandRepository brandRepository;

	@Override
	public ModelDTO createBrand(ModelDTO dto) {

		Model model = modelRepository.save(modelMapper.toModel(dto));

		return modelMapper.toModelDTO(model);
	}

	@Override
	public ResponseEntity<?> showByBrandName(String name) {

		if (!name.isEmpty()) {

			List<Brand> brands = brandRepository.findByNameLike(name);

			if (brands.size() < 1) {
				return ResponseEntity.ok(new ResourceNotFoundException(null, "brand"));
			}

			List<?> modelsList = brands.stream().map(t -> modelRepository.findByBrand(t)).collect(Collectors.toList());

			return ResponseEntity.ok(modelsList);

		}
		return ResponseEntity.ok(modelRepository.findAll());

	}

	@Override
	public Model findById(Long id) {
		Model model = modelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id, "Model"));
		return model;
	}

}
