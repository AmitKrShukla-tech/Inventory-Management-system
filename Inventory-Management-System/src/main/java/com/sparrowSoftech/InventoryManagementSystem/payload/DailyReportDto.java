package com.sparrowSoftech.InventoryManagementSystem.payload;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DailyReportDto {

    @NotEmpty
    private LocalDate date;
    @NotEmpty
    private Double Quantity;
    @NotEmpty
    private Double ProfitAndLoss;
}
