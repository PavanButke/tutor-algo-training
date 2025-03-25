package com.practice.training.exceptions;

public class ProductExistAlready extends RuntimeException{
	
	private String msg;

	
	
	public ProductExistAlready() {
		super();
	}


	public ProductExistAlready(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	
	
	

}
