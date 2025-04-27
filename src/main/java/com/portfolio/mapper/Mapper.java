package com.portfolio.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.portfolio.dto.AchievementDTO;
import com.portfolio.dto.FeedbackDTO;
import com.portfolio.dto.PortfolioDTO;
import com.portfolio.dto.ProjectDTO;
import com.portfolio.entity.Achievement;
import com.portfolio.entity.Feedback;
import com.portfolio.entity.Portfolio;
import com.portfolio.entity.Project;

@Component
public class Mapper {
    
    // Achievement mappers
    public AchievementDTO toAchievementDTO(Achievement achievement) {
        return AchievementDTO.builder()
                .id(achievement.getId())
                .title(achievement.getTitle())
                .description(achievement.getDescription())
                .dateAchieved(achievement.getDateAchieved())
                .portfolioId(achievement.getPortfolio().getId())
                .build();
    }
    
    public List<AchievementDTO> toAchievementDTOList(List<Achievement> achievements) {
        return achievements.stream()
                .map(this::toAchievementDTO)
                .collect(Collectors.toList());
    }
    
    // Feedback mappers
    public FeedbackDTO toFeedbackDTO(Feedback feedback) {
        return FeedbackDTO.builder()
                .id(feedback.getId())
                .comment(feedback.getComment())
                .createdAt(feedback.getCreatedAt())
                .portfolioId(feedback.getPortfolio().getId())
                .teacherId(feedback.getTeacher().getId())
                .teacherName(feedback.getTeacher().getFullName())
                .build();
    }
    
    public List<FeedbackDTO> toFeedbackDTOList(List<Feedback> feedbacks) {
        return feedbacks.stream()
                .map(this::toFeedbackDTO)
                .collect(Collectors.toList());
    }
    
    // Portfolio mappers
    public PortfolioDTO toPortfolioDTO(Portfolio portfolio) {
        return PortfolioDTO.builder()
                .id(portfolio.getId())
                .title(portfolio.getTitle())
                .description(portfolio.getDescription())
                .createdAt(portfolio.getCreatedAt())
                .studentId(portfolio.getStudent().getId())
                .studentName(portfolio.getStudent().getFullName())
                .studentUsername(portfolio.getStudent().getUsername())
                .build();
    }
    
    public PortfolioDTO toPortfolioDTOWithDetails(Portfolio portfolio) {
        PortfolioDTO dto = toPortfolioDTO(portfolio);
        if (portfolio.getProjects() != null) {
            dto.setProjects(toProjectDTOList(portfolio.getProjects()));
        }
        if (portfolio.getAchievements() != null) {
            dto.setAchievements(toAchievementDTOList(portfolio.getAchievements()));
        }
        if (portfolio.getFeedbacks() != null) {
            dto.setFeedbacks(toFeedbackDTOList(portfolio.getFeedbacks()));
        }
        return dto;
    }
    
    public List<PortfolioDTO> toPortfolioDTOList(List<Portfolio> portfolios) {
        return portfolios.stream()
                .map(this::toPortfolioDTO)
                .collect(Collectors.toList());
    }
    
    // Project mappers
    public ProjectDTO toProjectDTO(Project project) {
        return ProjectDTO.builder()
                .id(project.getId())
                .title(project.getTitle())
                .description(project.getDescription())
                .imageUrl(project.getImageUrl())
                .projectLink(project.getProjectLink())
                .createdAt(project.getCreatedAt())
                .portfolioId(project.getPortfolio().getId())
                .build();
    }
    
    public List<ProjectDTO> toProjectDTOList(List<Project> projects) {
        return projects.stream()
                .map(this::toProjectDTO)
                .collect(Collectors.toList());
    }
}