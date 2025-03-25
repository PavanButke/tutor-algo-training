package com.practice.training.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.practice.training.dto.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = OutOfStockException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND) 
	public @ResponseBody ErrorResponse handleErrorResponse(OutOfStockException ex) {
	    return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}

	@ExceptionHandler(value = ProductExistAlready.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public @ResponseBody ErrorResponse handleErrorResponse(ProductExistAlready ex) { 
	    return new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
	}

}
