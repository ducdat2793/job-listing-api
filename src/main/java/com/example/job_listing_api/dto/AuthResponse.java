package com.example.job_listing_api.dto;

public class AuthResponse {

	private String token;

	public AuthResponse(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

}
