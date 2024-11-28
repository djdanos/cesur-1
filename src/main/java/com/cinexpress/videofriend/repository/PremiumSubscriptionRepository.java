package com.cinexpress.videofriend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinexpress.videofriend.models.PremiumSubscription;

@Repository
public interface PremiumSubscriptionRepository extends JpaRepository<PremiumSubscription, Long> {
}
