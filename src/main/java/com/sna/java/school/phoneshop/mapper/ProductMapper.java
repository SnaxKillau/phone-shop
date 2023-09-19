package com.sna.java.school.phoneshop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.sna.java.school.phoneshop.dto.ProductDTO;
import com.sna.java.school.phoneshop.entity.Product;
import com.sna.java.school.phoneshop.service.ColorService;
import com.sna.java.school.phoneshop.service.ModelService;


@Mapper(componentModel = "spring" ,uses = {ModelService.class , ColorService.class})
public interface ProductMapper {
	
	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

	@Mapping(target = "model" , source = "modelId")
	@Mapping(target = "color" , source = "colorId")
	Product toProduct(ProductDTO productDTO);
	
	
}
