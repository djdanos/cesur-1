package com.cinexpress.videofriend.services;

import java.util.List;

import com.cinexpress.videofriend.models.Movie;

public interface MovieService {
    Movie addMovie(Movie movie);
    Movie updateMovie(Long movieId, Movie movie);
    void updateAvailability(Movie movie);
    List<Movie> findMoviesByGenre(String genre);
    List<Movie> findAvailableMovies();
    boolean deleteMovie(Long movieId);
    Movie findMovieById(Long movieId);
    List<Movie> findByPromotion(Long promotionId);
    List<Movie> findByCompany(Long companyId);
    List<Movie> findMoviesByTitle(String title);
}
