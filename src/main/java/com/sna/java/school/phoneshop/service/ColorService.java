package com.sna.java.school.phoneshop.service;

import com.sna.java.school.phoneshop.entity.Color;

public interface ColorService {
	
	Color create(Color color);
	Color getByID(Long id);

}
