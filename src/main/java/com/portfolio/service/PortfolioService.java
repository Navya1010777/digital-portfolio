package com.portfolio.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.portfolio.entity.Portfolio;
import com.portfolio.entity.Role;
import com.portfolio.entity.User;
import com.portfolio.exception.ResourceNotFoundException;
import com.portfolio.exception.UnauthorizedException;
import com.portfolio.repository.PortfolioRepository;
import com.portfolio.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PortfolioService {
    
    private final PortfolioRepository portfolioRepository;
    private final UserRepository userRepository;
    
    public Portfolio createPortfolio(Portfolio portfolio, String username) {
        User student = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        
        if (student.getRole() != Role.STUDENT) {
            throw new UnauthorizedException("Only students can create portfolios");
        }
        
        portfolio.setStudent(student);
        portfolio.setCreatedAt(LocalDateTime.now());
        return portfolioRepository.save(portfolio);
    }
    
    public List<Portfolio> getAllPortfoliosByUser(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        
        if (user.getRole() == Role.STUDENT) {
            return portfolioRepository.findByStudent(user);
        } else {
            // Teachers can see all portfolios
            return portfolioRepository.findAll();
        }
    }
    
    public Portfolio getPortfolioById(Long id, String username) {
        Portfolio portfolio = portfolioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));
        
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        
        // Students can only access their own portfolios
        if (user.getRole() == Role.STUDENT && !portfolio.getStudent().getId().equals(user.getId())) {
            throw new UnauthorizedException("You can only access your own portfolios");
        }
        
        return portfolio;
    }
    
    public Portfolio updatePortfolio(Long id, Portfolio portfolioDetails, String username) {
        Portfolio portfolio = getPortfolioById(id, username);
        
        // Only the owner can update the portfolio
        if (!portfolio.getStudent().getUsername().equals(username)) {
            throw new UnauthorizedException("You can only update your own portfolios");
        }
        
        portfolio.setTitle(portfolioDetails.getTitle());
        portfolio.setDescription(portfolioDetails.getDescription());
        
        return portfolioRepository.save(portfolio);
    }
    
    public void deletePortfolio(Long id, String username) {
        Portfolio portfolio = getPortfolioById(id, username);
        
        // Only the owner can delete the portfolio
        if (!portfolio.getStudent().getUsername().equals(username)) {
            throw new UnauthorizedException("You can only delete your own portfolios");
        }
        
        portfolioRepository.delete(portfolio);
    }
}
