package com.portfolio.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.dto.ProjectDTO;
import com.portfolio.entity.Project;
import com.portfolio.mapper.Mapper;
import com.portfolio.service.ProjectService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {
    
    private final ProjectService projectService;
    private final Mapper mapper;
    
    @PostMapping
    public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO projectDTO, 
                                                 @RequestParam Long portfolioId,
                                                 Principal principal) {
        Project project = new Project();
        project.setTitle(projectDTO.getTitle());
        project.setDescription(projectDTO.getDescription());
        project.setImageUrl(projectDTO.getImageUrl());
        project.setProjectLink(projectDTO.getProjectLink());
        
        Project savedProject = projectService.createProject(project, portfolioId, principal.getName());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.toProjectDTO(savedProject));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable Long id, Principal principal) {
        Project project = projectService.getProjectById(id, principal.getName());
        return ResponseEntity.ok(mapper.toProjectDTO(project));
    }
    
    @GetMapping("/portfolio/{portfolioId}")
    public ResponseEntity<List<ProjectDTO>> getProjectsByPortfolio(@PathVariable Long portfolioId, Principal principal) {
        List<Project> projects = projectService.getProjectsByPortfolio(portfolioId, principal.getName());
        return ResponseEntity.ok(mapper.toProjectDTOList(projects));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ProjectDTO> updateProject(@PathVariable Long id, 
                                                @RequestBody ProjectDTO projectDTO, 
                                                Principal principal) {
        Project project = new Project();
        project.setTitle(projectDTO.getTitle());
        project.setDescription(projectDTO.getDescription());
        project.setImageUrl(projectDTO.getImageUrl());
        project.setProjectLink(projectDTO.getProjectLink());
        
        Project updatedProject = projectService.updateProject(id, project, principal.getName());
        return ResponseEntity.ok(mapper.toProjectDTO(updatedProject));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id, Principal principal) {
        projectService.deleteProject(id, principal.getName());
        return ResponseEntity.noContent().build();
    }
}