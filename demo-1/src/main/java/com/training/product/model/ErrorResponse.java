package com.training.product.model;

public class ErrorResponse {
	
	private int statusCode;
	private String msg;
	
	
	
	public ErrorResponse() {
		super();
	}



	public ErrorResponse(int statusCode, String msg) {
		super();
		this.statusCode = statusCode;
		this.msg = msg;
	}
	
	

}
