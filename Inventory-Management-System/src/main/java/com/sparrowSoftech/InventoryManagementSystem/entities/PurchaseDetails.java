package com.sparrowSoftech.InventoryManagementSystem.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CurrentTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "purchase_details")
@Table(name = "purchase_details")
public class PurchaseDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    @Column(name="quantity",nullable = false)
    private double quantity;
    @Column(name = "price", nullable = false)
    private float price;
    @Column(name = "amount", nullable = false)
    private BigDecimal amount;
    @CurrentTimestamp()
    private LocalDateTime dateTime;
    @Column(name = "status", nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;


}

