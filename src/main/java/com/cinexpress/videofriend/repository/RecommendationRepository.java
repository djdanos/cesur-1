package com.cinexpress.videofriend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinexpress.videofriend.models.Recommendation;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
}
