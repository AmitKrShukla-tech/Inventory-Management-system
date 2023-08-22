package com.sparrowSoftech.InventoryManagementSystem.controller;

import com.sparrowSoftech.InventoryManagementSystem.entities.DailyReport;
import com.sparrowSoftech.InventoryManagementSystem.payload.DailyReportDto;
import com.sparrowSoftech.InventoryManagementSystem.service.DailyReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/report")
public class DailyReportController {

    @Autowired
    private DailyReportService dailyReportService;



    //api=== http://localhost:8080/api/report/quantities
    @GetMapping("/quantities")
    public ResponseEntity<List<DailyReport>> getDailyWiseQuantities(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {

        List<DailyReport> quantities = dailyReportService.getDailyWiseQuantities(startDate, endDate);
        return new ResponseEntity<>(quantities, HttpStatus.OK);
    }


//    @GetMapping("/profit-and-loss")
//    public ResponseEntity<List<DailyReport>> getDailyWiseProfitAndLoss(
//            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
//            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
//
//        List<DailyReport> profitAndLossValues = dailyReportService.getDailyWiseProfitAndLoss(startDate, endDate);
//        return new ResponseEntity<>(profitAndLossValues, HttpStatus.OK);
//    }

    //api=== http://localhost:8080/api/report/dailyStock/{purchaseDetails_id}/{saleDetails_id}/quantity

    @GetMapping("dailyStock/{purchaseDetails_id}/{saleDetails_id}/quantity")
    public ResponseEntity<DailyReportDto> getDailyQuantityReport(@PathVariable("purchaseDetails_id") long purchaseDetails_id,
                                                                 @PathVariable("saleDetails_id") long saleDetails_id){
        DailyReportDto dailyStockQuantityReport = dailyReportService.getDailyStockQuantityReport(purchaseDetails_id, saleDetails_id);
        return new ResponseEntity<>(dailyStockQuantityReport,HttpStatus.CREATED);
    }
}
