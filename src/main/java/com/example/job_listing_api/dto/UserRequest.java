package com.example.job_listing_api.dto;

import lombok.Data;

@Data
public class UserRequest {

	private String username;
	private String password;
	private String role;

}
