package com.sparrowSoftech.InventoryManagementSystem.service;

import com.sparrowSoftech.InventoryManagementSystem.payload.DateWiseStockAndProfitLossDto;
import com.sparrowSoftech.InventoryManagementSystem.payload.ReportDto;
import com.sparrowSoftech.InventoryManagementSystem.payload.SaleReportDto;

import java.time.LocalDateTime;

public interface ReportService {

    ReportDto getPurchasesStockDataByDateRange(LocalDateTime startDate, LocalDateTime endDate);

    SaleReportDto getSaleStockDataByDateRange(LocalDateTime startDate, LocalDateTime endDate);

    DateWiseStockAndProfitLossDto dailyReport(LocalDateTime startDate, LocalDateTime endDate);


//    ReportDto getSumOfQuantity(LocalDateTime startDate, LocalDateTime endDate);
//    List<ReportDto> getStockDataByDateRange(LocalDate startDate, LocalDate endDate);
//    ReportDto getDailyBasedReport(String startDate, String endDate);
//    List<ReportDto> getPurchasesStockDataByDateRange(LocalDateTime startDate, LocalDateTime endDate);
//
//    List<ReportDto> getSaleStockDataByDateRange(LocalDateTime startDate, LocalDateTime endDate);
}
