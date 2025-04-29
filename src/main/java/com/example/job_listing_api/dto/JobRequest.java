package com.example.job_listing_api.dto;

import lombok.Data;

@Data
public class JobRequest {

	private String title;
	private String description;
	private String company;
	private String location;
	private Double salary;
	private String type;

}
