package com.sparrowSoftech.InventoryManagementSystem.payload;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DateWiseStockAndProfitLossDto {

    private BigDecimal dateWiseProfitAmount=BigDecimal.ZERO;
    private BigDecimal dateWisePurchaseAmount;
    private BigDecimal dateWiseSaleAmount;
    private double purchaseQuantity;
    private double saleQuantity;
    private double dateWiseStockedQuantity;

    private BigDecimal dateWiseLossAmount=BigDecimal.ZERO;

}
