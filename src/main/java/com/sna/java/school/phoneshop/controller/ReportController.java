package com.sna.java.school.phoneshop.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sna.java.school.phoneshop.dto.ProductReportDTO;
import com.sna.java.school.phoneshop.entity.SaleDetail;
import com.sna.java.school.phoneshop.service.ReportService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("reports")
public class ReportController {

	private final ReportService reportService;

	
	@GetMapping("v2/{startDate}/{endDate}")
	public ResponseEntity<?> productSoldV2(@DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable("startDate") LocalDate startDate, 
			@DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable("endDate") LocalDate endDate) {
		 List<ProductReportDTO> report = reportService.report(startDate, endDate);
		return ResponseEntity.ok(report);
	}
	
	
}