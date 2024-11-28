package com.cinexpress.videofriend.services;

import com.cinexpress.videofriend.models.Customer;
import com.cinexpress.videofriend.models.PremiumSubscription;

public interface PremiumSubscriptionService {
    void activatePremiumSubscription(Customer customer, PremiumSubscription ps);
    Boolean hasDiscount(Customer customer);
    Boolean hasExcusiveCatalog(Customer customer);
}
