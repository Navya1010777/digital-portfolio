package com.portfolio.entity;

import jakarta.persistence.*;

@Entity
public class Achievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String awardedBy;    // e.g., "Google", "College Name"
    private String dateReceived; // You can also use LocalDate

    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;
    
    

	public Achievement(Long id, String title, String description, String awardedBy, String dateReceived,
			Portfolio portfolio) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.awardedBy = awardedBy;
		this.dateReceived = dateReceived;
		this.portfolio = portfolio;
	}
	
	public Achievement() {
		
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

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}
    
    
}
