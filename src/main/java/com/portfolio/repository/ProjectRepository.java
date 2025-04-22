package com.portfolio.repository;

import com.portfolio.entity.Project;
import com.portfolio.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByPortfolio(Portfolio portfolio);
    List<Project> findByPortfolioId(Long portfolioId);
    List<Project> findByPortfolioOrderByCreatedAtDesc(Portfolio portfolio);
}
