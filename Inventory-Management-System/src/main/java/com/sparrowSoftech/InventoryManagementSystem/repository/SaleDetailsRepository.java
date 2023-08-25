package com.sparrowSoftech.InventoryManagementSystem.repository;


import com.sparrowSoftech.InventoryManagementSystem.entities.SaleDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@Component
public interface SaleDetailsRepository extends JpaRepository<SaleDetails, Long> {
    @Query("select sd from sale_details sd where sd.dateTime BETWEEN :startDate AND :endDate")
    List<SaleDetails> findByStockDateBetween(@Param("startDate") LocalDateTime startDate,
                                             @Param("endDate") LocalDateTime endDate);

//
//    @Query("SELECT com.sparrowSoftech.InventoryManagementSystem.payload.ReportDto SUM(s.quantity, s.amount) FROM SaleDetails s WHERE s.datetime BETWEEN :startDate AND :endDate")
//    List<SaleDetails> findByStockDateBetween(LocalDateTime startDate, LocalDateTime endDate);
}
//NEW com.sparrowSoftech.InventoryManagementSystem.payload.ReportDto