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

import com.portfolio.dto.AchievementDTO;
import com.portfolio.entity.Achievement;
import com.portfolio.mapper.Mapper;
import com.portfolio.service.AchievementService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/achievements")
@RequiredArgsConstructor
public class AchievementController {
    
    private final AchievementService achievementService;
    private final Mapper mapper;
    
    @PostMapping
    public ResponseEntity<AchievementDTO> createAchievement(@RequestBody AchievementDTO achievementDTO, 
                                                        @RequestParam Long portfolioId,
                                                        Principal principal) {
        Achievement achievement = new Achievement();
        achievement.setTitle(achievementDTO.getTitle());
        achievement.setDescription(achievementDTO.getDescription());
        achievement.setDateAchieved(achievementDTO.getDateAchieved());
        
        Achievement savedAchievement = achievementService.createAchievement(achievement, portfolioId, principal.getName());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.toAchievementDTO(savedAchievement));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<AchievementDTO> getAchievementById(@PathVariable Long id, Principal principal) {
        Achievement achievement = achievementService.getAchievementById(id, principal.getName());
        return ResponseEntity.ok(mapper.toAchievementDTO(achievement));
    }
    
    @GetMapping("/portfolio/{portfolioId}")
    public ResponseEntity<List<AchievementDTO>> getAchievementsByPortfolio(@PathVariable Long portfolioId, Principal principal) {
        List<Achievement> achievements = achievementService.getAchievementsByPortfolio(portfolioId, principal.getName());
        return ResponseEntity.ok(mapper.toAchievementDTOList(achievements));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<AchievementDTO> updateAchievement(@PathVariable Long id, 
                                                       @RequestBody AchievementDTO achievementDTO, 
                                                       Principal principal) {
        Achievement achievement = new Achievement();
        achievement.setTitle(achievementDTO.getTitle());
        achievement.setDescription(achievementDTO.getDescription());
        achievement.setDateAchieved(achievementDTO.getDateAchieved());
        
        Achievement updatedAchievement = achievementService.updateAchievement(id, achievement, principal.getName());
        return ResponseEntity.ok(mapper.toAchievementDTO(updatedAchievement));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAchievement(@PathVariable Long id, Principal principal) {
        achievementService.deleteAchievement(id, principal.getName());
        return ResponseEntity.noContent().build();
    }
}