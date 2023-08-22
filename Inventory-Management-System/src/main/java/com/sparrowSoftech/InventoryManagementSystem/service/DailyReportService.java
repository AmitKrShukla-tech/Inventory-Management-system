package com.sparrowSoftech.InventoryManagementSystem.service;

import com.sparrowSoftech.InventoryManagementSystem.entities.DailyReport;
import com.sparrowSoftech.InventoryManagementSystem.payload.DailyReportDto;

import java.time.LocalDate;
import java.util.List;

public interface DailyReportService {


    DailyReportDto getDailyStockQuantityReport(long purchaseDetails_id, long saleDetails_id);

    List<DailyReport> getDailyWiseQuantities(LocalDate startDate, LocalDate endDate);
}
