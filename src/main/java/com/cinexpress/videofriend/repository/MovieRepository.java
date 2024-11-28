package com.cinexpress.videofriend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinexpress.videofriend.models.Customer;
import com.cinexpress.videofriend.models.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByGenre(String genre);

    List<Movie> findByAvailability(Boolean availability);

    List<Movie> findByTitleContainingIgnoreCase(String title);

    List<Movie> findByFormat(String format);

    List<Movie> findByLanguage(String language);

    List<Movie> findByPromotion(Long promotionId);

    List<Movie> findByCompanyId(Long companyId);

    List<Movie> findByCustomerId(Customer customerId);
}
