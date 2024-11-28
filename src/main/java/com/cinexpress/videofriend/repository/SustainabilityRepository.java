package com.cinexpress.videofriend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinexpress.videofriend.models.Sustainability;

@Repository
public interface SustainabilityRepository extends JpaRepository<Sustainability, Long> {
}
