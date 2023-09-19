package com.sna.java.school.phoneshop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.sna.java.school.phoneshop.dto.ProductImportDTO;
import com.sna.java.school.phoneshop.entity.Product;
import com.sna.java.school.phoneshop.entity.ProductImportHistory;

@Mapper
public interface ProductHistoryMapper {
	
	ProductHistoryMapper INSTANCE = Mappers.getMapper(ProductHistoryMapper.class);
	@Mapping(target = "product" , source = "product")
	@Mapping(target = "id" , ignore = true)
	ProductImportHistory toProductImportHistory(ProductImportDTO dto , Product product );
	

}
