package com.cinexpress.videofriend.services;

import java.util.List;

import com.cinexpress.videofriend.models.Customer;
import com.cinexpress.videofriend.models.Recommendation;

public interface RecommendationService {
    void addRecomendation(Recommendation recommendation);
    List<Recommendation> getCustomerRecomendations(Customer customer);
}
