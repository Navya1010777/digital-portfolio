package com.portfolio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.portfolio.entity.Achievement;
import com.portfolio.entity.Portfolio;
import com.portfolio.entity.Role;
import com.portfolio.entity.User;
import com.portfolio.exception.ResourceNotFoundException;
import com.portfolio.exception.UnauthorizedException;
import com.portfolio.repository.AchievementRepository;
import com.portfolio.repository.PortfolioRepository;
import com.portfolio.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AchievementService {
    
    private final AchievementRepository achievementRepository;
    private final PortfolioRepository portfolioRepository;
    private final UserRepository userRepository;
    
    public Achievement createAchievement(Achievement achievement, Long portfolioId, String username) {
        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));
        
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        
        // Only the portfolio owner can add achievements
        if (!portfolio.getStudent().getId().equals(user.getId())) {
            throw new UnauthorizedException("You can only add achievements to your own portfolios");
        }
        
        achievement.setPortfolio(portfolio);
        return achievementRepository.save(achievement);
    }
    
    public Achievement getAchievementById(Long id, String username) {
        Achievement achievement = achievementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Achievement not found"));
        
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        
        // Students can only access their own achievements
        if (user.getRole() == Role.STUDENT && !achievement.getPortfolio().getStudent().getId().equals(user.getId())) {
            throw new UnauthorizedException("You can only access achievements from your own portfolios");
        }
        
        return achievement;
    }
    
    public List<Achievement> getAchievementsByPortfolio(Long portfolioId, String username) {
        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));
        
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        
        // Students can only access their own portfolio achievements
        if (user.getRole() == Role.STUDENT && !portfolio.getStudent().getId().equals(user.getId())) {
            throw new UnauthorizedException("You can only access achievements from your own portfolios");
        }
        
        return achievementRepository.findByPortfolioId(portfolioId);
    }
    
    public Achievement updateAchievement(Long id, Achievement achievementDetails, String username) {
        Achievement achievement = getAchievementById(id, username);
        
        // Only the portfolio owner can update achievements
        if (!achievement.getPortfolio().getStudent().getUsername().equals(username)) {
            throw new UnauthorizedException("You can only update achievements from your own portfolios");
        }
        
        achievement.setTitle(achievementDetails.getTitle());
        achievement.setDescription(achievementDetails.getDescription());
        achievement.setDateAchieved(achievementDetails.getDateAchieved());
        
        return achievementRepository.save(achievement);
    }
    
    public void deleteAchievement(Long id, String username) {
        Achievement achievement = getAchievementById(id, username);
        
        // Only the portfolio owner can delete achievements
        if (!achievement.getPortfolio().getStudent().getUsername().equals(username)) {
            throw new UnauthorizedException("You can only delete achievements from your own portfolios");
        }
        
        achievementRepository.delete(achievement);
    }
}
