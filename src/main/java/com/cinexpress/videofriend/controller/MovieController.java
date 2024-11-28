package com.cinexpress.videofriend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinexpress.videofriend.models.Movie;
import com.cinexpress.videofriend.services.MovieService;

@RestController
@RequestMapping("'/movie'")
public class MovieController {
    @Autowired
    MovieService movieService;

     @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Movie>> getMoviesByGenre(@PathVariable String genre) {
        List<Movie> movies = movieService.findMoviesByGenre(genre);
        return movies.isEmpty() ? 
               new ResponseEntity<>(HttpStatus.NO_CONTENT) : 
               new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/availability")
    public ResponseEntity<List<Movie>> getAvailableMovies() {
        List<Movie> movies = movieService.findAvailableMovies();
        return movies.isEmpty() ? 
               new ResponseEntity<>(HttpStatus.NO_CONTENT) : 
               new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<Movie>> getMoviesByTitle(@PathVariable String title) {
        List<Movie> movies = movieService.findMoviesByTitle(title);
        return movies.isEmpty() ? 
               new ResponseEntity<>(HttpStatus.NO_CONTENT) : 
               new ResponseEntity<>(movies, HttpStatus.OK);
    }
 
    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<Movie>> getMoviesByCompany(@PathVariable Long companyId) {
        List<Movie> movies = movieService.findByCompany(companyId);
        return movies.isEmpty() ? 
               new ResponseEntity<>(HttpStatus.NO_CONTENT) : 
               new ResponseEntity<>(movies, HttpStatus.OK);
    }

       @GetMapping("/promotion/{promotionId}")
    public ResponseEntity<List<Movie>> getMoviesByPromotion(@PathVariable Long promotionId) {
        List<Movie> movies = movieService.findByPromotion(promotionId);
        return movies.isEmpty() ? 
               new ResponseEntity<>(HttpStatus.NO_CONTENT) : 
               new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long movieId) {
        Movie movie = movieService.findMovieById(movieId);
        return movie == null ? 
               new ResponseEntity<>(HttpStatus.NOT_FOUND) : 
               new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        Movie addMovie = movieService.addMovie(movie);
        return new ResponseEntity<>(addMovie, HttpStatus.CREATED);
    }

    @PutMapping("/{movieId}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long movieId, @RequestBody Movie movie) {
        Movie updatedMovie = movieService.updateMovie(movieId, movie);
        return updatedMovie == null ? 
               new ResponseEntity<>(HttpStatus.NOT_FOUND) : 
               new ResponseEntity<>(updatedMovie, HttpStatus.OK);
    }

    @DeleteMapping("/{movieId}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long movieId) {
        boolean isDeleted = movieService.deleteMovie(movieId);
        return isDeleted ? 
               new ResponseEntity<>(HttpStatus.NO_CONTENT) : 
               new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
