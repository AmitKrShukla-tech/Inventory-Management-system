package com.sparrowSoftech.InventoryManagementSystem.repository;

import com.sparrowSoftech.InventoryManagementSystem.entities.DailyReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface DailyReportRepository extends JpaRepository<DailyReport, Long> {
    static List<DailyReport> findByDateBetween(LocalDate startDate, LocalDate endDate) {
        return null;
    };
//    static List<DailyReport> findByDateBetween(LocalDate startDate, LocalDate endDate) {
//        return null;
//    };
//    static List<DailyReport> findByDateBetween(LocalDate startDate, LocalDate endDate) {
//        return null;
//    }

}
