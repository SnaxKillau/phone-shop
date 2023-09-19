package com.sna.java.school.phoneshop.service.impl;


import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sna.java.school.phoneshop.dto.ProductImportDTO;
import com.sna.java.school.phoneshop.entity.Product;
import com.sna.java.school.phoneshop.entity.ProductImportHistory;
import com.sna.java.school.phoneshop.exception.ApiException;
import com.sna.java.school.phoneshop.exception.ResourceNotFoundException;
import com.sna.java.school.phoneshop.mapper.ProductHistoryMapper;
import com.sna.java.school.phoneshop.repository.ProductImportHistoryRepository;
import com.sna.java.school.phoneshop.repository.ProductRepository;
import com.sna.java.school.phoneshop.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	private final ProductImportHistoryRepository productImportHistoryRepository;

	@Override
	public Product create(Product product) {
		product.setName(String.format("%s" + "%s", product.getModel().getName(), product.getColor().getName()));
		return productRepository.save(product);
	}

	@Override
	public Product getByID(Long id) {

		return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id, "products"));
	}

	@Override
	public void importProduct(ProductImportDTO importDTO) {
		Product product = getByID(importDTO.getProductId());
		Integer available_unit = 0;
		if (product.getAvailableUnit() != null) {
			available_unit = product.getAvailableUnit();
		}
		product.setAvailableUnit(available_unit + importDTO.getImportUnit());
		productRepository.save(product);

		ProductImportHistory productImportHistory = ProductHistoryMapper.INSTANCE.toProductImportHistory(importDTO,
				product);
		productImportHistoryRepository.save(productImportHistory);

	}

	@Override
	public Map<Integer, String> uploadProduct(MultipartFile file) {
		     Map<Integer, String> map = new HashMap<>();
			try {
				Workbook workbook = new XSSFWorkbook(file.getInputStream());
				
				// what sheet in excel file you want to access
			    Sheet sheet = workbook.getSheet("products");
			    
			    Iterator<Row> iteratorRow = sheet.iterator();
			    
			    iteratorRow.next();
			    
			    if(iteratorRow.hasNext()) {
			    	Integer rowInteger = 0;
			    	
			    	try {
			    		Row row = iteratorRow.next();
			    		Integer colInteger = 0;
			    		
			    		rowInteger = (int)row.getCell(colInteger++).getNumericCellValue();
			    		
			    		Cell modelCell = row.getCell(colInteger++);
			    		Long modelId = (long)modelCell.getNumericCellValue();
			    		String format = String.format("%o  = %o", rowInteger , modelId);
			    		
			    		map.put(1, format );
			    	}
			    	catch (Exception e) {
						
					}
			    }
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		
		
		return map;
	}

}
