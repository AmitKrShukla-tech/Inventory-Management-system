package com.sparrowSoftech.InventoryManagementSystem.payload;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CurrentTimestamp;

import java.math.BigDecimal;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ReportDto {

     private BigDecimal purchaseAmount;
     private double purchaseStock;

}
