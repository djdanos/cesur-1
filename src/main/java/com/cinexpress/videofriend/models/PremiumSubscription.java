package com.cinexpress.videofriend.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PremiumSubscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean exclusiveCatalog;
    private Boolean discounts;
    private Boolean preReleases;

    @OneToOne(mappedBy = "premiumSubscription")
    private Customer customer;
}
