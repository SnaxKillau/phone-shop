package com.sna.java.school.phoneshop.service.impl;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sna.java.school.phoneshop.dto.SaleDTO;
import com.sna.java.school.phoneshop.entity.Product;
import com.sna.java.school.phoneshop.entity.Sale;
import com.sna.java.school.phoneshop.entity.SaleDetail;
import com.sna.java.school.phoneshop.exception.ApiException;
import com.sna.java.school.phoneshop.repository.ProductRepository;
import com.sna.java.school.phoneshop.repository.SaleDetailRepository;
import com.sna.java.school.phoneshop.repository.SaleRepository;
import com.sna.java.school.phoneshop.service.ProductService;
import com.sna.java.school.phoneshop.service.SaleService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {
	
	private final ProductService productService;
	private final ProductRepository productRepository;
	private final SaleRepository saleRepository;
	private final SaleDetailRepository saleDetailRepository;
	@Override
	public void sell(SaleDTO dto) {
		List<Long> productsID = dto.getProduct().stream()
				.map(t -> t.getProductId()).collect(Collectors.toList());
		
		productsID.forEach(productService::getByID);
		
		List<Product> products = productRepository.findAllById(productsID);
		
		Map<Long, Product> proMap = products.stream()
				.collect(Collectors.toMap(Product::getId, Function.identity()));
		
		
		dto.getProduct().forEach(t -> {
			Product product = proMap.get(t.getProductId());
			if(t.getNumberOfUnit() > product.getAvailableUnit()) {
				throw new ApiException(HttpStatus.BAD_REQUEST, String.format("Product %s is not enough in stock", product.getName()));
			}
		});
		Sale sale = new Sale();
		sale.setSoldDate(dto.getSaleDate());
	    saleRepository.save(sale);
		
		dto.getProduct().forEach(t -> {
			Product pro = proMap.get(t.getProductId());
			SaleDetail saleDetail = new SaleDetail();
			saleDetail.setAmount(pro.getSalePrice());
			saleDetail.setProduct(pro);
			saleDetail.setSale(sale);
			saleDetail.setUnit(t.getNumberOfUnit());
			saleDetailRepository.save(saleDetail);
			
			Integer availableUnit = pro.getAvailableUnit() - t.getNumberOfUnit();
			pro.setAvailableUnit(availableUnit);
			productRepository.save(pro);
		});
		
		
		
	}
	



	  



}
