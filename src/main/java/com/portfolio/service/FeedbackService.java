package com.portfolio.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.portfolio.entity.Feedback;
import com.portfolio.entity.Portfolio;
import com.portfolio.entity.Role;
import com.portfolio.entity.User;
import com.portfolio.exception.ResourceNotFoundException;
import com.portfolio.exception.UnauthorizedException;
import com.portfolio.repository.FeedbackRepository;
import com.portfolio.repository.PortfolioRepository;
import com.portfolio.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FeedbackService {
    
    private final FeedbackRepository feedbackRepository;
    private final PortfolioRepository portfolioRepository;
    private final UserRepository userRepository;
    
    public Feedback createFeedback(Feedback feedback, Long portfolioId, String username) {
        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));
        
        User teacher = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        
        // Only teachers can provide feedback
        if (teacher.getRole() != Role.TEACHER) {
            throw new UnauthorizedException("Only teachers can provide feedback");
        }
        
        feedback.setPortfolio(portfolio);
        feedback.setTeacher(teacher);
        feedback.setCreatedAt(LocalDateTime.now());
        return feedbackRepository.save(feedback);
    }
    
    public Feedback getFeedbackById(Long id, String username) {
        Feedback feedback = feedbackRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Feedback not found"));
        
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        
        // Teachers can access any feedback they created, students can access feedback on their portfolios
        if (user.getRole() == Role.TEACHER && !feedback.getTeacher().getId().equals(user.getId())) {
            throw new UnauthorizedException("You can only access feedback you provided");
        } else if (user.getRole() == Role.STUDENT && !feedback.getPortfolio().getStudent().getId().equals(user.getId())) {
            throw new UnauthorizedException("You can only access feedback on your portfolios");
        }
        
        return feedback;
    }
    
    public List<Feedback> getFeedbackByPortfolio(Long portfolioId, String username) {
        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio not found"));
        
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        
        // Teachers can see all feedback, students can see feedback on their portfolios
        if (user.getRole() == Role.STUDENT && !portfolio.getStudent().getId().equals(user.getId())) {
            throw new UnauthorizedException("You can only access feedback on your portfolios");
        }
        
        return feedbackRepository.findByPortfolioId(portfolioId);
    }
    
    public Feedback updateFeedback(Long id, Feedback feedbackDetails, String username) {
        Feedback feedback = feedbackRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Feedback not found"));
        
        // Only the teacher who created the feedback can update it
        if (!feedback.getTeacher().getUsername().equals(username)) {
            throw new UnauthorizedException("You can only update your own feedback");
        }
        
        feedback.setComment(feedbackDetails.getComment());
        
        return feedbackRepository.save(feedback);
    }
    
    public void deleteFeedback(Long id, String username) {
        Feedback feedback = feedbackRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Feedback not found"));
        
        // Only the teacher who created the feedback can delete it
        if (!feedback.getTeacher().getUsername().equals(username)) {
            throw new UnauthorizedException("You can only delete your own feedback");
        }
        
        feedbackRepository.delete(feedback);
    }
}
