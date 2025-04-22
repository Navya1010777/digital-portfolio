package com.portfolio.dto;

public class AchievementDTO {
	private Long id;
	private String title;
    private String description;
    private String awardedBy;    // e.g., "Google", "College Name"
    private String dateReceived;
    private Long portfolioId;
    
    public AchievementDTO()  {
    	
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
	public String getAwardedBy() {
		return awardedBy;
	}
	public void setAwardedBy(String awardedBy) {
		this.awardedBy = awardedBy;
	}
	public String getDateReceived() {
		return dateReceived;
	}
	public void setDateReceived(String dateReceived) {
		this.dateReceived = dateReceived;
	}
    
    
}
