package com.sparrowSoftech.InventoryManagementSystem.payload;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.annotations.CurrentTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class PurchaseDetailsDto {

    private long id;
    @NotEmpty(message = "Quantity is Missing")
    private double quantity;
    @NotEmpty(message = "Price is Missing")
    private float price;
    @NotEmpty(message = "Amount is missing")
    private BigDecimal amount;
    @CurrentTimestamp
    private LocalDateTime dateTime;
    @NotEmpty(message = "Provide Status")
    private String status;
}
