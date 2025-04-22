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

import com.portfolio.entity.Project;
import com.portfolio.service.ProjectService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {
    
    private final ProjectService projectService;
    
    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project, 
                                                 @RequestParam Long portfolioId,
                                                 Principal principal) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(projectService.createProject(project, portfolioId, principal.getName()));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id, Principal principal) {
        return ResponseEntity.ok(projectService.getProjectById(id, principal.getName()));
    }
    
    @GetMapping("/portfolio/{portfolioId}")
    public ResponseEntity<List<Project>> getProjectsByPortfolio(@PathVariable Long portfolioId, Principal principal) {
        return ResponseEntity.ok(projectService.getProjectsByPortfolio(portfolioId, principal.getName()));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, 
                                                @RequestBody Project project, 
                                                Principal principal) {
        return ResponseEntity.ok(projectService.updateProject(id, project, principal.getName()));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id, Principal principal) {
        projectService.deleteProject(id, principal.getName());
        return ResponseEntity.noContent().build();
    }
}
