package com.sna.java.school.phoneshop.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import com.sna.java.school.phoneshop.entity.Brand;
import com.sna.java.school.phoneshop.exception.ResourceNotFoundException;
import com.sna.java.school.phoneshop.repository.BrandRepository;
import com.sna.java.school.phoneshop.service.impl.BrandServiceImpl;


@ExtendWith(MockitoExtension.class)
public class BrandServiceTest {

	@Mock
    private	BrandRepository brandRepository;
	
	private BrandService brandService;
	
	@BeforeEach
	public void Assign() {
		brandService = new BrandServiceImpl(brandRepository);
	}
	
	@Test
	public void createdTest() {
		
		// given 
		Brand brand = new Brand();
		brand.setId(1L);
		brand.setName("Sna");
		
		
		// when 
		
		brandService.created(brand);
		
		// then
	
		verify(brandRepository , times(1)).save(brand);
	}
	
	@Test
	public void showTest() {
		
		// given 
		
		// when 
		
		brandService.show();
		
		// then
		verify(brandRepository , times(1)).findAll();
	}
	
	@Test
	public void findByIDSuccessTest() {
		
		// given
		Brand brand = new Brand();
		brand.setId(1L);
		brand.setName("Sna");
		
		//when
		when(brandRepository.findById(1L)).thenReturn(Optional.of(brand));
		
		Brand brand2 = brandService.findById(1L);
		
		//then
		assertEquals(1, brand2.getId());
		
	}
	@Test
	public void findByIDFialTest() {
		
		// given
		Brand brand = new Brand();
		brand.setId(1L);
		brand.setName("Sna");
		
		//when
		when(brandRepository.findById(1L)).thenReturn(Optional.empty());
		
		
		
		//then
		assertThatThrownBy(() -> brandService.findById(1L))
		.isInstanceOf(ResourceNotFoundException.class)
		.hasMessage("Brand with this 1 isn't found");
		
	}
	
	
	

}
