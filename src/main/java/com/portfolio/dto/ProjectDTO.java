package com.portfolio.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ProjectDTO {
    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private String projectLink;
    private LocalDateTime createdAt;
    private Long portfolioId;
    
    public ProjectDTO() {
    }

    public ProjectDTO(Long id, String title, String description, String imageUrl, String projectLink,
            LocalDateTime createdAt, Long portfolioId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.projectLink = projectLink;
        this.createdAt = createdAt;
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
    
    public String getImageUrl() {
        return imageUrl;
    }
    
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public String getProjectLink() {
        return projectLink;
    }
    
    public void setProjectLink(String projectLink) {
        this.projectLink = projectLink;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public Long getPortfolioId() {
        return portfolioId;
    }
    
    public void setPortfolioId(Long portfolioId) {
        this.portfolioId = portfolioId;
    }
    
} 
