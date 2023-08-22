package com.sparrowSoftech.InventoryManagementSystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dailyReport")
public class DailyReport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    @Column
    private LocalDate date;
    @Column(nullable = false)
    private Double Quantity;
    @Column()
    private Double ProfitAndLoss;

}
