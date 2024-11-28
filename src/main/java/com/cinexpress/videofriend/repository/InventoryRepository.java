package com.cinexpress.videofriend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinexpress.videofriend.models.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
