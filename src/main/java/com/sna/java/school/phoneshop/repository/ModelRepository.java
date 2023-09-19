package com.sna.java.school.phoneshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sna.java.school.phoneshop.entity.Brand;
import com.sna.java.school.phoneshop.entity.Model;

public interface ModelRepository extends JpaRepository<Model, Long> , JpaSpecificationExecutor<Model> {

	List<Model> findByBrand(Brand brand);
}
