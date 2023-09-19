package com.sna.java.school.phoneshop.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.sna.java.school.phoneshop.entity.Brand;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BrandRepositoryTest {
	
	
	@Autowired
	private BrandRepository brandRepository;

	@Test
	public void testFindByName() {
		// given
		
		Brand brand = new Brand();
		brand.setName("Haha");
		brandRepository.save(brand);
		
		// when 
		List<Brand> brands =brandRepository.findByNameLike("%H%");
		
		//then
		assertEquals("Haha", brands.get(0).getName());
//		assertEquals(17, brands.get(0).getId());
		
		
		
	}
	
	

}
