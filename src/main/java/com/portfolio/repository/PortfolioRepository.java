package com.portfolio.repository;

import com.portfolio.entity.Portfolio;
import com.portfolio.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    List<Portfolio> findByStudent(User student);
    
    // Find all portfolios (for teachers to browse)
    @Query("SELECT p FROM Portfolio p ORDER BY p.createdAt DESC")
    List<Portfolio> findAllPortfolios();
    
    // Search portfolios by title
    List<Portfolio> findByTitleContainingIgnoreCase(String keyword);
}
