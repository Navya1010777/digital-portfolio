package com.portfolio.entity;

import jakarta.persistence.*;


@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;      // Feedback from teacher
    private Integer rating;      // You can give a rating out of 5 or 10, etc.

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;     // The teacher who gave the feedback

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;     // The project the feedback is for

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
    
    
}
