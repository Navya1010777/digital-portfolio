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

import com.portfolio.entity.Feedback;
import com.portfolio.service.FeedbackService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/feedback")
@RequiredArgsConstructor
public class FeedbackController {
    
    private final FeedbackService feedbackService;
    
    @PostMapping
    public ResponseEntity<Feedback> createFeedback(@RequestBody Feedback feedback, 
                                                  @RequestParam Long portfolioId,
                                                  Principal principal) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(feedbackService.createFeedback(feedback, portfolioId, principal.getName()));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable Long id, Principal principal) {
        return ResponseEntity.ok(feedbackService.getFeedbackById(id, principal.getName()));
    }
    
    @GetMapping("/portfolio/{portfolioId}")
    public ResponseEntity<List<Feedback>> getFeedbackByPortfolio(@PathVariable Long portfolioId, Principal principal) {
        return ResponseEntity.ok(feedbackService.getFeedbackByPortfolio(portfolioId, principal.getName()));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Feedback> updateFeedback(@PathVariable Long id, 
                                                 @RequestBody Feedback feedback, 
                                                 Principal principal) {
        return ResponseEntity.ok(feedbackService.updateFeedback(id, feedback, principal.getName()));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Long id, Principal principal) {
        feedbackService.deleteFeedback(id, principal.getName());
        return ResponseEntity.noContent().build();
    }
}
