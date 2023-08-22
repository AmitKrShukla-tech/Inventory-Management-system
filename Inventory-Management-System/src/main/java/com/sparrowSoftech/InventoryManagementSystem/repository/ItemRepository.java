package com.sparrowSoftech.InventoryManagementSystem.repository;

import com.sparrowSoftech.InventoryManagementSystem.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
