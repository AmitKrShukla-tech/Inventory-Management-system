package com.sparrowSoftech.InventoryManagementSystem.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CurrentTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class SaleDetailsDto {

    @NotEmpty(message = " Check Quantity")
    private double quantity;
    @NotEmpty(message = "Check Price")
    private float price;
    @NotEmpty(message = "Check Total Amount")
    private BigDecimal amount;
    @CurrentTimestamp
    private LocalDateTime dateTime;
    @NotEmpty(message = "Provide Valid Status its Should be Active/NotActive")
    @Size(min = 6)
    private String status;
}
