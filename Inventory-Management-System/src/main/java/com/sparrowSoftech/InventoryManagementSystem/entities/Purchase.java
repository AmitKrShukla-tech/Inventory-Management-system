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
@Table(name = "purchase_mstr")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    @Column(name = "invoice_no",nullable = false,unique = true)
    private String invoiceNo;
    @CurrentTimestamp
    @Column(name = "invoice_date",nullable = false)
    private LocalDateTime invoiceDate;
    @Column(name = "total_amount",nullable = false)
    private BigDecimal totalAmount;
    @CurrentTimestamp
    private LocalDateTime dateTime;
    @Column(name = "status",nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL)
    private List<PurchaseDetails> purchaseDetailsList;


}
