package com.portfolio.repository;

import com.portfolio.entity.Achievement;
import com.portfolio.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AchievementRepository extends JpaRepository<Achievement, Long> {
    List<Achievement> findByPortfolio(Portfolio portfolio);
    List<Achievement> findByPortfolioId(Long portfolioId);
    List<Achievement> findByPortfolioOrderByDateAchievedDesc(Portfolio portfolio);
}
