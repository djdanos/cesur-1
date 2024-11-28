package com.cinexpress.videofriend.services;

import java.util.List;

import com.cinexpress.videofriend.models.Customer;
import com.cinexpress.videofriend.models.Movie;

public interface CustomerService {
    void createCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    void deleteCustomer(Long customerId);
    Customer getCustomerById(Long customerId);

    void addClientToCompany(Long customerId, Long companyId);

    void addMovieToCostumer(Long customerId, Movie movie);

    boolean hasPremiumSubscription(Long customerId);
    void activatePremiumSubscription(Long customerId);

    void addLoyaltyPoints(Long customerId, int points);
    int getLoyaltyPoints(Long customerId);
    void removeLoyaltyPoints(Long customerId, int points);

    List<Customer> getCustomersByType(String type);
    List<Customer> searchCustomerByName(String name);
    List<Customer> getAllCustomers();
    List<Movie> listAllCustomerMovies(Long customerId);
}
