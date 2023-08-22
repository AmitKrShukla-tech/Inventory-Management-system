package com.sparrowSoftech.InventoryManagementSystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CurrentTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sale_mstr")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    @Column(name="customer_name",nullable = false)
    private String customerName;
    @Column(name="number",nullable = false, unique = true)
    private String mobileNumber;
    @Column(name="invoice_no",nullable = false,unique = true)
    private String invoiceNo;
    @Column(name = "invoice_date",nullable = false)
    @CurrentTimestamp
    private LocalDateTime invoiceDate;
    @Column(name="total_amount",nullable = false)
    private BigDecimal totalAmount;
    @CurrentTimestamp
    private LocalDateTime dateTime;
    @Column(name="status",nullable = false)
    private String status;

    @OneToMany(mappedBy = "sale",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<SaleDetails> saleDetails;

}
