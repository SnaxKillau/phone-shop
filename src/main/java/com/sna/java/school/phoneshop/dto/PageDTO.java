package com.sna.java.school.phoneshop.dto;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.Data;

@Data
public class PageDTO {

	private List<?> content;
	private PaginationDTO paginationDTO;
//	private int pageSize;
//	private int pageNumber;
//	private int totalPages;
//	private long totalElements;
//	private long numberOfElements;
//	private boolean first;
//	private boolean last;
//	private boolean empty;
	
	
	
	public PageDTO( Page<?> page) {
		this.content = page.getContent();
		this.paginationDTO = PaginationDTO.builder()
							.empty(page.isEmpty())
							.pageSize(page.getPageable().getPageSize())
							.pageNumber(page.getPageable().getPageNumber())
							.totalPages(page.getTotalPages())
							.totalElements(page.getTotalElements())
							.numberOfElements(page.getNumberOfElements())
							.first(page.isFirst())
							.last(page.isLast())
							.build();
							
		
	}

}
