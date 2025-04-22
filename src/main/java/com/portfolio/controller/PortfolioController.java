package com.portfolio.controller;

import com.portfolio.entity.Portfolio;
import com.portfolio.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/portfolios")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    // Endpoint to create or update a portfolio
    @PostMapping
    public ResponseEntity<Portfolio> createOrUpdatePortfolio(@RequestBody Portfolio portfolio) {
        Portfolio savedPortfolio = portfolioService.savePortfolio(portfolio);
        return new ResponseEntity<>(savedPortfolio, HttpStatus.CREATED);
    }

    // Endpoint to get a portfolio by student ID
    @GetMapping("/{studentId}")
    public ResponseEntity<Portfolio> getPortfolio(@PathVariable Long studentId) {
        Portfolio portfolio = portfolioService.getPortfolio(studentId);
        if (portfolio != null) {
            return new ResponseEntity<>(portfolio, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to delete a portfolio by student ID
    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deletePortfolio(@PathVariable Long studentId) {
        portfolioService.deletePortfolio(studentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
