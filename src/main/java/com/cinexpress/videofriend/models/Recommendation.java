package com.cinexpress.videofriend.models;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<String> userHistory;

    @ElementCollection
    private List<String> preferences;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
