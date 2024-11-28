package com.cinexpress.videofriend.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String itemType;
    @NonNull
    private Boolean availability;

    @OneToMany(mappedBy = "inventory", cascade = CascadeType.ALL)
    private List<Movie> movies;

    @OneToMany(mappedBy = "inventory", cascade = CascadeType.ALL)
    private List<RelatedProduct> relatedProducts;
}
