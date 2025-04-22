package com.portfolio.controller;

import com.portfolio.entity.Portfolio;
import com.portfolio.service.PortfolioService;

import lombok.RequiredArgsConstructor;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/portfolios")
@RequiredArgsConstructor
public class PortfolioController {
    
    private final PortfolioService portfolioService;
    
    @PostMapping
    public ResponseEntity<Portfolio> createPortfolio(@RequestBody Portfolio portfolio, Principal principal) {
        return ResponseEntity.status(HttpStatus.CREATED).body(portfolioService.createPortfolio(portfolio, principal.getName()));
    }
    
    @GetMapping
    public ResponseEntity<List<Portfolio>> getAllPortfolios(Principal principal) {
        return ResponseEntity.ok(portfolioService.getAllPortfoliosByUser(principal.getName()));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Portfolio> getPortfolioById(@PathVariable Long id, Principal principal) {
        return ResponseEntity.ok(portfolioService.getPortfolioById(id, principal.getName()));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Portfolio> updatePortfolio(@PathVariable Long id, @RequestBody Portfolio portfolio, Principal principal) {
        return ResponseEntity.ok(portfolioService.updatePortfolio(id, portfolio, principal.getName()));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePortfolio(@PathVariable Long id, Principal principal) {
        portfolioService.deletePortfolio(id, principal.getName());
        return ResponseEntity.noContent().build();
    }
}
