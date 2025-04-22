package com.portfolio.dto;

public class CommentDTO {
	 private Long id;
	 private String content;
	 private StudentDTO author;
	 private Long projectId;
	 
	 public CommentDTO() {
	    	
	 }

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public StudentDTO getAuthor() {
		return author;
	}

	public void setAuthor(StudentDTO author) {
		this.author = author;
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


	 

}
