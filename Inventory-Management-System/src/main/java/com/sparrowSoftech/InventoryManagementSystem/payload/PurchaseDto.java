package com.sparrowSoftech.InventoryManagementSystem.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CurrentTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PurchaseDto {

    private long id;
    @NotEmpty(message = "Invoice Not Found")
    private String invoiceNo;
    @CurrentTimestamp
    private LocalDateTime invoiceDate;
    @NotNull
    private BigDecimal totalAmount;
    @CurrentTimestamp
    private LocalDateTime dateTime;
    @NotEmpty(message = "Status is Missing")
    private String status;
    private long supplierId;
}
