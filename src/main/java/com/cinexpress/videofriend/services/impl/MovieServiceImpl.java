package com.cinexpress.videofriend.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinexpress.videofriend.models.Movie;
import com.cinexpress.videofriend.repository.MovieRepository;
import com.cinexpress.videofriend.services.MovieService;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(Long movieId, Movie movie) {
        Optional<Movie> existingMovie = movieRepository.findById(movie.getId());
        if (existingMovie.isPresent()) {
            Movie updatedMovie = existingMovie.get();

            updatedMovie.setTitle(movie.getTitle());
            updatedMovie.setFormat(movie.getFormat());
            updatedMovie.setGenre(movie.getGenre());
            updatedMovie.setLanguage(movie.getLanguage());
            updatedMovie.setAvailability(movie.getAvailability());

            return movieRepository.save(updatedMovie);
        }
        return null;
    }

    @Override
    public void updateAvailability(Movie movie) {
        Optional<Movie> existingMovie = movieRepository.findById(movie.getId());
        if (existingMovie.isPresent()) {
            Movie updatedMovie = existingMovie.get();
            updatedMovie.setAvailability(movie.getAvailability());
            movieRepository.save(updatedMovie);
        }
    }

    @Override
    public List<Movie> findMoviesByGenre(String genre) {
        return movieRepository.findByGenre(genre);
    }

    @Override
    public List<Movie> findAvailableMovies() {
        return movieRepository.findByAvailability(true); 
    }

    @Override
    public boolean deleteMovie(Long movieId) {
        Optional<Movie> movie = movieRepository.findById(movieId);
        if (movie.isPresent()) {
            movieRepository.delete(movie.get());
            return true;
        }
        return false; 
    }

    @Override
    public Movie findMovieById(Long movieId) {
        Optional<Movie> movie = movieRepository.findById(movieId);
        return movie.orElse(null); 
    }

    @Override
    public List<Movie> findByPromotion(Long promotionId) {
        return movieRepository.findByPromotion(promotionId);
    }

    @Override
    public List<Movie> findByCompany(Long companyId) {
        return movieRepository.findByCompanyId(companyId);
    }

    @Override
    public List<Movie> findMoviesByTitle(String title) {
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }   
}
