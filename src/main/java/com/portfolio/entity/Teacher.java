package com.portfolio.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String teacherId;
    private String branch;

    @ElementCollection
    private List<String> subjects;

    @OneToMany(mappedBy = "teacher")
    private List<Feedback> feedbacks;

	public Teacher(Long id, String name, String email, String teacherId, String branch, List<String> subjects,
			List<Feedback> feedbacks) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.teacherId = teacherId;
		this.branch = branch;
		this.subjects = subjects;
		this.feedbacks = feedbacks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}
    
    
}
