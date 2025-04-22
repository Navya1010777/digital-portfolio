package com.portfolio.repository;

import com.portfolio.entity.Feedback;
import com.portfolio.entity.Portfolio;
import com.portfolio.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findByPortfolio(Portfolio portfolio);
    List<Feedback> findByTeacher(User teacher);
    List<Feedback> findByPortfolioOrderByCreatedAtDesc(Portfolio portfolio);
    boolean existsByPortfolioAndTeacher(Portfolio portfolio, User teacher);
    List<Feedback> findByPortfolioId(Long portfolioId);
    List<Feedback> findByTeacherId(Long teacherId);
    List<Feedback> findByPortfolioIdAndTeacherId(Long portfolioId, Long teacherId);
}
