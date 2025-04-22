package com.portfolio.entity;

import java.util.List;

import jakarta.persistence.*;


@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String techStack;     // e.g., React, Java, etc.
    private String githubLink;    // Optional: link to source code
    private String demoLink;      // Optional: link to live demo

    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;
    
    @OneToMany(mappedBy = "project")
    private List<Comment> comments;
    
    @OneToMany(mappedBy = "project")
    private List<Feedback> feedbacks;
    

	public Project(Long id, String title, String description, String techStack, String githubLink, String demoLink,
			Portfolio portfolio) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.techStack = techStack;
		this.githubLink = githubLink;
		this.demoLink = demoLink;
		this.portfolio = portfolio;
	}
	
	public Project() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTechStack() {
		return techStack;
	}

	public void setTechStack(String techStack) {
		this.techStack = techStack;
	}

	public String getGithubLink() {
		return githubLink;
	}

	public void setGithubLink(String githubLink) {
		this.githubLink = githubLink;
	}

	public String getDemoLink() {
		return demoLink;
	}

	public void setDemoLink(String demoLink) {
		this.demoLink = demoLink;
	}

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}
    
    
}
