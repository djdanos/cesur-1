package com.cinexpress.videofriend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinexpress.videofriend.models.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findByName(String name);
    List<Company> findByMoviesAvailabilityTrue();
    List<Company> findByPromotionsIsNotNull();
    List<Company> findByPromotionsId(Long promotionId);
}
