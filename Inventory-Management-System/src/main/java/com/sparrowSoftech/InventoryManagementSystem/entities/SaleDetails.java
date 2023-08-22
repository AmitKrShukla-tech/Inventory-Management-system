package com.sparrowSoftech.InventoryManagementSystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CurrentTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sale_details")
public class SaleDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    @Column(name = "quantity",nullable = false)
    private double quantity;
    @Column(name = "price",nullable = false)
    private float price;
    @Column(name = "amount",nullable = false)
    private BigDecimal amount;
    @CurrentTimestamp
    private LocalDateTime dateTime;
    @Column(name = "status",nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
}
