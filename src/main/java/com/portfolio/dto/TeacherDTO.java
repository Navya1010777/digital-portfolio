package com.portfolio.dto;

import java.util.List;


public class TeacherDTO {
	private String name;
    private String email;
    private String teacherId;
    private String branch;
    private List<String> subjects;
    private List<FeedbackDTO> feedbacks;
    
    public TeacherDTO() {
    	
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public List<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}

	public List<FeedbackDTO> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<FeedbackDTO> feedbacks) {
		this.feedbacks = feedbacks;
	}
    
    
}
