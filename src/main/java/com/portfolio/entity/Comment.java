package com.portfolio.entity;

import jakarta.persistence.*;

@Entity
public class Comment {
    @Id @GeneratedValue
    private Long id;
    private String content;
    
    @ManyToOne
    private Student author;
    
    @ManyToOne
    private Project project;

	public Comment(Long id, String content, Student author, Project project) {
		super();
		this.id = id;
		this.content = content;
		this.author = author;
		this.project = project;
	}
    
    public Comment() {
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Student getAuthor() {
		return author;
	}

	public void setAuthor(Student author) {
		this.author = author;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
    
    
 }