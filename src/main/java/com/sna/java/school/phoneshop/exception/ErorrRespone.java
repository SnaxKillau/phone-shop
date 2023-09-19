package com.sna.java.school.phoneshop.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ErorrRespone {

	private HttpStatus status;
	private String message;

}
