package com.practice.training.exceptions;

public class OutOfStockException extends RuntimeException{
	
	public String msg;

	public OutOfStockException() {
		super();
	}

	public OutOfStockException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	

}
