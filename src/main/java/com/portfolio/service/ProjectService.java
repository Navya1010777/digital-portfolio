package com.portfolio.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.portfolio.entity.Portfolio;
import com.portfolio.entity.Project;
import com.portfolio.entity.Role;
import com.portfolio.entity.User;
import com.portfolio.exception.ResourceNotFoundException;
import com.portfolio.exception.UnauthorizedException;
import com.portfolio.repository.PortfolioRepository;
import com.portfolio.repository.ProjectRepository;
import com.portfolio.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectService {
    
    private final ProjectRepository projectRepository;
    private final PortfolioRepository portfolioRepository;
    private final UserRepository userRepository;
    
    public Project createProject(Project project, Long portfolioId, String username) {
        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));
        
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        
        // Only the portfolio owner can add projects
        if (!portfolio.getStudent().getId().equals(user.getId())) {
            throw new UnauthorizedException("You can only add projects to your own portfolios");
        }
        
        project.setPortfolio(portfolio);
        project.setCreatedAt(LocalDateTime.now());
        return projectRepository.save(project);
    }
    
    public Project getProjectById(Long id, String username) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found"));
        
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        
        // Students can only access their own projects
        if (user.getRole() == Role.STUDENT && !project.getPortfolio().getStudent().getId().equals(user.getId())) {
            throw new UnauthorizedException("You can only access projects from your own portfolios");
        }
        
        return project;
    }
    
    public List<Project> getProjectsByPortfolio(Long portfolioId, String username) {
        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));
        
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        
        // Students can only access their own portfolio projects
        if (user.getRole() == Role.STUDENT && !portfolio.getStudent().getId().equals(user.getId())) {
            throw new UnauthorizedException("You can only access projects from your own portfolios");
        }
        
        return projectRepository.findByPortfolioId(portfolioId);
    }
    
    public Project updateProject(Long id, Project projectDetails, String username) {
        Project project = getProjectById(id, username);
        
        // Only the portfolio owner can update projects
        if (!project.getPortfolio().getStudent().getUsername().equals(username)) {
            throw new UnauthorizedException("You can only update projects from your own portfolios");
        }
        
        project.setTitle(projectDetails.getTitle());
        project.setDescription(projectDetails.getDescription());
        project.setImageUrl(projectDetails.getImageUrl());
        project.setProjectLink(projectDetails.getProjectLink());
        
        return projectRepository.save(project);
    }
    
    public void deleteProject(Long id, String username) {
        Project project = getProjectById(id, username);
        
        // Only the portfolio owner can delete projects
        if (!project.getPortfolio().getStudent().getUsername().equals(username)) {
            throw new UnauthorizedException("You can only delete projects from your own portfolios");
        }
        
        projectRepository.delete(project);
    }
}
