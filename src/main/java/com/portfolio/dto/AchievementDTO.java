package com.portfolio.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AchievementDTO {
    private Long id;
    private String title;
    private String description;
    private LocalDate dateAchieved;
    private Long portfolioId;

    public AchievementDTO() {

    }

    public AchievementDTO(Long id, String title, String description, LocalDate dateAchieved, Long portfolioId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dateAchieved = dateAchieved;
        this.portfolioId = portfolioId;
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
    
    public LocalDate getDateAchieved() {
        return dateAchieved;
    }
    
    public void setDateAchieved(LocalDate dateAchieved) {
        this.dateAchieved = dateAchieved;
    }
    
    public Long getPortfolioId() {
        return portfolioId;
    }
    
    public void setPortfolioId(Long portfolioId) {
        this.portfolioId = portfolioId;
    }
}
