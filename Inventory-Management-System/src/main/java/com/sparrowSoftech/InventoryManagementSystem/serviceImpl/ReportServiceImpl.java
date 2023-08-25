package com.sparrowSoftech.InventoryManagementSystem.serviceImpl;

import com.sparrowSoftech.InventoryManagementSystem.entities.PurchaseDetails;
import com.sparrowSoftech.InventoryManagementSystem.entities.SaleDetails;
import com.sparrowSoftech.InventoryManagementSystem.payload.DateWiseStockAndProfitLossDto;
import com.sparrowSoftech.InventoryManagementSystem.payload.ReportDto;
import com.sparrowSoftech.InventoryManagementSystem.payload.SaleReportDto;
import com.sparrowSoftech.InventoryManagementSystem.repository.PurchaseDetailsRepository;
import com.sparrowSoftech.InventoryManagementSystem.repository.SaleDetailsRepository;
import com.sparrowSoftech.InventoryManagementSystem.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private PurchaseDetailsRepository purchaseDetailsRepo;
    @Autowired
    private SaleDetailsRepository saleDetailsRepo;
//    @Autowired
//    private ReportDtoRepository reportDtoRepository;

    @Override
    public ReportDto getPurchasesStockDataByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        List<PurchaseDetails> byStockDateBetween = purchaseDetailsRepo.findByStockDateBetween(startDate, endDate);
        List<Double> dailyPurchaseStock = new ArrayList<>();
        List<BigDecimal> pAmount = new ArrayList<>();
        ReportDto reportDto = new ReportDto();

       // Double sum = (double) 0;

        for (PurchaseDetails purchases : byStockDateBetween) {
            System.out.println(purchases.getQuantity());
            dailyPurchaseStock.add(purchases.getQuantity());
            pAmount.add(purchases.getAmount());

          //  reportDto.setPurchaseStock(purchases.getQuantity());
//            dailyPurchaseStock.add(reportDto.setPurchaseStock(purchases.getQuantity().);


//            reportDto.setPurchaseStock(purchases.getQuantity());
            //reportDto.setPurchaseAmount(BigDecimal.valueOf(purchases.getAmount());
//            dailyPurchaseStock.add(reportDto);
//            ReportDto sum = dailyPurchaseStock.stream().mapToDouble(Double::doubleValue).sum();
//            System.out.println(purchases.getQuantity());
            //  double sum = dailyPurchaseStock.stream().mapToDouble(Double::doubleValue).sum();

//        for (ReportDto quantity : dailyPurchaseStock) {
//            sum= sum+reportDto.getPurchaseStock();
//            System.out.println(sum);
//        }
        }
        double sum =0;
        for (Double x:dailyPurchaseStock) {
            sum = sum+ x;
        }
        BigDecimal sum1= BigDecimal.ZERO;
        for (BigDecimal value : pAmount) {
            sum1 = sum1.add(value);
        }
        reportDto.setPurchaseAmount(sum1);
         reportDto.setPurchaseStock(sum);
        System.out.println(sum);
        System.out.println(sum1);

        return reportDto;
    }

    @Override
    public SaleReportDto getSaleStockDataByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        List<SaleDetails> byStockDateBetween = saleDetailsRepo.findByStockDateBetween(startDate, endDate);
        List<Double> dailySaleDetails = new ArrayList<>();
        List<BigDecimal> dailyAmountDetails = new ArrayList<>();

        SaleReportDto saleReportDto = new SaleReportDto();

        // Double sum = (double) 0;

        for (SaleDetails sale : byStockDateBetween) {
            System.out.println(sale.getQuantity());
            dailySaleDetails.add(sale.getQuantity());
            dailyAmountDetails.add(sale.getAmount());
        }
        double sum =0;
        for (Double x:dailySaleDetails) {
            sum = sum+ x;
        }
        BigDecimal sum1= BigDecimal.ZERO;
        for (BigDecimal value : dailyAmountDetails) {
            sum1 = sum1.add(value);
        }
        saleReportDto.setSaleStock(sum);
        saleReportDto.setSaleAmount(sum1);
        System.out.println(sum);
        System.out.println(sum1);

        return saleReportDto;
    }

    @Override
    public DateWiseStockAndProfitLossDto dailyReport(LocalDateTime startDate, LocalDateTime endDate) {
        List<PurchaseDetails> byStockDateBetween = purchaseDetailsRepo.findByStockDateBetween(startDate, endDate);
        List<Double> dailyPurchaseStock = new ArrayList<>();
        List<BigDecimal> pAmount = new ArrayList<>();
        DateWiseStockAndProfitLossDto dateWiseStockAndProfitLossDto = new DateWiseStockAndProfitLossDto();
        for (PurchaseDetails purchases : byStockDateBetween) {
            System.out.println(purchases.getQuantity());
            dailyPurchaseStock.add(purchases.getQuantity());
            pAmount.add(purchases.getAmount());
        }
        double sum =0;
        for (Double x:dailyPurchaseStock) {
            sum = sum+ x;
        }
        BigDecimal sum1= BigDecimal.ZERO;
        for (BigDecimal value : pAmount) {
            sum1 = sum1.add(value);
        }
        dateWiseStockAndProfitLossDto.setDateWisePurchaseAmount(sum1);
        dateWiseStockAndProfitLossDto.setPurchaseQuantity(sum);

        List<SaleDetails> xx = saleDetailsRepo.findByStockDateBetween(startDate, endDate);
        List<Double> dailySaleDetails = new ArrayList<>();
        List<BigDecimal> dailyAmountDetails = new ArrayList<>();

        for (SaleDetails sale : xx) {
            System.out.println(sale.getQuantity());
            dailySaleDetails.add(sale.getQuantity());
            dailyAmountDetails.add(sale.getAmount());
        }
        double sum2=0;
        for (Double x:dailySaleDetails) {
            sum2= sum2+ x;
        }
        BigDecimal sum3= BigDecimal.ZERO;
        for (BigDecimal value : dailyAmountDetails) {
            sum3 = sum3.add(value);
        }

        dateWiseStockAndProfitLossDto.setDateWisePurchaseAmount(sum1);
        dateWiseStockAndProfitLossDto.setPurchaseQuantity(sum);
        dateWiseStockAndProfitLossDto.setSaleQuantity(sum2);
        dateWiseStockAndProfitLossDto.setDateWiseSaleAmount(sum3);


        dateWiseStockAndProfitLossDto.setDateWiseStockedQuantity(sum - sum2);
        BigDecimal subtract = sum1.subtract(sum3);
        BigDecimal subtract1 = sum3.subtract(sum1);
        int i = subtract.compareTo(BigDecimal.ZERO);
        if(i>=0){
            dateWiseStockAndProfitLossDto.setDateWiseProfitAmount(subtract);
        }else {
            dateWiseStockAndProfitLossDto.setDateWiseLossAmount(subtract1);
        }
        return dateWiseStockAndProfitLossDto;
    }

