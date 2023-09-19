package com.sna.java.school.phoneshop.service.impl;


import org.springframework.stereotype.Service;
import com.sna.java.school.phoneshop.entity.Color;
import com.sna.java.school.phoneshop.exception.ResourceNotFoundException;
import com.sna.java.school.phoneshop.repository.ColorRepository;
import com.sna.java.school.phoneshop.service.ColorService;
import lombok.RequiredArgsConstructor;





@Service
@RequiredArgsConstructor
public class ColorServiceImpl implements ColorService{
	
	
	private final ColorRepository colorRepository;


	@Override
	public Color getByID(Long id) {
		
		return colorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id, "color"));
	}


	@Override
	public Color create(Color color) {
		
		return colorRepository.save(color);
	}

	

}
