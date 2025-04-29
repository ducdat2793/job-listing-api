package com.example.job_listing_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.job_listing_api.model.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long>{

}
