package com.cinexpress.videofriend.services;

import java.util.List;

import com.cinexpress.videofriend.models.Customer;
import com.cinexpress.videofriend.models.Promotion;

public interface PromotionService {
    void addPromotion(Promotion promotion);
    List<Customer> currentCustomersWithPromotion(Promotion promotion);
    
}
