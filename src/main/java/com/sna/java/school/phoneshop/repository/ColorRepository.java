package com.sna.java.school.phoneshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sna.java.school.phoneshop.entity.Color;

public interface ColorRepository extends JpaRepository<Color, Long> , JpaSpecificationExecutor<Color> {

	
}
