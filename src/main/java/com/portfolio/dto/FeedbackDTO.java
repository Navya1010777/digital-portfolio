package com.portfolio.dto;

public class FeedbackDTO {
	private Long id;
	private String comment;      // Feedback from teacher
    private Integer rating;
    private TeacherDTO teacher; 
    private Long projectId; 
    
    public FeedbackDTO() {
    	
    }

    
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getProjectId() {
		return projectId;
	}


	public void setProjectId(Long projectId) {
		this.projectId = projectId;
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

	
    
    
}
