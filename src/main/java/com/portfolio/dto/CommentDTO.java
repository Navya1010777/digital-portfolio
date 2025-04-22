package com.portfolio.dto;

public class CommentDTO {
	 private String content;
	 private StudentDTO author;
	 private ProjectDTO project;
	 
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

	public ProjectDTO getProject() {
		return project;
	}

	public void setProject(ProjectDTO project) {
		this.project = project;
	}
	 
	 

}
