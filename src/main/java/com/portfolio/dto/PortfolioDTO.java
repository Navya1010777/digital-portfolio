package com.portfolio.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PortfolioDTO {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private Long studentId;
    private String studentName;
    private String studentUsername;

    @Builder.Default
    private List<ProjectDTO> projects = new ArrayList<>();
    
    @Builder.Default
    private List<AchievementDTO> achievements = new ArrayList<>();
    
    @Builder.Default
    private List<FeedbackDTO> feedbacks = new ArrayList<>();
    
    public PortfolioDTO() {
    }

    

    public PortfolioDTO(Long id, String title, String description, LocalDateTime createdAt, Long studentId,
            String studentName, String studentUsername, List<ProjectDTO> projects, List<AchievementDTO> achievements,
            List<FeedbackDTO> feedbacks) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentUsername = studentUsername;
        this.projects = projects;
        this.achievements = achievements;
        this.feedbacks = feedbacks;
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
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public Long getStudentId() {
        return studentId;
    }
    
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
    
    public String getStudentName() {
        return studentName;
    }
    
    public void setStudentName(String studentName) {
        this.studentName = studentName;
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
    
    public List<FeedbackDTO> getFeedbacks() {
        return feedbacks;
    }
    
    public void setFeedbacks(List<FeedbackDTO> feedbacks) {
        this.feedbacks = feedbacks;
    }    

    public void setStudentUsername(String studentUsername) {
        this.studentUsername = studentUsername;
    }

    public String getStudentUsername() {
        return studentUsername;
    }
}