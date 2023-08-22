package com.sparrowSoftech.InventoryManagementSystem.repository;

import com.sparrowSoftech.InventoryManagementSystem.entities.SaleDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleDetailsRepository extends JpaRepository<SaleDetails, Long> {

}
