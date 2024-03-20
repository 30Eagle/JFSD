package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klu.entity.JobPosting;
import com.klu.model.JobPostingManager;

@RestController
@RequestMapping("/jobs")
public class JobPostingController {

	@Autowired
	JobPostingManager M;
	
	@PostMapping("/save")
	public String save(@RequestBody JobPosting J)
	{
		return M.insertData(J);
		
	}
	
	
}
