package com.sparrowSoftech.InventoryManagementSystem.serviceImpl;

import com.sparrowSoftech.InventoryManagementSystem.entities.DailyReport;
import com.sparrowSoftech.InventoryManagementSystem.entities.PurchaseDetails;
import com.sparrowSoftech.InventoryManagementSystem.entities.SaleDetails;
import com.sparrowSoftech.InventoryManagementSystem.exception.ResourceNotFoundExceptions;
import com.sparrowSoftech.InventoryManagementSystem.mapper.DailyReportMapper;
import com.sparrowSoftech.InventoryManagementSystem.payload.DailyReportDto;
import com.sparrowSoftech.InventoryManagementSystem.repository.DailyReportRepository;
import com.sparrowSoftech.InventoryManagementSystem.repository.PurchaseDetailsRepository;
import com.sparrowSoftech.InventoryManagementSystem.repository.SaleDetailsRepository;
import com.sparrowSoftech.InventoryManagementSystem.service.DailyReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DailyReportServiceImpl extends DailyReportMapper implements DailyReportService {

    @Autowired
    private DailyReportRepository dailyReportRepository;
    @Autowired
    private SaleDetailsRepository saleDetailsRepo;
    @Autowired
    private PurchaseDetailsRepository purchaseDetailsRepo;


    @Override
    public DailyReportDto getDailyStockQuantityReport(long purchaseDetails_id,
                                                      long saleDetails_id) {
//        DailyReport dailyReport = mapToDailyReportEntity(dailyReportDto);
        PurchaseDetails purchaseDetails = purchaseDetailsRepo.findById(purchaseDetails_id).orElseThrow(() -> new
                ResourceNotFoundExceptions("Purchase Details", "id", purchaseDetails_id));
        double quantity = purchaseDetails.getQuantity();

//        purchaseDetails.setQuantity(purchaseDetails.getQuantity());

        SaleDetails saleDetails = saleDetailsRepo.findById(saleDetails_id).orElseThrow(() -> new
                ResourceNotFoundExceptions("Sale Details", "id", saleDetails_id));
        double quantity1 = saleDetails.getQuantity();

        double finalQuantity = quantity - quantity1;

        DailyReportDto dailyReportDto = new DailyReportDto();
        dailyReportDto.setQuantity(finalQuantity);
        DailyReport dailyReport = mapToDailyReportEntity(dailyReportDto);

        DailyReport save = dailyReportRepository.save(dailyReport);

        DailyReportDto dailyReportDto1 = maptoDailyReportDto(save);

//        saleDetails.setQuantity(saleDetails.getQuantity());

        return dailyReportDto1;
    }

    @Override
    public List<DailyReport> getDailyWiseQuantities(LocalDate startDate, LocalDate endDate) {

        List<DailyReport> quantities = DailyReportRepository.findByDateBetween(startDate, endDate);

        Map<LocalDate, Double> dailyQuantitiesMap = new HashMap<>();
        for (DailyReport report: quantities) {
            LocalDate date = report.getDate();
            Double quantity = report.getQuantity();

            dailyQuantitiesMap.put(date,dailyQuantitiesMap.getOrDefault(date, 0.0) + quantity);
        }

        List<DailyReport> result = new ArrayList<>();
        for (Map.Entry<LocalDate, Double> entry: dailyQuantitiesMap.entrySet()) {
            DailyReport dailyReport = new DailyReport();
            dailyReport.setDate(entry.getKey());
            dailyReport.setQuantity(entry.getValue());
            result.add(dailyReport);
        }
        return result;
    }
//
//
//    @Override
//    public List<DailyReport> getDailyWiseQuantities(LocalDate startDate, LocalDate endDate) {
//        List<DailyReport> quantities = DailyReportRepository.findByDateBetween(startDate, endDate);
//
//        Map<LocalDate, Double> dailyQuantitiesMap = new HashMap<>();
//        for (DailyReport report : quantities) {
//            LocalDate date = report.getDate();
//            Double quantity = report.getQuantity();
//
//            dailyQuantitiesMap.put(date, dailyQuantitiesMap.getOrDefault(date, 0.0) + quantity);
//        }
//
//        List<DailyReport> result = new ArrayList<>();
//        for (Map.Entry<LocalDate, Double> entry : dailyQuantitiesMap.entrySet()) {
//            DailyReport dailyReport = new DailyReport();
//            dailyReport.setDate(entry.getKey());
//            dailyReport.setQuantity(entry.getValue());
//            result.add(dailyReport);
//        }
//
//        return result;
//    }
//
//
//    @Override
//    public List<DailyReport> getDailyWiseProfitAndLoss(LocalDate startDate, LocalDate endDate) {
//
//        public List<DailyReportDto> getDailyProfitAndLoss(LocalDate startDate, LocalDate endDate){
//            List<DailyReport> profitAndLossValues = DailyReportRepository.findByDateBetween(startDate, endDate);
//
//            Map<LocalDate, Double> dailyProfitAndLossMap = new HashMap<>();
//            for (DailyReport report : profitAndLossValues) {
//                LocalDate date = report.getDate();
//                Double profitAndLoss = report.getProfitAndLoss();
//
//                dailyProfitAndLossMap.put(date, dailyProfitAndLossMap.getOrDefault(date, 0.0) + profitAndLoss);
//            }
//
//            List<DailyReport> result = new ArrayList<>();
//            for (Map.Entry<LocalDate, Double> entry : dailyProfitAndLossMap.entrySet()) {
//                DailyReport dailyReport = new DailyReport();
//                dailyReport.setDate(entry.getKey());
//                dailyReport.setProfitAndLoss(entry.getValue());
//                result.add(dailyReport);
//            }
//
//            return result;
//        }
//
//
//    }

}