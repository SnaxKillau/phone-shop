package com.sna.java.school.phoneshop.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SaleDTO {

	@NotEmpty
   private List<ProductSoldDTO> product;
   private LocalDate saleDate;
   

}
