package com.sna.java.school.phoneshop.exception;

import org.springframework.http.HttpStatus;


public class ResourceNotFoundException extends ApiException {

	public ResourceNotFoundException(Long id ,String resourceName ) {
		super(HttpStatus.NOT_FOUND, String.format("%s with this %d isn't found", resourceName, id));
		
	}



}
