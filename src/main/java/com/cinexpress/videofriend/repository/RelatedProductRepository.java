package com.cinexpress.videofriend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinexpress.videofriend.models.RelatedProduct;

@Repository
public interface RelatedProductRepository extends JpaRepository<RelatedProduct, Long> {
}
