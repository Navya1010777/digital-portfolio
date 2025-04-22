package com.portfolio.dto;

public class FeedbackDTO {
	private String comment;      // Feedback from teacher
    private Integer rating;
    private TeacherDTO teacher; 
    private ProjectDTO project; 
    
    public FeedbackDTO() {
    	
    }

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public TeacherDTO getTeacher() {
		return teacher;
	}

	public void setTeacher(TeacherDTO teacher) {
		this.teacher = teacher;
	}

	public ProjectDTO getProject() {
		return project;
	}

	public void setProject(ProjectDTO project) {
		this.project = project;
	}

	
    
    
}
