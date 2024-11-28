package com.cinexpress.videofriend.services.impl;

import org.springframework.stereotype.Service;

import com.cinexpress.videofriend.models.Customer;
import com.cinexpress.videofriend.models.PremiumSubscription;
import com.cinexpress.videofriend.services.PremiumSubscriptionService;

@Service
public class PremiumSubscriptionServiceImpl implements PremiumSubscriptionService{

    @Override
    public void activatePremiumSubscription(Customer customer, PremiumSubscription ps) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'activatePremiumSubscription'");
    }

    @Override
    public Boolean hasDiscount(Customer customer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hasDiscount'");
    }

    @Override
    public Boolean hasExcusiveCatalog(Customer customer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hasExcusiveCatalog'");
    }
    
}
