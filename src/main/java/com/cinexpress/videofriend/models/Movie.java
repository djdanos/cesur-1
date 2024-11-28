package com.cinexpress.videofriend.models;
import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String title;

    @NonNull
    private String format;

    @NonNull
    private String genre;
    private String language;
    private Boolean availability;
    private String rating;

    @Temporal(TemporalType.DATE)
    private Date releaseDate; 
    private Integer duration; 

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "promotion_id")
    private Promotion promotion;
}
