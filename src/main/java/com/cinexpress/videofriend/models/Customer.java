package com.cinexpress.videofriend.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String type;

    @ElementCollection
    private List<String> preferences;

    private String subscription;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Movie> movies;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "premium_subscription_id")
    private PremiumSubscription premiumSubscription;

    @ElementCollection
    private List<String> watchHistory;

    @Column
    private int loyaltyPoints;
}
