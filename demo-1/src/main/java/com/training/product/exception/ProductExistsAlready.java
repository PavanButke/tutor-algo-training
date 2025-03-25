package com.training.product.exception;

public class ProductExistsAlready extends RuntimeException{
	
	private String msg;

	
	
	public ProductExistsAlready() {
		super();
	}



	public ProductExistsAlready(String msg) {
		super(msg);
	
	}
	
	

}
