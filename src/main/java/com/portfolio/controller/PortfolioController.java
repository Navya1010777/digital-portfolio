package com.portfolio.controller;

import com.portfolio.dto.PortfolioDTO;
import com.portfolio.entity.Portfolio;
import com.portfolio.mapper.Mapper;
import com.portfolio.service.PortfolioService;

import lombok.RequiredArgsConstructor;

import java.security.Principal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/portfolios")
@RequiredArgsConstructor
public class PortfolioController {
    
    private final PortfolioService portfolioService;
    private final Mapper mapper;
    
    @PostMapping
    public ResponseEntity<PortfolioDTO> createPortfolio(@RequestBody PortfolioDTO portfolioDTO, Principal principal) {
        Portfolio portfolio = new Portfolio();
        portfolio.setTitle(portfolioDTO.getTitle());
        portfolio.setDescription(portfolioDTO.getDescription());
        
        Portfolio savedPortfolio = portfolioService.createPortfolio(portfolio, principal.getName());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.toPortfolioDTO(savedPortfolio));
    }
    
    @GetMapping
    public ResponseEntity<List<PortfolioDTO>> getAllPortfolios(Principal principal) {
        List<Portfolio> portfolios = portfolioService.getAllPortfoliosByUser(principal.getName());
        return ResponseEntity.ok(mapper.toPortfolioDTOList(portfolios));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PortfolioDTO> getPortfolioById(@PathVariable Long id, Principal principal) {
        Portfolio portfolio = portfolioService.getPortfolioById(id, principal.getName());
        return ResponseEntity.ok(mapper.toPortfolioDTOWithDetails(portfolio));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PortfolioDTO> updatePortfolio(@PathVariable Long id, 
                                                     @RequestBody PortfolioDTO portfolioDTO, 
                                                     Principal principal) {
        Portfolio portfolio = new Portfolio();
        portfolio.setTitle(portfolioDTO.getTitle());
        portfolio.setDescription(portfolioDTO.getDescription());
        
        Portfolio updatedPortfolio = portfolioService.updatePortfolio(id, portfolio, principal.getName());
        return ResponseEntity.ok(mapper.toPortfolioDTO(updatedPortfolio));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePortfolio(@PathVariable Long id, Principal principal) {
        portfolioService.deletePortfolio(id, principal.getName());
        return ResponseEntity.noContent().build();
    }
}