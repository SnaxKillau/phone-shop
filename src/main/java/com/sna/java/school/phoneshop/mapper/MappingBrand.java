package com.sna.java.school.phoneshop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.sna.java.school.phoneshop.dto.BrandDTO;
import com.sna.java.school.phoneshop.entity.Brand;

@Mapper

public interface MappingBrand {
	
	MappingBrand INSTANCE = Mappers.getMapper(MappingBrand.class);
	Brand toBrand(BrandDTO dto);
	BrandDTO toBrandDTO(Brand brand);

}
