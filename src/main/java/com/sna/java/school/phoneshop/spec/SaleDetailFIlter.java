package com.sna.java.school.phoneshop.spec;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SaleDetailFIlter {

	private LocalDate startDate;
	private LocalDate endDate;

}
