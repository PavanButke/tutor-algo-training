package com.practice.training.dto;

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

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "ErrorResponse [statusCode=" + statusCode + ", msg=" + msg + "]";
	}
	
	
	
}
