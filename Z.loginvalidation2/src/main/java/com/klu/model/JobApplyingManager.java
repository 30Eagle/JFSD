package com.klu.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.klu.entity.JobPosting;
import com.klu.repositry.JobPostingRepository;


@Service

public class JobApplyingManager {

    @Autowired
    JobPostingRepository jobPostingRepository;

    public String insertData(JobPosting jobPosting) {
        jobPostingRepository.save(jobPosting);
        return "Data inserted successfully";
    }

    public List<JobPosting> getAllJobPostings() {
        return jobPostingRepository.findAll();
    }
}
