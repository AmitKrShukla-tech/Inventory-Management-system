package com.sparrowSoftech.InventoryManagementSystem.repository;

import com.sparrowSoftech.InventoryManagementSystem.entities.Item;
import com.sparrowSoftech.InventoryManagementSystem.entities.PurchaseDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Repository
public interface PurchaseDetailsRepository extends JpaRepository<PurchaseDetails, Long> {


    @Query("select p from purchase_details p where p.dateTime BETWEEN :startDate AND :endDate")
    List<PurchaseDetails> findByStockDateBetween(@Param("startDate") LocalDateTime startDate,
                                                 @Param("endDate") LocalDateTime endDate);




////    @Query("select pd from  purchase_details pd where pd.itemId= :itemId")
//    PurchaseDetails getItemDetailsByItemId(long itemId);


//    @Query("select p from purchase_details p where p.item_id = id")

 //   @Query("Select p From purchase_details p WHERE p.item_id = :item_id")

//    @Query("SELECT pd FROM purchase_details pd WHERE pd.item_id = :item_id")
//    PurchaseDetails findByItemId(Long item_id);
//
//    @Query("select pd from product_details pd where pd.itemId = : id")
//    PurchaseDetails getItemDetailsByItemId(@Param("item_id") long itemId);


//
//    @Query("select SUM(p.quantity) from purchase_details p where p.dateTime BETWEEN :startDate AND :endDate")
//    List<P> getSumOfQuantityByDateWise(LocalDateTime startDate, LocalDateTime endDate);


    //   @Query("SELECT p FROM purchase_details p WHERE p.dateTime BETWEEN :startDate AND :endDate")

//    @Query("SELECT com.sparrowSoftech.InventoryManagementSystem.payload.ReportDto SUM(s.quantity, s.amount) FROM PurchaseDetails s WHERE s.datetime BETWEEN :startDate AND :endDate")
//    List<PurchaseDetails> findByStockDateBetween(@Param("startDate") LocalDateTime startDate,
//                                                  @Param("endDate") LocalDateTime endDate);
}
//com.sparrowSoftech.InventoryManagementSystem.payload.ReportDto
//sum(amount),