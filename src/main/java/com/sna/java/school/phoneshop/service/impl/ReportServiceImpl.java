package com.sna.java.school.phoneshop.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sna.java.school.phoneshop.dto.ProductReportDTO;
import com.sna.java.school.phoneshop.entity.Product;
import com.sna.java.school.phoneshop.entity.SaleDetail;
import com.sna.java.school.phoneshop.repository.ProductRepository;
import com.sna.java.school.phoneshop.repository.SaleDetailRepository;
import com.sna.java.school.phoneshop.service.ReportService;
import com.sna.java.school.phoneshop.spec.SaleDetailFIlter;
import com.sna.java.school.phoneshop.spec.SaleDetailSpec;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReportServiceImpl implements ReportService {
	
	private final SaleDetailRepository saleDetailRepository;
	private final ProductRepository productRepository;

	@Override
	public List<ProductReportDTO> report(LocalDate startDate, LocalDate endDate) {
		
		List<ProductReportDTO> list = new ArrayList<>();
		 
		SaleDetailFIlter saleDetailFIlter = new SaleDetailFIlter();
		saleDetailFIlter.setStartDate(startDate);
		System.out.print(startDate);
		saleDetailFIlter.setEndDate(endDate);
		System.out.print(endDate);
		SaleDetailSpec saleDetailSpec = new SaleDetailSpec(saleDetailFIlter);
		List<SaleDetail> saleDetails = saleDetailRepository.findAll(saleDetailSpec);
		
		List<Long> productId = saleDetails.stream()
		.map(t -> t.getProduct().getId())
		.toList();
		
		Map<Long, Product> productMap = productRepository.findAllById(productId).stream()
		.collect(Collectors.toMap(Product::getId, Function.identity()));
		
		Map<Product, List<SaleDetail>> saleDetailsMap = saleDetails.stream()
		.collect(Collectors.groupingBy(SaleDetail::getProduct));
		
		for(var entry: saleDetailsMap.entrySet()) {
			Product product = productMap.get(entry.getKey().getId());
			
			List<SaleDetail> sdList = entry.getValue();
			 Integer unit = sdList.stream().map(SaleDetail::getUnit).reduce(0,(t, u) -> t+u);
			
			double totalAmount = sdList.stream().mapToDouble(s -> s.getUnit() * s.getAmount().doubleValue()).sum();
			
			
			ProductReportDTO productReportDTO = new ProductReportDTO();
			productReportDTO.setProductName(product.getName());
			productReportDTO.setTotalAmount(BigDecimal.valueOf(totalAmount));
			productReportDTO.setUnit(unit);
			list.add(productReportDTO);
		}
		
		return list ;
	}
	

	



}
