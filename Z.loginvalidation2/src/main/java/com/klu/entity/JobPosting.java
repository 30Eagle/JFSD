package com.klu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "jobs")
public class JobPosting {
	
	@Id
	String jobname;
	String joblocation;
	String jobdrecption;
	public String getJobname() {
		return jobname;
	}
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	public String getJoblocation() {
		return joblocation;
	}
	public void setJoblocation(String joblocation) {
		this.joblocation = joblocation;
	}
	public String getJobdrecption() {
		return jobdrecption;
	}
	public void setJobdrecption(String jobdrecption) {
		this.jobdrecption = jobdrecption;
	}
	
	
	

}
