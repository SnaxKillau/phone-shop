package com.sna.java.school.phoneshop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


import com.sna.java.school.phoneshop.dto.ModelDTO;
import com.sna.java.school.phoneshop.entity.Model;
import com.sna.java.school.phoneshop.service.BrandService;

@Mapper(componentModel = "spring" ,uses = {BrandService.class})
public interface ModelMapper {
	
	ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);
	
	@Mapping(target = "brand", source = "brandId")
	Model toModel(ModelDTO modelDTO);
	
	@Mapping(target = "brandId", source = "brand.id")
	ModelDTO toModelDTO(Model model);



}
