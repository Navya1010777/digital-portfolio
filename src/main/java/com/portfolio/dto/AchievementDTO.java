package com.portfolio.dto;

public class AchievementDTO {
	private String title;
    private String description;
    private String awardedBy;    // e.g., "Google", "College Name"
    private String dateReceived;
    private PortfolioCreateDTO portfolio;
    
    public AchievementDTO()  {
    	
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
	public PortfolioCreateDTO getPortfolio() {
		return portfolio;
	}
	public void setPortfolio(PortfolioCreateDTO portfolio) {
		this.portfolio = portfolio;
	}
    
    
}
