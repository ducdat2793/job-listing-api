package com.example.job_listing_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.job_listing_api.dto.JobRequest;
import com.example.job_listing_api.model.Job;
import com.example.job_listing_api.service.JobService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

	@Autowired
	private JobService jobService;

	@Operation(summary = "Get all jobs")
	@GetMapping
	public ResponseEntity<List<Job>> getAllJobs() {
		List<Job> jobs = jobService.getAllJobs();
		return ResponseEntity.ok(jobs);
	}

	@Operation(summary = "Get job by id")
	@GetMapping("/{id}")
	public Job getJobById(@PathVariable Long id) {
		return jobService.getJobById(id).orElseThrow(() -> new RuntimeException("Job not found"));
	}

	@Operation(summary = "Create job")
	@PostMapping
	public ResponseEntity<Job> createJob(@RequestBody JobRequest jobRequest) {
		Job job = new Job();
		job.setTitle(jobRequest.getTitle());
		job.setType(jobRequest.getType());
		job.setLocation(jobRequest.getLocation());
		job.setSalary(jobRequest.getSalary());
		job.setCompany(jobRequest.getCompany());
		job.setDescription(jobRequest.getDescription());
		Job createdJob = jobService.createJob(job);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdJob);
	}

	@Operation(summary = "Update job by id")
	@PutMapping("/{id}")
	public ResponseEntity<Job> updateJob(@PathVariable Long id, @RequestBody JobRequest jobRequest) {
		try {
			Job job = new Job();
			job.setTitle(jobRequest.getTitle());
			job.setType(jobRequest.getType());
			job.setLocation(jobRequest.getLocation());
			job.setSalary(jobRequest.getSalary());
			job.setCompany(jobRequest.getCompany());
			job.setDescription(jobRequest.getDescription());
			Job result = jobService.updateJob(id, job);
			return ResponseEntity.ok(result);
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@Operation(summary = "Delete job by id")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
		try {
			jobService.deleteJob(id);
			return ResponseEntity.noContent().build(); // 204 No Content
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}

}
