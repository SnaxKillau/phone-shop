package com.sna.java.school.phoneshop.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
	
	
	@ExceptionHandler(value = ApiException.class)
	public ResponseEntity<?>handleApiException(ApiException e){
		ErorrRespone erorrRespone = new ErorrRespone(e.getStatus(), e.getMessage());
		return ResponseEntity.status(e.getStatus())
				.body(erorrRespone);
	}
	@ExceptionHandler(value = MethodArgumentNotValidException.class)

	public ResponseEntity<?>handleApiException(MethodArgumentNotValidException e){
		
		String message = e.getFieldError().getDefaultMessage();
		
		return ResponseEntity.status(400).body(message);
				
	}
	

}
