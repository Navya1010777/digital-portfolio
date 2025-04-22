package com.portfolio.service;

import com.portfolio.entity.Portfolio;

import com.portfolio.entity.Student;
import com.portfolio.repository.PortfolioRepository;
import com.portfolio.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PortfolioService {


    private final PortfolioRepository portfolioRepository;
    private final StudentRepository studentRepository;
    
    @Autowired
    public PortfolioService(PortfolioRepository portfolioRepository, StudentRepository studentRepository) {
    	this.portfolioRepository = portfolioRepository;
    	this.studentRepository = studentRepository;
    }

    // Create or update portfolio
    public Portfolio savePortfolio(Portfolio portfolio) {
    	 Long studentId = portfolio.getStudent().getId();
         Student student = studentRepository.findById(studentId)
                             .orElseThrow(() -> new RuntimeException("Student not found"));

         portfolio.setStudent(student);  // Set the managed entity
         return portfolioRepository.save(portfolio);
    }

    // Get portfolio by student ID
    public Portfolio getPortfolio(Long studentId) {
        return portfolioRepository.findById(studentId).orElse(null);
    }

    // Delete portfolio
    public void deletePortfolio(Long studentId) {
        portfolioRepository.deleteById(studentId);
    }
}
