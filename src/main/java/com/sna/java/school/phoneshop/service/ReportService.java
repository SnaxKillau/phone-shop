package com.sna.java.school.phoneshop.service;

import java.time.LocalDate;
import java.util.List;

import com.sna.java.school.phoneshop.dto.ProductReportDTO;
import com.sna.java.school.phoneshop.entity.SaleDetail;

public interface ReportService {

	List<ProductReportDTO> report(LocalDate startDate , LocalDate endDate);
}
