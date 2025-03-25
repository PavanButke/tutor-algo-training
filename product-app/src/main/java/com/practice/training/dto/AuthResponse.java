package com.practice.training.dto;

public class AuthResponse {

	private String username;
	private String token;
	
	public AuthResponse(String username, String token) {
		super();
		this.username = username;
		this.token = token;
	}

	public AuthResponse() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "AuthResponse [username=" + username + ", token=" + token + "]";
	}
	
	
}
