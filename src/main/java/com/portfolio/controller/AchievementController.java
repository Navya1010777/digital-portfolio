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

import com.portfolio.entity.Achievement;
import com.portfolio.service.AchievementService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/achievements")
@RequiredArgsConstructor
public class AchievementController {
    
    private final AchievementService achievementService;
    
    @PostMapping
    public ResponseEntity<Achievement> createAchievement(@RequestBody Achievement achievement, 
                                                        @RequestParam Long portfolioId,
                                                        Principal principal) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(achievementService.createAchievement(achievement, portfolioId, principal.getName()));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Achievement> getAchievementById(@PathVariable Long id, Principal principal) {
        return ResponseEntity.ok(achievementService.getAchievementById(id, principal.getName()));
    }
    
    @GetMapping("/portfolio/{portfolioId}")
    public ResponseEntity<List<Achievement>> getAchievementsByPortfolio(@PathVariable Long portfolioId, Principal principal) {
        return ResponseEntity.ok(achievementService.getAchievementsByPortfolio(portfolioId, principal.getName()));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Achievement> updateAchievement(@PathVariable Long id, 
                                                       @RequestBody Achievement achievement, 
                                                       Principal principal) {
        return ResponseEntity.ok(achievementService.updateAchievement(id, achievement, principal.getName()));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAchievement(@PathVariable Long id, Principal principal) {
        achievementService.deleteAchievement(id, principal.getName());
        return ResponseEntity.noContent().build();
    }
}
