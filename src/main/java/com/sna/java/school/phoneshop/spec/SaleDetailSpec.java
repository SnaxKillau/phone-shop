package com.sna.java.school.phoneshop.spec;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.domain.Specification;

import com.sna.java.school.phoneshop.entity.Sale;
import com.sna.java.school.phoneshop.entity.SaleDetail;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SaleDetailSpec implements Specification<SaleDetail> {
	
	private final SaleDetailFIlter saleDetailFIlter;


	@Override
	public Predicate toPredicate(Root<SaleDetail> saleDetail, CriteriaQuery<?> query, CriteriaBuilder cb) {
		
		List<Predicate> predicates = new ArrayList<>();
		Join<SaleDetail, Sale> sale = saleDetail.join("sale");
		
		if(Objects.nonNull(saleDetailFIlter.getStartDate())) {
			Predicate greatPredicate = cb.greaterThanOrEqualTo(sale.get("soldDate"), saleDetailFIlter.getStartDate());
			predicates.add(greatPredicate);
			
		}
		if(Objects.nonNull(saleDetailFIlter.getEndDate())) {
			Predicate lessPredicate = cb.lessThanOrEqualTo(sale.get("soldDate"), saleDetailFIlter.getEndDate());
			predicates.add(lessPredicate);
			
		}
		Predicate predicate = cb.and(predicates.toArray(Predicate[]::new));
		
		return predicate;
	}
	



}
