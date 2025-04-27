package com.portfolio.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FeedbackDTO {
    private Long id;
    private String comment;
    private LocalDateTime createdAt;
    private Long portfolioId;
    private Long teacherId;
    private String teacherName;
    
    public FeedbackDTO() {
    }

    public FeedbackDTO(Long id, String comment, LocalDateTime createdAt, Long portfolioId, Long teacherId,
            String teacherName) {
        this.id = id;
        this.comment = comment;
        this.createdAt = createdAt;
        this.portfolioId = portfolioId;
        this.teacherId = teacherId;
        this.teacherName = teacherName;
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getComment() {
        return comment;
    }
    
    public void setComment(String comment) {
        this.comment = comment;
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
    
    public Long getTeacherId() {
        return teacherId;
    }
    
    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }
    
    public String getTeacherName() {
        return teacherName;
    }
    
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
    
}