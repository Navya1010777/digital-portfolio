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

import com.portfolio.dto.FeedbackDTO;
import com.portfolio.entity.Feedback;
import com.portfolio.mapper.Mapper;
import com.portfolio.service.FeedbackService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/feedback")
@RequiredArgsConstructor
public class FeedbackController {
    
    private final FeedbackService feedbackService;
    private final Mapper mapper;
    
    @PostMapping
    public ResponseEntity<FeedbackDTO> createFeedback(@RequestBody FeedbackDTO feedbackDTO, 
                                                  @RequestParam Long portfolioId,
                                                  Principal principal) {
        Feedback feedback = new Feedback();
        feedback.setComment(feedbackDTO.getComment());
        
        Feedback savedFeedback = feedbackService.createFeedback(feedback, portfolioId, principal.getName());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.toFeedbackDTO(savedFeedback));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<FeedbackDTO> getFeedbackById(@PathVariable Long id, Principal principal) {
        Feedback feedback = feedbackService.getFeedbackById(id, principal.getName());
        return ResponseEntity.ok(mapper.toFeedbackDTO(feedback));
    }
    
    @GetMapping("/portfolio/{portfolioId}")
    public ResponseEntity<List<FeedbackDTO>> getFeedbackByPortfolio(@PathVariable Long portfolioId, Principal principal) {
        List<Feedback> feedbacks = feedbackService.getFeedbackByPortfolio(portfolioId, principal.getName());
        return ResponseEntity.ok(mapper.toFeedbackDTOList(feedbacks));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<FeedbackDTO> updateFeedback(@PathVariable Long id, 
                                                 @RequestBody FeedbackDTO feedbackDTO, 
                                                 Principal principal) {
        Feedback feedback = new Feedback();
        feedback.setComment(feedbackDTO.getComment());
        
        Feedback updatedFeedback = feedbackService.updateFeedback(id, feedback, principal.getName());
        return ResponseEntity.ok(mapper.toFeedbackDTO(updatedFeedback));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Long id, Principal principal) {
        feedbackService.deleteFeedback(id, principal.getName());
        return ResponseEntity.noContent().build();
    }
}