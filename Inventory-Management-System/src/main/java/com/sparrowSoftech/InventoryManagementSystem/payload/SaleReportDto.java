package com.sparrowSoftech.InventoryManagementSystem.payload;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SaleReportDto {

    private BigDecimal saleAmount;
    private double saleStock;
}
