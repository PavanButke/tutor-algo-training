package com.training.product.exception;

public class OutOfStockException extends RuntimeException{

	public String msg;

	public OutOfStockException() {
		super();
	}

	public OutOfStockException(String msg) {
		super(msg);
		
	}

	
}
