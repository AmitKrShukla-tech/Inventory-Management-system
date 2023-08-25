package com.sparrowSoftech.InventoryManagementSystem.repository;

import com.sparrowSoftech.InventoryManagementSystem.entities.PurchaseDetails;
import com.sparrowSoftech.InventoryManagementSystem.payload.ReportDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReportDtoRepository extends JpaRepository<PurchaseDetails, Long> {



//    @Query("SELECT p.quantity,p.price,p.amount,p.dateTime FROM purchase_details p WHERE p stockData p BETWEEN :startDate AND :endDate")

//    List<PurchaseDetails> findByStockDateBetween(LocalDate startDate, LocalDate endDate);

//    @Query("SELECT p.quantity,p.price,p.amount,p.dateTime FROM purchase_details p WHERE p stockData p BETWEEN :startDate AND :endDate")
//    List<ReportDto> getReoprtDailyWise(String startDate, String endDate);

//    ReportDto findByDate(Date date);
//    ReportDto findByItemId(long itemId);


}
