package com.cinexpress.videofriend.services;

import com.cinexpress.videofriend.models.Inventory;

public interface InventoryService {
    void addInventory(Inventory inventory);
    void updateInventory(Long id, Inventory inventory);
}
