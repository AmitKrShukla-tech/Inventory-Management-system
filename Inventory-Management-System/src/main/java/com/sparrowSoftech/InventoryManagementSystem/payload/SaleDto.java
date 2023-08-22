package com.sparrowSoftech.InventoryManagementSystem.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CurrentTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class SaleDto {

    @NotEmpty(message = "Enter here Customer Name")
    private String CustomerName;
    @NotEmpty(message = "Enter her Mobile Number with 10 digits")
    @Size(min = 10, max = 10)
    @Pattern(regexp = "(^[6-9]{1}[0-9]{9})$", message = "Mobile number should be 10 digits and Start from 6 to 9")
    private String mobileNumber;
    @NotEmpty(message = "Invoice No is Missing")
    private String invoiceNo;
    @NotEmpty(message = "Invoice Date is Missing")
    @CurrentTimestamp
    private LocalDateTime invoiceDate;
    @NotEmpty(message = "Total Amount !! ")
    private BigDecimal totalAmount;
    @CurrentTimestamp
    private LocalDateTime dateTime;
    @NotEmpty(message = "Provide Status")
    private String status;
}
