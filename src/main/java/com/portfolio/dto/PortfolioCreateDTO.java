package com.portfolio.dto;

import java.util.List;

public class PortfolioCreateDTO {
	private Long id;
	private StudentDTO student;
	private List<ProjectDTO> projects;
	private List<AchievementDTO> achievements;
	
	public PortfolioCreateDTO() {
		
	}

	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public StudentDTO getStudent() {
		return student;
	}


	public void setStudent(StudentDTO student) {
		this.student = student;
	}


	public List<ProjectDTO> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectDTO> projects) {
		this.projects = projects;
	}

	public List<AchievementDTO> getAchievements() {
		return achievements;
	}

	public void setAchievements(List<AchievementDTO> achievements) {
		this.achievements = achievements;
	}
	
	
}
