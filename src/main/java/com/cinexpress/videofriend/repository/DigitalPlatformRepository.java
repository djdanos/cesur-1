package com.cinexpress.videofriend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinexpress.videofriend.models.DigitalPlatform;
import com.cinexpress.videofriend.models.Movie;

@Repository
public interface DigitalPlatformRepository extends JpaRepository<DigitalPlatform, Long> {
    List<Movie> findByCompany(Object object);
}
