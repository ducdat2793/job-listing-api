package com.example.job_listing_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.job_listing_api.model.Job;
import com.example.job_listing_api.repository.JobRepository;

@Service
public class JobService {

	@Autowired
	private JobRepository jobRepository;

	public List<Job> getAllJobs() {
		return jobRepository.findAll();
	}

	public Optional<Job> getJobById(Long id) {
		return jobRepository.findById(id);
	}

	public Job createJob(Job job) {
		return jobRepository.save(job);
	}

	public Job updateJob(Long id, Job updatedJob) {
		return jobRepository.findById(id).map(job -> {
			job.setTitle(updatedJob.getTitle());
			job.setDescription(updatedJob.getDescription());
			job.setCompany(updatedJob.getCompany());
			job.setLocation(updatedJob.getLocation());
			job.setSalary(updatedJob.getSalary());
			job.setType(updatedJob.getType());
			return jobRepository.save(job);
		}).orElseThrow(() -> new RuntimeException("Job not found with id " + id));
	}

	public void deleteJob(Long id) {
		jobRepository.deleteById(id);
	}

}
