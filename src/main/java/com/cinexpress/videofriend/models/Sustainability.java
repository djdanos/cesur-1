package com.cinexpress.videofriend.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sustainability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean recyclableMaterials;
    private String campaigns;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
