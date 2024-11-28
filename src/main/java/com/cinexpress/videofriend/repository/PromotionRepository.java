package com.cinexpress.videofriend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinexpress.videofriend.models.Customer;
import com.cinexpress.videofriend.models.Movie;
import com.cinexpress.videofriend.models.Promotion;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    List<Promotion> findByStartDateBeforeAndEndDateAfter(java.util.Date startDate, java.util.Date endDate);
   
    List<Promotion> findByCustomers(Customer customer);

    List<Promotion> findByMovies(Movie movie);
}
