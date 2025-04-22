package com.portfolio.dto;

import java.util.List;



public class ProjectDTO {
	private Long id;
	private String title;
    private String description;
    private String techStack;     // e.g., React, Java, etc.
    private String githubLink;    // Optional: link to source code
    private String demoLink;
    private Long portfolioId;
    private List<CommentDTO> comments;
    private List<FeedbackDTO> feedbacks;
    
    public ProjectDTO() {
		
	}
    
    

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getPortfolioId() {
		return portfolioId;
	}



	public void setPortfolioId(Long portfolioId) {
		this.portfolioId = portfolioId;
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

	
	public List<CommentDTO> getComments() {
		return comments;
	}

	public void setComments(List<CommentDTO> comments) {
		this.comments = comments;
	}

	public List<FeedbackDTO> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<FeedbackDTO> feedbacks) {
		this.feedbacks = feedbacks;
	}
    
    
}