//    private double getTotalQuantity(double quantity) {
//        return
//    }

//    @Override
//    public ReportDto getSumOfQuantity(LocalDateTime startDate, LocalDateTime endDate) {
//        List<PurchaseDetails> sumOfQuantityByDateWise = purchaseDetailsRepo.getSumOfQuantityByDateWise(startDate, endDate);
//
//
//            Map<LocalDate, Double> sumOfQuantity = new HashMap<>();
//            for (PurchaseDetails quantity : sumOfQuantityByDateWise) {
////                LocalDate date = quantity.getDate();
//                Double profitAndLoss = quantity.getQuantity();
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

////        double quantity = sumOfQuantityByDateWise.stream().mapToDouble(Double::).sum();
//        ReportDto reportDto = new ReportDto();
//        reportDto.setPurchaseStock(purchaseDetailsRepo.getSumOfQuantityByDateWise());
//
//
//        return null;
//    }


    //        LocalDate parsedStartDate = LocalDate.parse(startDate);
//        LocalDate parsedEndDate = LocalDate.parse(endDate);


    //    @Override
//    public ReportDto addPost(ReportDto reportDto) {
//        reportDto.setDate(new Date());
//        return reportDtoRepository.save(reportDto);
//    }
//
//    @Override
//    public ReportDto getReport(Date date) {
//        ReportDto byDate = reportDtoRepository.findByDate(date);
//        return byDate;
//    }
//
//    @Override
//    public List<ReportDto> getSaleStockDataByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
//        List<SaleDetails> stockDateBetween = saleDetailsRepo.findByStockDateBetween(startDate, endDate);
//        List<ReportDto> dailySaleRecords = new ArrayList<>();
//        ReportDto reportDto = new ReportDto();
//        for (SaleDetails sale : stockDateBetween) {
//            reportDto.setSaleAmount(sale.getAmount());
//            reportDto.setSaleStock(sale.getQuantity());
//            dailySaleRecords.add(reportDto);
//
//        }
//        return dailySaleRecords;
//    }

//    @Override
//    public List<ReportDto> getReportDataByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
//        List<ReportDto> reportData = new ArrayList<>();
//
//        List<PurchaseDetails> purchaseData = purchaseDetailsRepo.findByStockDateBetween(startDate, endDate);
//        List<SaleDetails> saleData = saleDetailsRepo.findByStockDateBetween(startDate, endDate);
//
//        for (LocalDate date = startDate.toLocalDate(); date.isBefore(endDate.toLocalDate().plusDays(1)); date = date.plusDays(1)) {
//            ReportDto reportDto = new ReportDto();
//
//            reportDto.setPurchaseAmount(getTotalAmountForDate(purchaseData, date));
//            reportDto.setPurchaseStock(getTotalStockForDate(purchaseData, date));
//            reportDto.setSaleAmount(getTotalAmountForDate(saleData, date));
//            reportDto.setSaleStock(getTotalStockForDate(saleData, date));
//
//            reportData.add(reportDto);
//        }
//
//        return reportData;
//    }
//
//    private double getTotalAmountForDate(List<? extends StockDetails> stockData, LocalDate date) {
//        return stockData.stream()
//                .filter(stock -> stock.getDatetime().toLocalDate().isEqual(date))
//                .mapToDouble(StockDetails::getAmount)
//                .sum();
//    }
//
//    private int getTotalStockForDate(List<? extends StockDetails> stockData, LocalDate date) {
//        return stockData.stream()
//                .filter(stock -> stock.getDatetime().toLocalDate().isEqual(date))
//                .mapToInt(StockDetails::getQuantity)
//                .sum();
//    }

}
