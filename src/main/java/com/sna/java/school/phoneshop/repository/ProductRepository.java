package com.sna.java.school.phoneshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sna.java.school.phoneshop.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> , JpaSpecificationExecutor<Product>{

}
