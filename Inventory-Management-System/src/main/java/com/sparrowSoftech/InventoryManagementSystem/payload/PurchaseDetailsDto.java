package com.sparrowSoftech.InventoryManagementSystem.payload;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.annotations.CurrentTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
