package com.sparrowSoftech.InventoryManagementSystem.controller;

import com.sparrowSoftech.InventoryManagementSystem.payload.DateWiseStockAndProfitLossDto;
import com.sparrowSoftech.InventoryManagementSystem.payload.ReportDto;
import com.sparrowSoftech.InventoryManagementSystem.payload.SaleReportDto;
import com.sparrowSoftech.InventoryManagementSystem.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api")
public class ReportController {

    @Autowired
    private ReportService reportService;

//    @PostMapping("report")
//    public ResponseEntity<ReportDto> addPost(@RequestBody ReportDto reportDto){
//        return  new ResponseEntity<>(reportService.addPost(reportDto), HttpStatus.CREATED);
//    }
//
//    @GetMapping("getreport/date")
//    public ResponseEntity<ReportDto> getReportByDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
//        ReportDto report = reportService.getReport(date);
//        return new ResponseEntity<>(report, HttpStatus.OK);
//    }


// //   http://localhost:8080/api/purchase/datewise?startDate=2023-08-21&endDate=2023-08-22
    @GetMapping("/purchase/datewise")
    public ResponseEntity<ReportDto> getPurchaseStockDataByDate(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime endDate) {
        ReportDto purchasesStockDataByDateRange = reportService.getPurchasesStockDataByDateRange(startDate, endDate);

        return new ResponseEntity<>(purchasesStockDataByDateRange,HttpStatus.OK);
    }

  //  http://localhost:8080/api//sale/datewise?startDate=2023-08-21&endDate=2023-08-22
    @GetMapping("/sale/datewise")
    public ResponseEntity<SaleReportDto> getSaleStockDataByDate(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime endDate) {
        SaleReportDto saleStockDataByDateRange  = reportService.getSaleStockDataByDateRange(startDate, endDate);
        return new ResponseEntity<>(saleStockDataByDateRange,HttpStatus.OK);
    }


    //api=== http://localhost:8080/api/datewise/report
    @GetMapping("/datewise/report")
    public ResponseEntity<DateWiseStockAndProfitLossDto> dailyReport(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime endDate){

        return new ResponseEntity<>(reportService.dailyReport(startDate,endDate),HttpStatus.OK);
    }


//    @GetMapping("/purchase/quantity")
//    public ResponseEntity<ReportDto> getSumOfQuantity(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime startDate,
//                                                      @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime endDate){
//
//        reportService.getSumOfQuantity(startDate,endDate);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }


//
//    @GetMapping("/sale/date-wise")
//    public ResponseEntity<List<ReportDto>> getSaleStocksDateByDate(
//                     @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime startDate,
//                     @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime endDate) {
//        List<ReportDto> stockData = reportService.getSaleStockDataByDateRange(startDate, endDate);
//        return ResponseEntity.ok(stockData);
//    }
}
