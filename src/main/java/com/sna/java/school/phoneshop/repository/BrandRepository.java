package com.sna.java.school.phoneshop.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sna.java.school.phoneshop.entity.Brand;


public interface BrandRepository extends JpaRepository<Brand, Long>, JpaSpecificationExecutor<Brand>{
	
	List<Brand>findByNameLike(String name);

}