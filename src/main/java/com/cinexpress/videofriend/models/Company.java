package com.cinexpress.videofriend.models;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NonNull
    private String name;

    @NonNull
    private String description;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Movie> movies;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Customer> customers;

    private Integer totalMoviesAvailable;

    public void addMovie(Movie movie) {
        this.movies.add(movie);
        this.totalMoviesAvailable++;
    }

    public void removeMovie(Movie movie) {
        this.movies.remove(movie);
        this.totalMoviesAvailable--;
    }

    public List<Movie> findMoviesByGenre(String genre) {
        return this.movies.stream()
                          .filter(movie -> movie.getGenre().equalsIgnoreCase(genre))
                          .toList();
    }

    public List<Movie> findAvailableMovies() {
        return this.movies.stream()
                          .filter(movie -> movie.getAvailability() != null && movie.getAvailability())
                          .toList();
    }

    public Integer getTotalMoviesAvailable() {
        return totalMoviesAvailable;
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public void removeCustomer(Customer customer) {
        this.customers.remove(customer);
    }
}
